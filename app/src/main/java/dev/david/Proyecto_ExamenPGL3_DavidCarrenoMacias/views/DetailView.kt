package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.ActionButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.MainIconButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.NavigationButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleBar
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id:Int, opcional: String) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "DETAIL")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        // Volver a la página anterior
                        navController.popBackStack()
                    }
                }
            )
        },
        floatingActionButton = {
            ActionButton()
        }

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            DetailHomeView(navController, id, opcional)
        }
    }
}
// Contenido de la vista donde se muestran los parámetros pasados por la ruta
@Composable
fun DetailHomeView(navController: NavController, id: Int, opcional: String) {

    TitleView(name = "DetailView")
    //id
    Text(text = id.toString())
    // Parámetro opcional
    Text(text = opcional)
    Column{
        // Botón para navegar a HOME
        NavigationButton("Ir a Home", Color.LightGray, Color.Black){
            navController.navigate("Home")
        }
    }
}