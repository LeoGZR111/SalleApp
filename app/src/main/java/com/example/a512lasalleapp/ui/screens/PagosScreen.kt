package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a512lasalleapp.R
import androidx.navigation.NavController


// Data class para los pagos
data class Payment(val description: String, val folio: String, val period: String, val dueDate: String, val paymentNumber: Int, val isPaid: Boolean)

val paymentsList = listOf(
    Payment("SEGURO ESCOLAR", "CPAL00040761", "157 - AGO-DIC 2024", "octubre 10 de 2024", 1, false),
    Payment("PRIMER PAGO DE COLEGIATURA", "CPAL000017818", "157 - AGO-DIC 2024", "agosto 16 de 2024", 1, true),
    Payment("SEGUNDO PAGO DE COLEGIATURA", "CPAL000039053", "157 - AGO-DIC 2024", "septiembre 10 de 2024", 2, true),
    Payment("TERCER PAGO DE COLEGIATURA", "CPAL000049592", "157 - AGO-DIC 2024", "octubre 10 de 2024", 3, true),
    Payment("INGRESOS VIBU - GESTIÓN DESARROLLO Y GESTIÓN CULTURAL - CAMPESTRE", "CPAL000052870", "157 - AGO-DIC 2024", "octubre 19 de 2024", 1, true)
)

@Composable
fun PagosScreen(navController: NavController) { // Asegúrate de recibir navController
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Pagos", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Lista de pagos
        LazyColumn {
            items(paymentsList) { payment ->
                PaymentItem(payment, navController) // Pasar navController si es necesario
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun PaymentItem(payment: Payment, navController: NavController) { // Asegúrate de que sea necesario
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp).background(MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = if (payment.isPaid) R.drawable.ic_check else R.drawable.ic_alert),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = payment.description, fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground)
            Text(text = "Folio: ${payment.folio}", fontSize = 12.sp, color = Color.Gray)
            Text(text = "Periodo: ${payment.period}", fontSize = 12.sp, color = Color.Gray)
            Text(text = "Vencimiento: ${payment.dueDate}", fontSize = 12.sp, color = Color.Gray)
            Text(text = "No. Pago: ${payment.paymentNumber}", fontSize = 12.sp, color = Color.Gray)
        }

        // Botón para ver recibo
        Button(onClick = { /* Acción para ver recibo */ }) {
            Text(text = if (payment.isPaid) "VER RECIBO" else "PAGO PENDIENTE")
        }
    }
}
