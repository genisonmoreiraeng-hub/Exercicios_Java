# API Inteligente de Orçamento com Spring Boot e Spring AI

## O que o projeto faz
Desenvolvemos uma API Inteligente integrada com Spring Boot e Spring AI, capaz de interpretar comandos de voz, transformar áudio em texto, acionar funções reais da aplicação e gerar respostas em áudio para a pessoa usuária. O projeto evolui uma aplicação de orçamento financeiro (`budgeting`) que conecta IA Generativa a uma arquitetura Java organizada.

---

## Quais tecnologias foram usadas
* **Java 21**
* **Spring Boot** (com Spring Web, Spring MVC e Spring Validation)
* **Spring AI** (utilizando `TranscriptionModel`, `ChatClient`, *Tool Calling* e `TextToSpeechModel`)
* **MySQL 8.4 (LTS)** via Docker
* **Gradle Wrapper (9.5.1)**
* **Springdoc OpenAPI (Swagger UI)** para documentação interativa
* **Testcontainers** para testes de integração automatizados

---

## Qual melhoria você implementou
Além da arquitetura base de IA multimodal e endpoints RESTful (`/transactions`), implementamos melhorias estruturais fundamentais para produção:
* **Validação de Entrada (Bean Validation):** Anotações como `@NotNull`, `@NotBlank` e `@Positive` nos DTOs de requisição para barrar dados inválidos logo na camada de entrada.
* **Tratamento Global de Exceções (`@RestControllerAdvice`):** Centralização dos erros de validação em uma classe dedicada (`GlobalExceptionHandler`), convertendo-os em respostas JSON limpas e padronizadas.
* **Testes de Integração com Testcontainers:** Isolação e validação do banco MySQL rodando em containers Docker durante os testes.
* **Documentação Interativa:** Disponibilização da interface do Swagger UI (`/swagger-ui/index.html`) para visualização e testes dos endpoints.

---

## Como executar a aplicação
1. **Subir a infraestrutura do banco de dados via Docker:**
   ```bash
   docker compose up -d
   ```

2. **Executar a aplicação Spring Boot:**
   ```bash
   ./gradlew bootRun
   ```

3. **Acessar a Documentação Interativa (Swagger UI):**
   Abra no navegador: `http://localhost:8080/swagger-ui/index.html`

---

## Como testar o fluxo principal
* **Endpoints REST Tradicionais:** Utilize a interface do Swagger ou arquivos `.http` para realizar requisições `POST`, `GET`, `PUT`, `PATCH` e `DELETE` no caminho `/transactions`.
* **Fluxo de Inteligência Artificial Multimodal (`/transactions/ai`):**
  1. Envie uma requisição do tipo `multipart/form-data` contendo um arquivo de áudio (ex: `recording-1.m4a`).
  2. O sistema utiliza o `TranscriptionModel` para transcrever o áudio.
  3. O `ChatClient` interpreta a intenção utilizando *Tool Calling* conectado às regras de negócio.
  4. O sistema processa os dados, persiste as informações e retorna a resposta convertida em áudio (`audio/mp3`) através do `TextToSpeechModel`.

---

## O que você aprendeu durante o desafio
* Como integrar modelos de Inteligência Artificial Generativa diretamente a fluxos de negócio reais em aplicações Java.
* A importância de manter uma arquitetura limpa e separação de responsabilidades ao utilizar recursos avançados de *Tool Calling*, transcrição e síntese de voz.
* Diagnóstico e resolução avançada de problemas de infraestrutura (como compatibilidade de conexões Docker/MySQL, tratamento de arquivos multipart e gestão de dependências no Gradle).
* Aplicação de boas práticas de robustez com validação de dados, tratamento global de exceções e testes automatizados com containers.
```
