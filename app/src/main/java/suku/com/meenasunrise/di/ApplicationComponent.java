package suku.com.meenasunrise.di;


import android.content.Context;

import dagger.Component;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.storage.StorageModule;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.preference.AppPreference;
@AplicationScope
@Component(modules = {ApplicationModule.class, StorageModule.class})
public interface ApplicationComponent {
    MyDatabase getMyDatabase();
    AppPreference getAppPreference();
}
