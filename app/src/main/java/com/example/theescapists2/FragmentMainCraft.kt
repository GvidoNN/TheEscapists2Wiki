package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theescapists2.databinding.FragmentMainCraftBinding
import com.example.theescapists2.recycler.ItemAdapter
import com.example.theescapists2.recycler.Items


class FragmentMainCraft : Fragment(){
    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemsArrayList: ArrayList<Items>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var craft: Array<String>
    lateinit var intelligence: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainCraftBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.craftId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mapsId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentMainCraft_to_fragmentMap)
                    true
                }
                R.id.wallpaperId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentMainCraft_to_fragmentWallpaper)
                    true
                }
                else -> false
            }
        }
        return binding.root
    }


    /*companion object {

        @JvmStatic
        fun newInstance() = FragmentMainCraft().apply {
            arguments = Bundle().apply {
            }
            val fragment = FragmentMainCraft()
            fragment.arguments = arguments
            return fragment
        }

    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ItemAdapter(itemsArrayList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun dataInitialize() {
        itemsArrayList = arrayListOf<Items>()

        imageId = arrayOf(
            R.drawable.baseball,
            R.drawable.sockandmolotok
        )
        name = arrayOf(
            getString(R.string.baseball_bat),
            getString(R.string.sock_mase)
        )

        craft = arrayOf(
            getString(R.string.baseball_bat_craft),
            getString(R.string.sock_mase_craft)
        )

        intelligence = arrayOf("40",
            "40"
        )

        for (i in imageId.indices) {
            val items = Items(imageId[i], name[i], craft[i], intelligence[i])
            itemsArrayList.add(items)

        }
    }
}