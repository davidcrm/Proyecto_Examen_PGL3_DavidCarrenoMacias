package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String) {
    Text(
        text= name,
        fontSize = 40.sp,
        fontWeight = Bold,
        color = Color.White
    )
}
@Composable
fun ActionButton(){
    FloatingActionButton(
        onClick = {/*TODO*/},
        containerColor = Color.Gray,
        contentColor = Color.White) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar")

    }
}
@Composable
fun NavigationButton(name: String, backColor: Color, color: Color, onClick:() -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        )
    ) {
        Text(text= name)
    }
}

@Composable
fun MainIconButton(icon: ImageVector, onClick: () -> Unit){
    IconButton(onClick = onClick){
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}