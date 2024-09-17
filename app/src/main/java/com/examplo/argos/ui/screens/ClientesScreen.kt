package com.examplo.argos.ui.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Cliente
import com.examplo.argos.data.network.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun ClientesScreen(navController: NavHostController) {
    val clientes = remember { mutableStateListOf<Cliente>() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getClientes()
                clientes.addAll(response)
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }

    LazyColumn {
        items(clientes) { cliente ->
            Text(cliente.nome)
        }
    }
}
