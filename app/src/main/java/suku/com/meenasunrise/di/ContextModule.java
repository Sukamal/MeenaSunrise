package suku.com.meenasunrise.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;
    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @AplicationScope
    Context provideContext() {
        return context;
    }
}
