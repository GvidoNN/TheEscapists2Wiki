package my.guide.theescapists2.domain.usecase

import my.guide.theescapists2.data.repository.ItemsRepositoryImpl
import my.guide.theescapists2.recycler.ItemAdapter
import my.guide.theescapists2.recycler.Items
import java.util.*
import kotlin.collections.ArrayList

class SearchCraftsUseCase(var data : ItemsRepositoryImpl, var adapter: ItemAdapter) {

    fun filterList(query: String?): ArrayList<Items> {
        val filteredList = ArrayList<Items>()
        if (query != null) {
            for (i in data.dataInitialize()) {
                if (i.name.lowercase(Locale.ROOT).contains(query.lowercase())) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
        return filteredList
    }
}