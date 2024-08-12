package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appslist.R
import com.example.appslist.model.AppItem
import com.example.shareddata.model.appsList.AppInfo

@Composable
fun HighlightedZone(modifier: Modifier, editorsChoiceItems: List<AppInfo>, onAppClick: (id: Long) -> Unit) {
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
    HighlightedZone(Modifier, listOf(AppInfo(1, "ola"))) {}
}

