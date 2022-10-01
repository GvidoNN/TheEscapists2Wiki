package com.example.theescapists2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import com.example.theescapists2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.craft)
        bottomNavigation()
        if (savedInstanceState == null){
            val fragment = FragmentMainCraft.newInstance(
            )
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_craft_fragment, fragment)
                .commit()

        }
    }


    fun bottomNavigation(){
        binding.bottomNavigation.selectedItemId = R.id.craftId
        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.mapsId ->{
                    Toast.makeText(this,"Map",Toast.LENGTH_SHORT).show()
                    val fragment = FragmentMap.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_craft_fragment, fragment)
                        .commit()
                    true

                }
                R.id.craftId ->{
                    Toast.makeText(this,"Craft",Toast.LENGTH_SHORT).show()
                    val fragment = FragmentMainCraft.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_craft_fragment, fragment)
                        .commit()
                    true

                }
                R.id.wallpaperId ->{
                    Toast.makeText(this,"Wallpaper",Toast.LENGTH_SHORT).show()
                    val fragment = FragmentWallpaper.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.place_craft_fragment, fragment)
                        .commit()
                    true

                }

                else -> false
            }

        }
    }

}