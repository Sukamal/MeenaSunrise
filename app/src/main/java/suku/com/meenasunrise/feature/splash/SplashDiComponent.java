package suku.com.meenasunrise.feature.splash;

import dagger.Component;
import suku.com.meenasunrise.di.ApplicationComponent;
import suku.com.meenasunrise.di.ContextModule;
import suku.com.meenasunrise.storage.preference.AppPreference;

@SplashActivityScope
@Component(dependencies = {ApplicationComponent.class},modules = {SplashDiModule.class})
public interface SplashDiComponent {

    void inject(SplashActivity splashActivity);
//    void inject(SplashActivity splashActivity,AppPreference preference);

//    AppPreference getPreference(); //Directly we can get instance of AppPreference because its uses ApplicationComponent dependencies

}
