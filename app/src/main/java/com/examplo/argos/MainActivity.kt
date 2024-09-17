package com.examplo.argos

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.examplo.argos.ui.screens.*
import com.examplo.argos.ui.theme.ArgosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArgosAppTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "produtos") {

        // Rotas para Produtos
        composable("produtos") { ProdutosScreen(navController) }
        composable("addProduto") { AddProdutoScreen(navController) }
        composable("detalheProduto/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            id?.let { DetalheProdutoScreen(it, navController) }
        }

        // Rotas para Clientes
        composable("clientes") { ClientesScreen(navController) }
        composable("addCliente") { AddClienteScreen(navController) }
        composable("detalheCliente/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            id?.let { DetalheClienteScreen(it, navController) }
        }
    }
}
