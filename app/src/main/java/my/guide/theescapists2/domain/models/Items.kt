package my.guide.theescapists2.domain.models

data class Items(
    var imageId: Int,
    var name: String,
    var craft: String,
    var intelligence: String,
    var imOne: Int,
    var imTwo: Int,
    var imThree: Int,
    var haveThirdItem: Boolean,
    var contraband: Boolean
)
