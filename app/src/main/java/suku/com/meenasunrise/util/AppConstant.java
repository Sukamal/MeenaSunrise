package suku.com.meenasunrise.util;

/**
 * Created by SukamalD on 29-01-2018.
 */

public class AppConstant {

    public static final String DATABASE_NAME = "com.suku.mmenasunrise.db";
    public static final int DATABASE_VERSION = 1;
    public static final String PREFERENCE_NAME = "com.suku.mmenasunrise.pref";

    public static long ADD_DISPLAY_THRESHOLD = 60000 * 1;

    public enum Preferences {
        IS_LOADED,
        LOOGED_IN_USER_ID
    }

    public enum ExtraTag {
        TAG_VALUE_1
    }

}
