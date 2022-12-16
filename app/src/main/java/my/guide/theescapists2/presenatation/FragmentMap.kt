package my.guide.theescapists2.presenatation

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.databinding.FragmentMapBinding
import my.guide.theescapists2.recycler.MapAdapter
import my.guide.theescapists2.recycler.Maps
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import my.guide.theescapists2.R
import kotlin.collections.ArrayList


class FragmentMap : Fragment(), MapAdapter.Listener{
    private lateinit var adapter: MapAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var mapsArrayList: ArrayList<Maps>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var bundle : Bundle
    private var interAd: InterstitialAd? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMapBinding.inflate(inflater)
        loadInterAd()
        binding.bottomNavigation.selectedItemId = R.id.mapsId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.craftId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentMap_to_fragmentMainCraft)
                    true
                }
                R.id.componentId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view).navigate(R.id.action_fragmentMap_to_fragmentWallpaper)
                    true
                }
                else -> false
            }
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MapAdapter(mapsArrayList, this)
        recyclerView.adapter = adapter
    }

    private fun showInterAd(){
        if(interAd != null){
            interAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdDismissedFullScreenContent() {
                    interAd = null
                    loadInterAd()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    interAd = null
                    super.onAdFailedToShowFullScreenContent(p0)
                }

                override fun onAdShowedFullScreenContent() {
                    interAd = null
                    loadInterAd()
                }
            }
            interAd?.show(requireContext() as Activity)
        }
    }

    private fun loadInterAd(){
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(requireContext(), "ca-app-pub-7592888554989577/7116101010", adRequest, object : InterstitialAdLoadCallback(){
            override fun onAdFailedToLoad(p0: LoadAdError) {
                interAd = null
            }

            override fun onAdLoaded(ad: InterstitialAd) {
                interAd = ad
            }
        })
    }

    private fun dataInitialize() {
        mapsArrayList = arrayListOf<Maps>()

        imageId = arrayOf(
            R.drawable.centerperks20,
            R.drawable.cougarcreekrailroad,
            R.drawable.rattlesnakesprings,
            R.drawable.kapow,
            R.drawable.hmsorca,
            R.drawable.hmpoffshore,
            R.drawable.forttundra,
            R.drawable.area17,
            R.drawable.airforcecon,
            R.drawable.ussanomaly,
            R.drawable.santassshakedown,
            R.drawable.snowwayout
        )
        name = arrayOf(
            getString(R.string.center_perks_2_0),
            getString(R.string.cougar_creek_railroad),
            getString(R.string.rattlesnake_springs),
            getString(R.string.kapowcamp),
            getString(R.string.hmsorca),
            getString(R.string.hmpoffshore),
            getString(R.string.forttundra),
            getString(R.string.area17),
            getString(R.string.airforcecon),
            getString(R.string.ussanomaly),
            getString(R.string.santassshakedown),
            getString(R.string.snowwayout)
        )

        for (i in imageId.indices) {
            val maps = Maps(imageId[i], name[i])
            mapsArrayList.add(maps)

        }
    }

    override fun onClick(map: Maps) {
        bundle = Bundle()
        showInterAd()

        when(map.mapName){
            getString(R.string.center_perks_2_0) -> {
                val text = getString(R.string.center_perks_2_0)
                val textEscape1 = getString(R.string.escape1_center_perks_2_0)
                val textEscape2 = getString(R.string.escape2_center_perks_2_0)
                val textEscape3 = getString(R.string.escape3_center_perks_2_0)
                val titleImageId = R.drawable.centerperks20
                val scheduleImageId = R.drawable.schedulecenterperks
                val jobsImageId = R.drawable.jobscenterperks
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )

                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.cougar_creek_railroad) -> {
                val text = getString(R.string.cougar_creek_railroad)
                val textEscape1 = getString(R.string.escape1_cougar_creek_railroad)
                val textEscape2 = getString(R.string.escape2_cougar_creek_railroad)
                val textEscape3 = getString(R.string.escape3_cougar_creek_railroad)
                val textEscape4 = getString(R.string.escape4_cougar_creek_railroad)
                val titleImageId = R.drawable.cougarcreekrailroad
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putString("EscapePlan4", textEscape4)
                bundle.putInt("TitleImageId", titleImageId)
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.rattlesnake_springs) -> {
                val text = getString(R.string.rattlesnake_springs)
                val textEscape1 = getString(R.string.escape1_rattlesnake_springs)
                val textEscape2 = getString(R.string.escape2_rattlesnake_springs)
                val textEscape3 = getString(R.string.escape3_rattlesnake_springs)
                val titleImageId = R.drawable.rattlesnakesprings
                val scheduleImageId = R.drawable.schedulerattlesnakesprings
                val jobsImageId = R.drawable.jobrattlesnakesprings
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.kapowcamp) -> {
                val text = getString(R.string.kapowcamp)
                val textEscape1 = getString(R.string.escape1_kapowcamp)
                val textEscape2 = getString(R.string.escape2_kapowcamp)
                val textEscape3 = getString(R.string.escape3_kapowcamp)
                val titleImageId = R.drawable.kapow
                val scheduleImageId = R.drawable.schedulekapowcamp
                val jobsImageId = R.drawable.jobkapowcamp
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.hmsorca) -> {
                val text = getString(R.string.hmsorca)
                val textEscape1 = getString(R.string.escape1_hmsorca)
                val textEscape2 = getString(R.string.escape2_hmsorca)
                val textEscape3 = getString(R.string.escape3_hmsorca)
                val textEscape4 = getString(R.string.escape4_hmsorca)
                val titleImageId = R.drawable.hmsorca
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putString("EscapePlan4", textEscape4)
                bundle.putInt("TitleImageId", titleImageId)
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.hmpoffshore) -> {
                val text = getString(R.string.hmpoffshore)
                val textEscape1 = getString(R.string.escape1_hmpoffshore)
                val textEscape2 = getString(R.string.escape2_hmpoffshore)
                val textEscape3 = getString(R.string.escape3_hmpoffshore)
                val textEscape4 = getString(R.string.escape4_hmpoffshore)
                val titleImageId = R.drawable.hmpoffshore
                val scheduleImageId = R.drawable.schedulehmpoffshore
                val jobsImageId = R.drawable.jobhmpoffshore
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putString("EscapePlan4", textEscape4)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.forttundra) -> {
                val text = getString(R.string.forttundra)
                val textEscape1 = getString(R.string.escape1_forttundra)
                val textEscape2 = getString(R.string.escape2_forttundra)
                val textEscape3 = getString(R.string.escape3_forttundra)
                val titleImageId = R.drawable.forttundra
                val scheduleImageId = R.drawable.scheduleforttundra
                val jobsImageId = R.drawable.jobforttundra
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.area17) -> {
                val text = getString(R.string.area17)
                val textEscape1 = getString(R.string.escape1_area17)
                val textEscape2 = getString(R.string.escape2_area17)
                val textEscape3 = getString(R.string.escape3_area17)
                val titleImageId = R.drawable.area17
                val scheduleImageId = R.drawable.schedulearea17
                val jobsImageId = R.drawable.jobarea17
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.airforcecon) -> {
                val text = getString(R.string.airforcecon)
                val textEscape1 = getString(R.string.escape1_airforcecon)
                val textEscape2 = getString(R.string.escape2_airforcecon)
                val textEscape3 = getString(R.string.escape3_airforcecon)
                val textEscape4 = getString(R.string.escape4_airforcecon)
                val titleImageId = R.drawable.airforcecon
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putString("EscapePlan4", textEscape4)
                bundle.putInt("TitleImageId", titleImageId)
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.ussanomaly) -> {
                val text = getString(R.string.ussanomaly)
                val textEscape1 = getString(R.string.escape1_ussanomaly)
                val textEscape2 = getString(R.string.escape2_ussanomaly)
                val textEscape3 = getString(R.string.escape3_ussanomaly)
                val titleImageId = R.drawable.ussanomaly
                val scheduleImageId = R.drawable.scheduleussanomaly
                val jobsImageId = R.drawable.jobussanomaly
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.santassshakedown) -> {
                val text = getString(R.string.santassshakedown)
                val textEscape1 = getString(R.string.escape1_santassshakedown)
                val textEscape2 = getString(R.string.escape2_santassshakedown)
                val textEscape3 = getString(R.string.escape3_santassshakedown)
                val titleImageId = R.drawable.santassshakedown
                val scheduleImageId = R.drawable.schedulesantassshakedown
                val jobsImageId = R.drawable.jobsantassshakedown
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }
            getString(R.string.snowwayout) -> {
                val text = getString(R.string.snowwayout)
                val textEscape1 = getString(R.string.escape1_snowwayout)
                val textEscape2 = getString(R.string.escape2_snowwayout)
                val textEscape3 = getString(R.string.escape3_snowwayout)
                val titleImageId = R.drawable.snowwayout
                val scheduleImageId = R.drawable.schedulesnowwayout
                val jobsImageId = R.drawable.jobsnowwayout
                bundle.putString("MapName", text)
                bundle.putString("EscapePlan1", textEscape1)
                bundle.putString("EscapePlan2", textEscape2)
                bundle.putString("EscapePlan3", textEscape3)
                bundle.putInt("TitleImageId", titleImageId)
                bundle.putInt("ScheduleImageId", scheduleImageId )
                bundle.putInt("JobsImageId", jobsImageId )
                findNavController().navigate(R.id.action_fragmentMap_to_fragmentSampleMap,bundle)
            }

        }

    }


}