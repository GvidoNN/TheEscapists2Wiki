package lovely.honey.prison.domain.repository

import lovely.honey.prison.domain.models.Items

interface ItemsRepository {

    fun dataInitialize(): ArrayList<Items>
}