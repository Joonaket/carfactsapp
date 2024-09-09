package com.aop.carfactsapp;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Model {

    @PrimaryKey(autoGenerate = true)
    public int modelID;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="specsheet")
    public String specSheet;

    @ColumnInfo(name="image_id")
    public int imageId;

    @ColumnInfo(name="story")
    public String story;


}
