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



---


```
# Metodos HTTP
```



### 1. **Criação de Usuário**
- **Método HTTP:** `POST`
- **URL:** `http://localhost:8080/user`


- **Corpo da Requisição:**
  ```json
  {
    "nome": "Gustavo",
    "email": "email@email.com",
    "senha": "7438fd",
    "celular": "11958956948",
    "role": "ADMINISTRADOR",
    "dataNascimento": "1992-05-12"
  }

### 2. **Buscar Todos os Usuários**
- **Método HTTP:** `GET`
- **URL:** `http://localhost:8080/user`


- **Descrição:** Retorna uma lista de todos os usuários cadastrados no sistema.

---

### 3. **Buscar Usuário por ID**
- **Método HTTP:** `GET`
- **URL:** `http://localhost:8080/user/{id}`
  - Substitua `{id}` pelo ID do usuário que deseja buscar.

- **Descrição:** Retorna os dados de um usuário específico.

---

### 4. **Atualizar Usuário**

- **Método HTTP:** `PUT`
- **URL:** `http://localhost:8080/user/{id}`
  - Substitua `{id}` pelo ID do usuário que deseja atualizar.


#### Corpo da Requisição:
```json
{
  "nome": "Gustavo Atualizado",
  "email": "email@atualizado.com",
  "senha": "novaSenha123",
  "celular": "11999999999",
  "role": "USUARIO",
  "dataNascimento": "1992-05-12"
}
```

---

### 5. **Atualizar Senha do Usuário**

- **Método HTTP:** `PATCH`
- **URL:** `http://localhost:8080/user/{id}/password`
  - Substitua `{id}` pelo ID do usuário que deseja atualizar a senha.


#### Corpo da Requisição:
```json
{
  "novaSenha": "novaSenhaForte123"
}

```

---

### 6. **Excluir Usuário**

- **Método HTTP:** `DELETE`
- **URL:** `http://localhost:8080/user/{id}`
  - Substitua `{id}` pelo ID do usuário que deseja excluir.


#### Descrição:
Marca o usuário como cancelado no sistema.

---

## Tabelas


| Campo      | Descrição                                            | Valores Válidos             |
|------------|------------------------------------------------------|-----------------------------|
| `role`     | Define o papel do usuário no sistema.               | `ADMINISTRADOR`, `USUARIO`  |
