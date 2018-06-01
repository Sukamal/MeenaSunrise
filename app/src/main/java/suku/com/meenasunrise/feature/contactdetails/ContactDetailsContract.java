package suku.com.meenasunrise.feature.contactdetails;

import java.util.List;

import suku.com.meenasunrise.feature.common.CommonViewInterface;
import suku.com.meenasunrise.model.ContactDetailsModel;
import suku.com.meenasunrise.storage.database.entity.UserDetails;

public interface ContactDetailsContract {

    interface view extends CommonViewInterface {
        void displayContactDetails(ContactDetailsModel detailsModel);

    }

    interface presenter {
        void loadData(String userId);

    }
}
