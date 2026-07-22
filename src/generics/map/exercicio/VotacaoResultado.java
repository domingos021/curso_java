package generics.map.exercicio;

import generals_utils.utils.Leitor;
import generics.map.exercicio.entities.CandidateMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VotacaoResultado {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            /*
             * ============================================================
             * MAP DE RESULTADOS
             * ============================================================
             *
             * Chave (Key)  -> CandidateMap
             * Valor (Value)-> Total de votos do candidato.
             */
            Map<CandidateMap, Integer> votes = new HashMap<>();

            String path = Leitor.lerTexto(sc, "Insira o caminho do arquivo ");

            //String path = "C:\\temp01\\votos.txt";

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String line = br.readLine();

                while (line != null) {

                    /*
                     * Exemplo da linha:
                     *
                     * Alex Blue,15
                     */
                    String[] fields = line.split(",");

                    CandidateMap candidate = new CandidateMap(fields[0]);

                    Integer quantity = Integer.parseInt(fields[1]);

                    /*
                     * Se o candidato ainda não existir,
                     * adiciona-o ao Map.
                     */
                    if (!votes.containsKey(candidate)) {

                        votes.put(candidate, quantity);

                    } else {

                        /*
                         * Recupera o total atual de votos.
                         */
                        Integer totalVotes = votes.get(candidate);

                        /*
                         * Atualiza o total somando os novos votos.
                         */
                        votes.put(candidate, totalVotes + quantity);
                    }

                    line = br.readLine();
                }

                System.out.println();
                System.out.println("RESULTADO DA ELEIÇÃO");
                System.out.println("-------------------------");

                /*
                 * Percorre todas as entradas do Map.
                 */
                for (Map.Entry<CandidateMap, Integer> entry : votes.entrySet()) {

                    System.out.printf("%s: %d%n",
                            entry.getKey().getName(),
                            entry.getValue());
                }

            } catch (IOException e) {

                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }
}