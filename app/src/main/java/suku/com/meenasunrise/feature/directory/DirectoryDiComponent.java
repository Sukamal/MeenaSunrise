package suku.com.meenasunrise.feature.directory;

import dagger.Component;

@DirectoryFragmentScope
@Component(modules = {DirectoryDiModule.class})
public interface DirectoryDiComponent {

    void inject(DirectoryFragment fragment);
}
