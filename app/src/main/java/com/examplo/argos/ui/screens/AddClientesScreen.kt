package com.examplo.argos.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Cliente
import com.examplo.argos.data.network.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun AddClienteScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()

    Button(onClick = {
        coroutineScope.launch {
            try {
                val novoCliente = Cliente(0, "Novo Cliente", "email@exemplo.com", "123456789")
                RetrofitInstance.api.createCliente(novoCliente)
                navController.navigate("clientes")
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }) {
        Text("Adicionar Cliente")
    }
}
