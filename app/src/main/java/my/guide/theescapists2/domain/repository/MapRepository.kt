package my.guide.theescapists2.domain.repository

import android.os.Bundle
import my.guide.theescapists2.domain.models.Maps

interface MapRepository {

    fun dataInitialize(): ArrayList<Maps>

    fun putData(text: Int,
                stringEscape1: Int,
                stringEscape2: Int,
                stringEscape3: Int,
                stringEscape4: Int?,
                titleImageId: Int,
                scheduleImageId: Int?,
                jobsImageId: Int?) : Bundle

}