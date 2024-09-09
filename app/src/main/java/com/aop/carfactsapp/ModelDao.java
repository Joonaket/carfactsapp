package com.aop.carfactsapp;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ModelDao {

    @Query("SELECT * FROM model WHERE name LIKE :name LIMIT 1")
    Model findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll (Model... models);

    @Query("SELECT * FROM model")
    Model[] getAllModels();

    @Query("DELETE FROM model")
    void deleteAll();

}
