package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(name: String) {
    Text(text= name, fontSize = 40.sp, fontWeight = Bold)
}