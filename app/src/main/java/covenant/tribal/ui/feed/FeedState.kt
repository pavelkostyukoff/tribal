package covenant.tribal.ui.feed

import covenant.tribal.domain.model.FeedEntity

sealed class FeedState {
    object Loading : FeedState()
    data class Success(val cities: List<FeedEntity>) : FeedState()
    object Error : FeedState()
}