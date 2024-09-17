package com.examplo.argos.data.network

import com.examplo.argos.data.models.Cliente as ClienteModel
import com.examplo.argos.data.models.Produto as ProdutoModel

// Função de conversão para Cliente (mapeia de data.network para data.models)
fun ClienteModel.toModel(): ClienteModel {
    return ClienteModel(id = this.id, nome = this.nome, email = this.email, telefone = this.telefone)
}

// Função de conversão para Produto (mapeia de data.network para data.models)
fun ProdutoModel.toModel(): ProdutoModel {
    return ProdutoModel(id = this.id, nome = this.nome, preco = this.preco)
}

