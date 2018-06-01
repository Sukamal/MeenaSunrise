package suku.com.meenasunrise.storage.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.Product;

@Dao
public interface FlatDetailsDao {


    @Query("SELECT * FROM flatdetails")
    List<FlatDetails> getAll();

    @Query("SELECT * FROM FlatDetails WHERE flat_number = :flatId")
    FlatDetails findById(String flatId);

    @Insert
    void insertAll(List<FlatDetails> flatDetails);

    @Update
    void update(FlatDetails flatDetails);

    @Delete
    void delete(FlatDetails flatDetails);
}
