package suku.com.meenasunrise.feature.splash;

import suku.com.meenasunrise.feature.common.CommonViewInterface;

public interface SplashContract {

    interface view extends CommonViewInterface{
        void openLoginScreen();
        void openHomeScreen();
    }

    interface presenter {
        void insertStaticData();
        void receiveRoutingData(String code);
    }
}
