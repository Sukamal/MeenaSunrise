package suku.com.meenasunrise.feature.profile;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileDiModule {

    private ProfileContract.view view;

    public ProfileDiModule(ProfileContract.view view){
        this.view = view;
    }

    @ProfileFragmentScope
    @Provides
    public ProfileContract.view provideView(){
        return view;
    }

    @ProfileFragmentScope
    @Provides
    public ProfileContract.presenter providePresenter(ProfilePresenter presenter){
        return presenter;
    }

}
