package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.theescapists2.databinding.FragmentMapBinding

class FragmentMap : Fragment(){
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
                R.id.wallpaperId -> {
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
}