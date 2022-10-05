package com.example.theescapists2.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theescapists2.R
import com.example.theescapists2.databinding.ItemItemBinding

class ItemAdapter(private val itemList: ArrayList<Items>): RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(itemList[position])
        }


    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemsViewHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ItemItemBinding.bind(item)
        fun bind(item : Items){
            binding.titleImage.setImageResource(item.imageId)
            binding.tvName.text = item.name
            binding.tvCraft.text = item.craft
            binding.tvIntelligence.text = item.intelligence
        }
    }

}