package com.devx.kdeviceinfo.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devx.kdeviceinfo.DeviceInfoX
import com.devx.kdeviceinfo.model.android.AndroidInfo
import com.devx.kdeviceinfo.model.ios.IosInfo
import com.devx.kdeviceinfo.rememberDeviceInfoXState
import com.devx.kdeviceinfo.sample.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() = AppTheme {

    val deviceInfoXState: DeviceInfoX = rememberDeviceInfoXState()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "KDeviceInfo Sample App") })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .windowInsetsPadding(insets = WindowInsets.safeDrawing),
        ) {
            if (deviceInfoXState.isAndroid) {
                Text(deviceInfoXState.androidInfo.toString())
                ShowAndroidDeviceInfo(androidInfo = deviceInfoXState.androidInfo)
            } else {
                Text(deviceInfoXState.iosInfo.toString())
                ShowIosDeviceInfo(iosInfo = deviceInfoXState.iosInfo)
            }
        }
    }
}

@Composable
private fun ShowAndroidDeviceInfo(androidInfo: AndroidInfo) {
    val verticalScrollState = rememberScrollState()

    androidInfo.VERSION_CODES.LOLLIPOP
    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {
        Text(text = "Device : ${androidInfo.device}")
        Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
        Text(text = "BaseOs : ${androidInfo.version.baseOs}")
        Text(text = "Release : ${androidInfo.version.release}")
        Text(text = "SecurityPatch : ${androidInfo.version.securityPatch}")
        Text(text = "previewSdkInt : ${androidInfo.version.previewSdkInt}")
        Text(text = "ReleaseOrCodeName : ${androidInfo.version.releaseOrCodeName}")
        Text(text = "MediaPerformanceClass : ${androidInfo.version.mediaPerformanceClass}")
        Text(text = "Incremental : ${androidInfo.version.incremental}")
        Text(text = "ReleaseOrPreviewDisplay : ${androidInfo.version.releaseOrPreviewDisplay}")
        Text(text = "CodeName : ${androidInfo.version.codeName}")
        Text(text = "Board : ${androidInfo.board}")
        Text(text = "Bootloader : ${androidInfo.bootloader}")
        Text(text = "Display : ${androidInfo.display}")
        Text(text = "DisplayWidthInches : ${androidInfo.displayMetrics.widthInches}")
        Text(text = "DisplayHeightInches : ${androidInfo.displayMetrics.heightInches}")
        Text(text = "DisplayXDpi : ${androidInfo.displayMetrics.xDpi}")
        Text(text = "DisplayYDpi : ${androidInfo.displayMetrics.yDpi}")
        Text(text = "Fingerprint : ${androidInfo.fingerprint}")
        Text(text = "Hardware : ${androidInfo.hardware}")
        Text(text = "Host : ${androidInfo.host}")
        Text(text = "Id : ${androidInfo.id}")
        Text(text = "IsPhysicalDevice : ${androidInfo.isPhysicalDevice}")
        Text(text = "Manufacturer : ${androidInfo.manufacturer}")
        Text(text = "Model : ${androidInfo.model}")
        Text(text = "Product : ${androidInfo.product}")
//        Text(text = "SerialNumber : ${androidInfo.serialNumber}")
//        Text(text = "SystemFeatureList : ${androidInfo.systemFeatureList}")
        Text(text = "SupportedAbis : ${androidInfo.supportedAbis}")
        Text(text = "Supported32BitAbis : ${androidInfo.supported32BitAbis}")
        Text(text = "Supported64BitAbis : ${androidInfo.supported64BitAbis}")
    }
}

@Composable
private fun ShowIosDeviceInfo(iosInfo: IosInfo) {
    val verticalScrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {
        Text(text = "Name : ${iosInfo.name}")
        Text(text = "Model : ${iosInfo.model}")
        Text(text = "SystemName : ${iosInfo.systemName}")
        Text(text = "SystemVersion : ${iosInfo.systemVersion}")
        Text(text = "LocalizedModel : ${iosInfo.localizedModel}")
        Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        Text(text = "IdentifierForVendor : ${iosInfo.identifierForVendor}")
        Text(text = "IsMultitaskingSupported : ${iosInfo.isMultitaskingSupported}")
        Text(text = "IsGeneratingDeviceOrientationNotifications : ${iosInfo.isGeneratingDeviceOrientationNotifications}")
        Text(text = "DeviceOrientation : ${iosInfo.deviceOrientation.getDeviceOrientation()}")
    }
}
