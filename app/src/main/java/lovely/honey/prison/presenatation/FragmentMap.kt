package lovely.honey.prison.presenatation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lovely.honey.prison.databinding.FragmentMapBinding
import lovely.honey.prison.recycler.MapAdapter
import lovely.honey.prison.domain.models.Maps
import lovely.honey.prison.R
import lovely.honey.prison.data.repository.MapRepositoryImpl
import lovely.honey.prison.domain.usecase.PutDataSampleMapUseCase


class FragmentMap : Fragment(), MapAdapter.Listener {
    private lateinit var adapter: MapAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    private val mapsRepository by lazy { MapRepositoryImpl(context = requireContext()) }
    private val putDataSampleMapUseCase by lazy { PutDataSampleMapUseCase(mapRepository = mapsRepository) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMapBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MapAdapter(mapsRepository.dataInitialize(), this)
        recyclerView.adapter = adapter
    }

    override fun onClick(map: Maps) {
        when (map.mapName) {
            getString(R.string.center_perks_2_0) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.center_perks_2_0,
                        stringEscape1 = R.string.escape1_center_perks_2_0,
                        stringEscape2 = R.string.escape2_center_perks_2_0,
                        stringEscape3 = R.string.escape3_center_perks_2_0,
                        stringEscape4 = null,
                        titleImageId = R.drawable.centerperks20,
                        scheduleImageId = R.drawable.schedulecenterperks,
                        jobsImageId = R.drawable.jobscenterperks
                    )
                )
            }
            getString(R.string.cougar_creek_railroad) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.cougar_creek_railroad,
                        stringEscape1 = R.string.escape1_cougar_creek_railroad,
                        stringEscape2 = R.string.escape2_cougar_creek_railroad,
                        stringEscape3 = R.string.escape3_cougar_creek_railroad,
                        stringEscape4 = R.string.escape4_cougar_creek_railroad,
                        titleImageId = R.drawable.cougarcreekrailroad,
                        scheduleImageId = null,
                        jobsImageId = null
                    )
                )
            }
            getString(R.string.rattlesnake_springs) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.rattlesnake_springs,
                        stringEscape1 = R.string.escape1_rattlesnake_springs,
                        stringEscape2 = R.string.escape2_rattlesnake_springs,
                        stringEscape3 = R.string.escape3_rattlesnake_springs,
                        stringEscape4 = null,
                        titleImageId = R.drawable.rattlesnakesprings,
                        scheduleImageId = R.drawable.schedulerattlesnakesprings,
                        jobsImageId = R.drawable.jobrattlesnakesprings
                    )
                )
            }
            getString(R.string.kapowcamp) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.kapowcamp,
                        stringEscape1 = R.string.escape1_kapowcamp,
                        stringEscape2 = R.string.escape2_kapowcamp,
                        stringEscape3 = R.string.escape3_kapowcamp,
                        stringEscape4 = null,
                        titleImageId = R.drawable.kapow,
                        scheduleImageId = R.drawable.schedulekapowcamp,
                        jobsImageId = R.drawable.jobkapowcamp
                    )
                )
            }
            getString(R.string.hmsorca) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.hmsorca,
                        stringEscape1 = R.string.escape1_hmsorca,
                        stringEscape2 = R.string.escape2_hmsorca,
                        stringEscape3 = R.string.escape3_hmsorca,
                        stringEscape4 = R.string.escape4_hmsorca,
                        titleImageId = R.drawable.hmsorca,
                        scheduleImageId = null,
                        jobsImageId = null
                    )
                )
            }
            getString(R.string.hmpoffshore) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.hmpoffshore,
                        stringEscape1 = R.string.escape1_hmpoffshore,
                        stringEscape2 = R.string.escape2_hmpoffshore,
                        stringEscape3 = R.string.escape3_hmpoffshore,
                        stringEscape4 = R.string.escape4_hmpoffshore,
                        titleImageId = R.drawable.hmpoffshore,
                        scheduleImageId = R.drawable.schedulehmpoffshore,
                        jobsImageId = R.drawable.jobhmpoffshore
                    )
                )
            }
            getString(R.string.forttundra) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.forttundra,
                        stringEscape1 = R.string.escape1_forttundra,
                        stringEscape2 = R.string.escape2_forttundra,
                        stringEscape3 = R.string.escape3_forttundra,
                        stringEscape4 = null,
                        titleImageId = R.drawable.forttundra,
                        scheduleImageId = R.drawable.scheduleforttundra,
                        jobsImageId = R.drawable.jobforttundra
                    )
                )
            }
            getString(R.string.area17) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.area17,
                        stringEscape1 = R.string.escape1_area17,
                        stringEscape2 = R.string.escape2_area17,
                        stringEscape3 = R.string.escape3_area17,
                        stringEscape4 = null,
                        titleImageId = R.drawable.area17,
                        scheduleImageId = R.drawable.schedulearea17,
                        jobsImageId = R.drawable.jobarea17
                    )
                )
            }
            getString(R.string.airforcecon) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.airforcecon,
                        stringEscape1 = R.string.escape1_airforcecon,
                        stringEscape2 = R.string.escape2_airforcecon,
                        stringEscape3 = R.string.escape3_airforcecon,
                        stringEscape4 = R.string.escape4_airforcecon,
                        titleImageId = R.drawable.airforcecon,
                        scheduleImageId = null,
                        jobsImageId = null
                    )
                )
            }
            getString(R.string.ussanomaly) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.ussanomaly,
                        stringEscape1 = R.string.escape1_ussanomaly,
                        stringEscape2 = R.string.escape2_ussanomaly,
                        stringEscape3 = R.string.escape3_ussanomaly,
                        stringEscape4 = null,
                        titleImageId = R.drawable.ussanomaly,
                        scheduleImageId = R.drawable.scheduleussanomaly,
                        jobsImageId = R.drawable.jobussanomaly
                    )
                )
            }
            getString(R.string.santassshakedown) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.santassshakedown,
                        stringEscape1 = R.string.escape1_santassshakedown,
                        stringEscape2 = R.string.escape2_santassshakedown,
                        stringEscape3 = R.string.escape3_santassshakedown,
                        stringEscape4 = null,
                        titleImageId = R.drawable.santassshakedown,
                        scheduleImageId = R.drawable.schedulesantassshakedown,
                        jobsImageId = R.drawable.jobsantassshakedown
                    )
                )
            }
            getString(R.string.snowwayout) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.snowwayout,
                        stringEscape1 = R.string.escape1_snowwayout,
                        stringEscape2 = R.string.escape2_snowwayout,
                        stringEscape3 = R.string.escape3_snowwayout,
                        stringEscape4 = null,
                        titleImageId = R.drawable.snowwayout,
                        scheduleImageId = R.drawable.schedulesnowwayout,
                        jobsImageId = R.drawable.jobsnowwayout
                    )
                )
            }
            getString(R.string.wicked_ward) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.wicked_ward,
                        stringEscape1 = R.string.escape1_wicked_ward,
                        stringEscape2 = R.string.escape2_wicked_ward,
                        stringEscape3 = R.string.escape3_wicked_ward,
                        stringEscape4 = null,
                        titleImageId = R.drawable.wickedward,
                        scheduleImageId = R.drawable.schedulewickedward,
                        jobsImageId = R.drawable.jobwickedward
                    )
                )
            }
            getString(R.string.the_glorious_regime) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.the_glorious_regime,
                        stringEscape1 = R.string.escape1_glorious_regime,
                        stringEscape2 = R.string.escape2_glorious_regime,
                        stringEscape3 = R.string.escape3_glorious_regime,
                        stringEscape4 = null,
                        titleImageId = R.drawable.gloriousregime,
                        scheduleImageId = R.drawable.schedulegloriousregime,
                        jobsImageId = R.drawable.jobgloriousregime
                    )
                )
            }
            getString(R.string.dungeons_and_duct_tape) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.dungeons_and_duct_tape,
                        stringEscape1 = R.string.escape1_dungeons_duct_tape,
                        stringEscape2 = R.string.escape2_dungeons_duct_tape,
                        stringEscape3 = R.string.escape3_dungeons_duct_tape,
                        stringEscape4 = null,
                        titleImageId = R.drawable.dangeonandducttape,
                        scheduleImageId = R.drawable.scheduledangeonsandducttapee,
                        jobsImageId = R.drawable.jobsdangeonducttape
                    )
                )
            }
            getString(R.string.big_top_breakout) -> {
                findNavController().navigate(
                    R.id.action_fragmentMap_to_fragmentSampleMap, putDataSampleMapUseCase.getData(
                        text = R.string.big_top_breakout,
                        stringEscape1 = R.string.escape1_big_top_breakout,
                        stringEscape2 = R.string.escape2_big_top_breakout,
                        stringEscape3 = R.string.escape3_big_top_breakout,
                        stringEscape4 = null,
                        titleImageId = R.drawable.bigtopbreakout,
                        scheduleImageId = R.drawable.schedulebigtopbreakout,
                        jobsImageId = R.drawable.jobbigtopbreakout
                    )
                )
            }
        }
    }
}