package com.example.theescapists2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.theescapists2.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMapsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.map)
        bottomNavigation()
    }

    fun bottomNavigation() {
        binding.bottomNavigation.selectedItemId = R.id.mapsId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.craftId -> {
                    Toast.makeText(this, "Craft", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
//                R.id.mapsId -> {
//                    Toast.makeText(this, "Maps", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, MapsActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
                R.id.wallpaperId -> {
                    Toast.makeText(this, "wallapapers", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, WallpaperActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }

        }
    }
}