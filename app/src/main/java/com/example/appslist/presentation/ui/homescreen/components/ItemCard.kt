package com.example.appslist.presentation.ui.homescreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appslist.model.AppItem
import com.example.appslist.R
import com.example.appslist.ui.theme.Typography
import com.example.appslist.ui.theme.itemCardHeight
import com.example.appslist.ui.theme.itemCardWidth
import com.example.appslist.ui.theme.marginNormal
import com.example.appslist.ui.theme.marginSmall
import com.example.appslist.ui.theme.marginxSmall
import com.example.appslist.ui.theme.marginxxSmall

@Composable
fun ItemCard(item: AppItem, onAppClick: (id: Long, name: String) -> Unit) {
    Card(
        onClick = { onAppClick(item.id, item.name) },
        modifier = Modifier
            .height(itemCardHeight)
            .width(itemCardWidth)
            .padding(end = marginNormal)
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(marginSmall)),
        shape = RoundedCornerShape(marginSmall),
        elevation = CardDefaults.cardElevation(marginxxSmall),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .align(Alignment.TopStart)
                    .padding(marginSmall)
                    .clip(RoundedCornerShape(marginxSmall)),
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                error = painterResource(R.drawable.ic_placeholder),
                placeholder = painterResource(R.drawable.ic_placeholder),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(marginSmall)
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(marginxxSmall),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
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
                        style = Typography.labelSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun previewItemCard() {
    ItemCard(
        item = AppItem(
            1,
            "Test",
            "https://pool.img.aptoide.com/catappult/1406ca2b9502fdccb366724e2f5b20e0_fgraphic.png",
            R.drawable.ic_star,
            "2.2"
        )
    ) { _, _ ->

    }
}