package com.example.fitbitpart1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitbitpart1.FoodEntry

import com.example.fitbitpart1.databinding.RowFoodBinding

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.VH>() {
    private val data = mutableListOf<FoodEntry>()

    fun submit(list: List<FoodEntry>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class VH(private val b: RowFoodBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(item: FoodEntry) {
            b.nameText.text = item.name
            b.calText.text = item.calories.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(data[position])
    override fun getItemCount() = data.size
}