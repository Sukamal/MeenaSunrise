package suku.com.meenasunrise.feature.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginDiModule {

    private LoginContract.view view;

    public LoginDiModule(LoginContract.view view){
        this.view = view;
    }

    @Provides
    public LoginContract.view provideView(){
        return view;
    }

    @Provides
    public LoginContract.presenter providePresenter(LoginPresenter presenter){
        return presenter;
    }

}
