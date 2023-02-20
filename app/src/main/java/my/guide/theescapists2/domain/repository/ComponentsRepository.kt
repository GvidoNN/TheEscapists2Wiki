package my.guide.theescapists2.domain.repository

import my.guide.theescapists2.domain.models.Components

interface ComponentsRepository {
    fun dataInitialize() : ArrayList<Components>
}