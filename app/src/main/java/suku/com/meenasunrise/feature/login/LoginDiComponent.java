package suku.com.meenasunrise.feature.login;

import dagger.Component;

@Component(modules = LoginDiModule.class)
public interface LoginDiComponent {
    void inject(LoginActivity activity);
}
