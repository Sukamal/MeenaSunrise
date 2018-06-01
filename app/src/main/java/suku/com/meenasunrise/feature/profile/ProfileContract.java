package suku.com.meenasunrise.feature.profile;

import suku.com.meenasunrise.feature.common.CommonViewInterface;
import suku.com.meenasunrise.model.UserProfileModel;

public interface ProfileContract {

    interface view extends CommonViewInterface {
        public void populateData(UserProfileModel userProfileModel);
    }

    interface presenter {
        public void loadData();
    }
}
