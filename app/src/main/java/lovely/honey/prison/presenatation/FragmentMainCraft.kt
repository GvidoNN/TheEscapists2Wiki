package lovely.honey.prison.presenatation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lovely.honey.prison.R
import lovely.honey.prison.data.repository.FavouriteItemsRepositoryImpl
import lovely.honey.prison.data.repository.ItemsRepositoryImpl
import lovely.honey.prison.data.repository.UserRepositoryImpl
import lovely.honey.prison.databinding.FragmentMainCraftBinding
import lovely.honey.prison.domain.models.Items
import lovely.honey.prison.presenatation.recycler.ItemAdapter
import java.util.Locale


class FragmentMainCraft : Fragment() {

    private lateinit var adapter: ItemAdapter
    private lateinit var itemsList: List<Items>
    private lateinit var binding: FragmentMainCraftBinding

    private val itemsRepository by lazy { ItemsRepositoryImpl(context = requireContext()) }
    private val userRepository by lazy { UserRepositoryImpl(context = requireContext()) }
    private val favouriteItemsRepository by lazy { FavouriteItemsRepositoryImpl(context = requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCraftBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        checkFirstEnter()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        itemsList = itemsRepository.dataInitialize()

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        lifecycleScope.launch(Dispatchers.IO) {
            val adapterInstance = ItemAdapter(
                itemList = itemsList as ArrayList<Items>,
                onLikeClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        favouriteItemsRepository.insertItems(it)
                        val updatedList = favouriteItemsRepository.getAllItems()
                        withContext(Dispatchers.Main) {
                            adapter.updateFavouriteList(updatedList)
                        }
                    }
                },
                onDislikeClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        favouriteItemsRepository.deleteItem(it)
                        val updatedList = favouriteItemsRepository.getAllItems()
                        withContext(Dispatchers.Main) {
                            adapter.updateFavouriteList(updatedList)
                        }
                    }
                },
                favouriteItemList = favouriteItemsRepository.getAllItems()
            )

            withContext(Dispatchers.Main) {
                adapter = adapterInstance
                binding.recyclerView.adapter = adapter
            }

            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterList(newText)
                    adapter.notifyDataSetChanged()
                    return false
                }
            })
        }
    }

    private fun checkFirstEnter() {
        if (!userRepository.getFirstEnter()) {
            findNavController().navigate(R.id.action_fragmentMainCraft_to_fragmentOnboarding)
        }
    }

    fun filterList(query: String?): ArrayList<Items> {
        val filteredList = ArrayList<Items>()
        if (query != null) {
            for (i in itemsList) {
                if (i.name.lowercase(Locale.ROOT).contains(query.lowercase())) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
            } else {
                adapter.setFilteredList(filteredList)
                adapter.notifyDataSetChanged()
            }
        }
        return filteredList
    }
}