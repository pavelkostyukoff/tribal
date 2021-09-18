package covenant.tribal.domain.usecase

import covenant.tribal.domain.model.FeedEntity
import covenant.tribal.domain.repository.FeedRepository
import kotlinx.coroutines.flow.Flow

class GetFeedUseCase(private val repository: FeedRepository) {

    fun getCities(): Flow<List<FeedEntity>> {
        return repository.getCities()
    }
}