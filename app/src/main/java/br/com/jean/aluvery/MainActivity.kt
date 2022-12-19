package br.com.jean.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.jean.aluvery.screens.HomeScreen
import br.com.jean.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    HomeScreen()
}

@Preview(
    showSystemUi = true
)
@Composable
fun AppPreview() {
    App()
}

