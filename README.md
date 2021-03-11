## E-COMERCIE API
Projeto básico de uma API de e-commerce.

### Funcionalidades:

### Produtos

URL   | METÓDO   | FUNÇÃO | DADOS DE ENVIO |
------|----------|--------|-------|
produtos/ | POST | Cadastrar produtos | json |
produtos/ | GET | mostrar todos os produtos | não tem |

**Exemplo do corpo de envio de produto em JSON**
```json
{
  "nome": "nome do produto",
  "preco": 1.44,
  "quantidade": 1
}
```
### Clientes

URL   | METÓDO   | FUNÇÃO | DADOS DE ENVIO |
------|----------|--------|-------|
clientes/ | POST | Cadastrar um novo cliente | json |
clientes/{cpf}/ | GET | retornar o cliente com seu cpf | não tem |

**Exemplo do corpo de envio do cliente em JSON**
```json
{
  "nome": "nome do cliente",
  "cpf": "0000000000",
  "email": "emaildocleinte@cliente.com"
}
```
### Compras

URL   | METÓDO   | FUNÇÃO | DADOS DE ENVIO |
------|----------|--------|-------|
compras/ | POST | Cadastrar uma nova compra | json |
compras/{cpf}/ | GET | retornar as compras de um deteminado cliente pelo CPF | não tem |
compras/ | GET | retornar retornar todas as compras cadastradas | não tem |

**Exemplo do corpo de envio para cadastrar compras em JSON**
```json
{
  "cpf": "0000000000",
  "produtos": [
    {"nome":  "nome produto 1"},
    {"nome":  "nome produto 2"}.
    ....
  ]
}
```