package com.meliskarci.supabasetest.presentation.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meliskarci.supabasetest.R
import com.meliskarci.supabasetest.navigation.Screen
import com.meliskarci.supabasetest.presentation.category.components.ArtCategoryCard

@Composable
fun CategoryScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ArtCategoryCard(
                categoryName = "Tablo",
                imageRes = R.drawable.ciglik,
                onClick = { navController.navigate(Screen.List.createRoute("Tablo"))  }
            )


            Spacer(modifier = Modifier.width(8.dp)) // YAN boşluk için width!


            ArtCategoryCard(
                categoryName = "Heykel",
                imageRes = R.drawable.davut,
                onClick = { navController.navigate(Screen.List.createRoute("Heykel")) }
            )


        }
    }}


