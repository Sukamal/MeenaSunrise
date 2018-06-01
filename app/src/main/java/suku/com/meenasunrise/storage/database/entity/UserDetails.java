package suku.com.meenasunrise.storage.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UserDetails {

    @PrimaryKey(autoGenerate = true)
    private int userId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_phno")
    private String userPhNo;
    @ColumnInfo(name = "user_email")
    private String userEmail;
    @ColumnInfo(name = "user_picture")
    private String userPic;
    @ColumnInfo(name = "user_flat_id")
    private String flatId;
    @ColumnInfo(name = "user_pwd")
    private String password;
    @ColumnInfo(name = "is_active")
    private boolean is_active;


    public UserDetails(String userName,String userPhNo,String userEmail,String userPic,String flatId,String password){
        this.userName = userName;
        this.userPhNo = userPhNo;
        this.userEmail = userEmail;
        this.userPic = userPic;
        this.flatId = flatId;
        this.password = password;
        is_active = true;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getFlatId() {
        return flatId;
    }

    public void setFlatId(String flatId) {
        this.flatId = flatId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
