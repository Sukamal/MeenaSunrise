package suku.com.meenasunrise.feature.home;

import suku.com.meenasunrise.feature.common.CommonViewInterface;

public interface HomeContract {

    interface view extends CommonViewInterface{

        public void displyLogoutDialog();
        public void displyLoginScreen();
    }

    interface presenter {

        public void doLogout();
    }
}
