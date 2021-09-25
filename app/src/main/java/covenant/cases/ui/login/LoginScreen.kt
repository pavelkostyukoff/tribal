package covenant.cases.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import covenant.tribal.R

@Composable
fun LoginScreen() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (button, logo, editName, editPass) = createRefs()
        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 32.dp)
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        startMargin = 16.dp,
                        endMargin = 16.dp
                    )
                }
                .fillMaxWidth(0.8F)
                .height(48.dp)
        ) {
            Text("Button")
        }
        Card(
            modifier = Modifier
                .size(128.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top, 64.dp)
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        startMargin = 16.dp,
                        endMargin = 16.dp
                    )
                },
            shape = CircleShape,
            elevation = 2.dp
        ) {

            Image(
                painterResource(R.drawable.button_blue),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        val login = remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = login.value,
            label = { Text(text = "Login")},
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(editName) {
                    top.linkTo(logo.bottom, 64.dp)
                }
                .fillMaxWidth(),
            onValueChange = {
                login.value = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
