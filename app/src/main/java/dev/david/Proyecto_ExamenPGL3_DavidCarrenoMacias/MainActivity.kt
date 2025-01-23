package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.navigation.NavManager
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.ui.theme.Proyecto_ExamenPGL3_DavidCarreñoMaciasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                NavManager()
        }
    }
}