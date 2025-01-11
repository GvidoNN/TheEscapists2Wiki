package lovely.honey.prison.domain.repository

import lovely.honey.prison.domain.models.Components

interface ComponentsRepository {
    fun dataInitialize() : ArrayList<Components>
}