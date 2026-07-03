package trabArquivos.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

    /*
    CONCEITOS DAS CLASSES:

    FileWriter =>
    - Stream de escrita de caracteres em arquivos.
    - Escreve caractere por caractere ou Strings (baixo nível).
    - Normalmente não é usado sozinho, apenas como base.

    FORMAS DE INSTANCIAR O FILEWRITER:
    - new FileWriter(path)        => Cria um novo arquivo ou recria (sobrescreve) o existente.
    - new FileWriter(path, true)  => Acrescenta (append) o novo conteúdo ao final do arquivo existente.

    BufferedWriter =>
    - Envolve o FileWriter para melhorar performance.
    - Acumula os dados em um bloco de memória (buffer) antes de gravar no disco.
    - Permite escrita eficiente de linhas e quebras de linha com newLine().
    - Mais eficiente para grandes volumes de escrita.

    Scanner =>
    - Classe mais simples e de alto nível.
    - Faz parsing automático de tipos (int, double, String etc).
    - Pode ler arquivos ou entrada do teclado.
    - Mais lento que BufferedReader, mas mais fácil de usar.
    */

public class ClassesWriters {

    public static void main(String[] args) {

        String[] lines = new String[] {"Good morning", "Good afternoon", "Good evening", "Good night"," Sr Domingos Dinis"};
        String path = "C:\\temp01\\out.txt";
        String path2 = "C:\\temp01\\in.txt";

        /*
         ============================
         ✔ BufferedWriter (mais usado em nível intermediário/avançado)
         ============================
         //try (BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
        */
        /*
            Criamos objetos encadeados (composição), ou seja, um objeto dentro do outro.

            BufferedWriter é o objeto responsável por escrever no arquivo de forma eficiente,
            mas ele não acessa o arquivo diretamente para gravar.

            Ele precisa de um FileWriter como fonte de escrita.

            FileWriter é o objeto responsável por abrir/criar o arquivo e receber os caracteres
            para escrita.

            O path é uma String que representa o caminho do arquivo no sistema operacional.

            O BufferedWriter atua como um wrapper (classe “envoltória”),
            adicionando uma camada de performance e escrita otimizada
            em cima do FileWriter.
        */
        //Try-with-resources garante o fechamento automático do arquivo após o bloco
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            // Escreve a string no buffer do arquivo de forma dinâmica através do laço.
            // O método newLine() insere a quebra de linha correta dependendo do sistema operacional.
            for (String line : lines) {
                bw.write(line);
                bw.newLine(); // Adiciona quebra de linha após cada saudação
                System.out.println("Escrevendo no arquivo: " + line);
            }

        } catch (IOException e) {
            System.out.println("Erro BufferedWriter: " + e.getMessage());
        }

        /*
         ============================
         ✔ Scanner (para leitura e comparação no estudo)
         ============================
        */
        try (Scanner sc = new Scanner(new FileReader(path2))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Erro Scanner: " + e.getMessage());
        }
    }
}