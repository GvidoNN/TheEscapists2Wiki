package my.guide.theescapists2.domain.usecase

import android.os.Bundle
import my.guide.theescapists2.domain.repository.MapRepository

class PutDataSampleMapUseCase(var mapRepository: MapRepository) {

    fun getData(
        text: Int,
        stringEscape1: Int,
        stringEscape2: Int,
        stringEscape3: Int,
        stringEscape4: Int?,
        titleImageId: Int,
        scheduleImageId: Int?,
        jobsImageId: Int?
    ): Bundle {
        return mapRepository.putData(text,stringEscape1,stringEscape2,stringEscape3, stringEscape4, titleImageId,scheduleImageId, jobsImageId)
    }


}