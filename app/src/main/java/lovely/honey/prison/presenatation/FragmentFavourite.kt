package lovely.honey.prison.presenatation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lovely.honey.prison.data.repository.FavouriteItemsRepositoryImpl
import lovely.honey.prison.databinding.FragmentFavouriteBinding
import lovely.honey.prison.domain.models.Items
import lovely.honey.prison.presenatation.recycler.ItemAdapter

class FragmentFavourite : Fragment() {

    private lateinit var adapter: ItemAdapter
    private lateinit var binding: FragmentFavouriteBinding

    private val favouriteItemsRepository by lazy { FavouriteItemsRepositoryImpl(context = requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)

        lifecycleScope.launch(Dispatchers.IO) {
            val dbItems = favouriteItemsRepository.getAllItems()
            val adapterInstance = ItemAdapter(
                itemList = dbItems as ArrayList<Items>,
                onLikeClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        favouriteItemsRepository.insertItems(it)
                    }
                },
                favouriteItemList = favouriteItemsRepository.getAllItems(),
                onDislikeClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        favouriteItemsRepository.deleteItem(it)
                    }
                }
            )

            withContext(Dispatchers.Main) {
                if (dbItems.isEmpty) {
                    binding.recyclerView.visibility = View.GONE
                    binding.imEmpty.visibility = View.VISIBLE
                    binding.tvEmpty.visibility = View.VISIBLE
                } else {
                    adapter = adapterInstance
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.imEmpty.visibility = View.GONE
                    binding.tvEmpty.visibility = View.GONE
                    binding.recyclerView.adapter = adapter
                }

            }
        }
    }
}