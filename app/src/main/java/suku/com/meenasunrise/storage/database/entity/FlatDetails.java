package suku.com.meenasunrise.storage.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class FlatDetails {

    @PrimaryKey(autoGenerate = true)
    private int flatId;
    @ColumnInfo(name = "flat_number")
    private String flatNo;
    @ColumnInfo(name = "block_number")
    private String blockNo;
    @ColumnInfo(name = "floor_number")
    private String floorNo;
    @ColumnInfo(name = "door_number")
    private String doorNo;
    @ColumnInfo(name = "intercom_number")
    private String extentionNo;
    @ColumnInfo(name = "status")
    private String status;


    public FlatDetails(){};

    @Ignore
    public FlatDetails(String flatNo,String blockNo,String floorNo,String doorNo,String extentionNo,String status){
        this.flatNo = flatNo;
        this.blockNo = blockNo;
        this.floorNo = floorNo;
        this.doorNo = doorNo;
        this.extentionNo = extentionNo;
        this.status = status;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getExtentionNo() {
        return extentionNo;
    }

    public void setExtentionNo(String extentionNo) {
        this.extentionNo = extentionNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
