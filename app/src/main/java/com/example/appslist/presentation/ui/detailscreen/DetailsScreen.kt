package com.example.appslist.presentation.ui.detailscreen

import android.widget.Toast
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import com.example.appslist.R
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
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                Modifier.padding(marginNormal)) {
                AsyncImage(
                    model = appDetails?.image,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(marginxSmall)),
                )
            }
            Column {
                DetailInfoComponent(label = "Name", value = appDetails?.name.orEmpty(), R.drawable.ic_store)
                DetailInfoComponent(label = "Size", value = appDetails?.size.orEmpty(), R.drawable.ic_store)
                DetailInfoComponent(label = "Downloads", value = appDetails?.size.orEmpty(), R.drawable.ic_store)
                DetailInfoComponent(label = "Updated", value = appDetails?.updated.orEmpty(), R.drawable.ic_store)
                DetailInfoComponent(label = "Rating", value = appDetails?.rating.orEmpty(), R.drawable.ic_store)
                // App rating and reviews
            }
        }
    }
}