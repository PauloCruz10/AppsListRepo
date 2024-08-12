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
import com.example.appslist.ui.theme.marginNormal
import com.example.appslist.ui.theme.marginSmall
import com.example.appslist.ui.theme.marginxSmall
import com.example.appslist.ui.theme.marginxxSmall

@Composable
fun HighLightedCard(item: AppItem, onAppClick: (id: Long) -> Unit) {
    Card(
        onClick = { onAppClick(item.id) },
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .padding(end = marginNormal),
        shape = RoundedCornerShape(marginxSmall),
        elevation = CardDefaults.cardElevation(marginxxSmall),
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
                    .padding(start = marginSmall, bottom = marginSmall)
            ) {
                Text(
                    text = item.name,
                    style = Typography.titleMedium
                )

                Row {
                    Icon(
                        modifier = Modifier.padding(end = marginxxSmall),
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )

                    Text(
                        text = item.name,
                        modifier = Modifier.padding(top = marginxxSmall),
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
            1,
            "Test",
            "https://pool.img.aptoide.com/catappult/1406ca2b9502fdccb366724e2f5b20e0_fgraphic.png",
            R.drawable.ic_star,
            "2.2"
        )
    ) {}
}