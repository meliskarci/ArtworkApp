package com.meliskarci.supabasetest.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    category: String
) {
    val viewModel = hiltViewModel<ListViewModel>()
    val artworks by viewModel.artworks.collectAsStateWithLifecycle()

    LaunchedEffect(category) {
        viewModel.getArtworkByType(type = category)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(artworks) { artwork ->
                val imageUrl = remember(artwork.image_name) {
                    "https://nsxnptfzgueoeadiwuem.supabase.co/storage/v1/object/public/artworks/${artwork.image_name}"
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("detail/${artwork.id}")
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                        ) {
                            AsyncImage(
                                model = imageUrl,
                                contentDescription = artwork.name,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(12.dp))
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = artwork.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}


//package com.meliskarci.supabasetest.presentation.list
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavController
//import coil.compose.AsyncImage
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ListScreen(
//    navController: NavController,
//    category: String,
//    onBackClick: () -> Unit = { navController.popBackStack() }
//) {
//    // Get view model and instrument data
//    val viewModel = hiltViewModel<ListViewModel>()
//    val artworks by viewModel.artworks.collectAsStateWithLifecycle()
//
//    LaunchedEffect(category) {
//        viewModel.getArtworkByType(type = category)
//    }
//
////    Scaffold(
//////        topBar = {
//////            TopAppBar(
//////                colors = TopAppBarDefaults.topAppBarColors(
//////                    containerColor = Color.Black,
//////                    titleContentColor = Color.White
//////                ),
//////                title = {
//////                    Text(text = category, color = Color.White)
//////                },
//////                navigationIcon = {
//////                    IconButton(onClick = onBackClick) {
//////                        Icon(
//////                            imageVector = Icons.Default.ArrowBack,
//////                            contentDescription = "Geri",
//////                            tint = Color.White
//////                        )
//////                    }
//////                }
//////            )
//////        }
////    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black)
////                .padding(innerPadding)
//        ) {
//            LazyVerticalGrid(
//                columns = GridCells.Adaptive(160.dp),
//                contentPadding = PaddingValues(
//                    start = 12.dp,
//                    end = 12.dp,
////                    top = innerPadding.calculateTopPadding() + 12.dp,
////                    bottom = innerPadding.calculateBottomPadding() + 12.dp
//                ),
//                verticalArrangement = Arrangement.spacedBy(12.dp),
//                horizontalArrangement = Arrangement.spacedBy(12.dp),
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(color = Color.Black)
//            ) {
//                items(artworks) { artwork ->
//                    val imageUrl = remember(artwork.image_name) {
//                        "https://nsxnptfzgueoeadiwuem.supabase.co/storage/v1/object/public/artworks/${artwork.image_name}"
//                    }
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable { navController.navigate("detail/${artwork.id}") },
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f)
//                        ),
//                        shape = RoundedCornerShape(12.dp),
//                        elevation = CardDefaults.cardElevation(
//                            defaultElevation = 2.dp
//                        )
//                    ) {
//                        Column(
//                            modifier = Modifier.padding(8.dp)
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(8.dp))
//                            ) {
//                                AsyncImage(
//                                    model = imageUrl,
//                                    contentDescription = artwork.name,
//                                    contentScale = ContentScale.Fit,   // Crop
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .aspectRatio(1f) // Square aspect ratio
//                                        .clip(RoundedCornerShape(12.dp))
//                                )
//                            }
//
//                            Spacer(modifier = Modifier.height(8.dp))
//
//                            Text(
//                                text = artwork.name,
//                                style = MaterialTheme.typography.titleMedium,
//                                color = Color.White
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
////}
