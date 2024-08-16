package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appslist.R
import com.example.appslist.model.AppItem
import com.example.appslist.presentation.ui.common.Error
import com.example.appslist.presentation.ui.common.Loading
import com.example.shareddata.common.Resource
import com.example.shareddata.common.isLoading
import com.example.shareddata.model.appsList.AppInfo

@Composable
fun AllItemsZone(
    modifier: Modifier,
    allApps: Resource<List<AppInfo>>,
    onAppClick: (id: Long, name: String) -> Unit = { _, _ -> },
    onRetryClick: () -> Unit = {},
) {
    when {
        allApps.isLoading() -> Loading(modifier)
        allApps is Resource.Success -> Success(modifier, allApps.data, onAppClick)
        allApps is Resource.Failure -> Error(modifier, onRetryClick)
    }
}

@Composable
private fun Success(modifier: Modifier, allApps: List<AppInfo>, onAppClick: (id: Long, name: String) -> Unit) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(allApps) { item ->
            ItemCard(
                AppItem(
                    item.id,
                    item.name.orEmpty(),
                    item.graphic.orEmpty(),
                    R.drawable.ic_star,
                    item.rating.orEmpty()
                ),
                onAppClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previvewAllItemsZone() {
    AllItemsZone(Modifier, Resource.Loading(emptyList()))
}
