package my.guide.theescapists2.data.repository

import android.content.Context
import android.os.Bundle
import my.guide.theescapists2.R
import my.guide.theescapists2.domain.repository.MapRepository
import my.guide.theescapists2.recycler.Maps

class MapRepositoryImpl(private var context: Context) : MapRepository {

    lateinit var bundle: Bundle

    override fun dataInitialize(): ArrayList<Maps> {

        var mapsArrayList = arrayListOf<Maps>()

        val imageId = arrayOf(
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
        val name = arrayOf(
            context.getString(R.string.center_perks_2_0),
            context.getString(R.string.cougar_creek_railroad),
            context.getString(R.string.rattlesnake_springs),
            context.getString(R.string.kapowcamp),
            context.getString(R.string.hmsorca),
            context.getString(R.string.hmpoffshore),
            context.getString(R.string.forttundra),
            context.getString(R.string.area17),
            context.getString(R.string.airforcecon),
            context.getString(R.string.ussanomaly),
            context.getString(R.string.santassshakedown),
            context.getString(R.string.snowwayout)
        )

        for (i in imageId.indices) {
            val maps = Maps(imageId[i], name[i])
            mapsArrayList.add(maps)

        }
        return mapsArrayList
    }

    override fun putData(
        text: Int,
        stringEscape1: Int,
        stringEscape2: Int,
        stringEscape3: Int,
        stringEscape4: Int?,
        titleImageId: Int,
        scheduleImageId: Int?,
        jobsImageId: Int?
    ): Bundle {
        bundle = Bundle()
        val text = context.getString(text)
        val textEscape1 = context.getString(stringEscape1)
        val textEscape2 = context.getString(stringEscape2)
        val textEscape3 = context.getString(stringEscape3)
        if (stringEscape4 != null) {
            val textEscape4 = context.getString(stringEscape4)
            bundle.putString("EscapePlan4", textEscape4)}
        val titleImage = titleImageId
        val scheduleImage = scheduleImageId
        val jobsImage = jobsImageId
        bundle.putString("MapName", text)
        bundle.putString("EscapePlan1", textEscape1)
        bundle.putString("EscapePlan2", textEscape2)
        bundle.putString("EscapePlan3", textEscape3)
        bundle.putInt("TitleImageId", titleImage)
        if (scheduleImage != null) {
            bundle.putInt("ScheduleImageId", scheduleImage)}
        if (jobsImage != null) {
            bundle.putInt("JobsImageId", jobsImage)}
        return bundle
    }


}