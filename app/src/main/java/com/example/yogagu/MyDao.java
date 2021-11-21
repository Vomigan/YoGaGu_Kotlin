package com.example.yogagu;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Query("SELECT * FROM Guide")
    List<Guide> getAll();

    @Query("DELETE FROM guide")
    public void nukeTable();

    @Query("SELECT * FROM Guide WHERE id = :id")
    Guide getById(long id);

    @Insert
    void insert(Guide guide);

    @Update
    void update(Guide guide);

    @Delete
    void delete(Guide guide);
}