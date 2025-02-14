package com.mhendrif.watchstore.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhendrif.watchstore.R
import com.mhendrif.watchstore.data.itemsViewPager
import com.mhendrif.watchstore.model.CategoryViewPager
import com.mhendrif.watchstore.ui.component.ViewPagerItem
import com.mhendrif.watchstore.ui.theme.BluePrimary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
    val itemsViewPager = listOf(
       CategoryViewPager(name = "Details"),
        CategoryViewPager(name = "Reviews"),
        CategoryViewPager(name = "Specifications"),
    )
    val pagerState = rememberPagerState{ itemsViewPager.size }
    val buttonGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF1A73E8),
            Color(0xFF42A5F5)
        )
    )

    Surface(modifier = modifier) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
        ) {
            TopBar(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp), onClickBack = { onClickBack() })
            Image(modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .padding(top = 16.dp),
                painter = painterResource(id = R.drawable.watch1), contentDescription = "Image detail"
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Apple Watch Series 6",
                        fontFamily = FontFamily(Font(R.font.raleway_semibold)),
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = "With solo loop",
                        fontFamily = FontFamily(Font(R.font.raleway_light)),
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = "Rp 3.000.000",
                    fontFamily = FontFamily(Font(R.font.raleway_bold)),
                    fontSize = 18.sp,
                    color = BluePrimary
                )
            }

            HorizontalPager(
                modifier = Modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp),
                state = pagerState
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(itemsViewPager) { categoryViewPager ->
                        ViewPagerItem(
                            isSelected = pagerState.currentPage == itemsViewPager.indexOf(categoryViewPager),
                            item = categoryViewPager)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "This is detail product",
                fontFamily = FontFamily(Font(R.font.raleway_light)),
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .background(brush = buttonGradientBrush, shape = RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Add to Cart", fontFamily = FontFamily(Font(R.font.raleway_semibold)))

            }


        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(modifier = Modifier.clickable { onClickBack() }, imageVector = Icons.Default.ArrowBack, contentDescription = "Icon Back")
        Image(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Icon Favorite")
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(onClickBack = { /*TODO*/ })
}