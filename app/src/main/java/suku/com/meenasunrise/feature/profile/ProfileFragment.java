package suku.com.meenasunrise.feature.profile;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import suku.com.meenasunrise.R;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.feature.common.BaseFragment;
import suku.com.meenasunrise.model.UserProfileModel;

public class ProfileFragment extends BaseFragment implements ProfileContract.view{


    @Inject
    ProfilePresenter presenter;

    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvFlatNumber)
    TextView tvFlatNumber;
    @BindView(R.id.ivProfileImage)
    ImageView ivProfileImage;
    @BindView(R.id.tvIssue)
    TextView tvIssue;
    @BindView(R.id.tvPendingIssue)
    TextView tvPendingIssue;
    @BindView(R.id.tvCompletedIssue)
    TextView tvCompletedIssue;
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


    public ProfileFragment() {

    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    public void initComponents() {
        ProfileDiComponent diComponent = DaggerProfileDiComponent
                .builder()
                .profileDiModule(new ProfileDiModule(this))
                .applicationComponent(MeenaSunriseApplication.getApplication(getActivity()).getApplicationComponent())
                .build();
        diComponent.inject(this);
        presenter.loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    @Override
    public void populateData(UserProfileModel userDetails) {

        if(userDetails != null){
            tvUserName.setText(userDetails.getUserName());
            tvFlatNumber.setText(userDetails.getFlatDetails().getFlatNo());
            tvIssue.setText("10");
            tvPendingIssue.setText("3");
            tvCompletedIssue.setText("7");
            tvBlock.setText(userDetails.getFlatDetails().getBlockNo());
            tvFlatNo.setText(userDetails.getFlatDetails().getDoorNo()+userDetails.getFlatDetails().getFloorNo());
            tvInterCom.setText(userDetails.getFlatDetails().getExtentionNo());
            tvMobNo.setText(userDetails.getUserPhNo());
            tvEmail.setText(userDetails.getUserEmail());

        }


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
