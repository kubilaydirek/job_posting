package com.example.jobposting.scene.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jobposting.data.enums.Screen
import com.example.jobposting.ui.scene.login.LoginScene

@Composable
fun JobNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScene.route) {
        composable(route = Screen.LoginScene.route) {
            LoginScene(modifier)
        }
    }
}