package suku.com.meenasunrise.model;

import suku.com.meenasunrise.storage.database.entity.FlatDetails;

public class UserProfileModel {

    private String userName;
    private String userPhNo;
    private String userEmail;
    private String userPic;
    private FlatDetails flatDetails;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhNo() {
        return userPhNo;
    }

    public void setUserPhNo(String userPhNo) {
        this.userPhNo = userPhNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }


    public FlatDetails getFlatDetails() {
        return flatDetails;
    }

    public void setFlatDetails(FlatDetails flatDetails) {
        this.flatDetails = flatDetails;
    }
}
