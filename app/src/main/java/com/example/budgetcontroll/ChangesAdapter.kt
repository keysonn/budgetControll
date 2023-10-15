package com.example.budgetcontroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetcontroll.databinding.ChangeItemBinding

class ChangesAdapter: RecyclerView.Adapter<ChangesAdapter.ChangesHolder>() {

    val changesList = ArrayList<ChangesHistory>()

    class ChangesHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ChangeItemBinding.bind(item)
        fun bind(changes: ChangesHistory) = with(binding){
            fromCell.text = changes.from
            whereCell.text= changes.where
            change.text = changes.change.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.change_item, parent, false)
        return ChangesHolder(view)
    }

    override fun onBindViewHolder(holder: ChangesHolder, position: Int) {
        holder.bind(changesList[position])
    }

    override fun getItemCount(): Int {
        return changesList.size
    }

    fun addChange(changes: ChangesHistory){
        changesList.add(changes)
        notifyDataSetChanged()
    }

}