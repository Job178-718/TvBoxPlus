package com.example.tv

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tv.ui.page.HomePage
import com.example.tv.ui.page.Router
import com.example.tv.ui.page.settings.SettingsPage
import com.example.tv.viewmodel.SettingsViewModel

class MainActivity : ComponentActivity() {

    private val settingsModel: SettingsViewModel by viewModels<SettingsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationController(settingsModel)
        }
    }
}


@Composable
fun NavigationController(settingsModel: SettingsViewModel) {
    val navController = rememberNavController()
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    // 添加返回按键监听
    backDispatcher?.addCallback {
        if (navController.currentDestination?.route == Router.ROUTER_HOME.name) {
            // 在首页时的处理逻辑
            Log.d("NavigationController", "首页返回按键")
            //两次返回退出应用
        } else {
            navController.popBackStack()
        }
    }
    NavHost(
        navController = navController,
        startDestination = Router.ROUTER_HOME.name,
        enterTransition = {  scaleIn(initialScale = 0.8f) + fadeIn(initialAlpha = 0.3f) },
        exitTransition = { scaleOut(targetScale = 0.8f) + fadeOut(targetAlpha = 0.3f) }
    ) {
        composable(Router.ROUTER_HOME.name) {
            HomePage(navController)
        }

        composable(Router.ROUTER_SEARCH.name) {
            Log.d("NavigationController", "NavigationController:ROUTER_SEARCH ")
        }

        composable(Router.ROUTER_HISTORY.name) {
            Log.d("NavigationController", "NavigationController: ROUTER_HISTORY")
        }

        composable(Router.ROUTER_SETTING.name) {
            Log.d("NavigationController", "NavigationController: ROUTER_SETTING")
            SettingsPage(settingsModel)
        }
    }

}




