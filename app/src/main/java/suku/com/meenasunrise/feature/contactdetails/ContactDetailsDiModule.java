package suku.com.meenasunrise.feature.contactdetails;

import dagger.Module;
import dagger.Provides;
import suku.com.meenasunrise.feature.contactlist.ContactListContract;
import suku.com.meenasunrise.feature.contactlist.ContactListFragmentScope;
import suku.com.meenasunrise.feature.contactlist.ContactListPresenter;

@Module
public class ContactDetailsDiModule {

    private ContactDetailsContract.view view;

    public ContactDetailsDiModule(ContactDetailsContract.view view){
        this.view  = view;
    }

    @ContactDetailsFragmentScope
    @Provides
    public ContactDetailsContract.view provideView(){
        return view;
    }

    @ContactDetailsFragmentScope
    @Provides
    public ContactDetailsContract.presenter providePresenter(ContactDetailsPresenter presenter){
        return presenter;
    }
}
