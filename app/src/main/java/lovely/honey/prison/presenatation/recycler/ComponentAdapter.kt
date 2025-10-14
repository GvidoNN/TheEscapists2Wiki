package lovely.honey.prison.presenatation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R
import lovely.honey.prison.databinding.ItemComponentBinding
import lovely.honey.prison.domain.models.Components

class ComponentAdapter(private var componentList: ArrayList<Components>) :
    RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_component, parent, false)
        return ComponentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val itemData = componentList[position]
        holder.bind(itemData)

    }

    fun setFilteredList(componentList: ArrayList<Components>){
        this.componentList = componentList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return componentList.size
    }

    class ComponentViewHolder(component: View) : RecyclerView.ViewHolder(component) {
        private val binding = ItemComponentBinding.bind(component)
        fun bind(component: Components) {
            binding.tvNameComponent.text = component.name
            binding.imComponent.setImageResource(component.imageId)
            if (component.contraband) {
                binding.tvContrabandComponent.visibility = View.VISIBLE
            } else {
                binding.tvContrabandComponent.visibility = View.GONE
            }
        }
    }
}