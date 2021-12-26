package covenant.tribal.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import covenant.tribal.R
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = getViewModel()) {
    val login = remember { mutableStateOf(TextFieldValue("")) }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val toast by viewModel.toast.collectAsState()

    if (toast.isNotBlank()) {
        Toast.makeText(LocalContext.current, toast, Toast.LENGTH_SHORT).show()
    }

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (button, logo, editName, editPass) = createRefs()
        val buttonModifier = Modifier
            .constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 32.dp)
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    startMargin = 16.dp,
                    endMargin = 16.dp
                )
                linkTo(
                    bottom = parent.bottom,
                    top = editPass.bottom,
                    bottomMargin = 16.dp,
                    topMargin = 8.dp,
                    bias = 1f
                )
            }
            .fillMaxWidth(0.8F)
            .height(48.dp)
        SignInButton(buttonModifier, viewModel, login, password)
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

        TextField(
            value = login.value,
            label = { Text(text = "Login") },
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(editName) {
                    top.linkTo(logo.bottom, 32.dp)
                }
                .fillMaxWidth(),
            onValueChange = {
                login.value = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(editPass) {
                top.linkTo(editName.bottom, 8.dp)
            }
        ) {
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },

                placeholder = { Text("Password") },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisibility) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(imageVector = image, "")
                    }
                }

            )
            //todo проверяю текущий стейт check current state если это ошибка то
                // рисую текст с ошибкой
                // если нет ошибки

        }
    }
}

@Composable
private fun SignInButton(buttonModifier: Modifier, viewModel: LoginViewModel, login: MutableState<TextFieldValue>, password: String) {
    Button(
        onClick = {
            viewModel.signIn(login.value.text, password)
        },
        modifier = buttonModifier
    ) {
        Text("SingIn")
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

sealed class  UiState {
    object Default : UiState()
    class Error(val errText: String) : UiState()
    //
}
