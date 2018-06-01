package suku.com.meenasunrise.feature.splash;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import suku.com.meenasunrise.di.AplicationScope;
import suku.com.meenasunrise.di.ContextModule;
import suku.com.meenasunrise.storage.preference.AppPreference;
import suku.com.meenasunrise.util.AppConstant;

@Module
public class SplashDiModule {

    private SplashContract.view view;

    public SplashDiModule(SplashContract.view view) {
        this.view = view;
    }

    @SplashActivityScope
    @Provides
    public SplashContract.view provideView(){
        return view;
    }


    @SplashActivityScope
    @Provides
    public SplashContract.presenter providePresenter(SplashPresenter presenter){
        return presenter;
    }

}
