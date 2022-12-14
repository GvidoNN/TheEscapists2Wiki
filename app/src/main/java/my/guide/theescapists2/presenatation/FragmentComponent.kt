package my.guide.theescapists2.presenatation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.databinding.FragmentComponentBinding
import my.guide.theescapists2.recycler.ComponentAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import my.guide.theescapists2.R
import my.guide.theescapists2.data.repository.ComponentsRepositoryImpl

class FragmentComponent : Fragment() {
    private lateinit var adapter: ComponentAdapter
    private lateinit var recyclerView: RecyclerView
    private val componentsRepository by lazy { ComponentsRepositoryImpl(context = requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentComponentBinding.inflate(inflater)
        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView2.loadAd(adRequest)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ComponentAdapter(componentsRepository.dataInitialize())
        recyclerView.adapter = adapter
    }

}