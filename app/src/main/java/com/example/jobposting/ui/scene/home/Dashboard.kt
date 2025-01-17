package com.example.jobposting.ui.scene.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.ui.component.bottomBar.BottomNavigationBarItems
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.scene.profile.ProfileScene
import com.example.jobposting.ui.scene.settings.SettingsScene
import com.example.jobposting.ui.theme.Gray
import com.example.jobposting.ui.theme.Primary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val screens = listOf(
        BottomNavigationBarItems.HomeScene,
        BottomNavigationBarItems.ProfileScene,
        BottomNavigationBarItems.SettingsScene
    )

    Scaffold(
        content = {
            when (selectedIndex) {
                0 -> HomeScene()
                1 -> ProfileScene()
                2 -> SettingsScene()
            }
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color.White)
                    .border(
                        width = 2.dp,
                        color = Gray,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(8.dp),
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                screens.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        label = {
                            val iconColor = if (selectedIndex == index) Primary else Gray
                            JobText(text = screen.title!!, color = iconColor) },
                        icon = {
                            val iconColor = if (selectedIndex == index) Primary else Gray
                            Image(
                                painterResource(screen.icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(28.dp),
                                colorFilter = ColorFilter.tint(color = iconColor)
                            )
                        },
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index;
                        },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedTextColor = Color.Gray,
                            selectedTextColor = Color.Black,
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Black,
                            indicatorColor = Color.White
                        )

                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun DashboardPreview() {
    Dashboard()
}


