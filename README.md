# CRUD Imóveis em Java com PostgreSQL

Este é um projeto simples de CRUD (Create, Read, Update, Delete) para gerenciar informações de imóveis usando Java e PostgreSQL. O sistema permite a criação, leitura, atualização e exclusão de registros de imóveis.
## Descrição

Este projeto é um exemplo prático de como implementar operações básicas de um CRUD em Java usando PostgreSQL como banco de dados. Ele pode ser usado como base para projetos mais complexos que requerem operações de manipulação de dados em um banco de dados relacional.

## Funcionalidades

- **Criar**: Adicionar novos imóveis ao banco de dados.
- **Ler**: Listar todos os imóveis ou buscar por propriedades específicas.
- **Atualizar**: Modificar as informações de um imóvel existente.
- **Deletar**: Remover um imóvel do banco de dados.

## Requisitos

- **Java JDK** (versão 8 ou superior)
- **PostgreSQL** (versão 9.6 ou superior)
- **Bibliotecas/Dependências Java**:
  - PostgreSQL JDBC Driver (`org.postgresql:postgresql`)

## Configuração

### Banco de Dados

1. **Instale o PostgreSQL**.
2. **Crie um banco de dados para o projeto**:
   ```sql
   CREATE DATABASE "CRUD";
3. **Crie a tabela de imóveis no banco de dados**:
      ```sql
   CREATE TABLE "Building" (
    id SERIAL PRIMARY KEY,
    address VARCHAR(300) NOT NULL,
    building_scale VARCHAR(40) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    description TEXT
    );
4. **Baixe o Driver JDBC**:
- Acesse o site oficial do PostgreSQL JDBC Driver: [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)

- Baixe o arquivo JAR apropriado (por exemplo, postgresql-42.6.0.jar).

5. **Adicione o JAR ao Classpath**:
- No Eclipse: Clique com o botão direito no seu projeto → Build Path → Add External Archives... e selecione o arquivo JAR baixado.
- No IntelliJ IDEA: Vá para File → Project Structure → Modules → Dependencies → + → JARs or directories e selecione o arquivo JAR.
- Certifique-se de substituir a versão 42.6.0 pela versão mais recente disponível, se necessário.
Com estas adições, seu projeto Java será capaz de se conectar ao banco de dados PostgreSQL usando o driver JDBC.
