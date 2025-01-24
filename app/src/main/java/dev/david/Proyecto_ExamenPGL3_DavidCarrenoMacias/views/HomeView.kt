package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.affirmations.Affirmation
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.ActionButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.NavigationButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleBar
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleView
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.data.Datasource

// Vista
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "HOME" )},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.LightGray
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            ContentHomeView(navController)
        }

    }
}
// Contenido de la vista
@Composable
fun ContentHomeView(navController: NavController) {
    // declaracion de las variables que vamos a pasar por parámetro
    val id = 1
    var opcional by remember { mutableStateOf("")}

    TitleView(name = "HomeView")
    TextField(value = opcional, onValueChange = {opcional = it}, label = {Text(text= "Opcional: ")})
    //Botón para navegar al que pasaremos los parámetros declarados
    NavigationButton("Ir a la siguiente pantalla",Color.Gray, Color.White){
        navController.navigate("Detail/${id}?${opcional}")

    }

}

