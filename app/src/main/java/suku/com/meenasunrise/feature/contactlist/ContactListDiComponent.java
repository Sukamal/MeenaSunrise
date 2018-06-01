package suku.com.meenasunrise.feature.contactlist;

import dagger.Component;
import suku.com.meenasunrise.di.ApplicationComponent;
import suku.com.meenasunrise.feature.directory.DirectoryDiModule;
import suku.com.meenasunrise.feature.directory.DirectoryFragment;
import suku.com.meenasunrise.feature.directory.DirectoryFragmentScope;

@ContactListFragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ContactListDiModule.class})
public interface ContactListDiComponent {

    void inject(ContactListFragment fragment);
}
