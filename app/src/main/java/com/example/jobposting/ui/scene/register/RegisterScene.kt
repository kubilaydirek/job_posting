package com.example.jobposting.ui.scene.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobposting.R
import com.example.jobposting.ui.component.button.JobButton
import com.example.jobposting.ui.component.button.JobCircleBackButton
import com.example.jobposting.ui.component.scaffold.JobScaffold
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.component.textfield.JobTextField
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.DarkGrey
import com.example.jobposting.ui.theme.customTypography

@Composable
fun RegisterScene(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    navigationToBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    JobScaffold(
        content = {
            Content(modifier, navigationToBack)
        },
        uiState = uiState
    )
}

@Composable
private fun Content(modifier: Modifier, navigationToBack: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        JobCircleBackButton(onClick = { navigationToBack.invoke() })
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.cool_kids_standing),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .height(250.dp)
                    .width(350.dp)
            )
            TextContent(modifier)
            Form(modifier, navigationToBack)
        }
    }
}

@Composable
private fun TextContent(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 15.dp), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobText(text = stringResource(R.string.sign_up), color = Dark, style = customTypography.headlineLarge)
            JobText(text = stringResource(R.string.create_your_account), color = DarkGrey)
        }

    }
}

@Composable
private fun Form(modifier: Modifier, navigationToBack: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(330.dp)
            .padding(top = 15.dp)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobTextField(label = stringResource(R.string.name))
            JobTextField(label = stringResource(R.string.email))
            JobTextField(label = stringResource(R.string.password))
            JobButton(onclick = {}, buttonText = stringResource(R.string.sign_up))
            JobText(
                text = stringResource(R.string.log_in),
                color = DarkGrey,
                modifier = modifier.clickable { navigationToBack.invoke() })
        }
    }
}

@Preview
@Composable
private fun RegisterScenePreview() {
    RegisterScene(navigationToBack = {})
}