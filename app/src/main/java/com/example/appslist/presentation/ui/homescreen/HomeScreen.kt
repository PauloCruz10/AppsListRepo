package com.example.appslist.presentation.ui.homescreen

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appslist.R
import com.example.appslist.presentation.ui.homescreen.components.Body
import com.example.appslist.presentation.ui.homescreen.components.TopBar

@Composable
fun HomeScreen( homeViewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopBar("WallApps",
                onIconAction = {
                    Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                })
        }) { innerPadding ->

        Body(Modifier.padding(innerPadding), "Highlighted", R.drawable.ic_account, listOf("ola", "batatas", "couves"), listOf("cenas", "dude", "mano"))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}