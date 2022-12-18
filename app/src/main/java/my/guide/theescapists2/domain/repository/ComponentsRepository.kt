package my.guide.theescapists2.domain.repository

import my.guide.theescapists2.recycler.Components

interface ComponentsRepository {

    fun dataInitialize() : ArrayList<Components>
}