package trabArquivos.exerc;

import trabArquivos.exerc.entities.Products;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExercicioArquivos {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Products> list = new ArrayList<>();

        System.out.println("Digite o caminho do arquivo/ or enter file path: ");
        // Lê do teclado o caminho completo do arquivo.
        String sourceFileStr = sc.nextLine().trim();

        // sourceFileStr => C:\temp01\exercicio\input.csv
        // source = origem
        // file = arquivo
        // Str = String
        // Armazena em uma String o caminho completo do arquivo de origem informado pelo usuário.

        // FILE
        // sourceFile => Referencia do objeto que guarda(C\\temp01\\exercicio\\input.csv
        // Cria um objeto do tipo File utilizando o caminho armazenado in sourceFileStr.
        // O objeto File representa o arquivo e fornece métodos para acessar
        // informações como nome, caminho, tamanho, existência, pasta, etc.
        File sourceFile = new File(sourceFileStr);

        // sourceFolderStr => C:\temp01\exercicio
        // source = origem
        // folder = pasta
        // Str = String
        // Armazena em uma String o caminho da pasta onde o arquivo de origem está localizado.
        String sourceFolderStr = sourceFile.getParent(); // Retorna apenas o caminho da pasta, sem o nome do arquivo.

        /*
            Teste no console

            System.out.println("Caminho da pasta do arquivo: " + sourceFolderStr);

            Exemplo:

            Arquivo:
             C:\temp01\exercicio\input.csv

            Resultado do getParent():
            C:\temp01\exercicio

            Ou seja, getParent() retorna somente o caminho da pasta
            que contém o arquivo.
        */

        // Criando a pasta "out".
         // sourceFolderStr + "\\out").mkdir(); => C:\temp01\exercicio\out
        // mkdir()
        // Cria a pasta "out" dentro da pasta onde está localizado o arquivo de origem.
        // Retorna:
        // true  -> pasta criada com sucesso.
        // false -> a pasta já existia ou não foi possível criá-la.
        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        /*
            Teste no console

            System.out.println("Pasta criada com sucesso? " + success);
        */

        // Caminho do arquivo que será criado dentro da pasta "out".
        //sourceFolderStr + "\\out\\summary.csv"; => C:\temp01\exercicio\(+)out\summary.csv
        // targetFileStr
        // target = destino
        // file = arquivo
        // Str = String
        // Armazena o caminho completo do arquivo de destino (summary.csv),
        // que será criado dentro da pasta "out".

        // Neste caso, não é apenas uma pasta, mas sim um arquivo final
        // que será gerado pelo programa com o resultado do processamento.

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        //========================== FAZENDO A LEITURA DO ARQUIVO ==========================
        // Utilizando o try-with-resources para garantir o fechamento automático dos recursos
        // e evitar vazamento de memória.

        /*
         Diferente do Scanner, que normalmente é utilizado para leitura do teclado,
         neste caso vamos utilizar FileReader e BufferedReader, que são mais indicados
         para leitura de arquivos de texto.

         FileReader
         -> Classe responsável por abrir o arquivo para leitura.
         -> Recebe como argumento o arquivo (ou o caminho do arquivo).
         -> Faz a comunicação entre o programa e o arquivo físico.

         BufferedReader
         -> Classe wrapper (envoltório) que encapsula o FileReader.
         -> Adiciona um buffer de memória, tornando a leitura mais eficiente,
            principalmente em arquivos maiores.
         -> Também fornece métodos úteis, como readLine(), para ler o arquivo
            linha por linha.

         Fluxo da leitura:

         Arquivo (.csv)
                ↓
           FileReader
                ↓
         BufferedReader
                ↓
         Programa Java

         O try-with-resources fecha automaticamente o BufferedReader ao final
         da execução. Como o BufferedReader encapsula o FileReader, o FileReader
         também é fechado automaticamente.
        */
        //le isso:sourceFileStr = ( C:\temp01\exercicio\\input.csv)
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            // try
            // Tenta executar todo o código que pode lançar exceções.
            // Se nenhuma exceção ocorrer, o programa continua normalmente.
            // Caso ocorra uma IOException, a execução é interrompida
            // e o controle passa para o bloco catch.
            //br =(detem os dados lidos atravez fileReader)
            //br.readLine() => le primeira linha do arquivo e a armazena na variável itemCsvLine

            String itemCsvLine = br.readLine();

            // readLine()
            // Lê a primeira linha do arquivo e a armazena na variável itemCsvLine.
            // Se o arquivo estiver vazio, retorna null.

            // Enquanto ainda existir uma linha para ser lida,
            // o laço continuará executando.
            while (itemCsvLine != null) {

                // CORREÇÃO LOGICA AJUSTADA: Se a linha lida estiver em branco (ex: quebras de linha no final do arquivo),
                // pula o processamento dela direto para a próxima linha sem disparar o "Linha inválida" no console.
                if (itemCsvLine.isBlank()) {
                    itemCsvLine = br.readLine();
                    continue;
                }

                // Exibe a linha atual do arquivo.
                System.out.println(itemCsvLine);

                // Criando uma lista para agrupar os produtos (objetos Products)

                // split()
                // Quebra a linha (String) em partes, usando a vírgula "," como separador.
                // Cada parte do CSV vira um elemento de um array de String.

                // Exemplo:
                // "TV,900.00,10"
                // vira:
                // fields[0] = "TV" => name
                // fields[1] = "900.00" => price
                // fields[2] = "10" => quantity

                String[] fields = itemCsvLine.split(",");

                // VALIDAÇÃO
                if (fields.length == 3) {

                    // trim()
                    // Remove espaços em branco no início e no fim da String.
                    // Garante que valores como " 900.00 " não causem erro na conversão.

                    String name = fields[0].trim();

                    // parseDouble()
                    // Converte uma String para número decimal (double).
                    // CORREÇÃO LOGICA: Juntamos a parte inteira (fields[1]) com os centavos (fields[2]) usando um ponto.
                    // AJUSTE DEFINITIVO: Como o arquivo original usa vírgulas, a conversão do preço voltou a ser direta no índice 1.
                    double price = Double.parseDouble(fields[1].trim());

                    // parseInt()
                    // Converte uma String para número inteiro (int).
                    // CORREÇÃO LOGICA: A quantidade agora passou para o índice 3.
                    // AJUSTE DEFINITIVO: A quantidade voltou para o índice 2.
                    int quantity = Integer.parseInt(fields[2].trim());

                    // Aqui você pode continuar o fluxo normalmente:
                    // Products product = new Products(name, price, quantity);
                    // list.add(product);

                    //============= APOS A LEITURA PROCESSAR OS DADOS LIDOS =============
                    // Instanciamos a classe Products e criamos um objeto (product)
                    // com os valores lidos do arquivo, enviados como argumentos para o construtor.
                    //
                    // Isso transforma dados "crus" (String, double, int)
                    // em um objeto estruturado da aplicação.

                    Products product = new Products(name, price, quantity);

                    // Adiciona o objeto product na lista.
                    // Agora temos um produto completo armazenado em memória,
                    // pronto para ser processado (ex: gerar resumo, calcular total, etc)

                    list.add(product); // A lista armazena a referência (endereço) que aponta para o objeto na memória.

                    // Forma alternativa (mais compacta):
                    // Cria o objeto diretamente dentro do add(), sem variável intermediária.
                    //
                    // list.add(new Products(name, price, quantity));

                } else {
                    // Caso a linha esteja inválida (não tenha os 3 campos esperados)
                    System.out.println("Linha inválida ignorada: " + itemCsvLine);
                }

                // CORREÇÃO LOGICA: A leitura da próxima linha deve ficar no final do bloco do while,
                // evitando pular a primeira linha e prevenindo NullPointerException.
                // Lê a próxima linha do arquivo e atualiza a variável.
                // Quando chegar ao final do arquivo, readLine() retornará null,
                // encerrando automaticamente o laço.
                itemCsvLine = br.readLine();
            }


            //===================== PEGAR OS DADOS PROCESSADOS E GRAVAR NA SAIDA ARQUIVO SUMMARY==========

                /*
                 Diferente do Scanner, que normalmente é utilizado para leitura do teclado,
                 neste caso vamos utilizar FileWriter e BufferedWriter, que são mais indicados
                 para escrita em arquivos de texto.

                 FileWriter
                 -> Classe responsável por abrir o arquivo para escrita.
                 -> Recebe como argumento o arquivo (ou o caminho do arquivo).
                 -> Faz a comunicação entre o programa e o arquivo físico.
                 -> Pode criar ou sobrescrever arquivos.

                 BufferedWriter
                 -> Classe wrapper (envoltório) que encapsula o FileWriter.
                 -> Adiciona um buffer de memória, tornando a escrita mais eficiente,
                    principalmente em arquivos maiores.
                 -> Permite escrever texto de forma mais rápida e organizada,
                    usando métodos como write() e newLine().

                 Fluxo da escrita:

                 Programa Java
                        ↓
                   BufferedWriter
                        ↓
                     FileWriter
                        ↓
                   Arquivo (.csv ou .txt)

                 O try-with-resources fecha automaticamente o BufferedWriter ao final
                 da execução. Como o BufferedWriter encapsula o FileWriter, o FileWriter
                 também é fechado automaticamente.

                 targetFileStr  => CAMINHO DO ARQUIVO DE SAIDA-> SUMMARY.CSV
                */

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                // Percorre a lista de produtos e escreve cada produto no arquivo de saída.
                for (Products pdItem : list) {
                    // write()
                    // Escreve a String no arquivo.
                    bw.write(pdItem.getName() + "," + String.format("%.2f", pdItem.calcularTotal()));
                    bw.newLine(); // Adiciona uma nova linha no arquivo.
                }
                System.out.println(targetFileStr + " criado com sucesso na pasta out!");
            } catch (IOException e) {
                System.out.println("Error while writing files: " + e.getMessage());
            }

        } catch (IOException e) {
            // Executado caso ocorra algum erro durante a leitura do arquivo.
            System.out.println("Error while reading files: " + e.getMessage());
        }

        sc.close();
    }
}