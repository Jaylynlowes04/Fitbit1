package com.example.fitbitpart1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fitbitpart1.databinding.ActivityAddEntryBinding

class AddEntryActivity : AppCompatActivity() {
    private lateinit var b: ActivityAddEntryBinding
    private val vm: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAddEntryBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.saveBtn.setOnClickListener {
            val name = b.nameInput.text?.toString().orEmpty()
            val calStr = b.calInput.text?.toString().orEmpty()
            val calories = calStr.toIntOrNull()

            if (name.isBlank() || calories == null) {
                Toast.makeText(this, "Enter name and calories", Toast.LENGTH_SHORT).show()
            } else {
                vm.add(name, calories)
                finish() // return to list; observer will refresh
            }
        }
    }
}