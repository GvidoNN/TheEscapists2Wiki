package lovely.honey.prison.data.db

import androidx.room.TypeConverter
import lovely.honey.prison.data.entity.ItemsFilter
import kotlin.collections.joinToString

class Converters {

    @TypeConverter
    fun fromFilterList(filters: List<ItemsFilter>): String {
        return filters.joinToString(",") { it.name }
    }

    @TypeConverter
    fun toFilterList(data: String): List<ItemsFilter> {
        if (data.isEmpty()) return emptyList()
        return data.split(",").map { ItemsFilter.valueOf(it) }
    }
}