package covenant.tribal.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import covenant.tribal.ui.login.LoginScreen
import covenant.tribal.ui.theme.TribalChatsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TribalChatsTheme {
                LoginScreen()
            }
        }
    }
}