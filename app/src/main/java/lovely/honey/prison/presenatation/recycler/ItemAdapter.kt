package lovely.honey.prison.presenatation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R
import lovely.honey.prison.domain.models.Items

class ItemAdapter(
    private var itemList: ArrayList<Items>,
    private var favouriteItemList: List<Items>,
    private val onLikeClick: (item: Items) -> Unit,
    private val onDislikeClick: (item: Items) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>() {

    class ItemsViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleImage: ImageView = item.findViewById(R.id.title_image)
        val tvName: TextView = item.findViewById(R.id.tvName)
        val tvCraft: TextView = item.findViewById(R.id.tvCraft)
        val imOne: ImageView = item.findViewById(R.id.imOne)
        val imTwo: ImageView = item.findViewById(R.id.imTwo)
        val imThree: ImageView = item.findViewById(R.id.imThree)
        val tvIntelligence: TextView = item.findViewById(R.id.tvIntelligence)
        val tvContraband: TextView = item.findViewById(R.id.tvContraband)
        val imLike: ImageView = item.findViewById(R.id.imLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ItemsViewHolder(view)
    }

    fun updateFavouriteList(newFavouriteList: List<Items>) {
        favouriteItemList = newFavouriteList
        notifyDataSetChanged()
    }

    fun setFilteredList(itemList: ArrayList<Items>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val itemData = itemList[position]
        with(holder) {
            titleImage.setImageResource(itemData.imageId)
            tvName.text = itemData.name
            tvCraft.text = itemData.craft
            imOne.setImageResource(itemData.imOne)
            imTwo.setImageResource(itemData.imTwo)
            imThree.setImageResource(itemData.imThree)
            tvIntelligence.text = itemData.intelligence
            if (favouriteItemList.any { it.id == itemData.id }) {
                imLike.setImageResource(R.drawable.ic_like_filled)
                imLike.setOnClickListener {
                    onDislikeClick.invoke(itemData)
                    imLike.setImageResource(R.drawable.ic_like)
                }
            } else {
                imLike.setImageResource(R.drawable.ic_like)
                imLike.setOnClickListener {
                    onLikeClick.invoke(itemData)
                    imLike.setImageResource(R.drawable.ic_like_filled)
                }
            }

            if (itemData.haveThirdItem) {
                imThree.visibility = View.VISIBLE
            } else {
                imThree.visibility = View.GONE
            }

            if (itemData.contraband) {
                tvContraband.visibility = View.VISIBLE
            } else {
                tvContraband.visibility = View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}