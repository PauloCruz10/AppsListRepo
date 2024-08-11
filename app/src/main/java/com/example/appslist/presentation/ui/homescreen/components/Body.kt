package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appslist.R

@Composable
fun Body(modifier: Modifier, title: String, icon: Int, editorsChoice: List<String>, allItems: List<String>) {
    Column(modifier.fillMaxSize()) {
        // Editors Choice Zone
        Box(Modifier.fillMaxSize().weight(0.6f).padding(16.dp)) {
            HighlightedZone(title, icon, editorsChoice)
        }

        // Spacer to separate sections
        Spacer(Modifier.height(40.dp))

        Box(Modifier.fillMaxSize().weight(0.4f).padding(start = 16.dp)) {
            AllItemsZone(title, icon, editorsChoice)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previvewBody() {
    Body(Modifier, "Highlighted", R.drawable.ic_account, listOf("Test1", "Test2", "Test3"), listOf("Test4", "Test5", "Test6"))
}

