package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appslist.R

@Composable
fun Body(modifier: Modifier, title: String, icon: Int, editorsChoice: List<String>, allItems: List<String>) {
    Column(modifier.fillMaxSize().padding(start = 16.dp)) {
        HeaderZone(Modifier.weight(0.1f), title, icon)
        // Editors Choice Zone
        HighlightedZone(Modifier.weight(0.3f), editorsChoice)

        HeaderZone(Modifier.weight(0.1f), title, icon)

        AllItemsZone(Modifier.weight(0.4f), allItems)
    }
}

@Preview(showBackground = true)
@Composable
fun previvewBody() {
    Body(Modifier, "Highlighted", R.drawable.ic_account, listOf("Test1", "Test2", "Test3"), listOf("Test4", "Test5", "Test6"))
}

