package suku.com.meenasunrise.feature.login;

import suku.com.meenasunrise.feature.common.CommonViewInterface;

public interface LoginContract {

    interface view extends CommonViewInterface{
        void openHomeScreen();
        void displayError(int field,String error);
    }

    interface presenter {

        public void logIn(String userId, String password);
    }
}
