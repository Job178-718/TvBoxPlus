package com.example.tv.ui.page.settings

import CustomToast
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tv.osc.util.HawkConfig
import com.example.tv.ui.theme.Border
import com.example.tv.ui.theme.SettingBackGround
import com.example.tv.ui.theme.SettingSelectText
import com.example.tv.ui.theme.Solid
import com.example.tv.viewmodel.SettingsViewModel
import com.orhanobut.hawk.Hawk

@Composable
fun SettingsPage(settingsModel: SettingsViewModel) {
    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding()
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                top = statusBarHeight
            )
    ) {
        LeftTabButton(settingsModel)
        MainContent(settingsModel)
    }
}

@Composable
fun MainContent(settingsModel: SettingsViewModel) {
    val pager = settingsModel.selectContextFlow.collectAsState("配置").value
    SideEffect {
        Log.d("MainContent", "MainContent:$pager ")
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(1f)
            .padding(end = 20.dp, bottom = 20.dp)
            .background(
                color = Solid, shape = RoundedCornerShape(10.dp)
            )
            .border(
                border = BorderStroke(1.dp, Border),
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        when (pager) {
            "首页" -> {

            }
            "配置" -> {
                ConfigurationPager(pager,settingsModel)
            }
            "播放器" -> {

            }
            "系统" -> {

            }
            "关于" -> {
                AboutPage(pager)
            }
         }
    }
}

@Composable
fun ConfigurationPager(pager: String,settingsModel: SettingsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                start = 20.dp,
                top = 10.dp,
                end = 20.dp,
            )
    ) {
//        Text(
//            text = pager,
//            fontSize = 20.sp,
//        )
        SourceEditView("视频源", HawkConfig.API_URL)
        SourceEditView("直播源","")
    }
}

@Composable
fun SourceEditView(text: String,map:String){
    var editText by remember{ mutableStateOf(Hawk.get<String>(map)?:"")}
    Column(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .padding(top = 5.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth(1f),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,//SettingBackGround,
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    border = BorderStroke(0.dp, Border),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(
                        color = Solid,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        border = BorderStroke(1.dp, Border),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                ,
                value = editText,
                onValueChange = {
                    editText = it

                }
            )
            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )
            Text(
                text = "保存",
                modifier = Modifier
                    .background(
                        color = Solid,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        border = BorderStroke(1.dp, Border),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                    .clickable {
                        Hawk.put(map,editText)
                    }

            )
        }
    }
}


@Composable
fun AboutPage(pager: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Text(text = pager,fontSize = 20.sp)
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = "关于",
            fontSize = 18.sp
        )
    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun LeftTabButton(settingsModel: SettingsViewModel) {
    val titles = mutableSetOf<String>("首页","配置","播放器","系统", "关于")
    val selectedIndex = remember { mutableIntStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.4f)
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .width(5.dp)
                    .background(Border),
                text = "",
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = "设置",
                fontSize = 24.sp,
                color = Color(0xFF333333)
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 10.dp)
                .background(
                    color = Solid, shape = RoundedCornerShape(10.dp)
                )
                .border(
                    border = BorderStroke(1.dp, Border),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            items(titles.size) { index ->
                Text(
                    text = titles.elementAt(index),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .background(
                            color = if (index == selectedIndex.value) SettingSelectText else Solid,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .border(
                            border = BorderStroke(1.dp, Border),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp)
                        .clickable(
                            onClick = {
                                selectedIndex.value = index
                                settingsModel.updateSelectContext(titles.elementAt(index))
                            },
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ),
                    fontSize = 20.sp
                )
            }
        }
    }
}
