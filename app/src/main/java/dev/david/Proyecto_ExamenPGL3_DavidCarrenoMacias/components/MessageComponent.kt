package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.R
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.data.Message


@Composable
fun MensajeCompleto(msg: Message, color: Color){
    Row (modifier = Modifier.padding(all= 8.dp)){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, color = MaterialTheme.colorScheme.primary, CircleShape)
        )
        EspacioHorizontal(alto = 8)
        //variable que recuerda si el mensaje está expandido o no
        var isExpanded by remember { mutableStateOf(false) }
        //variable para cambiar de color el mensaje según su estado
        val surfaceColor by animateColorAsState(
            if (isExpanded) color else Color.LightGray
        )
        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            //Añade espacio vertical entre los mensajes
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // Si está expandido muestra el contenido y si no, mustra la primera línea
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}