package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.a512lasalleapp.ui.components.ScreenTemplate

@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController) { // Agregado navController aquí
    ScreenTemplate(
        innerPadding = innerPadding,
        header = {
            Text(
                text = "Configuración",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        },
        body = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen circular del alumno
                Image(
                    painter = rememberAsyncImagePainter("https://i.guim.co.uk/img/media/c8c00617b792d1d53f2d2b318820d5758dc61551/231_0_2968_1782/master/2968.jpg?width=1200&quality=85&auto=format&fit=max&s=99459057199a54c97181e29b0947b5fb"),
                    contentDescription = "Foto del Alumno",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Información del alumno
                StudentInfoRow(label = "Nombre Completo", value = "Leonardo Emmanuel Guizar Rivera")
                Spacer(modifier = Modifier.height(8.dp))
                StudentInfoRow(label = "Fecha de Nacimiento", value = "09/09/2002")
                Spacer(modifier = Modifier.height(8.dp))
                StudentInfoRow(label = "Correo Institucional", value = "lgr77149@lasallebajio.edu.mx")

                Spacer(modifier = Modifier.height(24.dp))

                // Lista de Opciones
                OptionItem(text = "Cambiar contraseña") {
                    // Navegar a la pantalla de cambio de contraseña
                    navController.navigate("change_password")
                }
                OptionItem(text = "Cambiar tema de la aplicación") {
                    // Navegar a la pantalla de cambio de tema
                    navController.navigate("change_theme")
                }
            }
        }
    )
}

@Composable
fun StudentInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}

@Composable
fun OptionItem(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}
