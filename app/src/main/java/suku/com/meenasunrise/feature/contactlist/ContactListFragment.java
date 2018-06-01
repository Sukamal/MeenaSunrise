package suku.com.meenasunrise.feature.contactlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.feature.common.AdapterItemClickListener;
import suku.com.meenasunrise.feature.common.BaseFragment;
import suku.com.meenasunrise.feature.common.OnFragmentInteractionListener;
import suku.com.meenasunrise.feature.contactdetails.ContactDetailsFragment;
import suku.com.meenasunrise.storage.database.entity.UserDetails;

public class ContactListFragment extends BaseFragment implements ContactListContract.view{

    @Inject
    ContactListPresenter presenter;

    @BindView(R.id.rvContactList)
    RecyclerView rvContactList;

    private ContactListAdapter contactListAdapter;
    private OnFragmentInteractionListener mListener;


    public ContactListFragment() {

    }

    public static ContactListFragment newInstance() {
        ContactListFragment fragment = new ContactListFragment();
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public void initComponents() {

        ContactListDiComponent diComponent = DaggerContactListDiComponent
                .builder()
                .applicationComponent(MeenaSunriseApplication.getApplication(getActivity()).getApplicationComponent())
                .contactListDiModule(new ContactListDiModule(this))
                .build();
        diComponent.inject(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactList.setLayoutManager(layoutManager);
        presenter.loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayContacts(List<UserDetails> modelList) {
        contactListAdapter = new ContactListAdapter(modelList);
        rvContactList.setAdapter(contactListAdapter);
        contactListAdapter.setItemClickListner(new AdapterItemClickListener() {
            @Override
            public void onAdapterItemClick(View view, int position, Object selectedItem) {
                presenter.receiveRoutingData(((UserDetails)selectedItem).getUserId());
            }
        });
    }

    @Override
    public void displayContactDetails(String userId) {
        mListener.onFragmentInteraction(ContactDetailsFragment.class.getName(),userId);
    }

    @Override
    public void displayMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
