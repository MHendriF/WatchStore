package com.mhendrif.watchstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhendrif.watchstore.ui.screen.DetailScreen
import com.mhendrif.watchstore.ui.screen.HomeScreen
import com.mhendrif.watchstore.ui.theme.WatchStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController =  rememberNavController()
            WatchStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetupNavigation(navHostController = navHostController)
                }
            }
        }
    }
}

@Composable
fun SetupNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navHostController = navHostController)
        }

        composable(route = "detail") {
            DetailScreen(onClickBack = { navHostController.popBackStack() })
        }
    }
}
