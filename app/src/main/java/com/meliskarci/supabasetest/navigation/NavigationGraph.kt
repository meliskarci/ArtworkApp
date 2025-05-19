package com.meliskarci.supabasetest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
//import com.meliskarci.supabasetest.ui.auth.LoginScreen
//import com.meliskarci.supabasetest.ui.auth.RegisterScreen
import com.meliskarci.supabasetest.presentation.category.CategoryScreen
import com.meliskarci.supabasetest.presentation.list.ListScreen
import com.meliskarci.supabasetest.presentation.detail.DetailScreen
import com.meliskarci.supabasetest.presentation.settings.SettingsScreen

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Category.route,
        modifier = modifier
    ) {

        composable(route = Screen.Category.route) {
            CategoryScreen(navController)
        }

        composable(
            route = Screen.List.route,  // "list/{category}"
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "Tablo"
            ListScreen(navController, category)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(navController)
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}