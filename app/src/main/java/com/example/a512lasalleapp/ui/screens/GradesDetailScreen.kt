package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.a512lasalleapp.ui.models.subjects
import com.example.a512lasalleapp.ui.models.student
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GradesDetailScreen(subjectId: Int) {
    val subject = subjects[subjectId] // Obtener la materia basada en el ID

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Detalles de la materia: ${subject.name}", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar calificaciones de los parciales
        subject.grades.forEachIndexed { index, grade ->
            Text(text = "Parcial ${index + 1}: $grade", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

