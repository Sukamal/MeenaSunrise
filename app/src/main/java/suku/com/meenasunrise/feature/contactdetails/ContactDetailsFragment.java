package suku.com.meenasunrise.feature.contactdetails;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.feature.common.BaseFragment;
import suku.com.meenasunrise.feature.common.OnFragmentInteractionListener;
import suku.com.meenasunrise.model.ContactDetailsModel;
import suku.com.meenasunrise.util.AppConstant;
import suku.com.meenasunrise.util.Utility;

public class ContactDetailsFragment extends BaseFragment implements ContactDetailsContract.view {

    @Inject
    ContactDetailsPresenter presenter;

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvBlock)
    TextView tvBlock;
    @BindView(R.id.tvFlatNo)
    TextView tvFlatNo;
    @BindView(R.id.tvInterCom)
    TextView tvInterCom;
    @BindView(R.id.tvMobNo)
    TextView tvMobNo;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.llCall)
    LinearLayout llCall;
    @BindView(R.id.llEmail)
    LinearLayout llEmail;

    private String userId;
    private OnFragmentInteractionListener mListener;

    public ContactDetailsFragment() {
    }

    public static ContactDetailsFragment newInstance() {
        ContactDetailsFragment fragment = new ContactDetailsFragment();
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_contact_details;
    }

    @Override
    public void initComponents() {

        ContactDetailsDiComponent component = DaggerContactDetailsDiComponent
                .builder()
                .applicationComponent(MeenaSunriseApplication.getApplication(getActivity()).getApplicationComponent())
                .contactDetailsDiModule(new ContactDetailsDiModule(this))
                .build();
        component.inject(this);
        if (getArguments() != null && getArguments().containsKey(AppConstant.ExtraTag.TAG_VALUE_1.name())) {
            userId = getArguments().getString(AppConstant.ExtraTag.TAG_VALUE_1.name());
        }
        presenter.loadData(userId);
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
    public void displayContactDetails(ContactDetailsModel detailsModel) {

        if (detailsModel != null) {
            tvName.setText(Utility.getText(detailsModel.getName()));
            tvBlock.setText(Utility.getText(detailsModel.getBlock()));
            tvFlatNo.setText(Utility.getText(detailsModel.getFlatNo()));
            tvInterCom.setText(Utility.getText(detailsModel.getExtention()));
            tvMobNo.setText(Utility.getText(detailsModel.getPhNo()));
            tvEmail.setText(Utility.getText(detailsModel.getEmail()));
        }

        llCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateCall(tvMobNo.getText().toString());
            }
        });

        llEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeMail(tvEmail.getText().toString());
            }
        });


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

    private void initiateCall(String phNo) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phNo));
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
            startActivity(intent);
        }
    }

    private void composeMail(String mailId){
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mailId});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Select Email Sending App :"));

    }
}
