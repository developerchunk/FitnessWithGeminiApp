package com.developerstring.fitnesswithgeminiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Welcome to Fitness", fontSize = 24.sp)
        Text(
            text = "With Gemini",
            fontSize = 24.sp,
            color = Color(0xFF007CC7),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(80.dp))

        CircularProgressIndicator(color = Color(0xFF007CC7))

    }

    LaunchedEffect(true) {
        // Delay for 3 seconds
        delay(3000)
        navController.navigate("fitness_screen")
    }


}

@Preview(showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {

    WelcomeScreen(navController = rememberNavController())

}