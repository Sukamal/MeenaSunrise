package suku.com.meenasunrise.storage.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import suku.com.meenasunrise.storage.database.dao.FlatDetailsDao;
import suku.com.meenasunrise.storage.database.dao.ProductDao;
import suku.com.meenasunrise.storage.database.dao.UserDetailsDao;
import suku.com.meenasunrise.storage.database.entity.FlatDetails;
import suku.com.meenasunrise.storage.database.entity.Product;
import suku.com.meenasunrise.storage.database.entity.UserDetails;
import suku.com.meenasunrise.util.AppConstant;

@Database(entities = {Product.class, FlatDetails.class, UserDetails.class},version = AppConstant.DATABASE_VERSION,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase{
    public abstract ProductDao productDao();
    public abstract FlatDetailsDao flatDetailsDao();
    public abstract UserDetailsDao userDetailsDao();
}
