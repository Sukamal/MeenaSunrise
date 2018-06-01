package suku.com.meenasunrise.storage.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import suku.com.meenasunrise.model.ContactDetailsModel;
import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.UserDetails;

@Dao
public interface UserDetailsDao {


    @Query("SELECT * FROM UserDetails")
    List<UserDetails> getAll();

    @Query("SELECT * FROM UserDetails WHERE user_phno = :Id")
    UserDetails findById(String Id);

    @Insert
    void insertAll(List<UserDetails> userDetails);

    @Update
    void update(UserDetails userDetails);

    @Delete
    void delete(UserDetails userDetails);

    @Query("select ud.user_name, ud.user_email,ud.user_phno, fd.intercom_number,fd.block_number,fd.flat_number from UserDetails ud "
            +"inner join FlatDetails fd on  ud.user_flat_id = fd.flat_number"
            +" where userId = :Id")
    ContactDetailsModel getContactDetails(String Id);
}
