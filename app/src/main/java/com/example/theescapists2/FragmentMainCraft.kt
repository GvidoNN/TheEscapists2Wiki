package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.theescapists2.databinding.ActivityMainBinding
import com.example.theescapists2.databinding.FragmentMainCraftBinding

class FragmentMainCraft : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = FragmentMainCraftBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.craftId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mapsId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view).navigate(R.id.action_fragmentMainCraft_to_fragmentMap)
                    true
                }
                R.id.wallpaperId ->{
                    val view = binding.FragmentMain
                    Navigation.findNavController(view).navigate(R.id.action_fragmentMainCraft_to_fragmentWallpaper)
                    true
                }
                else -> false
            }

        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentMainCraft().apply {
                arguments = Bundle().apply {
                }
            val fragment = FragmentMainCraft()
            fragment.arguments = arguments
            return fragment
            }

    }
}