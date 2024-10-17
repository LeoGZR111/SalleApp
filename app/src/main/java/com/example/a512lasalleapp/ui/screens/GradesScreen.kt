package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a512lasalleapp.ui.models.Subject
import com.example.a512lasalleapp.ui.models.subjects
import com.example.a512lasalleapp.ui.models.student

@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
        Text(
            text = "Calificaciones",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        // Información del alumno
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Nombre: ${student.name}", fontSize = 20.sp)
                Text("Carrera: ${student.career}", fontSize = 16.sp)
                Text("Semestre: ${student.semester}", fontSize = 16.sp)
                Text("Promedio Acumulado: ${student.cumulativeAverage}", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de materias
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(subjects) { subject ->
                SubjectItem(subject = subject, navController = navController)
            }
        }
    }
}

@Composable
fun SubjectItem(subject: Subject, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("gradesDetail/${subject.id}")
            },
        elevation = CardDefaults.cardElevation(2.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = subject.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Promedio: ${subject.average}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
