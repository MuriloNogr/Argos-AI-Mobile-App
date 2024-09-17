package com.examplo.argos.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.examplo.argos.data.models.Produto
import com.examplo.argos.data.network.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun AddProdutoScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()

    Button(onClick = {
        coroutineScope.launch {
            try {
                val novoProduto = Produto(0, "Novo Produto", 100.0)
                RetrofitInstance.api.addProduto(novoProduto)
                navController.navigate("produtos")
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }) {
        Text("Adicionar Produto")
    }
}
