package my.guide.theescapists2.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.R
import my.guide.theescapists2.databinding.ItemItemBinding
import my.guide.theescapists2.domain.models.Items
import org.w3c.dom.Text

class ItemAdapter(private var itemList: ArrayList<Items>): RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>(){
    lateinit var context: Context


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
        holder.titleImage.setImageResource(itemList[position].imageId)
        holder.tvName.text = itemList[position].name
        holder.tvCraft.text = itemList[position].craft
        holder.imOne.setImageResource(itemList[position].imOne)
        holder.imTwo.setImageResource(itemList[position].imTwo)
        holder.imThree.setImageResource(itemList[position].imThree)
        holder.tvIntelligence.text = itemList[position].intelligence

        }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val titleImage: ImageView = item.findViewById(R.id.title_image)
        val tvName: TextView = item.findViewById(R.id.tvName)
        val tvCraft: TextView = item.findViewById(R.id.tvCraft)
        val imOne: ImageView = item.findViewById(R.id.imOne)
        val imTwo: ImageView = item.findViewById(R.id.imTwo)
        val imThree: ImageView = item.findViewById(R.id.imThree)
        val tvIntelligence: TextView = item.findViewById(R.id.tvIntelligence)
    }
}