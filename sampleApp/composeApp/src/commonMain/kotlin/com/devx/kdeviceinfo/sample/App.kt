package com.devx.kdeviceinfo.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devx.kdeviceinfo.DeviceInfoXState
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.rememberDeviceInfoXState
import com.devx.kdeviceinfo.sample.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() = AppTheme {

    val deviceInfoXState: DeviceInfoXState = rememberDeviceInfoXState()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "KDeviceInfo Sample App") })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(horizontal = 16.dp)
        ) {
            if (deviceInfoXState.isAndroid) {
                ShowAndroidDeviceInfo(androidInfo = deviceInfoXState.androidInfo)
            } else {
                ShowIosDeviceInfo(iosInfo = deviceInfoXState.iosInfo)
            }
        }
    }
}

@Composable
private fun ShowAndroidDeviceInfo(androidInfo: AndroidInfo) {
    val verticalScrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {
        // App Info
        Text(text = "App Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "App Name : ${androidInfo.appName}")
        Text(text = "Version Code : ${androidInfo.versionCode}")
        Text(text = "Version Name : ${androidInfo.versionName}")
        Text(text = "Package Name : ${androidInfo.packageName}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Device Info
        Text(text = "Device Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Device : ${androidInfo.device}")
        Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
        Text(text = "Release : ${androidInfo.version.release}")
        Text(text = "CodeName : ${androidInfo.version.codeName}")
        Text(text = "Board : ${androidInfo.board}")
        Text(text = "IsPhysicalDevice : ${androidInfo.isPhysicalDevice}")
        Text(text = "Manufacturer : ${androidInfo.manufacturer}")
        Text(text = "Model : ${androidInfo.model}")
        Text(text = "Orientation : ${androidInfo.deviceOrientation.getDeviceOrientation()}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Locale
        Text(text = "Locale Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Language Code : ${androidInfo.locale.languageCode}")
        Text(text = "Region : ${androidInfo.locale.region}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))
    }
}

@Composable
private fun ShowIosDeviceInfo(iosInfo: IosInfo) {
    val verticalScrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {

        // App Info
        Text(text = "App Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "App Name : ${iosInfo.appName}")
        Text(text = "App Version : ${iosInfo.appVersion}")
        Text(text = "App Short Version : ${iosInfo.appShortVersion}")
        Text(text = "Bundle Id : ${iosInfo.bundleId}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Device Info
        Text(text = "Device Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Name : ${iosInfo.name}")
        Text(text = "Model : ${iosInfo.model}")
        Text(text = "SystemName : ${iosInfo.systemName}")
        Text(text = "SystemVersion : ${iosInfo.systemVersion}")
        Text(text = "LocalizedModel : ${iosInfo.localizedModel}")
        Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        Text(text = "Orientation : ${iosInfo.deviceOrientation.getDeviceOrientation()}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Locale Info
        Text(text = "Locale Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Language Code : ${iosInfo.locale.languageCode}")
        Text(text = "Region : ${iosInfo.locale.region}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))
    }
}
