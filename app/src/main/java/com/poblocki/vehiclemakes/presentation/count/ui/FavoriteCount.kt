package com.poblocki.vehiclemakes.presentation.count.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poblocki.vehiclemakes.R

@Composable
fun FavoriteCount(count: Int) {
    Icon(
        painter = painterResource(id = R.drawable.favorite),
        contentDescription = null
    )
    if (count > 0) {
        val resources = LocalContext.current.resources
        Text(
            text = resources.getQuantityString(R.plurals.favorites, count, count),
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            fontSize = 36.sp
        )
    } else {
        Text(
            text = "No favorites",
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            fontSize = 36.sp
        )
    }
}
