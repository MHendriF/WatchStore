package com.mhendrif.watchstore.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhendrif.watchstore.R
import com.mhendrif.watchstore.model.Watch
import com.mhendrif.watchstore.ui.theme.BluePrimary
import com.mhendrif.watchstore.ui.theme.Gray

@Composable
fun WatchCard(
    modifier: Modifier = Modifier, watch: Watch
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        tonalElevation = 10.dp,
        shadowElevation = 0.75.dp,
        shape = RoundedCornerShape(14.dp),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = watch.image),
                contentDescription = "Watch Image"
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = watch.name,
                fontFamily = FontFamily(Font(R.font.raleway_semibold)),
                fontSize = 16.sp,
                color = BluePrimary
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = watch.type,
                fontFamily = FontFamily(Font(R.font.raleway_medium)),
                fontSize = 16.sp,
                color = Gray
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Rp. ${watch.price}",
                fontFamily = FontFamily(Font(R.font.raleway_medium)),
                color = BluePrimary
            )
        }
    }
}

@Preview
@Composable
private fun WatchCardPreview() {
    WatchCard(watch = Watch(
        name = "Apple Watch Series 6",
        type = "Sport",
        price = 3000000,
        image = R.drawable.watch1
    ))
}