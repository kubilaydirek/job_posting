package com.example.jobposting.data.enums

sealed class Screen(val route : String){
    data object LoginScene : Screen("LoginScene")
}