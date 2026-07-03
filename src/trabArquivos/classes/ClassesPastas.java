package trabArquivos.classes;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

    /*
    CONCEITOS DA CLASSE FILE (Pastas e Diretórios):

    File =>
    - Pode representar tanto um arquivo quanto um diretório (pasta) no sistema.
    - Não abre fluxos de leitura/escrita de dados diretamente, mas gerencia o sistema de arquivos.
    - Permite listar conteúdos, criar pastas, verificar caminhos e deletar itens.

    MÉTODOS PRINCIPAIS DE PASTAS:
    - isDirectory() => Verifica se o caminho aponta para uma pasta.
    - isFile()      => Verifica se o caminho aponta para um arquivo comum.
    - listFiles()   => Retorna um array com todos os arquivos/pastas contidos no diretório.
    - mkdir()       => Cria uma nova pasta (retorna true se criada com sucesso).
    - getPath()     => Captura o caminho completo do objeto File.
    - getName()     => Captura apenas o nome final do arquivo ou pasta.
    */

public class ClassesPastas {

    public static void main(String[] args) {

        // Scanner para interatividade no console
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho do diretório (Ex: C:\\temp01):");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        // Validação de segurança: Só executa se o caminho digitado realmente existir
        if (path.exists() && path.isDirectory()) {

            /*
             ============================
             ✔ Filtrando e Listando apenas Subpastas
             ============================
             Pegar todas as pastas contidas neste caminho.
             File::isDirectory (só lista pastas) => Method Reference do Java 8+
            */
            System.out.println("\n--- LISTA DE PASTAS EM " + strPath + " ---");

            // listFiles com Method Reference para filtrar apenas o que for pasta
            File[] foldersList = path.listFiles(File::isDirectory);

            if (foldersList != null && foldersList.length > 0) {
                // Para cada pasta encontrada na lista de diretórios (foldersList),
               // percorre o array de File e exibe o caminho completo de cada subpasta.

                for (File folder : foldersList) {
                    // getPath() retorna o caminho completo do arquivo/pasta
                    System.out.println("Pasta encontrada: " + folder.getPath());

                }
            } else {
                System.out.println("Nenhuma subpasta encontrada.");
            }

            /*
             ============================
             ✔ Filtrando e Listando apenas Arquivos
             ============================
            */
            System.out.println("\n--- LISTA DE ARQUIVOS EM " + strPath + " ---");

            // listFiles com Method Reference para filtrar apenas arquivos simples
            File[] files = path.listFiles(File::isFile);

            if (files != null && files.length > 0) {
                //pega somente a lista de arquivos
                for (File file : files) {
                    // getName() pega apenas o nome do arquivo (ex: in.txt), sem o caminho completo
                    System.out.println("Arquivo encontrado: " + file.getName());
                    System.out.println(file);
                }
            } else {
                System.out.println("Nenhum arquivo encontrado.");
            }

            /*
             ============================
             ✔ Criando uma Nova Subpasta (mkdir)
             ============================
            */
            System.out.println("\n--- CRIANDO UMA NOVA PASTA ---");

            // Definimos o caminho da nova pasta que queremos criar dentro do diretório informado
            String novaPastaCaminho = strPath + "\\pinkFloyd";
            File novaPasta = new File(novaPastaCaminho);

            // O método mkdir() tenta criar a pasta fisicamente no disco
            boolean sucesso = novaPasta.mkdir();



            if (sucesso) {
                System.out.println("Sucesso: Pasta criada em " + novaPastaCaminho);
            } else {
                // Se a pasta já existir, o mkdir() retorna false
                System.out.println("Aviso: A pasta não foi criada (pode ser que já exista).");
            }

        } else {
            System.out.println("Erro: O caminho digitado não existe ou não é um diretório válido.");
        }

        // Fechamento seguro do scanner de console
        sc.close();
    }
}