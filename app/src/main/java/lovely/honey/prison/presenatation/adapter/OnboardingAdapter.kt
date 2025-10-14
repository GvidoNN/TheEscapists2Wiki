package lovely.honey.prison.presenatation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R

data class OnboardingItem(val imageRes: Int, val text: String)

class OnboardingAdapter(
    private val items: List<OnboardingItem>,
    private val onStartClick: () -> Unit
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.imageView)
        private val text: TextView = view.findViewById(R.id.textView)

        fun bind(item: OnboardingItem, isLast: Boolean) {
            image.setImageResource(item.imageRes)
            text.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position], position == items.lastIndex)
    }

    override fun getItemCount(): Int = items.size
}