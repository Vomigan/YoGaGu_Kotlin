package com.example.yogagu;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Guide.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
    private static MyDatabase INSTANCE;
    public static MyDatabase getDbInstance(final Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class, "WordsDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}