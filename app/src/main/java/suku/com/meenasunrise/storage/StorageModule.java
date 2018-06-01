package suku.com.meenasunrise.storage;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import suku.com.meenasunrise.di.AplicationScope;
import suku.com.meenasunrise.di.ContextModule;
import suku.com.meenasunrise.storage.database.MyDatabase;
import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

@Module(includes = {ContextModule.class})
public class StorageModule {

    @Provides
    @AplicationScope
    public AppPreference provideAppPreference(Context context){
        return  new AppPreference(context);
    }

    @Provides
    @AplicationScope
    public MyDatabase getMyDatabase(Context context){
        MyDatabase myDatabase = Room.databaseBuilder(context,MyDatabase.class, AppConstant.DATABASE_NAME).build();
        return myDatabase;
    }

}
