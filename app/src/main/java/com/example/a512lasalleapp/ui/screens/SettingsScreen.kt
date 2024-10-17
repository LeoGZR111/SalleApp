package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
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
        Column(modifier = Modifier.fillMaxWidth()) {
            StudentInfoRow(label = "Nombre Completo", value = "Leonardo Emmanuel Guizar Rivera")
            Spacer(modifier = Modifier.height(8.dp))
            StudentInfoRow(label = "Fecha de Nacimiento", value = "09/09/2002")
            Spacer(modifier = Modifier.height(8.dp))
            StudentInfoRow(label = "Correo Institucional", value = "lgr77149@lasallebajio.edu.mx")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de Opciones
        OptionItem(text = "Cambiar contraseña") {
            navController.navigate("change_password")
        }
        Spacer(modifier = Modifier.height(16.dp))
        OptionItem(text = "Cambiar tema de la aplicación") {
            navController.navigate("change_theme")
        }
    }
}

@Composable
fun StudentInfoRow(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Text(text = value, textAlign = TextAlign.Start)
    }
}

@Composable
fun OptionItem(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
            .background(Color(0xFF4B4B4B), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
    }
}
