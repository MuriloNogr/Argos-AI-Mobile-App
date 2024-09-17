package com.examplo.argos.ui.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Produto  // Modelo correto de data.models
import com.examplo.argos.data.network.RetrofitInstance
import com.examplo.argos.data.network.toModel  // Função de conversão
import kotlinx.coroutines.launch

@Composable
fun ProdutosScreen(navController: NavHostController) {
    val produtos = remember { mutableStateListOf<Produto>() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getProdutos()
                produtos.addAll(response.map { it.toModel() })  // Converter para data.models.Produto
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }

    LazyColumn {
        items(produtos) { produto ->
            Text(produto.nome)
            Button(onClick = { navController.navigate("detalheProduto/${produto.id}") }) {
                Text("Ver detalhes")
            }
        }
    }
}
