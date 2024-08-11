package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appslist.model.AppItem
import com.example.appslist.R
import com.example.appslist.ui.theme.Typography

@Composable
fun HighLightedCard(item: AppItem) {
    Card(
        modifier = Modifier.width(300.dp).fillMaxHeight().padding(end = 16.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(),
                // Adjust color filter as needed
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = item.name,
                    style = Typography.titleMedium
                )

                Row {
                    Icon(
                        modifier = Modifier.padding(end = 4.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )

                    Text(
                        text = item.name,
                        modifier = Modifier.padding(top = 4.dp),
                        style = Typography.labelSmall
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun previewHighLightedCard() {
    HighLightedCard(
        item = AppItem(
            "Test",
            "https://pool.img.aptoide.com/catappult/1406ca2b9502fdccb366724e2f5b20e0_fgraphic.png",
            R.drawable.ic_star,
            2.2f
        )
    )
}