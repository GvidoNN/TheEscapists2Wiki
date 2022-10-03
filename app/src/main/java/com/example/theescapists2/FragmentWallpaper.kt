package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.theescapists2.databinding.FragmentWallpaperBinding

class FragmentWallpaper : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentWallpaperBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.wallpaperId
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

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentWallpaper().apply {
                arguments = Bundle().apply {

                }
            }
    }
}