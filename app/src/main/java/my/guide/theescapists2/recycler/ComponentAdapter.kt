package my.guide.theescapists2.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.R
import my.guide.theescapists2.databinding.ItemComponentBinding
import my.guide.theescapists2.domain.models.Components

class ComponentAdapter(private val componentList: ArrayList<Components>) :
    RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_component, parent, false)
        return ComponentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        holder.bind(componentList[position])
    }

    override fun getItemCount(): Int {
        return componentList.size
    }

    class ComponentViewHolder(component: View) : RecyclerView.ViewHolder(component) {
        private val binding = ItemComponentBinding.bind(component)
        fun bind(component: Components) {
            binding.tvNameComponent.text = component.name
            binding.imComponent.setImageResource(component.imageId)
        }
    }
}