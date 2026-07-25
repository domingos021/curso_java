package generals_utils.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FileService {

    // ============================================================
    // 1. LEITURA DE ARQUIVOS (READ)
    // ============================================================

    /**
     * Leitura tradicional imperativa utilizando loop manual (while) e lista mutável.
     *
     * Método estático genérico <T> projetado para processar qualquer tipo de objeto.
     *
     * @param path   Caminho absoluto ou relativo do arquivo a ser lido.
     * @param mapper Função de mapeamento (Function<String, T>) enviada como parâmetro Lambda,
     *               que define como a linha de texto do arquivo será convertida no objeto do tipo T.
     * @param <T>    Tipo genérico do objeto que comporá a lista retornada.
     * @return Lista (List<T>) populada com os objetos instanciados a partir das linhas do arquivo.
     *
     * FLUXO DE EXECUÇÃO:
     * 1. try-with-resources : Abre o BufferedReader/FileReader e assegura o fechamento automático ao final.
     * 2. br.readLine()      : Lê sequencialmente a primeira linha do arquivo de texto.
     * 3. while (line != null): Percorre o arquivo até atingir o fim da leitura (EOF - End Of File).
     * 4. !line.isBlank()    : Condicional de segurança que ignora linhas em branco ou compostas por espaços.
     * 5. mapper.apply(line) : Executa a regra enviada via Lambda para transformar a String lida no objeto T.
     * 6. list.add(...)      : Adiciona o objeto gerado à lista acumuladora.
     * 7. catch (IOException): Captura e trata exceções de I/O de forma segura sem interromper a aplicação.
     */
    public static <T> List<T> lerArquivo(String path, Function<String, T> mapper) {
        List<T> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                if (!line.isBlank()) {
                    list.add(mapper.apply(line)); // Transforma a linha no objeto T via Lambda
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo: " + e.getMessage());
        }

        return list;
    }

    /**
     * Leitura moderna utilizando Java Streams (Retorna uma List<T> imutável).
     *
     * Método estático genérico <T> projetado para processar qualquer tipo de objeto.
     *
     * @param path   Caminho absoluto ou relativo do arquivo a ser lido.
     * @param mapper Função de mapeamento (Function<String, T>) que define como
     *               cada linha de texto do arquivo será transformada no objeto T.
     * @param <T>    Tipo genérico do objeto que comporá a lista retornada.
     * @return Lista imutável (List<T>) contendo os objetos processados.
     *
     * FLUXO DE EXECUÇÃO DO PIPELINE:
     * 1. try-with-resources : Abre o BufferedReader e garante que o recurso do sistema
     *                         seja fechado automaticamente ao final (evitando vazamento de memória).
     * 2. br.lines()          : Transforma todo o conteúdo do arquivo em uma Stream<String> (fluxo de linhas).
     * 3. .filter(...)        : Operação Intermediária. Descarta linhas nulas, vazias ou contendo apenas espaços em branco.
     * 4. .map(mapper)        : Operação Intermediária. Aplica a função Lambda enviada no parâmetro,
     *                         transformando cada String (linha) no objeto do tipo T.
     * 5. .toList()           : Operação Terminal (Java 16+). Coleta todos os objetos processados
     *                         e encerra a Stream retornando uma Lista imutável.
     * 6. catch (IOException) : Captura falhas de I/O (ex: arquivo não encontrado) e retorna
     *                         uma lista vazia e segura (List.of()) em vez de quebrar a aplicação.
     */
    public static <T> List<T> lerArquivoStream(String path, Function<String, T> mapper) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.lines()
                    .filter(line -> !line.isBlank())
                    .map(mapper)  // mapped e aplica a função mapper em cada linha
                    .toList();
        } catch (IOException e) {
            System.out.println("Erro de leitura com Stream: " + e.getMessage());
            return List.of();
        }
    }


    // ============================================================
    // 2. ESCRITA DE ARQUIVOS (WRITE)
    // ============================================================

    /**
     * Escreve e formata uma lista de objetos genéricos <T> para um arquivo físico no disco.
     *
     * @param path      Caminho de destino do arquivo a ser criado ou atualizado.
     * @param list      Lista de objetos (List<T>) contendo os dados a serem gravados.
     * @param formatter Função Lambda (Function<T, String>) que recebe cada objeto do tipo T e define
     *                  como ele deve ser formatado como texto (ex: separando por vírgulas para CSV).
     * @param append    Booleano que define o modo de gravação:
     *                  'true'  -> Adiciona os novos dados ao final do arquivo sem apagar o conteúdo existente.
     *                  'false' -> Sobrescreve completamente o arquivo caso ele já exista.
     * @param <T>       Tipo genérico dos objetos contidos na lista.
     *
     * FLUXO DE EXECUÇÃO:
     * 1. try-with-resources  : Instancia o BufferedWriter e FileWriter com o parâmetro 'append'.
     * 2. for (T item : list) : Itera sobre a lista de objetos passados.
     * 3. formatter.apply(...) : Invoca a Lambda para converter a instância da classe T em String formatada.
     * 4. bw.write(...)       : Grava a linha de texto no buffer do arquivo.
     * 5. bw.newLine()        : Insere a quebra de linha nativa do sistema operacional.
     * 6. catch (IOException) : Captura eventuais erros de gravação ou permissão de acesso ao diretório.
     */
    public static <T> void escreverArquivo(String path, List<T> list, Function<T, String> formatter, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (T item : list) {
                bw.write(formatter.apply(item)); // Converte o objeto T para a String formatada via Lambda
                bw.newLine();
            }
            System.out.println("Arquivo gravado com sucesso em: " + path);

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }


    // ============================================================
    // 3. OPERAÇÕES AVANÇADAS COMBINADAS (READ + FILTER + WRITE)
    // ============================================================

    /**
     * Operação de ETL (Extract, Transform, Load).
     * Lê um arquivo original, filtra o fluxo de dados através de um Predicate, e salva o resultado
     * transformado diretamente em um novo arquivo de saída.
     *
     * @param pathOrigem      Caminho do arquivo de entrada (arquivo fonte).
     * @param pathDestino     Caminho do novo arquivo a ser gerado como resultado.
     * @param readerMapper    Função (Function<String, T>) para converter as linhas lidas nos objetos T.
     * @param filtro          Predicado funcional (Predicate<T>) contendo a regra de negócio do filtro (retorna true/false).
     * @param writerFormatter Função (Function<T, String>) para formatar os objetos filtrados em texto para o novo arquivo.
     * @param <T>             Tipo genérico trabalhado durante todo o ciclo de vida do pipeline.
     *
     * FLUXO DE EXECUÇÃO:
     * 1. lerArquivoStream() : Lê e converte o arquivo de origem em uma lista de objetos do tipo T.
     * 2. .stream().filter() : Aplica o Predicate para selecionar apenas os objetos que atendem ao critério.
     * 3. .toList()          : Agrupa os dados filtrados em uma nova lista imutável.
     * 4. escreverArquivo()  : Formata e grava os dados filtrados no arquivo de destino final.
     */
    public static <T> void lerFiltrarEGravar(String pathOrigem, String pathDestino,
                                             Function<String, T> readerMapper,
                                             Predicate<T> filtro,
                                             Function<T, String> writerFormatter) {
        // 1. Extrai os dados do arquivo de origem
        List<T> dadosLidos = lerArquivoStream(pathOrigem, readerMapper);

        // 2. Transforma e filtra os dados usando o Predicate
        List<T> dadosFiltrados = dadosLidos.stream()
                .filter(filtro)
                .toList();

        // 3. Carrega e escreve o resultado no arquivo final de destino
        escreverArquivo(pathDestino, dadosFiltrados, writerFormatter, false);
    }
}