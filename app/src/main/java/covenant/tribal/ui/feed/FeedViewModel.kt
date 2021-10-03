package covenant.tribal.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import covenant.tribal.domain.usecase.GetFeedUseCase
import kotlinx.coroutines.launch

class FeedViewModel(private val useCase: GetFeedUseCase) :ViewModel() {

        private val stateInternal = MutableLiveData<FeedState>(FeedState.Loading)
        val state : LiveData<FeedState> = stateInternal

        init {
            viewModelScope.launch {
               /* useCase.getCities()
                    .map {
                        FeedState.Success(it) as FeedState
                    }
                    .catch {
                        emit(FeedState.Error)
                    }
                    .collect{
                        stateInternal.value = it
                    }*/
           // }
        }
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}