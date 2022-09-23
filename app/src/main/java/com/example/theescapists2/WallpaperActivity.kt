package com.example.theescapists2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.theescapists2.databinding.ActivityWallpaperBinding

class WallpaperActivity : AppCompatActivity() {
    lateinit var binding: ActivityWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}