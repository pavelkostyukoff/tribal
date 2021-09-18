package covenant.tribal.domain.repository

import covenant.tribal.domain.model.FeedEntity
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    fun getCities() : Flow<List<FeedEntity>>
}