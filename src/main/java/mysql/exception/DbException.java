package mysql.exception;

/*
 * Exceção personalizada para tratar erros
 * relacionados ao banco de dados.
 *
 * Como ela estende RuntimeException,
 * não precisamos obrigar o uso de try/catch
 * em todos os lugares.
 */
public class DbException extends RuntimeException {


    /*
     * Identificador de versão da classe.
     *
     * É recomendado quando criamos classes
     * que herdam de Exception.
     */
    private static final long serialVersionUID = 1L;



    /*
     * Construtor que recebe apenas uma mensagem.
     *
     * Exemplo:
     *
     * throw new DbException("Erro ao conectar");
     */
    public DbException(String msg) {

        super(msg);
    }



    /*
     * Construtor que recebe:
     *
     * - mensagem personalizada
     * - erro original que causou o problema
     *
     * Mantém a causa real do erro.
     *
     * Exemplo:
     *
     * throw new DbException(
     *     "Erro no banco de dados",
     *     e
     * );
     */
    public DbException(String msg, Throwable cause) {

        super(msg, cause);
    }
}
