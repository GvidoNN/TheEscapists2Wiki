package my.guide.theescapists2.presenatation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.databinding.FragmentComponentBinding
import my.guide.theescapists2.recycler.ComponentAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import my.guide.theescapists2.R
import my.guide.theescapists2.data.repository.ComponentsRepositoryImpl
import my.guide.theescapists2.domain.models.Components
import my.guide.theescapists2.domain.models.Items
import my.guide.theescapists2.domain.usecase.PutDataComponentUseCase
import java.util.Locale

class FragmentComponent : Fragment() {

    private lateinit var adapter: ComponentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private val componentsRepository by lazy { ComponentsRepositoryImpl(context = requireContext()) }
    private val putDataComponentUseCase by lazy { PutDataComponentUseCase(componentsRepository = componentsRepository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentComponentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)

        searchView = view.findViewById(R.id.searchView)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ComponentAdapter(putDataComponentUseCase.getData())
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

    private fun filterList(query: String?): ArrayList<Components> {
        val filteredList = ArrayList<Components>()
        if (query != null) {
            for (i in componentsRepository.dataInitialize()) {
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