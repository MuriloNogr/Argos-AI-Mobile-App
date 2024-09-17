package com.examplo.argos.ui.screens

import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Produto  // Modelo correto de data.models
import com.examplo.argos.data.network.RetrofitInstance
import com.examplo.argos.data.network.toModel  // Função de conversão
import kotlinx.coroutines.launch

@Composable
fun DetalheProdutoScreen(produtoId: Long, navController: NavHostController) {
    var produto by remember { mutableStateOf<Produto?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(produtoId) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getProdutos()
                produto = response.find { it.id == produtoId }?.toModel()  // Converter para data.models.Produto
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }

    produto?.let {
        Text(text = "Detalhes do Produto: ${it.nome}, Preço: ${it.preco}")
    }
}
