package com.meliskarci.supabasetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meliskarci.supabasetest.navigation.NavigationGraph
import com.meliskarci.supabasetest.navigation.Screen
import com.meliskarci.supabasetest.presentation.components.Bottombar
import com.meliskarci.supabasetest.presentation.settings.SettingsViewModal
import com.meliskarci.supabasetest.ui.theme.SupabaseTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<SettingsViewModal>()
            val isDarkMode by viewModel.isDarkMode.collectAsStateWithLifecycle()

            SupabaseTutorialTheme(darkTheme = isDarkMode) {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                // BottomBar sadece bu sayfalarda gösterilecek
                val shouldShowBottomBar = currentDestination?.hierarchy?.any { destination ->
                    destination.route in listOf(
                        Screen.Category.route,
                        Screen.Settings.route
                    )
                } == true


                Scaffold(
                    topBar = {
                        val showTopBarRoutes = listOf(Screen.List.route)

                        if (currentDestination?.route in showTopBarRoutes) {
                            CenterAlignedTopAppBar(
                                title = { },
                                navigationIcon = {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = "Geri",
                                            tint = Color.White
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = Color.Black
                                )
                            )
                        }
                    }

                    ,
                    bottomBar = {
                        if (shouldShowBottomBar) {
                            Bottombar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavigationGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

