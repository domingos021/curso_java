package mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {


        /*
         * Testa a conexão usando a classe DB.
         *
         * A classe DB:
         *
         * - lê o arquivo db.properties
         * - pega usuário, senha e URL
         * - cria a conexão com MySQL
         */

        /*
         * Creates a Connection variable named conn and calls
         * DB.getConnection(), which contains all the information
         * needed to connect to the database.
         */
        try (Connection conn = DB.getConnection()) {
            DB.closeConnection();


            /*
             * isClosed() verifica se a conexão está fechada.
             *
             * Retorna:
             *
             * false -> conexão aberta
             * true  -> conexão fechada
             */
            System.out.println("Conexão realizada com sucesso!");

            System.out.println(
                    "Banco conectado: " + !conn.isClosed()
            );


        } catch (SQLException e) {


            System.out.println("Erro ao conectar:");

            e.printStackTrace();
        }
    }
}

/*
TesteConexao.java
        |
        ↓
DB.getConnection()
        |
        ↓
db.properties
        |
        ↓
jdbc:mysql://localhost:3306/cursojdbc
        |
        ↓
Maven
        |
        ↓
mysql-connector-j-9.7.0.jar
        |
        ↓
MySQL Server

programa02
│
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── mysql
        │       ├── DB.java
        │       ├── TesteConexao.java
        │       └── exception
        │           └── DbException.java
        │
        └── resources
            └── db.properties



  TesteConexao.java
        |
        ↓
Responsável apenas por testar
        |
        ↓
DB.java
        |
        ↓
Responsável por criar conexão
        |
        ↓
db.properties
        |
        ↓
Responsável pelas configurações
        |
        ↓
MySQL
 */


/*
[ Programa Main ]          [ DB.java ]           [ ClassLoader ]       [ Driver MySQL ]       [ Banco MySQL ]
       │                        │                      │                      │                     │
      │─── 1. getConnection() ─►│                      │                      │                     │
       │                        │── 2. conn == null? ─►│                      │                     │
       │                        │      (SIM)           │                      │                     │
       │                        │                      │                      │                     │
       │                        │── 3. getResourceAsStream("db.properties") ─►│                     │
       │                        │◄─ 4. Retorna InputStream ───────────────────│                     │
       │                        │                      │                      │                     │
       │                        │── 5. Carrega credenciais (url, user, senha) │                     │
       │                        │                      │                      │                     │
       │                        │── 6. DriverManager.getConnection() ─────────►│                     │
       │                        │                                             │── 7. Handshake TCP ─►│
       │                        │                                             │◄─ 8. Conexão OK ────│
       │                        │◄── 9. Retorna Objeto Connection ────────────│                     │
       │                        │                                             │                     │
       │                        │── 10. Salva objeto em 'conn'                │                     │
       │◄── 11. Retorna conn ───│                                             │                     │
 */