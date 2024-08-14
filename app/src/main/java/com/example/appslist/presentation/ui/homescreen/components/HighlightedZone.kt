package com.example.appslist.presentation.ui.homescreen.components

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
fun HighlightedZone(
    modifier: Modifier,
    editorsChoiceItems: Resource<List<AppInfo>>,
    onAppClick: (id: Long, name: String) -> Unit = {_,_ -> },
    onRetryClick: () -> Unit = {},
) {
    when {
        editorsChoiceItems.isLoading() -> Loading(modifier)
        editorsChoiceItems is Resource.Success -> Success(modifier = modifier, editorsChoiceItems = editorsChoiceItems.data, onAppClick)
        editorsChoiceItems is Resource.Failure -> Error(modifier, onRetryClick)
    }
}

@Composable
private fun Success(modifier: Modifier, editorsChoiceItems: List<AppInfo>, onAppClick: (id: Long, name: String) -> Unit) {
    LazyRow(modifier = modifier) {
        items(editorsChoiceItems) { item ->
            HighLightedCard(
                AppItem(
                    item.id ?: -1,
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
fun previvewHighlightedZone() {
    HighlightedZone(Modifier, Resource.Success(listOf(AppInfo(1, "Name"))))
}

