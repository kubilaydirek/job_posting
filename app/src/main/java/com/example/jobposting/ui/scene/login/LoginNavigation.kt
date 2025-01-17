package com.example.jobposting.ui.scene.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.loginGraph(navController: NavController) {
    composable("LoginScene") {
        LoginScene(
            navigateToSignUp = { navController.navigate("RegisterScene") },
            navigateToHome = { navController.navigate("Dashboard") { popUpTo("LoginScene") { inclusive = true } } })
    }
}