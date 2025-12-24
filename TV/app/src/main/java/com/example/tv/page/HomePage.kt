package com.example.tv.page

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tv.R


@Composable
fun HomePage() {
    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding()
    }
    //第一行
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        // 添加占位
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(top = statusBarHeight))
        Row(
            modifier = Modifier
                .fillMaxHeight(0.07f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //标题
            Text(
                text = "TvBoxTvBoxTvBoxTvBoxTvBoxTvBoxTvBoxTvBoxTvBox",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(0.3f),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                ImageTextButton("搜索", R.drawable.icon_search)
                ImageTextButton("历史", R.drawable.icon_history)
                ImageTextButton("设置", R.drawable.icon_setting)
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {

        }
        Row {

        }
    }

}

@Composable
fun ImageTextButton(text: String, imageId: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 20.dp)
l
    ){
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "菜单",
            modifier = Modifier
                .width(32.dp)   // 设置固定宽度
                .height(32.dp)  // 设置固定高度
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 5.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            maxLines = 1,
        )
    }
}




