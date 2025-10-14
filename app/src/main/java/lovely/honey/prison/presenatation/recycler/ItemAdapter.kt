package lovely.honey.prison.presenatation.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R
import lovely.honey.prison.domain.models.Items

class ItemAdapter(private var itemList: ArrayList<Items>): RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>(){
    lateinit var context: Context


    class ItemsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val titleImage: ImageView = item.findViewById(R.id.title_image)
        val tvName: TextView = item.findViewById(R.id.tvName)
        val tvCraft: TextView = item.findViewById(R.id.tvCraft)
        val imOne: ImageView = item.findViewById(R.id.imOne)
        val imTwo: ImageView = item.findViewById(R.id.imTwo)
        val imThree: ImageView = item.findViewById(R.id.imThree)
        val tvIntelligence: TextView = item.findViewById(R.id.tvIntelligence)
        val tvContraband: TextView = item.findViewById(R.id.tvContraband)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ItemsViewHolder(view)
    }

    fun setFilteredList(itemList: ArrayList<Items>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val itemData = itemList[position]
        holder.titleImage.setImageResource(itemData.imageId)
        holder.tvName.text = itemData.name
        holder.tvCraft.text = itemData.craft
        holder.imOne.setImageResource(itemData.imOne)
        holder.imTwo.setImageResource(itemData.imTwo)
        holder.imThree.setImageResource(itemData.imThree)
        holder.tvIntelligence.text = itemData.intelligence
        if(itemData.haveThirdItem){
            holder.imThree.visibility = View.VISIBLE
        } else {
            holder.imThree.visibility = View.GONE
        }
        if (itemData.contraband) {
            holder.tvContraband.visibility = View.VISIBLE
        } else {
            holder.tvContraband.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}