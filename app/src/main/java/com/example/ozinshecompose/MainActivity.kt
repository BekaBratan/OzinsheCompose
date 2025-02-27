package com.example.ozinshecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ozinshecompose.presentation.DetailScreen
import com.example.ozinshecompose.presentation.HomeScreen
import com.example.ozinshecompose.ui.theme.OzinsheComposeTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OzinsheComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HomeScreen
                ) {
                    composable<HomeScreen> {
                        HomeScreen(navController)
                    }

                    composable<SecondScreen>{
                        val args = it.toRoute<SecondScreen>()
                        DetailScreen(args.id, args.name)
                    }
                }
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
data class SecondScreen(
    val id: Int,
    val name: String?
)
