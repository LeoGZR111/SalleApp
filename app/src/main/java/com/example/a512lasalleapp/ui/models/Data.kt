package com.example.a512lasalleapp.ui.models


data class Student(
    val name: String,
    val career: String,
    val semester: String,
    val cumulativeAverage: Double
)

data class Subject(
    val id: Int,
    val name: String,
    val average: Double,
    val grades: List<Double> // Calificaciones de los parciales
)

// Datos de ejemplo
val student = Student(
    name = "Leo Guizar",
    career = "Ingeniería en Sistemas",
    semester = "5to Semestre",
    cumulativeAverage = 8.9
)

val subjects = listOf(
    Subject(id = 0, name = "Matemáticas", average = 8.5, grades = listOf(9.0, 8.5, 8.0)),
    Subject(id = 1, name = "Historia", average = 9.0, grades = listOf(9.5, 8.5, 9.0)),
    Subject(id = 2, name = "Ciencias", average = 7.5, grades = listOf(7.0, 7.5, 8.0)),
    Subject(id = 3, name = "Programación I", average = 9.2, grades = listOf(10.0, 9.0, 8.5)),
    Subject(id = 4, name = "Programación II", average = 8.8, grades = listOf(9.0, 8.5, 8.8)),
    Subject(id = 5, name = "Física", average = 8.0, grades = listOf(7.5, 8.0, 8.5)),
    Subject(id = 6, name = "Química", average = 8.3, grades = listOf(8.0, 8.5, 8.5)),
    Subject(id = 7, name = "Base de Datos", average = 9.1, grades = listOf(9.0, 9.5, 8.5)),
    Subject(id = 8, name = "Redes de Computadoras", average = 8.7, grades = listOf(8.5, 9.0, 9.0)),
    Subject(id = 9, name = "Desarrollo Web", average = 9.4, grades = listOf(9.5, 9.0, 9.5)),
    Subject(id = 10, name = "Ética Profesional", average = 9.0, grades = listOf(9.0, 9.0, 9.0)),
    Subject(id = 11, name = "Sistemas Operativos", average = 7.8, grades = listOf(7.5, 8.0, 8.0)),
    Subject(id = 12, name = "Metodología de la Investigación", average = 8.6, grades = listOf(9.0, 8.5, 8.5)),
    Subject(id = 13, name = "Inteligencia Artificial", average = 8.9, grades = listOf(9.5, 9.0, 8.0)),
    Subject(id = 14, name = "Economía", average = 7.5, grades = listOf(7.0, 8.0, 7.5)),
    Subject(id = 15, name = "Administración de Proyectos", average = 8.4, grades = listOf(8.0, 8.5, 9.0)),
    Subject(id = 16, name = "Ingeniería de Software", average = 9.3, grades = listOf(9.5, 9.0, 9.0)),
    Subject(id = 17, name = "Arquitectura de Computadoras", average = 8.2, grades = listOf(8.0, 8.5, 8.0)),
    Subject(id = 18, name = "Teoría de Autómatas", average = 9.0, grades = listOf(9.0, 9.0, 9.0)),
    Subject(id = 19, name = "Interfaces de Usuario", average = 8.1, grades = listOf(8.0, 8.5, 8.0)),
    Subject(id = 20, name = "Seguridad Informática", average = 9.5, grades = listOf(10.0, 9.5, 9.0)),
    Subject(id = 21, name = "Machine Learning", average = 8.8, grades = listOf(9.0, 8.5, 9.0))
)