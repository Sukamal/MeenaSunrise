package suku.com.meenasunrise.feature.directory;

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
import suku.com.meenasunrise.feature.common.AdapterItemClickListener;
import suku.com.meenasunrise.feature.common.BaseFragment;
import suku.com.meenasunrise.feature.common.OnFragmentInteractionListener;
import suku.com.meenasunrise.feature.contactdetails.ContactDetailsFragment;
import suku.com.meenasunrise.feature.contactlist.ContactListFragment;
import suku.com.meenasunrise.model.DirectoryCategoryModel;

public class DirectoryFragment extends BaseFragment implements DirectoryContract.view{

    @BindView(R.id.rv_directory)
    RecyclerView rvDirectory;

    @Inject
    DirectoryPresenter presenter;

    private DirectoryCategoryAdapter categoryAdapter;
    private OnFragmentInteractionListener mListener;


    public DirectoryFragment() {
    }

    public static DirectoryFragment newInstance() {
        DirectoryFragment fragment = new DirectoryFragment();
        return fragment;
    }



    @Override
    public int getContentLayout() {
        return R.layout.fragment_directory;
    }

    @Override
    public void initComponents() {

        DirectoryDiComponent component = DaggerDirectoryDiComponent
                .builder()
                .directoryDiModule(new DirectoryDiModule(this))
                .build();
        component.inject(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDirectory.setLayoutManager(layoutManager);

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
    public void displayCategory(List<DirectoryCategoryModel> modelList) {
        categoryAdapter = new DirectoryCategoryAdapter(modelList);
        rvDirectory.setAdapter(categoryAdapter);
        categoryAdapter.setItemClickListner(new AdapterItemClickListener() {
            @Override
            public void onAdapterItemClick(View view, int position, Object selectedItem) {
                presenter.receiveRoutingData(position+1);
            }
        });
    }

    @Override
    public void openFlatOwnerContactScreen() {
        Toast.makeText(getContext(), "Flat Owner", Toast.LENGTH_SHORT).show();
        mListener.onFragmentInteraction(ContactListFragment.class.getName(),null);

    }

    @Override
    public void openCommityMemberContactScreen() {
        Toast.makeText(getContext(), "Commity Member", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void openCommunityContactScreen() {
        Toast.makeText(getContext(), "Community", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void openFecilityContactScreen() {
        Toast.makeText(getContext(), "Facility ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
