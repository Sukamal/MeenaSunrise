package suku.com.meenasunrise.feature.contactlist;

import java.util.List;

import suku.com.meenasunrise.feature.common.CommonViewInterface;
import suku.com.meenasunrise.model.DirectoryCategoryModel;
import suku.com.meenasunrise.storage.database.entity.UserDetails;

public interface ContactListContract {

    interface view extends CommonViewInterface {
        void displayContacts(List<UserDetails> modelList);
        void displayContactDetails(String userId);

    }

    interface presenter {
        void loadData();
        void receiveRoutingData(int code);
    }
}
