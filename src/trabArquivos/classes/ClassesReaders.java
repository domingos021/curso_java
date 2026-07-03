package trabArquivos.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

    /*
    CONCEITOS DAS CLASSES:

    FileReader =>
    - Stream de leitura de caracteres a partir de arquivos.
    - Lê caractere por caractere (baixo nível).
    - Normalmente não é usado sozinho, apenas como base.

    BufferedReader =>
    - Envolve o FileReader para melhorar performance.
    - Lê em blocos (buffer), não caractere por caractere.
    - Permite leitura linha por linha com readLine().
    - Mais eficiente para arquivos grandes.

    Scanner =>
    - Classe mais simples e de alto nível.
    - Faz parsing automático de tipos (int, double, String etc).
    - Pode ler arquivos ou entrada do teclado.
    - Mais lento que BufferedReader, mas mais fácil de usar.
    */

public class ClassesReaders {

    public static void main(String[] args) {

        String path = "C:\\temp01\\in.txt";

        /*
         ============================
         ✔ BufferedReader (mais usado em nível intermediário/avançado)
         ============================
         //try (BufferedReader br = new BufferedReader(new FileReader(path)))
        */
        /*
            Criamos objetos encadeados (composição), ou seja, um objeto dentro do outro.

            BufferedReader é o objeto responsável por ler o arquivo de forma eficiente,
            mas ele não acessa o arquivo diretamente.

            Ele precisa de um FileReader como fonte de leitura.

            FileReader é o objeto responsável por abrir o arquivo e fornecer os caracteres
            para leitura.

            O path é uma String que representa o caminho do arquivo no sistema operacional.

            O BufferedReader atua como um wrapper (classe “envoltória”),
            adicionando uma camada de performance e leitura por linhas
            em cima do FileReader.
        */
        //Try-with-resources é mais simples de ler, menos verboso e mais seguro do que o try tradicional,
        // pois garante o fechamento automático dos recursos, mesmo em caso de exceções.
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine(); // le uma linha do arquivo

            // Enquanto a linha lida não for null (ou seja, enquanto ainda existir conteúdo no arquivo),
            // imprime a linha atual e em seguida lê a próxima linha.
            //
            // Quando readLine() retorna null, significa que chegou ao final do arquivo (EOF),
            // então o laço é encerrado.
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro BufferedReader: " + e.getMessage());
        }

        /*
         ============================
         ✔ Scanner (mais simples e didático)
         ============================
        */
        try (Scanner sc = new Scanner(new FileReader(path))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Erro Scanner: " + e.getMessage());
        }
    }
}