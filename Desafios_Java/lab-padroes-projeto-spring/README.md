# Relatório de Ajustes e Melhorias - Lab Padrões de Projeto Spring

Este documento detalha todos os ajustes, correções de dependências, atualizações de versão e melhorias de segurança de código realizados no projeto **`lab-padroes-projeto-spring`** (desenvolvido originalmente no Digital Innovation One - DIO).

---

## 1. Configuração do Ambiente do Desenvolvedor
O projeto foi calibrado para rodar nativamente com a seguinte stack de tecnologias:
* **Apache Maven**: `3.9.16`
* **Java Version**: `21.0.11 (LTS)` (Oracle Corporation)
* **Sistema Operacional**: Windows 11 (amd64)
* **Codificação Padrão**: UTF-8 (`pt_BR`)

---

## 2. Correções no Arquivo `pom.xml`

O arquivo `pom.xml` original apresentava incompatibilidades críticas de versões futuras e artefatos descontinuados. As seguintes alterações foram efetuadas:

1. **Atualização da Versão do Spring Boot**:
   * *De*: `4.1.0` (Versão inexistente/futura)
   * *Para*: `3.2.5` (Versão estável com suporte completo e nativo ao **Java 21**).
2. **Correção do Starter Web**:
   * *De*: `spring-boot-starter-webmvc` (Incorreto)
   * *Para*: `spring-boot-starter-web` (Artefato oficial do ecossistema).
3. **Substituição do OpenAPI / Swagger (Spring Boot 3)**:
   * *Removido*: `springdoc-openapi-ui` (Legado para Spring Boot 2, que gerava erro de build faltando `${openapi.version}`).
   * *Adicionado*: `springdoc-openapi-starter-webmvc-ui` (Versão `2.5.0`), compatível com o ecossistema Jakarta EE / Spring Boot 3.
4. **Alinhamento do Spring Cloud**:
   * Atualizado para a versão compatível `2023.0.1` gerenciada via `spring-cloud-dependencies`.
5. **Padronização de Testes**:
   * Substituídos os artefatos quebrados de teste pelo `spring-boot-starter-test`.

---

## 3. Resolução de Alertas de Compilação e Null Safety

Durante a análise estática da IDE (Eclipse JDT / VS Code), foram corrigidos alertas de segurança de nulos (`Null type safety`) e imports não utilizados:

### A. Limpeza de Imports
* Identificado o aviso `The import jakarta.persistence.Entity is never used` em classes onde a anotação não era necessária, mantendo o código limpo e otimizado.

### B. Proteção contra `NullPointerException` e Null Safety (`@NonNull`)
O compilador exigia conversões seguras para evitar falhas em variáveis encapsuladas (`Long`, `String`, `Endereco`). O método de persistência com integração ViaCEP foi reestruturado para validar rigorosamente a presença de nulos:

```java
private void salvarClienteComCep(Cliente cliente) {
    // Validação estrita para evitar nulos e satisfazer o compilador
    if (cliente == null || cliente.getEndereco() == null) {
        throw new IllegalArgumentException("O cliente e o endereço não podem ser nulos.");
    }

    String cep = cliente.getEndereco().getCep();
    
    if (cep == null || cep.trim().isEmpty()) {
        throw new IllegalArgumentException("O CEP do endereço não pode ser nulo ou vazio.");
    }

    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
        Endereco novoEndereco = viaCepService.consultarCep(cep);
        if (novoEndereco == null) {
            throw new RuntimeException("Não foi possível encontrar o endereço para o CEP informado: " + cep);
        }
        enderecoRepository.save(novoEndereco);
        return novoEndereco;
    });
    
    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);
}
```

---

## 4. Benefícios e Conclusão

* **Build Estável**: O projeto compila sem erros de dependências ausentes (`Missing artifact`).
* **Resiliência**: Tratamento preventivo de dados nulos nas regras de negócio de consulta de CEP e atualização de cadastros.
* **Modernização**: Adoção das especificações modernas do Jakarta EE e Spring Boot 3 no Java 21.
