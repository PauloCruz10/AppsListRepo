package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appslist.R
import com.example.appslist.model.AppItem

@Composable
fun AllItemsZone(modifier: Modifier, editorsChoiceItems: List<String>) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(editorsChoiceItems) { item ->
            ItemCard(
                AppItem(
                    "Test",
                    "https://pool.img.aptoide.com/sf49ers/0a47ec8d1bd84f964e34f5bf93df58ca_fgraphic.png",
                    R.drawable.ic_star,
                    2.2f
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previvewAllItemsZone() {
    AllItemsZone(Modifier, listOf("Test1", "Test2", "Test3", "Test4", "Test5", "Test6"))
}
