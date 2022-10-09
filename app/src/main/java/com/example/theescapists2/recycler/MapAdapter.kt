package com.example.theescapists2.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theescapists2.R
import com.example.theescapists2.databinding.ItemMapBinding

class MapAdapter(private var MapsArrayList: ArrayList<Maps>):
    RecyclerView.Adapter<MapAdapter.MapsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_map,parent,false)
        return MapsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        holder.bind(MapsArrayList[position])
    }

    override fun getItemCount(): Int {
        return MapsArrayList.size
    }

    class MapsViewHolder(map : View): RecyclerView.ViewHolder(map){
        private val binding = ItemMapBinding.bind(map)
        fun bind(map: Maps){
            binding.imPrison.setImageResource(map.imageId)
            binding.tvNamePrison.text = map.mapName
        }
    }
}