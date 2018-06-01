package suku.com.meenasunrise.feature.profile;

import dagger.Component;
import suku.com.meenasunrise.di.ApplicationComponent;

@ProfileFragmentScope
@Component(dependencies = {ApplicationComponent.class},modules = {ProfileDiModule.class})
public interface ProfileDiComponent {
    public void inject(ProfileFragment fragment);
}
