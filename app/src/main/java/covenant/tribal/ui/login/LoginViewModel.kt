package covenant.tribal.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import covenant.tribal.domain.repository.AuthRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                repository.signIn("test", "test2")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
        Timber.d("loginD")
    }
}