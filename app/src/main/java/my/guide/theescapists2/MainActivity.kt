package my.guide.theescapists2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.guide.theescapists2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        (application as AppMainState).showAdIfAvailable(this) {
        }
        setContentView(binding.root)
    }

}