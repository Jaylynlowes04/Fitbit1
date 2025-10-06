package com.example.fitbitpart1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: FoodEntry)

    @Query("SELECT * FROM food_entries ORDER BY createdAt DESC")
    fun getAll(): LiveData<List<FoodEntry>>
}