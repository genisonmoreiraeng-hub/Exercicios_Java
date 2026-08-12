# Relatório Consolidado: Desenvolvimento, Infraestrutura, Solução de Erros e Evoluções da API de Orçamento (Spring Boot & Spring AI)

Este documento consolida toda a jornada de desenvolvimento, arquitetura, diagnóstico de problemas de infraestrutura, correções e melhorias avançadas aplicadas no projeto da API de controle orçamentário (`budgeting`), alinhado aos padrões e à trilha de Spring AI.

---

## 1. Arquitetura e Funcionalidades Implementadas

A aplicação foi desenvolvida com base em princípios modernos de engenharia de software e inteligência artificial multimodal.

* **Endpoints RESTful (`TransactionController`):**
* `POST /transactions`: Criação de transações financeiras.


* `GET /transactions/{category}`: Listagem filtrada de transações por categoria.


* `GET /transactions/id/{id}`: Busca específica de registros por ID.


* `PUT /transactions/{id}` & `PATCH /transactions/{id}`: Atualização completa e parcial de transações.


* `DELETE /transactions/{id}`: Exclusão de registros financeiros.




* **Inteligência Artificial Multimodal (`/transactions/ai`):**
* **Processamento de Áudio**: Recepção de arquivos via `multipart/form-data`.


* **TranscriptionModel**: Conversão de áudio para texto.


* **ChatClient**: Interpretação de comandos com *Tools* (ferramentas) injetadas para interagir diretamente com as regras de negócio e persistência.


* **TextToSpeechModel**: Conversão da resposta da IA de volta para formato de áudio (`audio/mp3`).


* **System Prompt e Contexto Dinâmico**: Configuração da IA como consultor financeiro integrado aos dados transacionais.





---

## 2. Configuração de Ambiente e Infraestrutura

* **Toolchain e Ferramentas:**
* Padronização para **Java 21** e **Gradle Wrapper (versão 9.5.1)**.


* Ajustes de sintaxe no `build.gradle` para a correta declaração de dependências e anotações do Lombok.




* **Banco de Dados e Docker:**
* Utilização do **MySQL 8.4 (LTS)** encapsulado via Docker.


* Mapeamento explícito de portas (`3307:3306` ou `3306:3306`).


* Correção de protocolos de comunicação no Windows, forçando o uso de TCP/IP (`127.0.0.1:3306`) e eliminando dependências de arquivos de socket locais (`mysqld.sock`).





---

## 3. Diagnóstico e Resolução de Erros (Troubleshooting)

* **Conflitos de Build (Windows/OneDrive):** Resolução de travamentos de I/O (`Unable to delete directory`) causados por instâncias persistentes do Gradle/Java.


* **Integridade de Dados:** Correção do erro *Data truncated for column 'category'* através do ajuste de mapeamentos e constraints de Enums no JPA.


* **Sintaxe de Payloads HTTP:** Eliminação de erros de parsing JSON (*trailing commas* e formatação de chaves) em arquivos de teste `.http`.


* **Requisições Multipart:** Correção do erro `MalformedStreamException: Stream ended unexpectedly` por meio da estruturação correta de *boundaries* e marcações de encerramento (`--boundary--`).


* **Segurança e Autenticação:** Solução de falhas de acesso negado (`Access denied for user 'root'`) com a configuração correta de credenciais e parâmetros de conexão.


* **Null Safety:** Proteção de fluxos reativos utilizando `.filter(Objects::nonNull)` e lambdas explícitas.



---

## 4. Melhorias e Evoluções Futuras Implementadas

Com base nas diretrizes de evolução do projeto, as seguintes melhorias estruturais foram incorporadas:

* **Validação de Entrada (Bean Validation):** Aplicação de anotações como `@NotNull`, `@NotBlank` e `@Positive` nos DTOs de requisição para barrar dados inválidos na camada de entrada.


* **Tratamento Global de Exceções (`@RestControllerAdvice`):** Centralização do tratamento de erros em uma classe dedicada (`GlobalExceptionHandler`), convertendo exceções de validação em payloads JSON limpos e padronizados.


* **Testes de Integração com Testcontainers:** Configuração de testes automatizados utilizando instâncias reais de MySQL isoladas em containers Docker.


* **Documentação Interativa (Springdoc OpenAPI / Swagger UI):** Disponibilização da interface gráfica em `http://localhost:8080/swagger-ui/index.html` para testes práticos dos endpoints.



---

## 5. Guia Rápido de Execução

1. **Subir Infraestrutura:** `docker compose up -d`

2. **Executar Aplicação:** `./gradlew bootRun`

3. **Acessar Documentação:** `http://localhost:8080/swagger-ui/index.html`

4. **Testar Endpoints:** Utilizar arquivos `.http` ou ferramentas como RestClient.