package com.example.fitbitpart1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_entries")
class FoodEntry (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
            val name: String,
            val calories: Int,
            val createdAt: Long = System.currentTimeMillis()
)