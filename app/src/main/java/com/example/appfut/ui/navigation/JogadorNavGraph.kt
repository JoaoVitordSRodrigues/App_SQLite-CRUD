package com.example.appfut.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfut.data.JogadorRepository
import com.example.appfut.ui.JogadorScreen
import com.example.appfut.ui.JogadorViewModel
import com.example.appfut.ui.JogadorViewModelFactory

@Composable
fun JogadorNavGraph(navController: NavHostController, jogadorRepository: JogadorRepository) {
    val viewModel: JogadorViewModel = viewModel(factory = JogadorViewModelFactory(jogadorRepository))

    NavHost(navController, startDestination = "futScreen") {
        composable("futScreen") { JogadorScreen(viewModel) }
    }
}
