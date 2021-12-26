package covenant.tribal.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import covenant.tribal.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
    val state = MutableStateFlow(UiState.Default)

    fun signIn(login: String, password: String) { //todo autorize
        viewModelScope.launch {
            try {
                repository.signIn(login, password)
            } catch (e: FirebaseAuthInvalidUserException) {

                Timber.e(e)
                when (e.errorCode) {
                    USER_NOT_FOUND -> signUp(login, password)
                    else -> {
                        Timber.e(e)
                    }
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    private fun signUp(login: String, password: String) { //registation
        viewModelScope.launch {
            try {
                repository.signUp(login, password)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    init {
        Timber.d("loginD")
    }

    companion object {
        const val USER_NOT_FOUND = "ERROR_USER_NOT_FOUND"
    }
}