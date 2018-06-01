package suku.com.meenasunrise.feature.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeDiModule {

    private HomeContract.view view;

    public HomeDiModule(HomeContract.view view){
        this.view = view;
    }

    @HomeActivityScope
    @Provides
    public HomeContract.view provideView(){
        return view;
    }

    @HomeActivityScope
    @Provides
    public HomeContract.presenter providePresenter(HomePresenter presenter){
        return presenter;
    }

}
