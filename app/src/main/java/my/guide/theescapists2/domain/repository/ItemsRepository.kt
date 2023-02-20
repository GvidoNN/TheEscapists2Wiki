package my.guide.theescapists2.domain.repository

import my.guide.theescapists2.domain.models.Items

interface ItemsRepository {

    fun dataInitialize(): ArrayList<Items>
}