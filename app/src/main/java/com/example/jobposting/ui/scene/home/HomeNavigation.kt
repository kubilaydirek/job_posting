package com.example.jobposting.ui.scene.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.jobposting.ui.component.bottomBar.JobBottomBar

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    composable("Dashboard") {
        JobBottomBar()
    }
}