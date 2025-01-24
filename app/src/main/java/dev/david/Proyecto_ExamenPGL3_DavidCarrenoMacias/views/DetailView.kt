package dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.MainIconButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.NavigationButton
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleBar
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.components.TitleView
import dev.david.Proyecto_ExamenPGL3_DavidCarrenoMacias.data.Datasource

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
    AffirmationsApp()
}
@Composable
fun AffirmationsApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
        )
    }

}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = Modifier){
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxSize()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>){
    LazyColumn(modifier = Modifier) {
        items(affirmationList){ affirmation ->
            AffirmationCard(
                affirmation= affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}