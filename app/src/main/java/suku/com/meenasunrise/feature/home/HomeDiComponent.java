package suku.com.meenasunrise.feature.home;

import dagger.Component;
import suku.com.meenasunrise.di.ApplicationComponent;

@HomeActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = HomeDiModule.class)
public interface HomeDiComponent {
    public void inject(HomeActivity activity);
}
