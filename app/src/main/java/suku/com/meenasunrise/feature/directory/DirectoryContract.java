package suku.com.meenasunrise.feature.directory;

import java.util.List;

import suku.com.meenasunrise.feature.common.CommonViewInterface;
import suku.com.meenasunrise.model.DirectoryCategoryModel;

public interface DirectoryContract {

    interface view extends CommonViewInterface {
        void displayCategory(List<DirectoryCategoryModel> modelList);
        void openFlatOwnerContactScreen();
        void openCommityMemberContactScreen();
        void openCommunityContactScreen();
        void openFecilityContactScreen();
    }

    interface presenter {
        void loadData();
        void receiveRoutingData(int code);
    }
}
