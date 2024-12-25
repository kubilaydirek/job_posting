package com.example.jobposting.ui.scene.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jobposting.R
import com.example.jobposting.ui.component.scaffold.JobScaffold
import com.example.jobposting.ui.component.button.JobButton
import com.example.jobposting.ui.component.button.SocialButton
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.component.textfield.JobTextField
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.DarkGrey
import com.example.jobposting.ui.theme.customTypography
import dagger.hilt.android.lifecycle.HiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScene(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToSignUp: () -> Unit
) {

    val viewState: LoginViewState = rememberLoginViewState()
    val uiState = viewModel.uiState.collectAsState()

    JobScaffold(
        uiState = uiState.value,
        content = {
            Content(modifier, viewState, navigateToSignUp, viewModel)
        },
    )

}

@Composable
private fun Content(modifier: Modifier, viewState: LoginViewState, navigateToSignUp: () -> Unit, viewModel: LoginViewModel) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 96.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cool_kids_sitting),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(250.dp)
                    .width(350.dp)
            )
            TextContent(modifier)
            Form(modifier, viewState, navigateToSignUp, viewModel)
        }
    }
}


@Composable
private fun TextContent(modifier: Modifier) {
    Box(
        modifier = modifier
            .width(375.dp)
            .height(110.dp)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobText(text = stringResource(R.string.log_in), color = Dark, style = customTypography.headlineLarge)
            JobText(
                text = stringResource(R.string.login_with_social_networks),
                color = DarkGrey,
                style = customTypography.titleSmall
            )
            SocialButtons(modifier)
        }
    }
}

@Composable
private fun SocialButtons(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement =
        Arrangement.spacedBy(
            10.dp,
            alignment = Alignment.CenterHorizontally
        )

    ) {
        SocialButton(painter = painterResource(R.drawable.facebook_icon))
        SocialButton(painter = painterResource(R.drawable.instagram))
        SocialButton(painter = painterResource(R.drawable.google))
    }
}

@Composable
private fun Form(modifier: Modifier, viewState: LoginViewState, navigateToSignUp: () -> Unit, viewModel: LoginViewModel) {
    Box(
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobTextField(
                label = stringResource(R.string.email),
                value = viewState.username.value,
                onChanceValue = {
                    viewState.username.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = viewState.usernameIsError.value,
                errorMessage = stringResource(R.string.is_not_empty)
            )
            JobTextField(
                label = stringResource(R.string.password),
                value = viewState.password.value,
                onChanceValue = {
                    viewState.password.value = it
                },
                isPasswordField = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = viewState.passwordIsError.value,
                errorMessage = stringResource(R.string.is_not_empty)
            )
            JobText(text = stringResource(R.string.forgot_password), color = DarkGrey)
            JobButton(buttonText = stringResource(R.string.log_in), onclick = {
            //    viewState.validator()
                if (!viewState.usernameIsError.value && !viewState.passwordIsError.value) {
                    viewModel.login(viewState.username.value.text, viewState.password.value.text)
                }
            })
            JobText(
                text = stringResource(R.string.sign_up),
                color = DarkGrey,
                modifier = modifier.clickable { navigateToSignUp.invoke() })
        }

    }
}

@Preview
@Composable
private fun LoginScenePreview() {
    LoginScene(navigateToSignUp = {})
}