package com.example.jobposting.ui.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.R
import com.example.jobposting.ui.component.button.JobCircleBackButton
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.theme.Gray
import com.example.jobposting.ui.theme.customTypography

object JobTopBar {

    @Composable
    fun JobHomePageTopBar(modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(8.dp)
        ) {
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = modifier.weight(3f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    JobText(text = "Hello,", style = customTypography.titleSmall)
                    JobText(text = "John Smith", style = customTypography.displayLarge)
                }

                Box(
                    modifier = modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(CircleShape)
                        .border(1.dp, Gray, CircleShape), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painterResource(R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = modifier
                            .width(17.dp)
                            .height(20.dp), colorFilter = ColorFilter.tint(Color.Black)
                    )
                }
            }

        }
    }


    @Composable
    fun JopTopBar(modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Row(modifier = modifier
                .fillMaxSize()
                .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                JobCircleBackButton(size = 40.dp, onClick = {})
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    JobText(text = "Header", style = customTypography.headlineLarge)
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun JopTopBarHomePagePreview() {
    JobTopBar.JobHomePageTopBar()
}

@Preview(showBackground = true)
@Composable
private fun JopTopBarPreview() {
    JobTopBar.JopTopBar()
}