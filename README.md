# 📧 Email Microservice - Uber Backend Challenge

Microserviço desenvolvido como solução para o **Uber Backend Challenge**, responsável pelo envio de e-mails utilizando o **Amazon Simple Email Service (AWS SES)**.

O projeto foi construído utilizando princípios de separação de responsabilidades e arquitetura em camadas, isolando regras de negócio, integrações externas e interfaces de entrada para facilitar manutenção, testes e evolução da aplicação.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge\&logo=spring\&logoColor=white)
![AWS](https://img.shields.io/badge/AWS_SES-232F3E?style=for-the-badge\&logo=amazonaws\&logoColor=white)

---

# 📋 Descrição

A aplicação disponibiliza uma API REST para envio de e-mails através do AWS SES.

Além da integração com a AWS, o projeto foi estruturado seguindo uma abordagem inspirada em **Clean Architecture**, separando regras de negócio, contratos e integrações externas.

---

# 🔧 Pré-requisitos

Antes de executar a aplicação, certifique-se de possuir:

* Java 17 ou superior
* Maven 3.8+
* Conta AWS
* AWS SES configurado
* Usuário IAM com permissões para envio de e-mails

### Verificando instalações

```bash
java -version
mvn -version
```

---

# 🏗️ Como Buildar

### Linux/macOS

```bash
./mvnw clean install
```

### Windows

```bash
mvnw.cmd clean install
```

### Build sem executar testes

```bash
./mvnw clean install -DskipTests
```

---

# ⚙️ Configuração

Configure as credenciais AWS como variáveis de ambiente:

```env
AWS_ACCESS_KEY_ID=YOUR_ACCESS_KEY
AWS_SECRET_ACCESS_KEY=YOUR_SECRET_KEY
```

A região utilizada atualmente é:

```text
us-east-1
```

---

# 🚀 Como Rodar

### Linux/macOS

```bash
./mvnw spring-boot:run
```

### Windows

```bash
mvnw.cmd spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

---

# 📡 Endpoints da API

## POST `/email`

Responsável pelo envio de e-mails através do Amazon SES.

### Exemplo de Requisição

```json
{
  "to": "destinatario@email.com",
  "subject": "Teste",
  "body": "Conteúdo do e-mail"
}
```

### Resposta

```text
Email enviado com sucesso
```

---

# 🏛️ Arquitetura

Fluxo da aplicação:

```text
Controller
    ↓
Use Case
    ↓
Gateway
    ↓
AWS SES
```

### Camadas

#### Controllers

Responsáveis por receber e responder requisições HTTP.

#### Application

Contém os serviços responsáveis por orquestrar os casos de uso da aplicação.

#### Core

Contém regras de negócio, contratos e exceções da aplicação.

#### Adapters

Define as interfaces utilizadas para comunicação com serviços externos.

#### Infra

Implementa as integrações externas, incluindo a configuração do AWS SES.

---

# 📁 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── uber.desafio
│   │       │
│   │       ├── Controllers
│   │       │   └── EmailSenderController.java
│   │       │
│   │       ├── application
│   │       │   └── EmailSenderService.java
│   │       │
│   │       ├── adapters
│   │       │   └── EmailSenderGateway.java
│   │       │
│   │       ├── core
│   │       │   ├── EmailRequest.java
│   │       │   ├── EmailSenderUsecase.java
│   │       │   └── exceptions
│   │       │       └── EmailServiceException.java
│   │       │
│   │       ├── infra
│   │       │   ├── AwsSesConfig.java
│   │       │   └── SesEmailSender.java
│   │       │
│   │       └── DesafioApplication.java
│   │
│   └── resources
│       └── application.properties
│
├── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web
* AWS SES
* Maven
* Lombok

---

# 📝 Observações

* O AWS SES deve estar corretamente configurado.
* Contas AWS recém-criadas podem operar inicialmente em modo Sandbox.
* No modo Sandbox, apenas e-mails verificados podem receber mensagens.
* As credenciais AWS não devem ser versionadas no repositório.
* Recomenda-se utilizar variáveis de ambiente para armazenamento de chaves de acesso.

---

# 📄 Licença

Projeto desenvolvido para fins educacionais e como solução do desafio técnico proposto pela Uber.
