package com.example.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theescapists2.databinding.FragmentMainCraftBinding

class FragmentMainCraft : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainCraftBinding.inflate(inflater)
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