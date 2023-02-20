package my.guide.theescapists2.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.R
import my.guide.theescapists2.databinding.ItemItemBinding
import my.guide.theescapists2.domain.models.Items

class ItemAdapter(private var itemList: ArrayList<Items>): RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false)
        return ItemsViewHolder(view)
    }

    fun setFilteredList(itemList: ArrayList<Items>){
        this.itemList = itemList
        notifyDataSetChanged()
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
            binding.imOne.setImageResource(item.imOne)
            binding.imTwo.setImageResource(item.imTwo)
            binding.imThree.setImageResource(item.imThree)
            binding.tvIntelligence.text = item.intelligence
        }
    }
}