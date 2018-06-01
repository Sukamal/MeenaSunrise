package suku.com.meenasunrise.di;


import android.app.Application;
import android.arch.persistence.room.Database;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import suku.com.meenasunrise.application.MeenaSunriseApplication;
import suku.com.meenasunrise.storage.StorageModule;
import suku.com.meenasunrise.storage.preference.AppPreference;

@Module
public class ApplicationModule {

//    @Provides
//    @AplicationScope
//    public AppPreference provideAppPreference(Context context){
//        return  new AppPreference(context);
//    }


}
