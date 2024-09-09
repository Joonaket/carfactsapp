package com.aop.carfactsapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class},version = 1)
public abstract class  ModelDatabase extends RoomDatabase {
    public abstract ModelDao modelDao();
}
