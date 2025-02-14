package com.mhendrif.watchstore.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mhendrif.watchstore.R
import com.mhendrif.watchstore.data.itemsViewPager
import com.mhendrif.watchstore.data.itemsWatch
import com.mhendrif.watchstore.ui.component.SearchBarView
import com.mhendrif.watchstore.ui.component.ViewPagerItem
import com.mhendrif.watchstore.ui.component.WatchCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val pagerState = rememberPagerState{ itemsViewPager.size }
    Surface(modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.padding(top = 32.dp))
            SearchBarView()
            Spacer(modifier = Modifier.padding(top = 32.dp))
            Text(
                text = "Find your suitable \nWatch now.",
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.raleway_bold))
            )
            HorizontalPager(
                modifier = Modifier.padding(top = 36.dp),
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

            LazyVerticalGrid(
                contentPadding = PaddingValues(bottom = 40.dp, top = 22.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                columns = GridCells.Fixed(2)) {
                items(items = itemsWatch) { watch ->
                    WatchCard(watch = watch, onClick = { navHostController.navigate("detail")})
                }
            }


        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navHostController = rememberNavController())
}