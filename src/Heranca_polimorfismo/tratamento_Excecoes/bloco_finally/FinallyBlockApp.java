package Heranca_polimorfismo.tratamento_Excecoes.bloco_finally;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class FinallyBlockApp {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        File file = new File("c:\\temp\\in.txt");

        // Inicialmente o Scanner não referencia nenhum objeto.
        // Ele será criado dentro do bloco try.
        Scanner sc = null;

        try {

            // Tenta abrir o arquivo.
            sc = new Scanner(file);

            // Lê todas as linhas do arquivo.
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
          //pega o erro se não encontrar o arquivo file
        } catch (FileNotFoundException e) {

            // Exibe informações detalhadas da exceção.
            e.printStackTrace();

            // Exibe uma mensagem mais amigável ao usuário.
            System.out.println("Error opening file: " + e.getMessage());

        } finally {

            // O bloco finally sempre será executado,
            // ocorrendo ou não uma exceção.

            // Fecha o Scanner somente se ele tiver sido criado.
            if (sc != null) {
                sc.close();
                System.out.println("Scanner fechado com sucesso.");
            }
            System.out.println("Finally executado com exito ");

        }

    }

}

    /*
    ===============================================================================
                                    BLOCO finally
    ===============================================================================

    CONCEITO
    ---------
    O bloco finally é um bloco opcional que contém código que será executado
    independentemente de ocorrer ou não uma exceção.

    Em outras palavras:

    • Se nenhuma exceção ocorrer → o finally será executado.
    • Se uma exceção for capturada → o finally também será executado.

    Sua principal finalidade é liberar recursos utilizados pelo programa.

    Exemplos clássicos:

    • Fechar um arquivo.
    • Fechar um Scanner.
    • Encerrar uma conexão com o banco de dados.
    • Fechar uma conexão de rede.
    • Liberar qualquer outro recurso utilizado durante o processamento.

    ===============================================================================
                                      SINTAXE
    ===============================================================================

    try {

        // Código que pode lançar uma exceção.

    }
    catch (ExceptionType e) {

        // Trata a exceção.

    }
    finally {

        // Código executado sempre,
        // independentemente de ocorrer ou não uma exceção.

    }

    ===============================================================================
                                 FLUXO DE EXECUÇÃO
    ===============================================================================

                try
                 │
          Ocorreu exceção?
             /          \
          NÃO            SIM
           │              │
     Continua       Executa o catch
           │              │
           └───────┬──────┘
                   │
             Executa o finally
                   │
             Continua ou encerra
               a execução.

    ===============================================================================
    OBSERVAÇÃO
    -------------------------------------------------------------------------------
    O bloco finally é muito utilizado para garantir que recursos sejam liberados,
    evitando desperdício de memória, arquivos abertos ou conexões que permaneçam
    ativas desnecessariamente.

    Em aplicações profissionais, é uma boa prática utilizar o finally sempre que
    for necessário garantir a liberação de recursos.
    ===============================================================================
    */
