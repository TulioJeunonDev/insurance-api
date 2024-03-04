
# Itau Challenge - Insurance API

A proposta da aplicação é disponibilizar a uma pessoa as modalidades de seguro as quais melhor se encaixam com seu perfil de acordo com algumas variáveis.

## Tecnologias
Java, SpringBoot, Docker

## Instalação e Configuração

Baixe o código-fonte desse repositório usando git clone ou de forma manual (.zip).

## Pré Requisitos
OpenJdk - 17.0.8 - Plataforma Java

Apache Maven - 3.6.1  - Build e Gestão de Dependências 

## Compilação
Para fazer o download das dependências e compilar o código-fonte da aplicação, navegue até o diretório raiz do projeto e execute:

mvn clean package

## Variáveis de ambiente
A URL de para integração com a api do IBGE, deve ser colocada como variável de ambiente.
No seguinte formato:

url.client.ibgeUrl=https://servicodados.ibge.gov.br/api/v1/localidades/estados

## Execução da aplicação
Para executar a aplicação, rode o comando:

mvn spring-boot:run

## Contrato de APIs
Este projeto utiliza a especificação OpenAPI para documentação e catálogo de APIs. Depois de executar a aplicação, é possível consultar todas as operações fornecidas pelo serviço e testá-las respectivamente acessando o endereço http://localhost:8080/api-insurance/swagger-ui/index.html#.

## Solução

Para atender da melhor forma o pedido do desafio, utilizei de dois padrões de projeto, para facilitar a manutenção e diminuir a quantidade de regras e responsabilidades atribuídas na classe de serviço.
Dessa forma, mapeei alguns Strategy's que levam a regra de negócio e um Factory, para mapear e escolher qual strategy deve ser utilizada.
