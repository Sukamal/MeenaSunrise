package suku.com.meenasunrise.model;

import android.arch.persistence.room.ColumnInfo;

public class ContactDetailsModel {

    @ColumnInfo(name = "user_name")
    private String name;
    @ColumnInfo(name = "user_phno")
    private String phNo;
    @ColumnInfo(name = "user_email")
    private String email;
    @ColumnInfo(name = "intercom_number")
    private String extention;
    @ColumnInfo(name = "block_number")
    private String block;
    @ColumnInfo(name = "flat_number")
    private String flatNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }
}
