package com.example.asm.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asm.entity.Chi;

import java.util.List;

@Dao
public interface ChiDao {
    @Query("SELECT * FROM chi")
    LiveData<List<Chi>> findAll();

    @Query("SELECT sum(sotien) FROM chi")
    LiveData<Integer> sumTongChi();

    @Insert
        void insert (Chi chi);
    @Update
        void update (Chi chi);
    @Delete
        void delete(Chi chi);


}
