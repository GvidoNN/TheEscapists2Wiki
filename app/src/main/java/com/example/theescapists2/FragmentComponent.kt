package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theescapists2.databinding.FragmentComponentBinding
import com.example.theescapists2.recycler.ComponentAdapter
import com.example.theescapists2.recycler.Components

class FragmentComponent : Fragment() {
    private lateinit var adapter: ComponentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var componentsArrayList: ArrayList<Components>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentComponentBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.componentId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.craftId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentWallpaper_to_fragmentMainCraft)
                    true
                }
                R.id.mapsId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentWallpaper_to_fragmentMap)
                    true
                }
                else -> false
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ComponentAdapter(componentsArrayList)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentComponent().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun dataInitialize(){
        componentsArrayList = arrayListOf<Components>()

        name = arrayOf(
            getString(R.string.roll_of_duct),
            getString(R.string.timber)

        )

        imageId = arrayOf(
            R.drawable.rollofduct,
            R.drawable.timber
        )

        for(i in imageId.indices){
            val components = Components(name[i],imageId[i])
            componentsArrayList.add(components)
        }


    }
}