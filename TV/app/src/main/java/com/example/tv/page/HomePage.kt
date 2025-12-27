package com.example.tv.page

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tv.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tv.ui.theme.Border
import com.example.tv.ui.theme.SettingSelectText


@Composable
fun HomePage(navController: NavHostController) {
    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding()
    }
    //第一行
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0x11333333))
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
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF333333)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                ImageTextButton("搜索", R.drawable.icon_search){
                    navController.navigate(Router.ROUTER_SEARCH.name)
                }
                ImageTextButton("历史", R.drawable.icon_history){
                    navController.navigate(Router.ROUTER_HISTORY.name)
                }
                ImageTextButton("设置", R.drawable.icon_setting){
                    navController.navigate(Router.ROUTER_SETTING.name)
                }
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
fun ImageTextButton(text: String, imageId: Int,click: () -> Unit = {}) {
    val interactionSource = remember { MutableInteractionSource() }
    val  isPressed by interactionSource.collectIsPressedAsState()
    Log.d("ImageTextButton", "ImageTextButton: $isPressed")
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.run {
            padding(start = 20.dp)
                .clickable(
                    onClick = click,
                    indication = null,
                    interactionSource = interactionSource
                )
        }
    ){
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "菜单",
            modifier = Modifier
                .width(32.dp)   // 设置固定宽度
                .height(32.dp)  // 设置固定高度
        )
    }
}




