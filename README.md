# Argos App

## Descrição

O **Argos App** é uma aplicação móvel Android construída com Jetpack Compose para gerenciar clientes e produtos. A aplicação consome uma API RESTful utilizando Retrofit para executar operações CRUD sobre as entidades de **Clientes** e **Produtos**.

## Arquitetura

A aplicação segue o padrão **MVVM (Model-View-ViewModel)**, separando responsabilidades entre a lógica de negócios e a interface do usuário.

- **Model**: Representação dos dados como classes de modelos (`Cliente`, `Produto`).
- **View**: Composables que exibem a UI para o usuário, utilizando o Jetpack Compose.
- **ViewModel**: Camada que gerencia os estados e a lógica de negócios, facilitando a comunicação entre a API e a UI (não implementada explicitamente, mas a lógica se encontra nos composables).

## Tecnologias Utilizadas

- **Kotlin**: Linguagem principal da aplicação Android.
- **Jetpack Compose**: Biblioteca para criar interfaces gráficas.
- **Retrofit**: Cliente HTTP para Android usado para fazer as chamadas à API.
- **Coroutines**: Usadas para executar chamadas de rede de maneira assíncrona.
- **Navigation Compose**: Navegação entre as telas do aplicativo.
- **Gson**: Conversor JSON para Kotlin, usado com Retrofit.

## Estrutura de Pastas

.
├── data
│   ├── models
│   │   ├── Cliente.kt        # Modelo de dados para Clientes
│   │   └── Produto.kt        # Modelo de dados para Produtos
│   ├── network
│       ├── ArgosApi.kt       # Interface Retrofit para comunicação com a API
│       ├── RetrofitInstance.kt # Singleton para inicializar Retrofit
│       └── ModelMappers.kt   # Funções de mapeamento dos modelos de dados
│
├── ui
│   ├── screens
│   │   ├── AddClienteScreen.kt    # Tela para adicionar um cliente
│   │   ├── AddProdutoScreen.kt    # Tela para adicionar um produto
│   │   ├── ClientesScreen.kt      # Tela que lista todos os clientes
│   │   ├── ProdutosScreen.kt      # Tela que lista todos os produtos
│   │   ├── DetalheClienteScreen.kt # Tela para visualizar os detalhes de um cliente
│   │   └── DetalheProdutoScreen.kt # Tela para visualizar os detalhes de um produto
│   └── theme
│       ├── Color.kt            # Definições de cores
│       ├── Theme.kt            # Configurações do tema do app
│       └── Type.kt             # Configurações de tipografia
│
└── MainActivity.kt             # Atividade principal que contém a navegação

## Diagrama UML

![ArgosMobileUml](https://github.com/user-attachments/assets/3daf1a13-1827-4140-b3cf-be31c50df154)



