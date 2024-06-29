package com.example.quizit.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.quizit.R
import com.example.quizit.presentation.home.HomeScreen
import com.example.quizit.presentation.home.HomeScreenViewModel
import com.example.quizit.presentation.nav_graph.SetNavGraph
import com.example.quizit.ui.theme.QuizItTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
            QuizItTheme {

                Box(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(colorResource(id = R.color.background)),
                    contentAlignment = Alignment.Center
                ) {
                    SetNavGraph()
                }
            }
        }
    }
}

