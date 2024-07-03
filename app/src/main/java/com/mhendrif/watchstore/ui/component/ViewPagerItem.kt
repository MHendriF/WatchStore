package com.mhendrif.watchstore.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhendrif.watchstore.R
import com.mhendrif.watchstore.model.CategoryViewPager
import com.mhendrif.watchstore.ui.theme.BluePrimary
import com.mhendrif.watchstore.ui.theme.ColorInActivePager

@Composable
fun ViewPagerItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    item: CategoryViewPager
) {
    Column(modifier = Modifier) {
        Text(
            text = item.name,
            color = if(isSelected) BluePrimary else ColorInActivePager,
            fontFamily = FontFamily(Font(R.font.raleway_semibold)),
            fontSize = 16.sp
        )
        
        Spacer(modifier = Modifier.padding(top = 6.dp))

        if (isSelected) {
            HorizontalDivider(
                modifier = Modifier.padding(top = 6.dp),
                thickness = 1.dp,
                color = BluePrimary
            )
        }
    }
}