package covenant.tribal.data.repository


import androidx.annotation.InspectableProperty.EnumEntry
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import covenant.tribal.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepositoryImpl : AuthRepository {
    private val firebaseAuth = Firebase.auth
    override suspend fun signIn(email: String, password: String) {
        withContext(
            Dispatchers.IO
        ) {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
        }
    }
    //todo sighUp

    //todo разлогин

    //todo check
}