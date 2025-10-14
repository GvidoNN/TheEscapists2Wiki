package lovely.honey.prison.domain.usecase

import lovely.honey.prison.domain.models.Components
import lovely.honey.prison.domain.repository.ComponentsRepository

class PutDataComponentUseCase(
    private val componentsRepository: ComponentsRepository
) {

    fun getData(): ArrayList<Components>{
        return componentsRepository.dataInitialize()
    }
}