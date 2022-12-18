package my.guide.theescapists2.domain.repository

import android.content.Context
import my.guide.theescapists2.recycler.Items

interface ItemsRepository {

    fun dataInitialize(): ArrayList<Items>
}