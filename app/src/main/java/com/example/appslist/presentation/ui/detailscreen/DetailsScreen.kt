package com.example.appslist.presentation.ui.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.appslist.R
import com.example.appslist.model.ApplicationDetails
import com.example.appslist.presentation.ui.common.Error
import com.example.appslist.presentation.ui.detailscreen.components.DetailTopBar
import com.example.appslist.ui.theme.marginNormal
import com.example.appslist.ui.theme.marginxSmall
import com.example.shareddata.common.Resource
import com.example.shareddata.common.isLoading

@Composable
fun DetailsScreen(backAction: () -> Unit, detailScreenViewmodel: DetailScreenViewmodel = hiltViewModel()) {
    val appDetailsResource = detailScreenViewmodel.currentApp.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            DetailTopBar(detailScreenViewmodel.name, backAction)
        }) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            when {
                appDetailsResource.isLoading() -> {
                    Loading(modifier = Modifier.fillMaxSize())
                }
                appDetailsResource is Resource.Success -> {
                    Success(appDetails = appDetailsResource.data)
                }
                appDetailsResource is Resource.Failure -> {
                    Error(modifier = Modifier.fillMaxSize()) {
                        detailScreenViewmodel.loadApp()
                    }
                }
            }
        }
    }
}

@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Success(appDetails: ApplicationDetails) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            Box(
                Modifier.padding(marginNormal)
            ) {
                AsyncImage(
                    model = appDetails.image,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(marginxSmall)),
                )
            }
        }

        items(appDetails.details) { item ->
            DetailInfoComponent(
                label = getLabelForType(item.type),
                value = item.detailedInfo,
                icon = getIconForType(item.type)
            )
        }
    }
}

@Composable
private fun Error(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "My GIF",
            contentScale = ContentScale.Fit
        )
    }
}

private fun getIconForType(type: AppDetailType): Int {
    return when (type) {
        AppDetailType.SIZE -> R.drawable.ic_store
        AppDetailType.DOWNLOAD -> R.drawable.ic_star
        AppDetailType.LAST_UPDATED -> R.drawable.ic_more
        AppDetailType.RATING -> R.drawable.ic_account
    }
}

private fun getLabelForType(type: AppDetailType): Int {
    return when (type) {
        AppDetailType.SIZE -> R.string.detail_size
        AppDetailType.DOWNLOAD -> R.string.detail_downloads
        AppDetailType.LAST_UPDATED -> R.string.detail_last_updated
        AppDetailType.RATING -> R.string.detail_rating
    }
}