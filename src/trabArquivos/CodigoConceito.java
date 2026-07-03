package trabArquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CodigoConceito {
    public static void main(String[] args) {

        /*
         * Instanciamos um objeto da classe ou do tipo File.
         *
         * O objeto File representa um arquivo ou diretório do sistema de arquivos,
         * encapsulando informações como seu caminho (path).
         *
         * Ele não realiza a leitura nem a escrita do arquivo.
         * Sua função é fornecer uma referência para que outras classes,
         * como FileReader, BufferedReader, FileWriter ou Scanner,
         * possam manipular o arquivo.
         */

       /*

        * A classe Scanner é utilizada para realizar leituras de dados.
        *
        * Exemplo para leitura pelo teclado:
        *
        * ```
          Scanner sc = new Scanner(System.in);
          ```
        *
        * Nesse exemplo:
        *
        * * Scanner é a classe.
        * * sc é a referência para o objeto criado.
        * * new Scanner(...) cria uma nova instância da classe Scanner.
        * * System.in representa a entrada padrão do sistema, ou seja, o teclado.
        *
        * Entretanto, o Scanner não se limita à leitura pelo teclado.
        * Ele também pode receber outras fontes de dados, como um arquivo.
        *
        * Exemplo:
        *
        * ```
          Scanner sc = new Scanner(file);
          ```
        *
        * Nesse caso, o Scanner utilizará o objeto File como origem dos dados,
        * permitindo ler o conteúdo do arquivo em vez da entrada do teclado.
          */

        File file = new File("C:\\temp01\\in.txt");;
        // Mostra o caminho absoluto do arquivo no sistema operacional
        System.out.println(file.getAbsolutePath());

       // Verifica se o arquivo existe no caminho informado (true ou false)
        System.out.println(file.exists());

        /*
        TESTES DO ARQUIVO

        System.out.println("Existe? " + file.exists());
            // Verifica se o arquivo realmente existe no diretório especificado

        System.out.println("É arquivo? " + file.isFile());
            // Verifica se o caminho aponta para um arquivo (e não uma pasta)

        System.out.println("Pode ler? " + file.canRead());
            // Verifica se o programa tem permissão para ler o arquivo

        System.out.println("Caminho: " + file.getAbsolutePath());
            // Exibe o caminho completo e absoluto do arquivo no sistema
        */


        // O objeto File representa o caminho do arquivo que será manipulado.
        // Scanner sc = new Scanner(System.in)

        /*
         * O try-with-resources é a forma moderna de trabalhar com recursos
         * que precisam ser fechados, como Scanner, BufferedReader, FileWriter,
         * Connection, entre outros.
         *
         * Ao final do bloco try, o Java fecha automaticamente o recurso
         * chamando o método close(), mesmo que ocorra uma exceção.
         *
         * Dessa forma, não é necessário utilizar um bloco finally apenas
         * para chamar sc.close(), tornando o código mais limpo, seguro
         * e seguindo as boas práticas do Java moderno.
         */
        try (Scanner sc = new Scanner(file)) {

            /*
             * Enquanto ainda existir uma próxima linha no arquivo,
             * o laço continuará executando.
             */
            while (sc.hasNextLine()) {

                /*
                 * nextLine() lê a linha atual do arquivo e avança
                 * automaticamente para a próxima linha.
                 *
                 * A linha lida é enviada para o console através
                 * do System.out.println().
                 */
                System.out.println(sc.nextLine());
            }

        } catch (IOException e) {
            //retorna a mensagem armazenada no próprio objeto da exceção,
            // que foi criada pela classe nativa do Java (ou pela biblioteca que lançou a exceção).
            System.out.println("Erro " + e.getMessage());
        }
    }
}


    /*
     * IOException (Input/Output Exception)
     *
     * É uma exceção muito comum em Java quando trabalhamos com
     * operações de Entrada e Saída de dados (I/O - Input/Output).
     *
     * Essa exceção representa erros que podem ocorrer durante
     * a manipulação de recursos externos ao programa, como
     * arquivos, diretórios, conexões de rede e streams.
     *
     * Exemplos de situações que podem gerar uma IOException:
     *
     * - Leitura de arquivos;
     * - Escrita de arquivos;
     * - Cópia de arquivos;
     * - Leitura e gravação de imagens;
     * - Comunicação pela rede (Sockets);
     * - Download e upload de arquivos;
     * - Manipulação de Streams (InputStream e OutputStream).
     *
     * Em resumo:
     * Sempre que um programa precisar ler ou gravar dados em um
     * recurso externo, existe a possibilidade de ocorrer uma
     * IOException, que deverá ser tratada ou propagada.
     */

/*
CONCEITOS DAS CLASSES
FileReader => (stream de leitura de caracteres a partir de arquivos
BufferedReader =>(mais rapido)
 */



    /*
    Com try tradicional
    1º momento

    sc
     │
     ▼
    null

    2º momento

    sc
     │
     ▼
    Scanner
    Com try-with-resources
    sc
     │
     ▼
    Scanner

    Ela já começa referenciando o objeto Scanner, sem passar pelo estado null.
     */
