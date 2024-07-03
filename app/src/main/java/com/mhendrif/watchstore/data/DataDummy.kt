package com.mhendrif.watchstore.data

import com.mhendrif.watchstore.R
import com.mhendrif.watchstore.model.CategoryViewPager
import com.mhendrif.watchstore.model.Watch

val itemsViewPager = listOf(
    CategoryViewPager(name = "Search Product"),
    CategoryViewPager(name = "Brand"),
)

val itemsWatch = listOf(
    Watch(
        name = "Apple Watch",
        type = "Series 6",
        price = 3000000,
        image = R.drawable.watch1
    ),
    Watch(
        name = "Apple Watch",
        type = "Series 7",
        price = 3000000,
        image = R.drawable.watch2
    ),
    Watch(
        name = "Apple Watch",
        type = "Series 8",
        price = 3000000,
        image = R.drawable.watch3
    ),
    Watch(
        name = "Apple Watch",
        type = "Series 9",
        price = 3000000,
        image = R.drawable.watch4
    )
)