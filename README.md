# 🏗️ Hexagonal Architecture - Spring Boot Project

## 📋 Sobre o Projeto

Projeto demonstrando a implementação da **Arquitetura Hexagonal** (Ports & Adapters) com Spring Boot, seguindo os princípios de Clean Architecture e Domain-Driven Design.

## 🎯 Objetivo

Demonstrar na prática como isolar o domínio da aplicação das tecnologias externas (banco de dados, mensageria, APIs externas), tornando o sistema mais testável, manutenível e adaptável a mudanças.

## 🏗️ Arquitetura Hexagonal - Conceitos

* **Port (Porta)**: interface que define o limite entre a lógica da aplicação e os detalhes de implementação.

* **Adapter (Adaptador)**: implementação da porta que conecta o domínio da aplicação com o contexto do sistema (banco de dados, APIs externas, etc.).

* **Domain (Domínio)**: contém a lógica de negócio da aplicação e as entidades do modelo.

* **Service (Serviço)**: implementa operações agrupadas por um tópico em comum. Geralmente chama as portas de saída (driven ports).

* **UseCase/Case (Caso de Uso)**: serviço de operação única (funcionalidades isoladas). Pode coexistir com Services.

* **Output/Driven Adapter (Adaptador de Saída)**: implementação das portas chamadas pelo domínio. Ex: Repository, Kafka Producer, Feign Client.

* **Input/Driver Adapter (Adaptador de Entrada)**: comandos que chamam a lógica da aplicação (não exigem uma porta). Ex: Controller REST, Kafka Consumer.

## 📦 Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
|------------|--------|------------|
| **Java** | 21 | Linguagem |
| **Spring Boot** | 4.0.6 | Framework |
| **Spring Cloud** | 2021.0.4 | Microsserviços |
| **MongoDB** | - | Banco de Dados |
| **Apache Kafka** | - | Mensageria |
| **OpenFeign** | - | Cliente HTTP |
| **Lombok** | - | Código boilerplate |
| **MapStruct** | 1.5.2 | Mapeamento DTO/Entity |
| **ArchUnit** | 1.2.1 | Testes de Arquitetura |

## 📁 Estrutura do Projeto
src/
├── main/
│ ├── java/
│ │ └── com.arthurbarbosa.hexagonal/
│ │ │
│ │ ├── HexagonalApplication.java # Main class
│ │ │
│ │ ├── adapters/ # Adapters Layer
│ │ │ ├── in/ # Driving Adapters (input)
│ │ │ │ ├── consumer/ # Kafka consumers
│ │ │ │ │ └── CustomerConsumer.java
│ │ │ │ └── controller/ # REST controllers
│ │ │ │ └── CustomerController.java
│ │ │ │
│ │ │ └── out/ # Driven Adapters (output)
│ │ │ ├── client/ # HTTP Clients (Feign)
│ │ │ │ └── FindAddressByZipCodeClient.java
│ │ │ ├── mapper/ # DTO mappers
│ │ │ │ └── AddressResponseMapper.java
│ │ │ └── repository/ # JPA/MongoDB repositories
│ │ │ └── CustomerRepository.java
│ │ │
│ │ ├── application/ # Application Layer
│ │ │ └── service/ # Use case implementations
│ │ │ └── CustomerService.java
│ │ │
│ │ ├── config/ # Spring Configuration
│ │ │ ├── FeignConfig.java
│ │ │ ├── KafkaConfig.java
│ │ │ └── MongoConfig.java
│ │ │
│ │ └── core/ # Core/Domain Layer
│ │ ├── domain/ # Domain Entities
│ │ │ ├── Address.java
│ │ │ └── Customer.java
│ │ │
│ │ ├── usecase/ # Business use cases
│ │ │ ├── InsertCustomerUseCase.java
│ │ │ └── ports/ # Ports (interfaces)
│ │ │ ├── in/ # Input ports
│ │ │ │ └── InsertCustomerInputPort.java
│ │ │ └── out/ # Output ports
│ │ │ ├── FindAddressByZipCodeOutputPort.java
│ │ │ └── InsertCustomerOutputPort.java
│ │ │
│ │ └── exceptions/ # Domain exceptions
│ │ └── BusinessException.java
│ │
│ └── resources/
│ ├── application.yaml # Main configuration
│ └── application-dev.yaml # Dev profile
│
└── test/ # Testes
├── java/
│ └── com.arthurbarbosa.hexagonal/
│ ├── unit/ # Unit tests
│ ├── integration/ # Integration tests
│ └── architecture/ # ArchUnit tests
└── resources/

## 🔧 Configuração da Aplicação

### application.yaml

```yaml
spring:
  application:
    name: hexagonal
  
  data:
    mongodb:
      host: localhost
      port: 27017
      authentication-database: admin
      username: root
      password: root
      database: hexagonal

client:
  address:
    url: http://localhost:8082/addresses

# Kafka configuration
spring:
  kafka:
    bootstrap-servers: localhost:29092
    consumer:
      group-id: hexagonal-group
      auto-offset-reset: earliest
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
🚀 Como Executar
Pré-requisitos
bash
- Java 21
- Docker e Docker Compose
- MongoDB (ou via Docker)
- Kafka

# Todos os testes
./mvnw test

# Testes de arquitetura
./mvnw test -Dtest=ArchitectureTest

# Testes unitários
./mvnw test -Dtest=*UnitTest

# Testes de integração
./mvnw test -Dtest=*IntegrationTest

🛠️ Comandos Úteis
bash
# Build do projeto
./mvnw clean package

# Rodar aplicação
./mvnw spring-boot:run

# Rodar com profile específico
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# Gerar relatório de testes
./mvnw surefire-report:report

# Verificar dependências
./mvnw dependency:tree
🐛 Troubleshooting
Erro de conexão com MongoDB
bash
# Verificar se MongoDB está rodando
docker ps | grep mongodb

# Verificar logs
docker logs mongodb_hexagonal

# Conectar manualmente
mongosh mongodb://root:root@localhost:27017
Erro de dependência MapStruct
bash
# Limpar cache do Maven
./mvnw clean

# Recompilar
./mvnw compile
Arquitetura Hexagonal - Regras
java
// ✅ Core NÃO pode depender de adapters
// ✅ Application pode depender de Core
// ✅ Adapters podem depender de Application e Core
// ❌ Core NÃO pode ter anotações Spring
📝 Padrão de Commits
bash
feat(hexagonal): add new feature
fix(adapter): fix bug in adapter
test(archunit): add architecture tests
refactor(core): refactor domain entity
docs(readme): update documentation
🎓 Princípios Aplicados
Dependency Inversion: Core não depende de infraestrutura

Ports & Adapters: Isolamento das tecnologias externas

Domain-Driven Design: Entidades ricas e value objects

Clean Architecture: Camadas bem definidas

Separation of Concerns: Responsabilidades isoladas

👥 Autor
Arthur Barbosa

📄 Licença
MIT

Happy Coding with Hexagonal Architecture! 🏗️🚀
