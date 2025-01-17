package com.example.jobposting.scene.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jobposting.ui.scene.home.homeGraph
import com.example.jobposting.ui.scene.login.loginGraph
import com.example.jobposting.ui.scene.register.registerGraph

const val login = "LoginScene"

@Composable
fun JobNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = login) {
        loginGraph(navController = navController)
        registerGraph(navController = navController)
        homeGraph(navController = navController)
    }
}