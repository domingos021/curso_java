package mysql;

import mysql.exception.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            // 1. Obtém a conexão
            conn = DB.getConnection();

            // 2. Instrução SQL com '?' para evitar SQL Injection
            String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

            // 3. Prepara o comando e pede o ID gerado
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 4. Preenche os parâmetros (1º '?' e 2º '?')
            st.setString(1, "Maria Silva");
            st.setString(2, "maria.silva@email.com");

            // 5. Executa a inserção no banco
            int linhasAfetadas = st.executeUpdate();

            System.out.println("Inserção realizada com sucesso!");
            System.out.println("Linhas afetadas: " + linhasAfetadas);

            // 6. Recupera o ID AUTO_INCREMENT gerado pelo MySQL
            if (linhasAfetadas > 0) {
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGerado = rs.getInt(1);
                        System.out.println("ID gerado no banco: " + idGerado);
                    }
                }
            }

        } catch (SQLException e) {
            throw new DbException("Erro ao inserir registro: " + e.getMessage(), e);
        } finally {
            // 7. Fecha o Statement e a Conexão com segurança
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}