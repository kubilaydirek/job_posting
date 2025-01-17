package com.example.jobposting.ui.scene.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    composable("HomeScene") {
        HomeScene()
    }
    composable("Dashboard") {
        Dashboard()
    }
}