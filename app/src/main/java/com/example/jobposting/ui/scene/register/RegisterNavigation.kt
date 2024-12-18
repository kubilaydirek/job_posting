package com.example.jobposting.ui.scene.register

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.registerGraph(navController: NavController) {
    composable("RegisterScene") {
        RegisterScene(navigationToBack = { navController.popBackStack() })
    }
}