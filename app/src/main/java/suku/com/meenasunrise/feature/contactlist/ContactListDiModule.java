package suku.com.meenasunrise.feature.contactlist;

import dagger.Module;
import dagger.Provides;
import suku.com.meenasunrise.feature.directory.DirectoryContract;
import suku.com.meenasunrise.feature.directory.DirectoryFragmentScope;
import suku.com.meenasunrise.feature.directory.DirectoryPresenter;

@Module
public class ContactListDiModule {

    private ContactListContract.view view;

    public ContactListDiModule(ContactListContract.view view){
        this.view  = view;
    }

    @ContactListFragmentScope
    @Provides
    public ContactListContract.view provideView(){
        return view;
    }

    @ContactListFragmentScope
    @Provides
    public ContactListContract.presenter providePresenter(ContactListPresenter presenter){
        return presenter;
    }
}
