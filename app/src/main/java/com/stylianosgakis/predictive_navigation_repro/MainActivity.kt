package com.stylianosgakis.predictive_navigation_repro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stylianosgakis.predictive_navigation_repro.ui.theme.PredictivenavigationreproTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PredictivenavigationreproTheme {
        App()
      }
    }
  }
}

@Composable
private fun App() {
  val navController = rememberNavController()
  Surface(modifier = Modifier.fillMaxSize()) {
    NavHost(
      navController,
      "A",
      enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(1000)) },
      exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(1000)) },
      popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(1000)) },
      popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(1000)) },
      modifier = Modifier.fillMaxSize(),
    ) {
      composable("A") {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(Color.Red), contentAlignment = Alignment.Center
        ) {
          Column {
            Text("A")
            Button({ navController.navigate("B") }) { Text("Go to B") }
          }
        }
      }
      composable("B") {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow), contentAlignment = Alignment.Center
        ) {
          Column {
            Text("B")
            Button({ navController.navigate("C") }) { Text("Go to C") }
          }
        }
      }
      composable("C") {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
          contentAlignment = Alignment.Center
        ) {
          Column {
            Text("C")
            Button({ navController.navigate("D") }) { Text("Go to D") }
          }
        }
      }
      composable("D") {
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(Color.Green), contentAlignment = Alignment.Center
        ) {
          Text("D")
        }
      }
    }
  }
}