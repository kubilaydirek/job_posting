package com.example.jobposting.ui.scene.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobposting.data.helpers.UiState
import com.example.jobposting.data.models.getjobs.JobsResponseModel
import com.example.jobposting.ui.component.courseCard.CourseCard
import com.example.jobposting.ui.component.scaffold.JobScaffold
import com.example.jobposting.ui.component.textfield.JobTextField
import com.example.jobposting.ui.component.topbar.JobTopBar

@Composable
fun HomeScene(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val homeViewState: HomeViewState = rememberHomeViewState()
    val uiState = homeViewModel.uiState.collectAsState()

    JobScaffold(
        uiState = uiState.value,
        modifier = modifier,
        topBar = {
            JobTopBar.JobHomePageTopBar()
        },
        content = { paddingValue ->

        }
    )
}

@Preview
@Composable
private fun HomeScenePreview() {
    HomeScene()
}