package suku.com.meenasunrise.feature.profile;

import android.os.Handler;

import javax.inject.Inject;

import suku.com.meenasunrise.model.UserProfileModel;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.UserDetails;
import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

public class ProfilePresenter implements ProfileContract.presenter {

    private ProfileContract.view view;
    @Inject
    AppPreference preference;
    @Inject
    MyDatabase myDatabase;

    private UserProfileModel profileModel;


    @Inject
    public ProfilePresenter (ProfileContract.view view){
        this.view = view;
    }

    @Override
    public void loadData() {
        getLoginUserDetails();
    }

    private void displayOnUi(){
        view.populateData(profileModel);
    }

    private void getLoginUserDetails(){

        final String userId = preference.getStringPref(AppConstant.Preferences.LOOGED_IN_USER_ID.name());
        if(userId != null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final UserDetails user = myDatabase.userDetailsDao().findById(userId);
                    if(user != null){
                        final FlatDetails flatDetails = myDatabase.flatDetailsDao().findById(user.getFlatId());
                        profileModel = new UserProfileModel();
                        profileModel.setFlatDetails(flatDetails);
                        profileModel.setUserPhNo(user.getUserPhNo());
                        profileModel.setUserName(user.getUserName());
                        profileModel.setUserEmail(user.getUserEmail());
                        profileModel.setUserPic(user.getUserPic());
                        displayOnUi();

                    }
                }
            }).start();
        }
    }
}
