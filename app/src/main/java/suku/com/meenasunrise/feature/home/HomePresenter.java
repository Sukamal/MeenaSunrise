package suku.com.meenasunrise.feature.home;

import javax.inject.Inject;

import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

public class HomePresenter implements HomeContract.presenter {

    @Inject
    AppPreference preference;

    private HomeContract.view view;

    @Inject
    public HomePresenter(HomeContract.view view){
        this.view = view;
    }

    @Override
    public void doLogout() {
        preference.removePreferences(AppConstant.Preferences.IS_LOADED.name());
        preference.removePreferences(AppConstant.Preferences.LOOGED_IN_USER_ID.name());
        view.displyLoginScreen();
    }
}
