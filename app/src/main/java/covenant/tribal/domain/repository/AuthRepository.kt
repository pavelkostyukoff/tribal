package covenant.tribal.domain.repository

interface AuthRepository {
    suspend fun signIn(email: String, password:String)
}