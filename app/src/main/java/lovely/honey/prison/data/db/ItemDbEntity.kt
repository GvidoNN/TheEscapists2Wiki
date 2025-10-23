package lovely.honey.prison.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import lovely.honey.prison.data.entity.ItemsFilter
import lovely.honey.prison.domain.models.Items

@Entity(tableName = "main_items")
data class ItemDbEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "image_id")
    val imageId: Int,
    val name: String,
    val craft: String,
    val intelligence: String,
    @ColumnInfo(name = "image_one")
    val imOne: Int,
    @ColumnInfo(name = "image_two")
    val imTwo: Int,
    @ColumnInfo(name = "image_three")
    val imThree: Int,
    @ColumnInfo(name = "have_third_item")
    val haveThirdItem: Boolean,
    val contraband: Boolean,
    val filter: List<ItemsFilter>
)

fun List<ItemDbEntity>.toItems(): List<Items> =
    this.map {
        Items(
            id = it.id,
            imageId = it.imageId,
            name = it.name,
            craft = it.craft,
            intelligence = it.intelligence,
            imOne = it.imOne,
            imTwo = it.imTwo,
            imThree = it.imThree,
            haveThirdItem = it.haveThirdItem,
            contraband = it.contraband,
            filter = it.filter
        )
    }
