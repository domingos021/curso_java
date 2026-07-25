package progracaofuncional_lambda.exercicio_resolvido.app;

/*
 * ============================================================
 * EXERCÍCIO - PROCESSAMENTO DE PRODUTOS COM STREAM
 * ============================================================
 *
 * Fazer um programa para ler um conjunto de produtos a partir de
 * um arquivo no formato .csv.
 *
 * O arquivo deve conter os dados dos produtos (suponha que exista
 * pelo menos um produto cadastrado).
 *
 * O programa deve realizar as seguintes operações:
 *
 * 1) Ler os produtos do arquivo CSV.
 *
 * 2) Calcular e mostrar o preço médio de todos os produtos.
 *
 *    Exemplo:
 *    Produtos:
 *    TV, 900.00
 *    Mouse, 50.00
 *    Teclado, 100.00
 *
 *    Preço médio = (900 + 50 + 100) / 3
 *
 * 3) Depois, mostrar os nomes dos produtos que possuem preço
 *    inferior ao preço médio.
 *
 * 4) Os nomes dos produtos devem ser exibidos em ordem decrescente.
 *
 *    Exemplo:
 *
 *    Preço médio: 350.00
 *
 *    Produtos abaixo da média:
 *    Teclado
 *    Mouse
 *
 * ============================================================
 * CONCEITOS ENVOLVIDOS:
 * ============================================================
 * Exemplo de caminho: C:\\temp01\\produtosexerc.txt
 *
 * - Leitura de arquivos (.csv)
 * - Classe ProductExer
 * - List<T>
 * - Streams e Lambdas
 * - Operações intermediárias:
 *      filter()  -> filtrar produtos abaixo da média
 *      map()     -> obter somente os nomes dos produtos
 *      sorted()  -> ordenar os nomes com Comparator customizado
 *
 * - Operação terminal:
 *      reduce()  -> somar o preço total dos produtos
 *      collect() -> coletar o resultado em uma List<String>
 *      forEach() -> imprimir os resultados no console
 *
 * ============================================================
 */

import generals_utils.utils.FileService;
import generals_utils.utils.Leitor;
import progracaofuncional_lambda.exercicio_resolvido.entities.ProductExer;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        // Define o padrão numérico dos EUA (utiliza ponto para casas decimais)
        Locale.setDefault(Locale.US);

        // Bloco try-with-resources para garantir o fechamento automático do Scanner
        try (Scanner sc = new Scanner(System.in)) {

            // 1. Entrada de dados do caminho do arquivo CSV
            String path = Leitor.lerTexto(sc, "Insira o caminho do arquivo: ");

            // Declaração EXPLÍCITA da função de mapeamento (Function<String, ProductExer>)
            // Entrada: String (linha do CSV) | Saída: ProductExer
            Function<String, ProductExer> mapper = line -> {
                String[] fields = line.split(",");
                return new ProductExer(fields[0].trim(), Double.parseDouble(fields[1].trim()));
            };

            // Leitura genérica utilizando o FileService passando a variável 'mapper' explicitamente
            List<ProductExer> listaProdutos = FileService.lerArquivoStream(path, mapper);

            // 2. Cálculo da média dos preços utilizando Stream e reduce
            // O uso do operador ternário mantém a variável 'avg' como "effectively final" para uso futuro na lambda
            double media = listaProdutos.isEmpty() ? 0.0 : listaProdutos.stream()
                    .map(ProductExer::getPrice) // Também pode ser em lambda: .map(p -> p.getPrice())
                    .reduce(0.0, (x, y) -> x + y) / listaProdutos.size();
            // Exibe a média formatada
            System.out.printf("Preço médio: %.2f%n", media);

            // 3. Definição do Comparator customizado para ordenação de Strings (case-insensitive)
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            // 4. Filtragem e ordenação dos nomes de produtos que estão abaixo da média
            List<String> nomesAbaixoDaMedia = listaProdutos.stream()
                    .filter(p -> p.getPrice() < media)        // Filtra preços menores que a média
                    .map(ProductExer::getName)              // Extrai apenas o nome de cada produto
                    .sorted(comp.reversed())                // Ordena alfabeticamente em ordem decrescente (Z-A)
                    .collect(Collectors.toList());          // Agrupa o resultado em uma lista

            // 5. Exibição final dos produtos filtrados
            nomesAbaixoDaMedia.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
 ====================================================================================
                  ENTENDENDO O MÉTODO: lerArquivoStream(path, mapper)
 ====================================================================================

 1. QUEM ENVIA O QUÊ? (A ASSINATURA DO MÉTODO)
 ------------------------------------------------------------------------------------
  Parâmetro do método: (String path, Function<String, T> mapper)

  +-----------------------+---------------------------------------------------------+
  | PARÂMETRO             | QUEM ENVIA E O QUE ENVIA                                 |
  +-----------------------+---------------------------------------------------------+
  | String path           | Você envia um DADO PRONTO (ex: "clientes.csv").         |
  | Function<String, T>   | Você envia uma RECEITA / REGRA DE CONVERSÃO (Lambda).   |
  | mapper                | Não é o dado em si, mas a instrução de como pegar uma   |
  |                       | String e transformá-la no objeto do tipo <T>.           |
  +-----------------------+---------------------------------------------------------+


 ====================================================================================
 2. DIAGRAMA DE CASAMENTO DOS PARÂMETROS NA CHAMADA
 ====================================================================================

 Quando você escreve o código no seu 'main' ou 'service':

   lerArquivoStream( "dados.txt" ,  linha -> new Usuario(linha) );
                        |                         |
                        |                         |
   +--------------------+-------------------------+------------------------------+
   |                    v                                                        |
   |   public <T> List<T> lerArquivoStream( String path , Function<String,T> mapper )|
   +-----------------------------------------------------------------------------+

   CASAMENTO 1: "dados.txt"  ===>  String path
   CASAMENTO 2: Lambda       ===>  Function<String, T> mapper
                - 'linha' é do tipo String (Entrada)
                - 'new Usuario(linha)' retorna o tipo T (Saída)


 ====================================================================================
 3. DIAGRAMA DE EXECUÇÃO INTERNA (O FLUXO DOS DADOS)
 ====================================================================================

  [ SEU ARQUIVO ]             [ MÉTODO lerArquivoStream ]          [ SUA FUNÇÃO MAPPER ]
  ("dados.txt")                 (Executa a leitura)                  (Regra de Negócio)

   +-----------+
   | "João,30" | --- (1. Lê linha) -->  String linha
   +-----------+                               |
   | "Maria,25"|                               |
   +-----------+                               v
                                    (2. Chama o mapper)
                                  mapper.apply(linha) ------------+
                                                                  |
                                                                  v
                                                        linha -> new Usuario(linha)
                                                                  |
                                  +<-- (3. Retorna T) ------------+
                                  |    (Objeto Usuario)
                                  v
                       resultado.add(objetoUsuario)


 ====================================================================================
 4. CÓDIGO FONTE COMENTADO
 ====================================================================================

 public <T> List<T> lerArquivoStream(String path, Function<String, T> mapper) {
     List<T> resultado = new ArrayList<>();

     // Usa o 'path' que você enviou para localizar o arquivo no disco
     try (BufferedReader br = new BufferedReader(new FileReader(path))) {
         String linha;

         // Loop que lê linha por linha do arquivo
         while ((linha = br.readLine()) != null) {

             // O CASAMENTO ACONTECE AQUI:
             // O método lê a String 'linha' do disco e a injeta como argumento
             // dentro da função 'mapper' que você forneceu na chamada.
             T objeto = mapper.apply(linha);

             // O resultado do tipo <T> é guardado na lista de retorno
             resultado.add(objeto);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }

     return resultado;
 }


 ====================================================================================
 5. RESUMO DEFINITIVO DO CASAMENTO
 ====================================================================================

   * QUEM DECIDE QUANDO A FUNÇÃO RODA?
     -> O método 'lerArquivoStream' (à medida que lê as linhas do arquivo).

   * QUEM DECIDE QUAL DADO ENTRA NA FUNÇÃO?
     -> O método 'lerArquivoStream' (passa a String lida do arquivo para a função).

   * QUEM DECIDE O QUE É FEITO COM ESSE DADO E QUAL TIPO SERÁ GERADO?
     -> Você! Através do Lambda/Function enviado no parâmetro 'mapper'.

*/