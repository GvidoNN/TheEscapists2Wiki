package my.guide.theescapists2.domain.usecase

import my.guide.theescapists2.domain.models.Components
import my.guide.theescapists2.domain.repository.ComponentsRepository

class PutDataComponentUseCase(val componentsRepository: ComponentsRepository) {

    fun getData(): ArrayList<Components>{
        return componentsRepository.dataInitialize()
    }
}