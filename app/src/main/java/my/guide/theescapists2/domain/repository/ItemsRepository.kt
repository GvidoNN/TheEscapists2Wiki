package my.guide.theescapists2.domain.repository

import my.guide.theescapists2.recycler.Items

interface ItemsRepository {

    fun dataInitialize(): ArrayList<Items>
}