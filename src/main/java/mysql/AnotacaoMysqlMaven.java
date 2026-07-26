package mysql;

/*
 * ============================================================
 * CONFIGURANDO MYSQL CONNECTOR/J COM MAVEN NO INTELLIJ IDEA
 * ============================================================
 *
 * Objetivo:
 * Configurar um projeto Java para acessar o MySQL usando JDBC,
 * utilizando Maven para gerenciar dependências.
 *
 * Antes:
 * - O Connector era baixado manualmente.
 * - O arquivo .jar era adicionado no IntelliJ.
 *
 * Depois:
 * - Maven controla a dependência.
 * - O Connector é baixado automaticamente.
 * - Não precisamos adicionar .jar manualmente.
 *
 * ============================================================
 *
 * PASSO 1 - VERIFICAR O AMBIENTE
 * ============================================================
 *
 * Confirmamos:
 *
 * Java instalado:
 * JDK 25
 *
 * MySQL funcionando:
 *
 * mysql -u root -p
 *
 * Resultado:
 *
 * Welcome to the MySQL monitor.
 *
 * Confirmou:
 *
 * - Servidor MySQL ativo.
 * - Usuário root funcionando.
 * - Senha correta.
 *
 *
 * ============================================================
 *
 * PASSO 2 - TESTE INICIAL COM CONNECTOR MANUAL
 * ============================================================
 *
 * Baixamos:
 *
 * mysql-connector-j-9.7.0.jar
 *
 * Adicionamos no IntelliJ:
 *
 * File
 *  ↓
 * Project Structure
 *  ↓
 * Libraries
 *
 * O teste de conexão funcionou.
 *
 *
 * ============================================================
 *
 * PASSO 3 - MIGRAR PARA MAVEN
 * ============================================================
 *
 * Maven é usado profissionalmente para:
 *
 * - Gerenciar dependências.
 * - Controlar versões.
 * - Baixar bibliotecas.
 *
 *
 * ============================================================
 *
 * PASSO 4 - CRIAR pom.xml
 * ============================================================
 *
 * Criamos o arquivo:
 *
 * pom.xml
 *
 * na raiz:
 *
 * programa02
 *
 * ├── pom.xml
 * └── src
 *     └── mysql
 *         └── TesteConexao.java
 *
 *
 * ============================================================
 *
 * PASSO 5 - ADICIONAR MYSQL CONNECTOR NO MAVEN
 * ============================================================
 *
 * Dependência adicionada:
 *
 * <dependency>
 *     <groupId>com.mysql</groupId>
 *     <artifactId>mysql-connector-j</artifactId>
 *     <version>9.7.0</version>
 * </dependency>
 *
 *
 * O Maven:
 *
 * 1 - Acessa o repositório Maven.
 *
 * 2 - Baixa o Connector.
 *
 * 3 - Adiciona automaticamente ao projeto.
 *
 *
 * ============================================================
 *
 * PASSO 6 - RECONHECER COMO MAVEN NO INTELLIJ
 * ============================================================
 *
 * O IntelliJ mostrou o ícone:
 *
 * M
 *
 * no arquivo pom.xml.
 *
 * Abrimos:
 *
 * View
 *  ↓
 * Tool Windows
 *  ↓
 * Maven
 *
 * Depois:
 *
 * Reload All Maven Projects
 *
 *
 * ============================================================
 *
 * PASSO 7 - CONFIRMAR DEPENDÊNCIA
 * ============================================================
 *
 * Maven
 *
 * └── programa02
 *      └── Dependencies
 *
 * Apareceu:
 *
 * com.mysql:mysql-connector-j:9.7.0
 *
 *
 * Isso confirma:
 *
 * Maven está gerenciando o Connector.
 *
 *
 * ============================================================
 *
 * RESULTADO FINAL
 * ============================================================
 *
 * Antes:
 *
 * Projeto
 *  └── mysql-connector-j.jar
 *
 * Manual.
 *
 *
 * Depois:
 *
 * Projeto
 *  ├── pom.xml
 *  └── Maven
 *       └── mysql-connector-j
 *
 * Profissional.
 *
 *
 * Em novos projetos:
 *
 * 1 - Criar projeto Maven.
 *
 * 2 - Adicionar dependência no pom.xml.
 *
 * 3 - Maven baixa automaticamente.
 *
 * ============================================================
 */
public class AnotacaoMysqlMaven {

}