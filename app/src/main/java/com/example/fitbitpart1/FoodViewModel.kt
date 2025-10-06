package com.example.fitbitpart1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = AppDatabase.get(app).foodDao()
    val entries: LiveData<List<FoodEntry>> = dao.getAll()

    fun add(name: String, calories: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(FoodEntry(name = name.trim(), calories = calories))
        }
    }
}