package lovely.honey.prison.presenatation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R
import lovely.honey.prison.databinding.ItemMapBinding
import lovely.honey.prison.domain.models.Maps

class MapAdapter(private var MapsArrayList: ArrayList<Maps>, val listener: Listener):
    RecyclerView.Adapter<MapAdapter.MapsViewHolder>() {

    class MapsViewHolder(map : View): RecyclerView.ViewHolder(map){
        private val binding = ItemMapBinding.bind(map)
        fun bind(map: Maps, listener: Listener){
            binding.imPrison.setImageResource(map.imageId)
            binding.tvNamePrison.text = map.mapName
            itemView.setOnClickListener{
                listener.onClick(map)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_map,parent,false)
        return MapsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        holder.bind(MapsArrayList[position], listener)
    }

    override fun getItemCount(): Int {
        return MapsArrayList.size
    }

    interface Listener{
        fun onClick(map: Maps){

        }
    }
}