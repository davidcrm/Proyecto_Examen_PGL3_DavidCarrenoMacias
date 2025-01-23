package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.R
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.data.Message
import kotlin.random.Random

@Composable
fun Ficha(nombre: String){
    Row {
        Box(modifier = Modifier
            .border(2.dp, Color.Gray, shape = RectangleShape)
            .padding(all = 5.dp)
            .shadow(2.dp))
        {
            Row (modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(
                    id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, color = MaterialTheme.colorScheme.primary, CircleShape)
                )
                Column {
                    Text(text = "Alumno: $nombre",
                        modifier = Modifier
                    )
                    EspacioHorizontal(alto = 10)
                    Text(text = "Soy un alumno",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
@Composable
fun MainButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = color
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = text)
    }
}
@Composable
fun EspacioHorizontal(alto: Int){
    Spacer(modifier = Modifier.height(alto.dp))
}

@Composable
fun Conversacion(msg: List<Message>){
    var color by remember { mutableStateOf(Color.Magenta) }

    val listaColores = listOf(Color.Green, Color.Blue, Color.Red, Color.Cyan)
    MainButton(text = "Elegir nuevo color", color = color,onClick = {
        var indiceRandom = Random.nextInt(0,4)
        color = listaColores[indiceRandom]
    })

    LazyColumn {
        items(msg){ message ->
            MensajeCompleto(msg = message, color = color)
        }
    }
}