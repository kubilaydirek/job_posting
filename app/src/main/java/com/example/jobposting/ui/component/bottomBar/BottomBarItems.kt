package com.example.jobposting.ui.component.bottomBar

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.jobposting.R

sealed class BottomNavigationBarItems(
    val title: String? = null,
    @DrawableRes val icon : Int

) {
    data object HomeScene : BottomNavigationBarItems(
        title = "Courses",
        icon = R.drawable.courses
    )

    data object ProfileScene : BottomNavigationBarItems(
        title = "Profile",
        icon = R.drawable.profile
    )

    data object SettingsScene : BottomNavigationBarItems(
        title = "Settings",
        icon = R.drawable.settings
    )
}