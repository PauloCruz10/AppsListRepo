package com.example.appslist.presentation.ui.detailscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.appslist.presentation.ui.homescreen.components.TopBar
import com.example.appslist.ui.theme.marginNormal
import com.example.appslist.ui.theme.marginxSmall

@Composable
fun DetailsScreen(detailScreenViewmodel: DetailScreenViewmodel = hiltViewModel()) {
    val context = LocalContext.current
    val appDetails = detailScreenViewmodel.currentApp.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopBar(appDetails?.name.orEmpty(),
                onIconAction = {
                    Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                })
        }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                Modifier
                    .weight(0.4f)
                    .padding(marginNormal)) {
                AsyncImage(
                    model = appDetails?.graphic,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(marginxSmall)),
                )
            }
            Box(Modifier.weight(0.6f)) {
                Column {
                    Text(text = appDetails?.name.orEmpty())
                    // App rating and reviews
                }
            }
        }
    }
}