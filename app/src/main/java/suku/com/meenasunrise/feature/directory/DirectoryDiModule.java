package suku.com.meenasunrise.feature.directory;

import dagger.Module;
import dagger.Provides;

@Module
public class DirectoryDiModule {

    private DirectoryContract.view view;

    public DirectoryDiModule(DirectoryContract.view view){
        this.view  = view;
    }

    @DirectoryFragmentScope
    @Provides
    public DirectoryContract.view provideView(){
        return view;
    }

    @DirectoryFragmentScope
    @Provides
    public DirectoryContract.presenter providePresenter(DirectoryPresenter presenter){
        return presenter;
    }
}
