package com.example.jobposting.ui.scene.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jobposting.R
import com.example.jobposting.data.helpers.UiState
import com.example.jobposting.data.models.getjobs.JobsResponseModel
import com.example.jobposting.ui.component.courseCard.CourseCard
import com.example.jobposting.ui.component.scaffold.JobScaffold
import com.example.jobposting.ui.component.textfield.JobTextField
import com.example.jobposting.ui.component.topbar.JobTopBar

@Suppress("UNCHECKED_CAST")
@Composable
fun HomeScene(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val homeViewState: HomeViewState = rememberHomeViewState()
    val uiState = homeViewModel.uiState.collectAsState()

    JobScaffold(uiState = uiState.value, modifier = modifier, topBar = {
        JobTopBar.JobHomePageTopBar(name = homeViewModel.name.value)
    }, content = { paddingValue ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            JobTextField(
                value = homeViewState.searchTextField.value,
                onChanceValue = { homeViewState.searchTextField.value = it },
                label = "Search course",
                modifier = Modifier.padding(4.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.search_icon),
                        contentDescription = null,
                        modifier = modifier.size(24.dp)
                    )
                }

            )
            if (uiState.value is UiState.Success<*>) {
                val successState = uiState.value as UiState.Success<List<JobsResponseModel>>
                val jobList = successState.data ?: emptyList()

                LazyColumn {
                    items(jobList) { job ->
                        CourseCard(title = job.title, detail = job.description, price = job.salaryRange)
                    }
                }
            }
        }
    }
    )
}

@Preview
@Composable
private fun HomeScenePreview() {
    HomeScene()
}