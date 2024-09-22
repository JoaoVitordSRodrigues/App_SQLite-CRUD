package com.example.appfut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.appfut.data.AppContainer
import com.example.appfut.ui.navigation.JogadorNavGraph
import com.example.appfut.ui.theme.AppFutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFutTheme{
                val appContainer = AppContainer(applicationContext)
                val jogadorRepository = appContainer.jogadorRepository
                val navController = rememberNavController()
                JogadorNavGraph(navController = navController, jogadorRepository = jogadorRepository)
            }
        }
    }
}
