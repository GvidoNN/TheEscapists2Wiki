package lovely.honey.prison.presenatation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import lovely.honey.prison.presenatation.recycler.ComponentAdapter
import lovely.honey.prison.data.repository.ComponentsRepositoryImpl
import lovely.honey.prison.databinding.FragmentComponentBinding
import lovely.honey.prison.domain.models.Components
import lovely.honey.prison.domain.usecase.PutDataComponentUseCase
import java.util.Locale

class FragmentComponent : Fragment() {

    private lateinit var adapter: ComponentAdapter
    private lateinit var binding: FragmentComponentBinding

    private val componentsRepository by lazy { ComponentsRepositoryImpl(context = requireContext()) }
    private val putDataComponentUseCase by lazy { PutDataComponentUseCase(componentsRepository = componentsRepository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComponentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        with(binding){
            val layoutManager = LinearLayoutManager(context)
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