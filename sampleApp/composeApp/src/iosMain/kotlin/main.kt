import androidx.compose.ui.window.ComposeUIViewController
import com.devx.kdeviceinfo.sample.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    App()
}
