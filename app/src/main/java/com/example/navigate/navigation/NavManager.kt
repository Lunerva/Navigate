package com.example.navigate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigate.views.BarrancoView
import com.example.navigate.views.DetailView
import com.example.navigate.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  )
    {
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") { type = NavType.StringType },
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
        composable("Barranco/{id}/?{opcional}", arguments = listOf(
        navArgument("id") { type = NavType.IntType },
        navArgument("opcional") { type = NavType.StringType },
        )){
        val id = it.arguments?.getInt("id") ?: 0
        val opcional = it.arguments?.getString("opcional") ?: ""
        BarrancoView(navController, id, opcional)
    }
    }
}