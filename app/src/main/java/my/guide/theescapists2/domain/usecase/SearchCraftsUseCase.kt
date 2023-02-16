package my.guide.theescapists2.domain.usecase

import my.guide.theescapists2.domain.repository.ItemsRepository
import my.guide.theescapists2.recycler.ItemAdapter
import my.guide.theescapists2.recycler.Items
import java.util.*
import kotlin.collections.ArrayList

class SearchCraftsUseCase(var itemRepository : ItemsRepository, var adapter: ItemAdapter) {
    fun filterList(query: String?): ArrayList<Items> {
        val filteredList = ArrayList<Items>()
        if (query != null) {
            for (i in itemRepository.dataInitialize()) {
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