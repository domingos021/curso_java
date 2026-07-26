package mysql;

import mysql.exception.DbException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {


    /*
     * Carrega as configurações do arquivo:
     *
     * src/main/resources/db.properties
     *
     * Retorna um objeto Properties contendo:
     *
     * user
     * password
     * dburl
     */
    private static Properties loadProperties() {

        Properties prop = new Properties();


        /*
         * O ClassLoader procura automaticamente
         * dentro da pasta resources do Maven.
         */
        try (InputStream inputStream = DB.class.getClassLoader()
                .getResourceAsStream("db.properties")) {


            if (inputStream == null) {

                throw new DbException(
                        "Arquivo db.properties não encontrado!"
                );
            }


            // Carrega as propriedades do arquivo
            prop.load(inputStream);


        } catch (IOException e) {

            throw new DbException(
                    "Erro lendo arquivo de configuração",
                    e
            );
        }


        return prop;
    }



    /*
     * Método responsável por criar a conexão com o MySQL.
     */
    public static Connection getConnection() {

        Properties prop = loadProperties();


        String url = prop.getProperty("dburl");
        String usuario = prop.getProperty("user");
        String senha = prop.getProperty("password");


        try {

            return DriverManager.getConnection(
                    url,
                    usuario,
                    senha
            );


        } catch (SQLException e) {

            throw new DbException(
                    "Erro ao conectar no banco de dados",
                    e
            );
        }
    }
}