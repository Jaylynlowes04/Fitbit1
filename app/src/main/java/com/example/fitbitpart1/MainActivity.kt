package com.example.fitbitpart1

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitbitpart1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val vm: FoodViewModel by viewModels()
    private val adapter = FoodAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.recycler.layoutManager = LinearLayoutManager(this)
        b.recycler.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        b.recycler.adapter = adapter

        b.addButton.setOnClickListener {
            startActivity(Intent(this, AddEntryActivity::class.java))
        }

        // Observe DB → updates RecyclerView automatically
        vm.entries.observe(this) { adapter.submit(it) }
    }
}