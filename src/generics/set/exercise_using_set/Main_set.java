package generics.set.exercise_using_set;

import generals_utils.utils.Leitor;
import generics.set.exercise_using_set.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

public class Main_set {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Define o padrão de formatação decimal como Estados Unidos.
            Locale.setDefault(Locale.US);
            // Utiliza a classe utilitária Leitor passando o Scanner.
            //String path = "C:\\temp01\\acessos.txt";
            String path = Leitor.lerTexto(sc, "Caminho do arquivo: ");


            try (BufferedReader br  = new BufferedReader(new FileReader(path)) ) {
                /*
                 * Utilizamos um HashSet porque:
                 * - a ordem dos elementos não é importante;
                 * - não permite elementos duplicados;
                 * - oferece inserção e consulta eficientes.
                 * Neste exercício, queremos apenas contar os usuários registrados
                 * sem nos preocupar com a ordem em que foram lidos.
                 */
                Set<LogEntry> set = new HashSet<>();
                String line = br.readLine();

                while (line != null) {
                    /*
                     * Recorta a String em várias partes utilizando o espaço em branco (" ")
                     * como delimitador. Cada parte é armazenada em uma posição do vetor fields.
                     */
                    String[] fields = line.split(" ");

                    String username = fields[0];
                    Date moment = Date.from(Instant.parse(fields[1]));

                    /*
                     *  Cria um objeto novo de registro de acesso (LogEntry) com o nome do usuário
                     * e a data/hora do acesso. Em seguida, adiciona esse objeto ao conjunto (Set).
                     * Se já existir um objeto considerado igual (de acordo com os métodos
                     * equals() e hashCode() definidos na classe LogEntry), ele não será adicionado.
                     */
                    set.add(new LogEntry(username, moment));

                   //leitura da proxima linha
                    line = br.readLine();

                }

                System.out.println("Total users: " + set.size()); // exibe somente a quantidade

                //exibe a toString da classa
                System.out.println("Users:");
                for (LogEntry logEntry : set) {
                    System.out.println(logEntry);
                }


            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo" + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}