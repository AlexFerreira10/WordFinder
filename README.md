# Pesquisa de Palavras em Arquivos de Texto com Árvore AVL

Este projeto foi desenvolvido como parte da disciplina de Estrutura de Dados 2, ministrada pelo professor Dr. Denis Gonçalves Cople. Ele consiste em uma implementação de uma árvore AVL para pesquisa de palavras em uma coleção de arquivos de texto. O projeto permite a busca por palavras específicas nos arquivos e fornece informações sobre a frequência e a ocorrência dessas palavras.

## Motivação

A pesquisa de palavras em grandes volumes de texto é uma tarefa comum em muitas aplicações, como processamento de linguagem natural, análise de dados e indexação de documentos. A árvore AVL é uma estrutura de dados eficiente para essa finalidade, pois permite uma busca rápida e eficiente, mantendo o equilíbrio da árvore para garantir um desempenho estável.

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

- **application**: Contém a classe principal `Main`, responsável pela interação com o usuário.
- **structures**: Contém as classes que implementam a estrutura da árvore AVL e a representação dos arquivos de texto.
  - `TreeAVL`: Implementa a árvore AVL e fornece métodos para inserção, busca e rotações.
  - `Word`: Representa um nó da árvore AVL, contendo uma palavra e suas informações associadas.
  - `File`: Representa um arquivo de texto, fornecendo métodos para contagem de palavras e leitura.

## Utilização

Para utilizar o programa, execute a classe `Main` localizada em `application/Main.java`. Ele apresentará um menu interativo que permitirá a pesquisa de palavras nos arquivos de texto disponíveis.

### Funcionalidades

1. **Pesquisar Palavra**: Permite pesquisar uma palavra específica nos arquivos de texto e exibe as informações relacionadas a essa palavra, como frequência e ocorrências.
2. **Total de Palavras**: Exibe o total de palavras únicas presentes nos arquivos de texto.

## Requisitos

- Java 8 ou superior

## Como Contribuir

Se você deseja contribuir para o projeto, siga as instruções abaixo:

1. Faça um fork do repositório
2. Crie uma branch para a sua feature (`git checkout -b feature/MinhaFeature`)
3. Faça commit das suas alterações (`git commit -am 'Adicionando uma nova feature'`)
4. Faça push para a branch (`git push origin feature/MinhaFeature`)
5. Crie um novo Pull Request

## Autores

Este projeto foi desenvolvido por _Douglas Alexsander Ferreira Corrêa, Juan Patrick Barão
de Menezes e Gabriel André de Lima Silva_ como parte da disciplina de Estrutura de Dados 2, ministrada pelo professor Dr. Denis Gonçalves Cople.
