# Guia de Configuração e Teste da API no Postman

## Pré-requisitos
- API Spring Boot rodando localmente, com a dependência `spring-boot-starter-security`.
- Postman instalado para realizar requisições HTTP.

## Passo a Passo para Testar a Autenticação no Postman

### 1. Configuração Básica do Endpoint
No exemplo abaixo, vamos configurar um teste de criação de um novo usuário através do endpoint `/user`.

### 2. Configurar a Autenticação Básica no Postman
- Abra o Postman e clique em **New > Request** para criar uma nova requisição.
- Na URL, insira o endereço do endpoint, como:
  
http://localhost:8080/user


- Método HTTP: Selecione **POST** (para o exemplo de criação de usuário).

### 3. Configurar o Corpo da Requisição
Na aba **Body**:
- Selecione **raw** e, no menu suspenso à direita, escolha o formato **JSON**.
- Insira o seguinte JSON (ou algo semelhante) para criar um novo usuário:

```json
{
  "nome": "Gustavo",
  "email": "email@email.com",
  "senha": "7438fd",
  "celular": "11958956948",
  "role": "ADMINISTRADOR",
  "dataNascimento": "1992-05-12"
}
```
## Configurar a Autenticação
Na aba Authorization:

No campo Type, selecione Basic Auth.
Em Username, insira: loginMaster.
Em Password, insira: L02I6M@s7er.
O Postman irá automaticamente gerar o cabeçalho Authorization com as credenciais em base64.


## Tabelas


| Campo      | Descrição                                            | Valores Válidos             |
|------------|------------------------------------------------------|-----------------------------|
| `role`     | Define o papel do usuário no sistema.               | `ADMINISTRADOR`, `USUARIO`  |
