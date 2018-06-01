package suku.com.meenasunrise.feature.contactdetails;

import dagger.Component;
import suku.com.meenasunrise.di.ApplicationComponent;
import suku.com.meenasunrise.feature.contactlist.ContactListDiModule;
import suku.com.meenasunrise.feature.contactlist.ContactListFragment;
import suku.com.meenasunrise.feature.contactlist.ContactListFragmentScope;

@ContactDetailsFragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ContactDetailsDiModule.class})
public interface ContactDetailsDiComponent {

    void inject(ContactDetailsFragment fragment);
}
