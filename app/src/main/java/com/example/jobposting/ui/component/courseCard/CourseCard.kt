package com.example.jobposting.ui.component.courseCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.R
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.Gray
import com.example.jobposting.ui.theme.LightGray
import com.example.jobposting.ui.theme.Secondary
import com.example.jobposting.ui.theme.Success
import com.example.jobposting.ui.theme.White
import com.example.jobposting.ui.theme.customTypography

@Composable
fun CourseCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .height(300.dp)
            .border(1.dp, Gray, RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(LightGray), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
            ) {
                Image(
                    painterResource(R.drawable.cool_kids_discussion),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(140.dp)
                )
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 8.dp, end = 16.dp, bottom = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Price()
                }
            }

        }
        Box(
            modifier = modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                JobText(text = "3 h 30 min", color = Success, style = customTypography.bodySmall)
                JobText(text = "Course", color = Dark, style = customTypography.headlineLarge)
                JobText(text = "Advanced web applications", color = Dark, style = customTypography.bodyMedium)
            }
        }

    }
}

@Composable
fun Price(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(26.dp)
            .width(58.dp)
            .background(color = Secondary, shape = RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center
    ) {
        JobText(text = "$ 50", color = White, style = customTypography.bodySmall)
    }

}

@Preview
@Composable
private fun CourseCardPreview() {
    CourseCard()
}

@Preview
@Composable
private fun PricePreview() {
    Price()
}