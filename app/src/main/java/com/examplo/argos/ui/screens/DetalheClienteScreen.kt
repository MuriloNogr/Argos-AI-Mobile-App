package com.examplo.argos.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Cliente
import com.examplo.argos.data.network.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun DetalheClienteScreen(clienteId: Long, navController: NavHostController) {
    var cliente by remember { mutableStateOf<Cliente?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(clienteId) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getCliente(clienteId)
                cliente = response
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }

    cliente?.let {
        Text(text = "Detalhes do Cliente: Nome: ${it.nome}, Email: ${it.email}, Telefone: ${it.telefone}")
    }
}
