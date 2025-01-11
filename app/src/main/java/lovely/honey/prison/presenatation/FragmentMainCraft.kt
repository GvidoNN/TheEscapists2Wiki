package lovely.honey.prison.presenatation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.R
import lovely.honey.prison.data.repository.ItemsRepositoryImpl
import lovely.honey.prison.databinding.FragmentMainCraftBinding
import lovely.honey.prison.domain.models.Items
import lovely.honey.prison.recycler.ItemAdapter
import java.util.Locale


class FragmentMainCraft : Fragment() {

    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var itemsList: List<Items>
    private val itemsRepository by lazy { ItemsRepositoryImpl(context = requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainCraftBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        itemsList = itemsRepository.dataInitialize()
        recyclerView = view.findViewById(R.id.recycler_view)
        searchView = view.findViewById(R.id.searchView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        adapter = ItemAdapter(itemsList as ArrayList<Items>)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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