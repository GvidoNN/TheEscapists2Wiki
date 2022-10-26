package my.guide.theescapists2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.guide.theescapists2.databinding.FragmentComponentBinding
import my.guide.theescapists2.recycler.ComponentAdapter
import my.guide.theescapists2.recycler.Components
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class FragmentComponent : Fragment() {
    private lateinit var adapter: ComponentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var componentsArrayList: ArrayList<Components>
    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var advertising : AdView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentComponentBinding.inflate(inflater)
        binding.bottomNavigation.selectedItemId = R.id.componentId
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.craftId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentWallpaper_to_fragmentMainCraft)
                    true
                }
                R.id.mapsId -> {
                    val view = binding.FragmentMain
                    Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentWallpaper_to_fragmentMap)
                    true
                }
                else -> false
            }
        }

        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView2.loadAd(adRequest)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ComponentAdapter(componentsArrayList)
        recyclerView.adapter = adapter
    }

    fun dataInitialize(){
        componentsArrayList = arrayListOf<Components>()

        name = arrayOf(
            getString(R.string.roll_of_duct),
            getString(R.string.timber),
            getString(R.string.file),
            getString(R.string.sheet_of_metal),
            getString(R.string.wire),
            getString(R.string.battery),
            getString(R.string.comb),
            getString(R.string.toothbrush),
            getString(R.string.razor_blade),
            getString(R.string.sock),
            getString(R.string.soap),
            getString(R.string.nails),
            getString(R.string.glass_shard),
            getString(R.string.cup),
            getString(R.string.mug),
            getString(R.string.bar_of_chocolate),
            getString(R.string.lighter),
            getString(R.string.broom),
            getString(R.string.broom_handle),
            getString(R.string.old_box),
            getString(R.string.piece_of_string),
            getString(R.string.length_of_rope),
            getString(R.string.tin_of_paint),
            getString(R.string.pillow_case),
            getString(R.string.paper_clip),
            getString(R.string.metal_baton),
            getString(R.string.jar_of_ink),
            getString(R.string.inmate_outfit),
            getString(R.string.guard_outfit),
            getString(R.string.foil),
            getString(R.string.book),
            getString(R.string.pillow),
            getString(R.string.tub_of_bleach),
            getString(R.string.bed_sheet),
            getString(R.string.magazine),
            getString(R.string.crowbar),
            getString(R.string.wax),
            getString(R.string.roll_of_toilet_paper),
            getString(R.string.tube_of_glue),
            getString(R.string.circuit_board),
            getString(R.string.tub_of_talcum_powder),
            getString(R.string.tea_bag),
            getString(R.string.lump_of_sugar),
            getString(R.string.tub_of_hand_cream),
            getString(R.string.nail_polish),
            getString(R.string.juicy_worm),
            getString(R.string.seeds),
            getString(R.string.soil),
            getString(R.string.handkerchief),
            getString(R.string.orange_coloured_pen),
            getString(R.string.green_coloured_pen),
            getString(R.string.dowel),
            getString(R.string.paint_brush),
            getString(R.string.bottle_of_aftershave),
            getString(R.string.tubing),
            getString(R.string.family_photo),
            getString(R.string.can_of_soda),
            getString(R.string.sugar_mint),
            getString(R.string.washboard),
            getString(R.string.pie_filling),
            getString(R.string.pastry_case),
            getString(R.string.trash_bag),
            getString(R.string.bracket),
            getString(R.string.hammer),
            getString(R.string.bolts),
            getString(R.string.radio_receiver),
            getString(R.string.ice_pack),
            getString(R.string.sheet_of_paper),
            getString(R.string.tube_of_art_paints),
            getString(R.string.fine_art_brush),
            getString(R.string.bag_of_flour),
            getString(R.string.bottle_of_milk),
            getString(R.string.shoe_sole),
            getString(R.string.shoe_body),
            getString(R.string.tank_of_oxygen),
            getString(R.string.dinner_tray),
            getString(R.string.blank_security_pass),
            getString(R.string.feather),
            getString(R.string.toothpaste)
        )

        imageId = arrayOf(
            R.drawable.rollofduct,
            R.drawable.timber,
            R.drawable.file,
            R.drawable.sheetofmetal,
            R.drawable.wire,
            R.drawable.battery,
            R.drawable.comb,
            R.drawable.toothbrush,
            R.drawable.razorblade,
            R.drawable.sock,
            R.drawable.soapescapists,
            R.drawable.nails,
            R.drawable.glassshard,
            R.drawable.cup,
            R.drawable.mug,
            R.drawable.barofchocolate,
            R.drawable.lighter,
            R.drawable.broom,
            R.drawable.broomhandle,
            R.drawable.oldbox,
            R.drawable.pieceofstring,
            R.drawable.lenghtofrope,
            R.drawable.tinofpaint,
            R.drawable.pillowcase,
            R.drawable.paperclip,
            R.drawable.metalbaton,
            R.drawable.jarofink,
            R.drawable.inmateoutfit,
            R.drawable.guardoutfit,
            R.drawable.foil,
            R.drawable.book,
            R.drawable.pillow,
            R.drawable.tubofbleach,
            R.drawable.bedsheet,
            R.drawable.magazine,
            R.drawable.crowbar,
            R.drawable.wax,
            R.drawable.rolloftoiletpaper,
            R.drawable.tubeofglue,
            R.drawable.circuitboard,
            R.drawable.tuboftalcumpowder,
            R.drawable.teabag,
            R.drawable.lumpofsugar,
            R.drawable.tubofhandcream,
            R.drawable.nailpolish,
            R.drawable.juicyworm,
            R.drawable.seeds,
            R.drawable.soil,
            R.drawable.handkerchief,
            R.drawable.orangecolouredpen,
            R.drawable.greencolouredpen,
            R.drawable.dowel,
            R.drawable.paintbrush,
            R.drawable.bottleofaftershave,
            R.drawable.tubing,
            R.drawable.familyphoto,
            R.drawable.canofsoda,
            R.drawable.sugarmint,
            R.drawable.washboard,
            R.drawable.piefilling,
            R.drawable.pastrycase,
            R.drawable.trashbag,
            R.drawable.bracket,
            R.drawable.hammer,
            R.drawable.bolts,
            R.drawable.radioreceiver,
            R.drawable.icepack,
            R.drawable.sheetofpaper,
            R.drawable.tubeofartpaints,
            R.drawable.fineartbrush,
            R.drawable.bagofflour,
            R.drawable.bottleofmilk,
            R.drawable.shoesole,
            R.drawable.shoebody,
            R.drawable.tankofoxygen,
            R.drawable.dinnertray,
            R.drawable.blanksecuritypass,
            R.drawable.feather,
            R.drawable.toothpaste
        )

        for(i in imageId.indices){
            val components = Components(name[i],imageId[i])
            componentsArrayList.add(components)
        }


    }
}