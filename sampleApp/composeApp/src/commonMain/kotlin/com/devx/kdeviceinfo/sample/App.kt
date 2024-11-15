package com.devx.kdeviceinfo.sample

import androidx.compose.foundation.layout.*
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
import com.devx.kdeviceinfo.model.desktop.DesktopInfo
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
            } else if (deviceInfoXState.isIos) {
                ShowIosDeviceInfo(iosInfo = deviceInfoXState.iosInfo)
            } else if(deviceInfoXState.isDesktop) {
                ShowDesktopDeviceInfo(desktopInfo = deviceInfoXState.desktopInfo)
            } else {
                Text(text = "Welcome to Web App")
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
        Text(text = "Debug App : ${androidInfo.isDebug}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Device Info
        Text(text = "Device Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Device : ${androidInfo.device}")
        Text(text = "Android ID : ${androidInfo.androidId}")
        Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
        Text(text = "Release : ${androidInfo.version.release}")
        Text(text = "CodeName : ${androidInfo.version.codeName}")
        Text(text = "Board : ${androidInfo.board}")
        Text(text = "IsPhysicalDevice : ${androidInfo.isPhysicalDevice}")
        Text(text = "Manufacturer : ${androidInfo.manufacturer}")
        Text(text = "Model : ${androidInfo.model}")
        Text(text = "Device Orientation : ${androidInfo.deviceOrientation.getDeviceOrientation()}")
        Text(text = "IsPortrait : ${androidInfo.deviceOrientation.isPortrait}")
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
        Text(text = "Debug App : ${iosInfo.isDebug}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Device Info
        Text(text = "Device Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Name : ${iosInfo.name}")
        Text(text = "Model : ${iosInfo.model}")
        Text(text = "SystemName : ${iosInfo.systemName}")
        Text(text = "SystemVersion : ${iosInfo.systemVersion}")
        Text(text = "LocalizedModel : ${iosInfo.localizedModel}")
        Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        Text(text = "Device Orientation : ${iosInfo.deviceOrientation.getDeviceOrientation()}")
        Text(text = "IsPortrait : ${iosInfo.deviceOrientation.isPortrait}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

        // Locale Info
        Text(text = "Locale Info", style = TextStyle(fontSize = 20.sp))
        Text(text = "Language Code : ${iosInfo.locale.languageCode}")
        Text(text = "Region : ${iosInfo.locale.region}")
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))
    }
}

@Composable
private fun ShowDesktopDeviceInfo(desktopInfo: DesktopInfo) {
    val verticalScrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = verticalScrollState)
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Operating System Info (only easy to print info)
            // NOT PRINTED BUT AVAILABLE
            // - FileSystem
            // - InternetProtocolStats
            // - currentProcess: OSProcess
            // - currentThread: OSThread
            // - networkParams: NetworkParams
            // - services: List<OSService>
            // - sessions: List<OSSession>
            val operatingSystem = desktopInfo.operatingSystem
            Text(text = "Operating System Info", style = TextStyle(fontSize = 20.sp))
            Text(text = "Family : ${operatingSystem.family}")
            Text(text = "Manufacturer : ${operatingSystem.manufacturer}")
            val versionInfo = operatingSystem.versionInfo
            Text(text = "Version : ${versionInfo.version}")
            Text(text = "Codename : ${versionInfo.codeName}")
            Text(text = "Build number : ${versionInfo.buildNumber}")
            Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))

            // General info
            Text(text = "General Info", style = TextStyle(fontSize = 20.sp))
            Text(text = "Process id : ${operatingSystem.processId}")
            Text(text = "Process count : ${operatingSystem.processCount}")
            Text(text = "Thread id : ${operatingSystem.threadId}")
            Text(text = "Thread count : ${operatingSystem.threadCount}")
            Text(text = "Bitness : ${operatingSystem.bitness}")
            Text(text = "System uptime : ${operatingSystem.systemUptime}")
            Text(text = "System boot time : ${operatingSystem.systemBootTime}")
            Text(text = "Is elevated : ${operatingSystem.isElevated}")
            Spacer(modifier = Modifier.fillMaxWidth().height(height = 20.dp))
        }
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Hardware Info (few example)
            // Info available
            // - Computer system
            // - Central processor
            // - Global memory
            // - Sensors
            // - Power sources
            // - Disk stores
            // - Logical volume groups
            // - Network IFs
            // - Displays
            // - Sensors
            // - Sound cards
            // - Graphics cards
            val hardware = desktopInfo.hardware
            Text(text = "Hardware Info", style = TextStyle(fontSize = 20.sp))
            Text(text = "Cpu temperature : ${hardware.sensors.cpuTemperature}")
            Text(text = "Cpu max freq: ${hardware.centralProcessor.maxFreq} hz")
            Text(text = "Graphics cards number: ${hardware.graphicsCards.size}")
            hardware.graphicsCards.forEach { card ->
                Text(text = "Graphics cards name: ${card.name}")
            }
            Text(text = "Ram size: ${hardware.globalMemory.total} bytes")
        }
    }
}