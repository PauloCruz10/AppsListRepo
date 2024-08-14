package com.example.appslist.presentation.ui.homescreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.appslist.R
import com.example.appslist.presentation.ui.homescreen.components.AllItemsZone
import com.example.appslist.presentation.ui.homescreen.components.HeaderZone
import com.example.appslist.presentation.ui.homescreen.components.HighlightedZone
import com.example.appslist.presentation.ui.homescreen.components.TopBar
import com.example.appslist.ui.theme.marginNormal

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), onAppSelected: (id: Long, name: String) -> Unit) {
    val context = LocalContext.current
    val appsList = homeViewModel.listAppApps.collectAsStateWithLifecycle()
    val highlighted = homeViewModel.highlights.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopBar("WallApps",
                onIconAction = {
                    Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                })
        }) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(start = marginNormal)
        ) {
            Log.d("aqui", "mano")
            HeaderZone(Modifier.weight(0.1f), "Highlighted", R.drawable.ic_star)
            // Editors Choice Zone
            HighlightedZone(Modifier.weight(0.3f), highlighted.value, onAppSelected) {
                homeViewModel.loadApps()
            }

            HeaderZone(Modifier.weight(0.1f), "All Apps", R.drawable.ic_more)

            AllItemsZone(Modifier.weight(0.4f), appsList.value, onAppSelected) {
                homeViewModel.loadApps()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen() { _, _ -> }
}