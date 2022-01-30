package covenant.cases.ui.login

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen() {
    LazyColumn(Modifier.fillMaxSize()) {
        for (i in 0..1000) {
            item { Text(text = "Hello word $i") }
            item {
                Row(Modifier.fillMaxWidth()) {
                    Text(modifier = Modifier.weight(1f), text = "Hello ocean", color = colors.onPrimary)
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }
        }
    }
}
