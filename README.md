# Housin!

Encontre o parceiro certo para dividir sua casa, ou anuncie seu espaço para receber propostas. Nosso serviço irá selecionar baseado nos gostos pessoais as pessoas que mais encaixam no seu perfil, e a partir disso mostrar para você, já imaginou?! 

# O Projeto

Projeto iniciado na disciplina de  **ESA - Engenharia de Software Aplicada** durante o período 2019.1 do curso Sistemas de Informação.

## Arquitetura

O aplicativo será desenvolvido a partir do Android. Com o uso do Retrofit consumiremos a API criada, e com o Neo4J será criado a árvore gráfica do nosso algoritmo de match.

## O Algoritmo

```mermaid
graph LR
A[Ana gosta de Rock e Filme de Terror] -- Gosto Musical --> B(Pedro gosta de Rock)
A -- Gosto Cultural --> C(Pedro gosta de Filme de Terror)
B --> D{Match!}
C --> D