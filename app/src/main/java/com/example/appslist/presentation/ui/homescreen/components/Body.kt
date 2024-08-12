package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appslist.R
import com.example.appslist.ui.theme.marginNormal
import com.example.shareddata.model.appsList.AppInfo

@Composable
fun Body(modifier: Modifier, title: String, icon: Int, editorsChoice: List<AppInfo>, allItems: List<AppInfo>, onAppClick: (id: Long) -> Unit) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = marginNormal)
    ) {
        HeaderZone(Modifier.weight(0.1f), title, icon)
        // Editors Choice Zone
        HighlightedZone(Modifier.weight(0.3f), editorsChoice, onAppClick)

        HeaderZone(Modifier.weight(0.1f), title, icon)

        AllItemsZone(Modifier.weight(0.4f), allItems, onAppClick)
    }
}

@Preview(showBackground = true)
@Composable
fun previvewBody() {
    Body(
        Modifier,
        "Highlighted",
        R.drawable.ic_account,
        listOf(AppInfo(1, "test")),
        listOf(AppInfo(2, "test1")),
    ) {}
}

