package com.examplo.argos.data.network

import com.examplo.argos.data.models.Cliente
import com.examplo.argos.data.models.Produto
import retrofit2.http.*

interface ArgosApi {

    // Clientes endpoints
    @GET("/api/clientes")
    suspend fun getClientes(): List<Cliente>

    @GET("/api/clientes/{id}")
    suspend fun getCliente(@Path("id") id: Long): Cliente

    @POST("/api/clientes")
    suspend fun createCliente(@Body cliente: Cliente): Cliente

    @PUT("/api/clientes/{id}")
    suspend fun updateCliente(@Path("id") id: Long, @Body cliente: Cliente): Cliente

    @DELETE("/api/clientes/{id}")
    suspend fun deleteCliente(@Path("id") id: Long)

    // Produtos endpoints
    @GET("/api/produtos")
    suspend fun getProdutos(): List<Produto>

    @GET("/api/produtos/{id}")
    suspend fun getProduto(@Path("id") id: Long): Produto

    @POST("/api/produtos")
    suspend fun addProduto(@Body produto: Produto): Produto

    @PUT("/api/produtos/{id}")
    suspend fun updateProduto(@Path("id") id: Long, @Body produto: Produto): Produto

    @DELETE("/api/produtos/{id}")
    suspend fun deleteProduto(@Path("id") id: Long)
}
