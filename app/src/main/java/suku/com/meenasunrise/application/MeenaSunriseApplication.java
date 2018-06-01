package suku.com.meenasunrise.application;

import android.app.Activity;
import android.app.Application;

import suku.com.meenasunrise.di.ApplicationComponent;
import suku.com.meenasunrise.di.ContextModule;
import suku.com.meenasunrise.di.DaggerApplicationComponent;

public class MeenaSunriseApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    public static MeenaSunriseApplication getApplication(Activity activity){
        return (MeenaSunriseApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getApplicationComponent();
    }

    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .contextModule(new ContextModule(this))  // need to provide all the external dependencies
                    .build();
        }
        return mApplicationComponent;
    }
}
