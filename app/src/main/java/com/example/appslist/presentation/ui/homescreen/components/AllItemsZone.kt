package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appslist.R
import com.example.appslist.model.AppItem

@Composable
fun AllItemsZone(title: String, icon: Int, editorsChoiceItems: List<String>) {
    Column {
        HeaderZone(title, icon)
        // Spacer to separate sections
        Spacer(Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
}

@Preview(showBackground = true)
@Composable
fun previvewAllItemsZone() {
    AllItemsZone("Highlighted", R.drawable.ic_account, listOf("Test1", "Test2", "Test3", "Test4", "Test5", "Test6"))
}
