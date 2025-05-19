package com.meliskarci.supabasetest.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String) {

    //    object Login : Screen("login")
//    object Register : Screen("register")
    object Category : Screen("category")

    object List : Screen("list/{category}") {
        fun createRoute(category: String) = "list/$category"
    }

    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int): String = "detail/$id"
    }

    object Settings : Screen("settings")

}