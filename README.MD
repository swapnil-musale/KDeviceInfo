# KDeviceInfo

A Kotlin Multiplatform library to easily access device, OS, and environment information across **Android**, **iOS**, **Desktop (JVM)**, and **Web (WASM)** — all with a single unified API.

<p  align="center">
<a  href="https://github.com/swapnil-musale/KDeviceInfo"><img  src="https://img.shields.io/badge/Platform-Android-Blue?style=for-the-badge"  alt="Android"/></a>&nbsp; <a  href="https://github.com/swapnil-musale/KDeviceInfo"><img  src="https://img.shields.io/badge/Platform-Ios-Blue?style=for-the-badge"  alt="Ios"/></a>&nbsp; <a  href="https://github.com/swapnil-musale/KDeviceInfo"><img  src="https://img.shields.io/badge/Platform-Desktop-Blue?style=for-the-badge"  alt="Desktop"/></a>&nbsp; <a  href="https://github.com/swapnil-musale/KDeviceInfo"><img  src="https://img.shields.io/badge/Platform-Web-Blue?style=for-the-badge"  alt="Web"/></a>&nbsp; <a  href="https://search.maven.org/artifact/io.github.swapnil-musale/KDeviceInfo"><img  src="https://img.shields.io/maven-central/v/io.github.swapnil-musale/KDeviceInfo?style=for-the-badge"  alt="Maven Central"/></a>&nbsp; <a  href="https://github.com/swapnil-musale/KDeviceInfo/actions"><img  src="https://img.shields.io/github/actions/workflow/status/swapnil-musale/KDeviceInfo/build.yml?style=for-the-badge"  alt="CI Status"/></a>
</p>

---

# 🚀 Features

- 🌍 **Cross-Platform** — Android, iOS, Desktop (Windows, macOS, Linux), Web (WASM)
- 💬 **Unified API** — Use `DeviceInfoXState` everywhere
- ⚡ **Lightweight and Easy to Use**
- 🎯 **Kotlin Multiplatform First-Class Support**

---

# 📦 Installation

This library is available on mavenCentral. To use it in your project add following block of code
in ```settings.gradle.kts``` file if not available.

```kotlin
repositories { 
    ...
    mavenCentral()
}
```

### 1. Kotlin Multiplatform
Add the library dependency in ```shared``` module (```build.gradle.kts```)

```kotlin
commonMain.dependencies {
    ...
    api or implementation("io.github.swapnil-musale:KDeviceInfo:0.0.7")
}
```

### 2. Compose Multiplatform

Add the library dependency in ```composeApp``` module (```build.gradle.kts```)

```kotlin
commonMain.dependencies {
    ...
    implementation("io.github.swapnil-musale:KDeviceInfo:0.0.7")
}
```
---

# 🔥 Usage

Implementation of **KDeviceInfo** is pretty straightforward. Simply import the **DeviceInfoXState**
and start accessing device information in your Compose Multiplatform project.

```kotlin
@Composable
fun DeviceInfoExample() {

    val deviceInfoXState: DeviceInfoXState = rememberDeviceInfoXState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        if (deviceInfoXState.isAndroid) {
            // Android
            val androidInfo = deviceInfoXState.androidInfo
            Text(text = "App Name : ${androidInfo.appName}")
            Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
            Text(text = "PackageName : ${androidInfo.packageName}")
        } else if(deviceInfoXState.isIos) {
            // iOS
            val iosInfo = deviceInfoXState.iosInfo
            Text(text = "SystemName : ${iosInfo.systemName}")
            Text(text = "SystemVersion : ${iosInfo.systemVersion}")
            Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        } else if(deviceInfoXState.isDesktop) {
            // Desktop
            val desktopInfo = deviceInfoXState.desktopInfo
            val operatingSystem = desktopInfo.operatingSystem
            Text(text = "Operating System Info", style = TextStyle(fontSize = 20.sp))
            Text(text = "Family : ${operatingSystem.family}")
            Text(text = "Manufacturer : ${operatingSystem.manufacturer}")
        } else if(deviceInfoXState.isWeb) {
            // Web
            val webInfo = deviceInfoXState.webInfo
            val browser = webInfo.browser
            Text(text = "Browser Info", style = TextStyle(fontSize = 20.sp))
            Text(text = "Name : ${browser.name}")
            Text(text = "Version : ${browser.version}")
        }
    }
}
```

**OR** Use helper function to access device information

```kotlin
@Composable
fun DeviceInfoExample() {
    Column(modifier = Modifier.fillMaxSize()) {
        OnPlatform(
            onAndroid = { androidInfo ->
                Text(text = "App Name : ${androidInfo.appName}")
                Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
                Text(text = "PackageName : ${androidInfo.packageName}")
            },
            onIos = { iosInfo ->
                Text(text = "SystemName : ${iosInfo.systemName}")
                Text(text = "SystemVersion : ${iosInfo.systemVersion}")
                Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
            },
            onDesktop = { desktopInfo ->
                Text(text = "SystemName : ${desktopInfo.operatingSystem.versionInfo.version}")
            },
            onWeb = { webInfo ->
                Text(text = "SystemName : ${webInfo.os.version}")
            }
        )
    }
}
```

To access the device details outside the Composable function you can make use of **DeviceInfoState** as below

```kotlin
class AppViewModel {

    private val deviceInfoXState: DeviceInfoXState = DeviceInfoXState()

    init {
        if (deviceInfoXState.isAndroid) {
            val androidInfo: AndroidInfo = deviceInfoXState.androidInfo
            println("DeviceInfoX - App Name : ${androidInfo.appName}")
        } else if (deviceInfoXState.isIos) {
            val iosInfo: IosInfo = deviceInfoXState.iosInfo
            println("DeviceInfoX - System Name : ${iosInfo.systemName}")
        } else if (deviceInfoXState.isDesktop) {
            val desktopInfo = deviceInfoXState.desktopInfo
            println("DeviceInfoX - System Name : ${desktopInfo.operatingSystem.versionInfo.version}")
        } else if (deviceInfoXState.isWeb) {
            val webInfo = deviceInfoXState.webInfo
            println("DeviceInfoX - System Name : ${webInfo.os.version}")
        }
    }
}
```

**OR** Use helper function to access device information

```kotlin
class AppViewModel {
    init {
        onPlatform(
            onAndroid = { androidInfo ->
                println("DeviceInfoX - App Name : ${androidInfo.appName}")
            },
            onIos = { iosInfo ->
                println("DeviceInfoX - System Name : ${iosInfo.systemName}")
            },
            onDesktop = { desktopInfo ->
                println("DeviceInfoX - System Name : ${desktopInfo.operatingSystem.versionInfo.version}")
            },
            onWeb = { webInfo ->
                println("DeviceInfoX - System Name : ${webInfo.os.version}")
            }
        )
    }
}
```

You can access more info using this **State** API, for more information about API usage in your
Compose Multiplatform project check out [Sample App Example][9].


# 📚 API Reference

You can explore full platform-specific models like:

- [`AndroidInfo`][5]
- [`IosInfo`][6]
- [`DesktopInfo`][7]
- [`WebInfo`][8]

---

# 🤝 Contributions

Contributions to KDeviceInfo are super welcome checkout [Contributions Guidelines][4]. If you encounter any issues or have suggestions for
improvements, please feel free to open an issue or submit a pull request on GitHub.

---

## 🔗 Connect with me

[![Github Profile](https://skillicons.dev/icons?i=github)][1]
[![LinkedIn](https://skillicons.dev/icons?i=linkedin)][2]
[![Twitter](https://skillicons.dev/icons?i=twitter)][3]

---

[0]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/sampleApp/composeApp/src/commonMain/kotlin/com/devx/kdeviceinfo/sample/App.kt
[1]: https://github.com/swapnil-musale
[2]: https://linkedin.com/in/swapnil-musale
[3]: https://twitter.com/swapnil_musale
[4]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/CONTRIBUTING.MD
[5]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/KDeviceInfo/src/commonMain/kotlin/com/devx/kdeviceinfo/model/android/AndroidInfo.kt
[6]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/KDeviceInfo/src/commonMain/kotlin/com/devx/kdeviceinfo/model/ios/IosInfo.kt
[7]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/KDeviceInfo/src/commonMain/kotlin/com/devx/kdeviceinfo/model/desktop/DesktopInfo.kt
[8]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/KDeviceInfo/src/commonMain/kotlin/com/devx/kdeviceinfo/model/web/WebInfo.kt
[9]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/sampleApp/composeApp/src/commonMain/kotlin/com/devx/kdeviceinfo/sample/App.kt
# Licence

```
MIT License

Copyright (c) 2024 Swapnil Musale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
