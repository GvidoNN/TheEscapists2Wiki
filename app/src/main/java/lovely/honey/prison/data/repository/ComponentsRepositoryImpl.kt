package lovely.honey.prison.data.repository

import android.content.Context
import lovely.honey.prison.R
import lovely.honey.prison.domain.repository.ComponentsRepository
import lovely.honey.prison.domain.models.Components

class ComponentsRepositoryImpl(private var context: Context) : ComponentsRepository {

    override fun dataInitialize(): ArrayList<Components> {

        val componentsArrayList = arrayListOf<Components>()

        val name = arrayOf(
            context.getString(R.string.roll_of_duct),
            context.getString(R.string.timber),
            context.getString(R.string.file),
            context.getString(R.string.sheet_of_metal),
            context.getString(R.string.wire),
            context.getString(R.string.battery),
            context.getString(R.string.comb),
            context.getString(R.string.toothbrush),
            context.getString(R.string.razor_blade),
            context.getString(R.string.sock),
            context.getString(R.string.soap),
            context.getString(R.string.nails),
            context.getString(R.string.glass_shard),
            context.getString(R.string.cup),
            context.getString(R.string.mug),
            context.getString(R.string.bar_of_chocolate),
            context.getString(R.string.lighter),
            context.getString(R.string.broom),
            context.getString(R.string.broom_handle),
            context.getString(R.string.old_box),
            context.getString(R.string.piece_of_string),
            context.getString(R.string.length_of_rope),
            context.getString(R.string.tin_of_paint),
            context.getString(R.string.pillow_case),
            context.getString(R.string.paper_clip),
            context.getString(R.string.metal_baton),
            context.getString(R.string.jar_of_ink),
            context.getString(R.string.inmate_outfit),
            context.getString(R.string.guard_outfit),
            context.getString(R.string.foil),
            context.getString(R.string.book),
            context.getString(R.string.pillow),
            context.getString(R.string.tub_of_bleach),
            context.getString(R.string.bed_sheet),
            context.getString(R.string.magazine),
            context.getString(R.string.crowbar),
            context.getString(R.string.wax),
            context.getString(R.string.roll_of_toilet_paper),
            context.getString(R.string.tube_of_glue),
            context.getString(R.string.circuit_board),
            context.getString(R.string.tub_of_talcum_powder),
            context.getString(R.string.tea_bag),
            context.getString(R.string.lump_of_sugar),
            context.getString(R.string.tub_of_hand_cream),
            context.getString(R.string.nail_polish),
            context.getString(R.string.juicy_worm),
            context.getString(R.string.seeds),
            context.getString(R.string.soil),
            context.getString(R.string.handkerchief),
            context.getString(R.string.orange_coloured_pen),
            context.getString(R.string.green_coloured_pen),
            context.getString(R.string.dowel),
            context.getString(R.string.paint_brush),
            context.getString(R.string.bottle_of_aftershave),
            context.getString(R.string.tubing),
            context.getString(R.string.family_photo),
            context.getString(R.string.can_of_soda),
            context.getString(R.string.sugar_mint),
            context.getString(R.string.washboard),
            context.getString(R.string.pie_filling),
            context.getString(R.string.pastry_case),
            context.getString(R.string.trash_bag),
            context.getString(R.string.bracket),
            context.getString(R.string.hammer),
            context.getString(R.string.bolts),
            context.getString(R.string.radio_receiver),
            context.getString(R.string.ice_pack),
            context.getString(R.string.sheet_of_paper),
            context.getString(R.string.tube_of_art_paints),
            context.getString(R.string.fine_art_brush),
            context.getString(R.string.bag_of_flour),
            context.getString(R.string.bottle_of_milk),
            context.getString(R.string.shoe_sole),
            context.getString(R.string.shoe_body),
            context.getString(R.string.tank_of_oxygen),
            context.getString(R.string.dinner_tray),
            context.getString(R.string.blank_security_pass),
            context.getString(R.string.feather),
            context.getString(R.string.toothpaste),
            context.getString(R.string.leather_strap),
            context.getString(R.string.pair_of_white_gloves),
            context.getString(R.string.rivets),
            context.getString(R.string.wooden_peg),
            context.getString(R.string.iron_bar),
            context.getString(R.string.coconut),
            context.getString(R.string.spring),
            context.getString(R.string.chattering_teeth),
            context.getString(R.string.molten_metal)
        )

        val imageId = arrayOf(
            R.drawable.rollofducttape,
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
            R.drawable.lengthofrope,
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
            R.drawable.toothpaste,
            R.drawable.leather_strap,
            R.drawable.pair_of_white_gloves,
            R.drawable.rivets,
            R.drawable.wooden_peg,
            R.drawable.iron_bar,
            R.drawable.coconut,
            R.drawable.spring,
            R.drawable.chattering_teeth,
            R.drawable.molten_metal
        )

        val contraband = listOf(
            true,
            true,
            true,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            true,
            false,
            false,
            true,
            true,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            true,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            true,
            false,
            false
        )

        for (i in imageId.indices) {
            val components = Components(
                name = name[i],
                imageId = imageId[i],
                contraband = contraband[i]
            )
            componentsArrayList.add(components)
        }
        return componentsArrayList
    }
}