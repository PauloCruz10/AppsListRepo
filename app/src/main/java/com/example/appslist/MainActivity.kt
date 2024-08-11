package com.example.appslist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.appslist.presentation.ui.homescreen.components.Body
import com.example.appslist.presentation.ui.homescreen.components.TopBar
import com.example.appslist.ui.theme.AppListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White,
                    topBar = {
                        TopBar("WallApps",
                            onIconAction = {
                                Toast.makeText(this, "Not yet implemented", Toast.LENGTH_SHORT).show()
                            })
                    }) { innerPadding ->

                    Body(Modifier.padding(innerPadding), "Highlighted", R.drawable.ic_account, listOf("ola", "batatas", "couves"), listOf("cenas", "dude", "mano"))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val context = LocalContext.current
    AppListTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar("WallApps",
                    onIconAction = {
                        Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                    })
            }) { innerPadding ->

            Body(Modifier.padding(innerPadding), "Highlighted", R.drawable.ic_account, listOf("ola", "batatas", "couves"), listOf("cenas", "dude", "mano"))
        }
    }
}