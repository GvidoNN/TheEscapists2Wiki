package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theescapists2.databinding.FragmentMapBinding
import com.example.theescapists2.recycler.MapAdapter
import com.example.theescapists2.recycler.Maps

class FragmentMap : Fragment(), MapAdapter.Listener{

    private lateinit var adapter: MapAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var mapsArrayList: ArrayList<Maps>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMapBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.mapsId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.craftId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentMap_to_fragmentMainCraft)
                    true
                }
                R.id.componentId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentMap_to_fragmentWallpaper)
                    true
                }
                else -> false
            }
        }
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentMap().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MapAdapter(mapsArrayList, this)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        mapsArrayList = arrayListOf<Maps>()

        imageId = arrayOf(
            R.drawable.centerperks20,
            R.drawable.cougarcreekrailroad,
            R.drawable.rattlesnakesprings,
            R.drawable.kapow,
            R.drawable.hmsorca,
            R.drawable.hmpoffshore,
            R.drawable.forttundra,
            R.drawable.area17,
            R.drawable.airforcecon,
            R.drawable.ussanomaly,
            R.drawable.santassshakedown,
            R.drawable.snowwayout
        )
        name = arrayOf(
            getString(R.string.center_perks_2_0),
            getString(R.string.cougar_creek_railroad),
            getString(R.string.rattlesnake_springs),
            getString(R.string.kapowcamp),
            getString(R.string.hmsorca),
            getString(R.string.hmpoffshore),
            getString(R.string.forttundra),
            getString(R.string.area17),
            getString(R.string.airforcecon),
            getString(R.string.ussanomaly),
            getString(R.string.santassshakedown),
            getString(R.string.snowwayout)
        )

        for (i in imageId.indices) {
            val maps = Maps(imageId[i], name[i])
            mapsArrayList.add(maps)

        }
    }

    override fun onClick(map: Maps) {
        super.onClick(map)
        Toast.makeText(this,"Нажали на ${map.mapName}", Toast.LENGTH_SHORT).show()
    }
}