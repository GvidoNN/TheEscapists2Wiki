package my.guide.theescapists2.data.repository

import android.content.Context
import my.guide.theescapists2.R
import my.guide.theescapists2.recycler.Items

class ItemsRepositoryImpl(
    private var itemsArrayList: ArrayList<Items>,
    private var imOneId: Array<Int>,
    private var imTwoId: Array<Int>,
    private var imThreeId: Array<Int>,
    private var imageId: Array<Int>,
    private var name: Array<String>,
    private var craft: Array<String>,
    private var intelligence: Array<String>,
    private var context: Context
) {

    fun dataInitialize(): ArrayList<Items> {

        itemsArrayList = arrayListOf<Items>()

        imOneId = arrayOf(
            R.drawable.timber,
            R.drawable.sock,
            R.drawable.glassshard,
            R.drawable.comb,
            R.drawable.timber,
            R.drawable.whip,
            R.drawable.bedsheet,
            R.drawable.broomhandle,
            R.drawable.razorblade,
            R.drawable.knuckleduster,
            R.drawable.cup,
            R.drawable.oldbox,
            R.drawable.wire,
            R.drawable.broomhandle,
            R.drawable.baseball,
            R.drawable.battery,
            R.drawable.energymodule,
            R.drawable.metalbaton,
            R.drawable.sock,
            R.drawable.timber,
            R.drawable.toolhandle,
            R.drawable.flimsypickaxe,
            R.drawable.lightweightpickaxe,
            R.drawable.toolhandle,
            R.drawable.flimsyshovel,
            R.drawable.lightweightshovel,
            R.drawable.file,
            R.drawable.flimsycutters,
            R.drawable.lightweightcutters,
            R.drawable.sturdyshovel,
            R.drawable.dentalfloss,
            R.drawable.jarofink,
            R.drawable.inmateoutfit,
            R.drawable.inmateoutfit,
            R.drawable.inmateoutfit,
            R.drawable.inmateoutfit,
            R.drawable.sheetofmetal,
            R.drawable.papermache,
            R.drawable.papermache,
            R.drawable.wire,
            R.drawable.pillow,
            R.drawable.foil,
            R.drawable.foil,
            R.drawable.magazine,
            R.drawable.crowbar,
            R.drawable.grapplehead,
            R.drawable.bedsheet,
            R.drawable.wax,
            R.drawable.rolloftoiletpaper,
            R.drawable.comb,
            R.drawable.keymould,
            R.drawable.wadofputty,
            R.drawable.keycards,
            R.drawable.keycardmould,
            R.drawable.toothpaste,
            R.drawable.timber,
            R.drawable.timber,
            R.drawable.teabag,
            R.drawable.bedsheet,
            R.drawable.file,
            R.drawable.lenghtofrope,
            R.drawable.tinofpaint,
            R.drawable.fishingrod,
            R.drawable.bedsheet,
            R.drawable.mug,
            R.drawable.handkerchief,
            R.drawable.handkerchief,
            R.drawable.fineartbrush,
            R.drawable.bottleofaftershave,
            R.drawable.rollofduct,
            R.drawable.familyphoto,
            R.drawable.ungluedfurniture,
            R.drawable.canofsoda,
            R.drawable.pieceofstring,
            R.drawable.piefilling,
            R.drawable.timber,
            R.drawable.trashbag,
            R.drawable.cratebase,
            R.drawable.timber,
            R.drawable.timber,
            R.drawable.dowel,
            R.drawable.broom,
            R.drawable.wax,
            R.drawable.dowel,
            R.drawable.icepack,
            R.drawable.sheetofpaper,
            R.drawable.bagofflour,
            R.drawable.moltenplastic,
            R.drawable.shoesole,
            R.drawable.tankofoxygen,
            R.drawable.gunmakingkit,
            R.drawable.machinereadyshoe,
            R.drawable.blanksecuritypass,
            R.drawable.crossbowbody,
            R.drawable.mouldedgun,
            R.drawable.timber
        )

        imTwoId = arrayOf(
            R.drawable.timber,
            R.drawable.soapescapists,
            R.drawable.rollofduct,
            R.drawable.razorblade,
            R.drawable.wire,
            R.drawable.razorblade,
            R.drawable.soapescapists,
            R.drawable.glassshard,
            R.drawable.rollofduct,
            R.drawable.energymodule,
            R.drawable.barofchocolate,
            R.drawable.broomhandle,
            R.drawable.timber,
            R.drawable.tinofpaint,
            R.drawable.rollofduct,
            R.drawable.battery,
            R.drawable.paperclip,
            R.drawable.energymodule,
            R.drawable.battery,
            R.drawable.file,
            R.drawable.crowbar,
            R.drawable.timber,
            R.drawable.timber,
            R.drawable.sheetofmetal,
            R.drawable.sheetofmetal,
            R.drawable.sheetofmetal,
            R.drawable.file,
            R.drawable.file,
            R.drawable.file,
            R.drawable.sturdypickaxe,
            R.drawable.dentalfloss,
            R.drawable.infirmaryoveralls,
            R.drawable.tubofbleach,
            R.drawable.pillow,
            R.drawable.rollofduct,
            R.drawable.sheetofmetal,
            R.drawable.foil,
            R.drawable.papermache,
            R.drawable.papermache,
            R.drawable.wire,
            R.drawable.pillow,
            R.drawable.rollofduct,
            R.drawable.foil,
            R.drawable.rollofduct,
            R.drawable.crowbar,
            R.drawable.lenghtofrope,
            R.drawable.bedsheet,
            R.drawable.lighter,
            R.drawable.tubeofglue,
            R.drawable.lighter,
            R.drawable.moltenplastic,
            R.drawable.plastickeys,
            R.drawable.circuitboard,
            R.drawable.moltenplastic,
            R.drawable.tuboftalcumpowder,
            R.drawable.timber,
            R.drawable.timber,
            R.drawable.lumpofsugar,
            R.drawable.lenghtofrope,
            R.drawable.tubofhandcream,
            R.drawable.lenghtofrope,
            R.drawable.tinofpaint,
            R.drawable.juicyworm,
            R.drawable.makeshiftharness,
            R.drawable.seeds,
            R.drawable.orangecolouredpen,
            R.drawable.orangecolouredpen,
            R.drawable.tinofpaint,
            R.drawable.comb,
            R.drawable.tubing,
            R.drawable.timber,
            R.drawable.tubeofglue,
            R.drawable.sugarmint,
            R.drawable.washboard,
            R.drawable.pastrycase,
            R.drawable.timber,
            R.drawable.breathingmask,
            R.drawable.bracket,
            R.drawable.nails,
            R.drawable.timber,
            R.drawable.pieceofstring,
            R.drawable.rollofduct,
            R.drawable.soapescapists,
            R.drawable.dowel,
            R.drawable.icepack,
            R.drawable.tubeofartpaints,
            R.drawable.bottleofmilk,
            R.drawable.readiedpaintbrush,
            R.drawable.shoebody,
            R.drawable.tubing,
            R.drawable.lighter,
            R.drawable.machinereadyshoe,
            R.drawable.jarofink,
            R.drawable.crossbowlathe,
            R.drawable.jarofink,
            R.drawable.paperclip
        )

        imThreeId = arrayOf(
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.razorblade,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.lighter,
            R.drawable.pieceofstring,
            R.drawable.timber,
            R.drawable.rollofduct,
            R.drawable.nails,
            R.drawable.wire,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.dentalfloss,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.book,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.jarofink,
            R.drawable.empty,
            R.drawable.wire,
            R.drawable.bedsheet,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.pieceofstring,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.wire,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.timber,
            R.drawable.nails,
            R.drawable.cup,
            R.drawable.empty,
            R.drawable.nailpolish,
            R.drawable.lenghtofrope,
            R.drawable.tinofpaint,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.soil,
            R.drawable.dowel,
            R.drawable.greencolouredpen,
            R.drawable.empty,
            R.drawable.dentalfloss,
            R.drawable.handkerchief,
            R.drawable.tubeofglue,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.tubeofglue,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.empty,
            R.drawable.empty,
            R.drawable.bolts,
            R.drawable.tubeofglue,
            R.drawable.radioreceiver,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.rollofduct,
            R.drawable.fineartbrush,
            R.drawable.lumpofsugar,
            R.drawable.tubeofglue,
            R.drawable.empty,
            R.drawable.rollofduct,
            R.drawable.dinnertray,
            R.drawable.empty,
            R.drawable.feather,
            R.drawable.tubeofglue,
            R.drawable.empty,
            R.drawable.pieceofstring
        )

        imageId = arrayOf(
            R.drawable.baseball,
            R.drawable.sockandmolotok,
            R.drawable.glassshank,
            R.drawable.combblade,
            R.drawable.whip,
            R.drawable.superwhip,
            R.drawable.makeshiftcosh,
            R.drawable.makeshiftspear,
            R.drawable.knuckleduster,
            R.drawable.superknuckleduster,
            R.drawable.cupofmoltenchocolate,
            R.drawable.makeshiftdoublebass,
            R.drawable.nunchacks,
            R.drawable.makeshiftsledgehammer,
            R.drawable.superbat,
            R.drawable.energymodule,
            R.drawable.makeshiftstungun,
            R.drawable.supermetalbaton,
            R.drawable.supersockmace,
            R.drawable.toolhandle,
            R.drawable.flimsypickaxe,
            R.drawable.lightweightpickaxe,
            R.drawable.sturdypickaxe,
            R.drawable.flimsyshovel,
            R.drawable.lightweightshovel,
            R.drawable.sturdyshovel,
            R.drawable.flimsycutters,
            R.drawable.lightweightcutters,
            R.drawable.sturdycutters,
            R.drawable.multitool,
            R.drawable.cuttingfloss,
            R.drawable.guardoutfit,
            R.drawable.infirmaryoveralls,
            R.drawable.cushionedinmateoutfit,
            R.drawable.paddedinmateoutfit,
            R.drawable.platedinmateoutfit,
            R.drawable.makeshiftrobotguardoutfit,
            R.drawable.fakewallblock,
            R.drawable.fakeventcover,
            R.drawable.fakefence,
            R.drawable.beddummy,
            R.drawable.contrabandpouch,
            R.drawable.durablecontrabandpouch,
            R.drawable.poster,
            R.drawable.grapplehead,
            R.drawable.grapplinghook,
            R.drawable.sheetrope,
            R.drawable.candle,
            R.drawable.papermache,
            R.drawable.moltenplastic,
            R.drawable.plastickeys,
            R.drawable.keymould,
            R.drawable.keycardmould,
            R.drawable.keycards,
            R.drawable.wadofputty,
            R.drawable.timberbrace,
            R.drawable.cratebase,
            R.drawable.cupoftea,
            R.drawable.gliderskin,
            R.drawable.manicurekit,
            R.drawable.makeshiftharness,
            R.drawable.makeshiftladder,
            R.drawable.readiedfishingrod,
            R.drawable.parachute,
            R.drawable.pottedplant,
            R.drawable.pretendflower,
            R.drawable.pretendcarrot,
            R.drawable.readiedpaintbrush,
            R.drawable.visitorskit,
            R.drawable.breathingmask,
            R.drawable.framedphoto,
            R.drawable.gluereadiedfurniture,
            R.drawable.makeshiftrocketthruster,
            R.drawable.musicwashboard,
            R.drawable.uncookedpie,
            R.drawable.ungluedfurniture,
            R.drawable.breathabletrashbag,
            R.drawable.cratecasing,
            R.drawable.cratetop,
            R.drawable.crossbowbody,
            R.drawable.crossbowlathe,
            R.drawable.fakeaudioequipment,
            R.drawable.gunmakingkit,
            R.drawable.halfframeofglider,
            R.drawable.heartrateslower,
            R.drawable.beautifulpainting,
            R.drawable.cake,
            R.drawable.escapistsfigurine,
            R.drawable.machinereadyshoe,
            R.drawable.makeshiftbreathingapparatus,
            R.drawable.mouldedgun,
            R.drawable.pairofshoes,
            R.drawable.securitypass,
            R.drawable.completecrossbow,
            R.drawable.fakegun,
            R.drawable.fishingrod
        )
        name = arrayOf(
            context!!.getString(R.string.baseball_bat),
            context!!.getString(R.string.sock_mase),
            context!!.getString(R.string.glass_shank),
            context!!.getString(R.string.comb_blade),
            context!!.getString(R.string.whip),
            context!!.getString(R.string.super_whip),
            context!!.getString(R.string.makeshift_cosh),
            context!!.getString(R.string.makeshift_spear),
            context!!.getString(R.string.knuckle_duster),
            context!!.getString(R.string.super_knuckle_duster),
            context!!.getString(R.string.cup_of_molten_chocolate),
            context!!.getString(R.string.makeshift_double_bass),
            context!!.getString(R.string.nunchucks),
            context!!.getString(R.string.makeshift_sledgehammer),
            context!!.getString(R.string.super_baseball_bat),
            context!!.getString(R.string.energy_module),
            context!!.getString(R.string.makeshift_stungun),
            context!!.getString(R.string.super_metal_baton),
            context!!.getString(R.string.super_sock_mace),
            context!!.getString(R.string.tool_handle),
            context!!.getString(R.string.flimsy_pickaxe),
            context!!.getString(R.string.lightweight_pickaxe),
            context!!.getString(R.string.sturdy_pickaxe),
            context!!.getString(R.string.flimsy_shovel),
            context!!.getString(R.string.lightweight_shovel),
            context!!.getString(R.string.sturdy_shovel),
            context!!.getString(R.string.flimsy_cutters),
            context!!.getString(R.string.lightweight_cutters),
            context!!.getString(R.string.sturdy_cutters),
            context!!.getString(R.string.multitool),
            context!!.getString(R.string.cutting_floss),
            context!!.getString(R.string.guard_outfit),
            context!!.getString(R.string.infirmary_overalls),
            context!!.getString(R.string.cushioned_inmate_outfit),
            context!!.getString(R.string.padded_inmate_outfit),
            context!!.getString(R.string.plated_Inmate_outfit),
            context!!.getString(R.string.makeshift_robot_guard_outfit),
            context!!.getString(R.string.fake_wall_block),
            context!!.getString(R.string.fake_vent_cover),
            context!!.getString(R.string.fake_fence),
            context!!.getString(R.string.bed_dummy),
            context!!.getString(R.string.contraband_pouch),
            context!!.getString(R.string.durable_contraband_pouch),
            context!!.getString(R.string.poster),
            context!!.getString(R.string.grapple_head),
            context!!.getString(R.string.grappling_hook),
            context!!.getString(R.string.sheet_rope),
            context!!.getString(R.string.candle),
            context!!.getString(R.string.paper_mache),
            context!!.getString(R.string.molten_plastic),
            context!!.getString(R.string.plastic_key),
            context!!.getString(R.string.key_mold),
            context!!.getString(R.string.keycard_mould),
            context!!.getString(R.string.fake_keycards),
            context!!.getString(R.string.wad_of_putty),
            context!!.getString(R.string.timber_brace),
            context!!.getString(R.string.crate_base),
            context!!.getString(R.string.cup_of_tea),
            context!!.getString(R.string.glider_skin),
            context!!.getString(R.string.manicure_kit),
            context!!.getString(R.string.makeshift_harness),
            context!!.getString(R.string.makeshift_ladder),
            context!!.getString(R.string.readied_fishing_rod),
            context!!.getString(R.string.parachute),
            context!!.getString(R.string.potted_plant),
            context!!.getString(R.string.pretend_flower),
            context!!.getString(R.string.pretend_carrot),
            context!!.getString(R.string.readied_paint_brush),
            context!!.getString(R.string.visitors_kit),
            context!!.getString(R.string.breathing_mask),
            context!!.getString(R.string.framed_photo),
            context!!.getString(R.string.glue_readied_furniture),
            context!!.getString(R.string.makeshift_rocket_thruster),
            context!!.getString(R.string.music_washboard),
            context!!.getString(R.string.uncooked_pie),
            context!!.getString(R.string.unglued_furniture),
            context!!.getString(R.string.breathable_trash_bag),
            context!!.getString(R.string.crate_casing),
            context!!.getString(R.string.crate_top),
            context!!.getString(R.string.crossbow_body),
            context!!.getString(R.string.crossbow_lathe),
            context!!.getString(R.string.fake_audio_equipment),
            context!!.getString(R.string.gun_making_kit),
            context!!.getString(R.string.half_frame_of_glider),
            context!!.getString(R.string.heart_rate_slower),
            context!!.getString(R.string.beautiful_painting),
            context!!.getString(R.string.cake),
            context!!.getString(R.string.escapists_figurine),
            context!!.getString(R.string.machine_ready_shoe),
            context!!.getString(R.string.makeshift_breathing_apparatus),
            context!!.getString(R.string.moulded_gun),
            context!!.getString(R.string.pair_of_shoes),
            context!!.getString(R.string.security_pass),
            context!!.getString(R.string.complete_crossbow),
            context!!.getString(R.string.fake_gun),
            context!!.getString(R.string.fishing_rod)
        )

        craft = arrayOf(
            context!!.getString(R.string.baseball_bat_craft),
            context!!.getString(R.string.sock_mase_craft),
            context!!.getString(R.string.glass_shank_craft),
            context!!.getString(R.string.comb_blade_craft),
            context!!.getString(R.string.whip_craft),
            context!!.getString(R.string.super_whip_craft),
            context!!.getString(R.string.makeshift_cosh_craft),
            context!!.getString(R.string.makeshift_spear_craft),
            context!!.getString(R.string.knuckle_duster_craft),
            context!!.getString(R.string.super_knuckle_duster_craft),
            context!!.getString(R.string.cup_of_molten_chocolate_craft),
            context!!.getString(R.string.makeshift_double_bass_craft),
            context!!.getString(R.string.nunchucks_craft),
            context!!.getString(R.string.makeshift_sledgehammer_craft),
            context!!.getString(R.string.super_baseball_bat_craft),
            context!!.getString(R.string.energy_module_craft),
            context!!.getString(R.string.makeshift_stungun_craft),
            context!!.getString(R.string.super_metal_baton_craft),
            context!!.getString(R.string.super_sock_mace_craft),
            context!!.getString(R.string.tool_handle_craft),
            context!!.getString(R.string.flimsy_pickaxe_craft),
            context!!.getString(R.string.lightweight_pickaxe_craft),
            context!!.getString(R.string.sturdy_pickaxe_craft),
            context!!.getString(R.string.flimsy_shovel_craft),
            context!!.getString(R.string.lightweight_shovel_craft),
            context!!.getString(R.string.sturdy_shovel_craft),
            context!!.getString(R.string.flimsy_cutters_craft),
            context!!.getString(R.string.lightweight_cutters_craft),
            context!!.getString(R.string.sturdy_cutters_craft),
            context!!.getString(R.string.multitool_craft),
            context!!.getString(R.string.cutting_floss_craft),
            context!!.getString(R.string.guard_outfit_craft),
            context!!.getString(R.string.infirmary_overalls_craft),
            context!!.getString(R.string.cushioned_inmate_outfit_craft),
            context!!.getString(R.string.padded_inmate_outfit_craft),
            context!!.getString(R.string.plated_Inmate_outfit_craft),
            context!!.getString(R.string.makeshift_robot_guard_outfit_craft),
            context!!.getString(R.string.fake_wall_block_craft),
            context!!.getString(R.string.fake_vent_cover_craft),
            context!!.getString(R.string.fake_fence_craft),
            context!!.getString(R.string.bed_dummy_craft),
            context!!.getString(R.string.contraband_pouch_craft),
            context!!.getString(R.string.durable_contraband_pouch_craft),
            context!!.getString(R.string.poster_craft),
            context!!.getString(R.string.grapple_head_craft),
            context!!.getString(R.string.grappling_hook_craft),
            context!!.getString(R.string.sheet_rope_craft),
            context!!.getString(R.string.candle_craft),
            context!!.getString(R.string.paper_mache_craft),
            context!!.getString(R.string.molten_plastic_craft),
            context!!.getString(R.string.plastic_key_craft),
            context!!.getString(R.string.key_mold_craft),
            context!!.getString(R.string.keycard_mould_craft),
            context!!.getString(R.string.fake_keycards_craft),
            context!!.getString(R.string.wad_of_putty_craft),
            context!!.getString(R.string.timber_brace_craft),
            context!!.getString(R.string.crate_base_craft),
            context!!.getString(R.string.cup_of_tea_craft),
            context!!.getString(R.string.glider_skin_craft),
            context!!.getString(R.string.manicure_kit_craft),
            context!!.getString(R.string.makeshift_harness_craft),
            context!!.getString(R.string.makeshift_ladder_craft),
            context!!.getString(R.string.readied_fishing_rod_craft),
            context!!.getString(R.string.parachute_craft),
            context!!.getString(R.string.potted_plant_craft),
            context!!.getString(R.string.pretend_flower_craft),
            context!!.getString(R.string.pretend_carrot_craft),
            context!!.getString(R.string.readied_paint_brush_craft),
            context!!.getString(R.string.visitors_kit_craft),
            context!!.getString(R.string.breathing_mask_craft),
            context!!.getString(R.string.framed_photo_craft),
            context!!.getString(R.string.glue_readied_furniture_craft),
            context!!.getString(R.string.makeshift_rocket_thruster_craft),
            context!!.getString(R.string.music_washboard_craft),
            context!!.getString(R.string.uncooked_pie_craft),
            context!!.getString(R.string.unglued_furniture_craft),
            context!!.getString(R.string.breathable_trash_bag_craft),
            context!!.getString(R.string.crate_casing_craft),
            context!!.getString(R.string.crate_top_craft),
            context!!.getString(R.string.crossbow_body_craft),
            context!!.getString(R.string.crossbow_lathe_craft),
            context!!.getString(R.string.fake_audio_equipment_craft),
            context!!.getString(R.string.gun_making_kit_craft),
            context!!.getString(R.string.half_frame_of_glider_craft),
            context!!.getString(R.string.heart_rate_slower_craft),
            context!!.getString(R.string.beautiful_painting_craft),
            context!!.getString(R.string.cake_craft),
            context!!.getString(R.string.escapists_figurine_craft),
            context!!.getString(R.string.machine_ready_shoe_craft),
            context!!.getString(R.string.makeshift_breathing_apparatus_craft),
            context!!.getString(R.string.moulded_gun_craft),
            context!!.getString(R.string.pair_of_shoes_craft),
            context!!.getString(R.string.security_pass_craft),
            context!!.getString(R.string.complete_crossbow_craft),
            context!!.getString(R.string.fake_gun_craft),
            context!!.getString(R.string.fishing_rod_craft)
        )

        intelligence = arrayOf(
            "40+",
            "40+",
            "40+",
            "40+",
            "40+",
            "60+",
            "70+",
            "40+",
            "60+",
            "50+",
            "60+",
            "50+",
            "50+",
            "60+",
            "60+",
            "70+",
            "60+",
            "60+",
            "70+",
            "60+",
            "40+",
            "40+",
            "50+",
            "60+",
            "40+",
            "50+",
            "60+",
            "40+",
            "50+",
            "60+",
            "70+",
            "40+",
            "40+",
            "50+",
            "40+",
            "50+",
            "60+",
            "50+",
            "40+",
            "30+",
            "50+",
            "40+",
            "60+",
            "70+",
            "30+",
            "50+",
            "70+",
            "30+",
            "40+",
            "40+",
            "50+",
            "60+",
            "50+",
            "50+",
            "60+",
            "40+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "30+",
            "40+",
            "40+",
            "40+",
            "40+",
            "40+",
            "40+",
            "40+",
            "50+",
            "50+",
            "50+",
            "50+",
            "50+",
            "50+",
            "50+",
            "50+",
            "50+",
            "60+",
            "60+",
            "60+",
            "60+",
            "60+",
            "60+",
            "60+",
            "60+",
            "70+",
            "70+",
            "70+"
        )

        for (i in imageId.indices) {
            val items = Items(
                imageId[i],
                name[i],
                craft[i],
                intelligence[i],
                imOneId[i],
                imTwoId[i],
                imThreeId[i]
            )
            itemsArrayList.add(items)
        }
        return itemsArrayList
    }
}