package covenant.tribal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import covenant.cases.ui.login.LoginScreen
import covenant.cases.ui.theme.TribalChatsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TribalChatsTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
            }
        }
    }
}