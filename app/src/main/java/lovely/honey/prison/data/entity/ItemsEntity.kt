package lovely.honey.prison.data.entity

import lovely.honey.prison.R

enum class ItemsFilter(val stringId: Int) {
    CLOTHES(R.string.clothes),
    WEAPON(R.string.weapon),
    TOOL(R.string.tool),
    COMPONENT(R.string.component_one),
    EXCLUSIVE_COMPONENT(R.string.exclusive_item)
}