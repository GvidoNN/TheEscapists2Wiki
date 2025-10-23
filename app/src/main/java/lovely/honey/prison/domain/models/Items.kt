package lovely.honey.prison.domain.models

import lovely.honey.prison.data.db.ItemDbEntity
import lovely.honey.prison.data.entity.ItemsFilter

data class Items(
    var id: Int,
    var imageId: Int,
    var name: String,
    var craft: String,
    var intelligence: String,
    var imOne: Int,
    var imTwo: Int,
    var imThree: Int,
    var haveThirdItem: Boolean,
    var contraband: Boolean,
    var filter: List<ItemsFilter>
)


fun Items.toItemDbEntity(): ItemDbEntity =
    ItemDbEntity(
        id = this.id,
        imageId = this.imageId,
        name = this.name,
        craft = this.craft,
        intelligence = this.intelligence,
        imOne = this.imOne,
        imTwo = this.imTwo,
        imThree = this.imThree,
        haveThirdItem = this.haveThirdItem,
        contraband = this.contraband,
        filter = this.filter
    )