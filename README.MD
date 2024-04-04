<h1 align="center">KDeviceInfo</h1>

KDeviceInfo is Kotlin Multiplatform Library - allows to access the device details of android and
ios devices without writing expect actual boilerplate code.

<p align="center">
<a href="https://github.com/swapnil-musale/KDeviceInfo"><img alt="Android" src="https://img.shields.io/badge/Platform-Android-Blue?style=for-the-badge"/></a>
<a href="https://github.com/swapnil-musale/KDeviceInfo"><img alt="Ios" src="https://img.shields.io/badge/Platform-Ios-Blue?style=for-the-badge"/></a>
<a href="https://github.com/swapnil-musale/KDeviceInfo"><img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.swapnil-musale/KDeviceInfo?style=for-the-badge"/></a>
<a href="https://github.com/swapnil-musale/KDeviceInfo"><img alt="CI Status" src="https://img.shields.io/github/actions/workflow/status/swapnil-musale/KDeviceInfo/build.yml?style=for-the-badge"/></a>

# Demo ❤️


<table style="width:100%">
  <tr>
    <th>Android</th>
    <th>Ios</th> 
  </tr>
  <tr>
    <td><img src = "https://github.com/swapnil-musale/KDeviceInfo/assets/15209914/230a0983-ca7b-4983-a17d-e90cc639add5" width=250/></td> 
    <td><img src = "https://github.com/swapnil-musale/KDeviceInfo/assets/15209914/2024b962-e3ea-4e3f-beef-81561ca8371e" width=250/></td>
  </tr>
</table>

# Installation

This library is available on mavenCentral. To use it in your project add following block of code
in ```settings.gradle.kts``` file if not available.

```
repositories { 
    ...
    mavenCentral()
}
```

### 1. Kotlin Multiplatform
Add the library dependency in ```shared``` module (```build.gradle.kts```)

```
commonMain.dependencies {
    ...
    api or implementation("io.github.swapnil-musale:KDeviceInfo:0.0.6")
}
```

### 2. Compose Multiplatform

Add the library dependency in ```composeApp``` module (```build.gradle.kts```)

```
commonMain.dependencies {
    ...
    implementation("io.github.swapnil-musale:KDeviceInfo:0.0.6")
}
```

# Usage

Implementation of **KDeviceInfo** is pretty straightforward. Simply import the **DeviceInfoXState**
and start accessing device information in your Compose Multiplatform project.

```
@Composable
fun DeviceInfoExample() {

    val deviceInfoXState: DeviceInfoXState = rememberDeviceInfoXState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        if (deviceInfoXState.isAndroid) {
            val androidInfo = deviceInfoXState.androidInfo
            Text(text = "App Name : ${androidInfo.appName}")
            Text(text = "SdkInt : ${androidInfo.version.sdkInt}")
            Text(text = "PackageName : ${androidInfo.packageName}")
        } else {
            val iosInfo = deviceInfoXState.iosInfo
            Text(text = "SystemName : ${iosInfo.systemName}")
            Text(text = "SystemVersion : ${iosInfo.systemVersion}")
            Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        }
    }
}
```

**OR** Use helper function to access device information

```
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
            }
        )
    }
}
```

To access the device details outside the Composable function you can make use of **DeviceInfoState** as below

```
class AppViewModel {

    private val deviceInfoXState: DeviceInfoXState = DeviceInfoXState()

    init {
        if (deviceInfoXState.isAndroid) {
            val androidInfo: AndroidInfo = deviceInfoXState.androidInfo
            println("DeviceInfoX - App Name : ${androidInfo.appName}")
            println("DeviceInfoX - App Name : ${androidInfo.versionName}")
        } else {
            val iosInfo: IosInfo = deviceInfoXState.iosInfo
            println("DeviceInfoX - System Name : ${iosInfo.appName}")
            println("DeviceInfoX - System Name : ${iosInfo.appVersion}")
        }
    }
}
```

**OR** Use helper function to access device information

```
class AppViewModel {
    init {
        onPlatform(
            onAndroid = { androidInfo ->
                println("DeviceInfoX - App Name : ${androidInfo.appName}")
                println("DeviceInfoX - App Name : ${androidInfo.versionName}")
            },
            onIos = { iosInfo ->
                println("DeviceInfoX - System Name : ${iosInfo.appName}")
                println("DeviceInfoX - System Name : ${iosInfo.appVersion}")
            }
        )
    }
}
```

You can access more info using this **State** API, for more information about API usage in your
Compose Multiplatform project check out [Sample App][0].

# Contributions

Contributions to KDeviceInfo are super welcome checkout [Contributions Guidelines][4]. If you encounter any issues or have suggestions for
improvements, please feel free to open an issue or submit a pull request on GitHub.

## Connect with me

[![Github Profile](https://skillicons.dev/icons?i=github)][1]
[![LinkedIn](https://skillicons.dev/icons?i=linkedin)][2]
[![Twitter](https://skillicons.dev/icons?i=twitter)][3]


[0]: https://github.com/swapnil-musale/KDeviceInfo/tree/read_me/sampleApp
[1]: https://github.com/swapnil-musale
[2]: https://linkedin.com/in/swapnil-musale
[3]: https://twitter.com/swapnil_musale
[4]: https://github.com/swapnil-musale/KDeviceInfo/blob/master/CONTRIBUTING.MD

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
