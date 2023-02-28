package my.guide.theescapists2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.guide.theescapists2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as AppMainState).showAdIfAvailable(this) {
        }
    }

}