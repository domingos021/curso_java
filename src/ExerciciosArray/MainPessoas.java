package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class MainPessoas {
    /*
    [ Usuário ] ──(Digita Dados Brutos)──► [ MainPessoas ]
                                            │
                                 (grupo.adicionarPessoa)
                                            │
                                            ▼
                                     [ GrupoPessoas ]
                                            │
                                      (new Pessoas)
                                            │
                                            ▼
                                       [ Pessoas ] ──(Valida)──► [ Memória Heap ]
     */

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas?  ");
        int qt = sc.nextInt();

        int tentativas = 0;
        while ((qt <= 0 || qt > 10) && (tentativas < 2)) {
            System.out.println(" Digite um numero entre 1 e 10 ");
            qt = sc.nextInt();
            tentativas++;
        }

        if (qt <= 0 || qt > 10) {
            System.out.println("Sistema encerrado por excesso de tentativas");
        } else {
            sc.nextLine(); // Limpeza preventiva do buffer

            // INSTANCIAÇÃO: Ponto em que o 'main' envia a quantidade ('qt') via parâmetro para o construtor.
            // O 'main' apenas lê o limite do teclado e entrega esse dado para que a classe saiba o tamanho
            // exato do vetor que ela deve criar e gerenciar na memória Heap.
            GrupoPessoas grupo = new GrupoPessoas(qt);

            // FOR DE INTERAÇÃO (Fica aqui porque conversa direto com o Scanner)
            /*
             1ª - Consulta o limite: Ele pega o retorno do tamanho do vetor (que o main já havia
                  enviado à classe via construtor) acessando o método 'grupo.getTamanho()'.

             2ª - Controla o preenchimento: O laço garante a criação de uma pessoa por volta,
                  até que todas as gavetas do array estejam ocupadas.

                  Exemplo: Se o tamanho retornado pela classe for 3, o laço gira exatamente 3 vezes
                  para processar 3 pessoas distintas. Ele parte do valor inicial do índice (i = 0)
                  e continua enquanto a condição for verdadeira:
                  - Volta 1: i = 0 (0 < 3? Sim! Processa a 1ª pessoa)
                  - Volta 2: i = 1 (1 < 3? Sim! Processa a 2ª pessoa)
                  - Volta 3: i = 2 (2 < 3? Sim! Processa a 3ª pessoa)
                  - Volta 4: i = 3 (3 < 3? Não! O laço quebra e o programa avança).

             3ª - Incremento: O 'i++' soma 1 ao índice a cada fim de volta, controlando a progressão
                  passo a passo pelas gavetas do vetor.
            */

            for (int i = 0; i < grupo.getTamanho(); i++) {
                boolean sucesso = false;

                while (!sucesso) {
                    try {
                        System.out.printf("%n--- Dados da %dª pessoa ---%n", i + 1);

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Idade: ");
                        int idade = sc.nextInt();

                        System.out.print("Altura: ");
                        double altura = sc.nextDouble();
                        sc.nextLine(); // Limpeza imediata do ENTER

                        // Delega ao grupo a criação e validação da pessoa.
                        // O Main apenas lê os dados brutos do teclado e os repassa —
                        // quem cria o objeto Pessoas, valida e guarda no vetor é o GrupoPessoas.

                        //Main manda os dados via parametro ao metodo que aciona esses dados no vetor, ele mora na classe grupo pessoas
                        grupo.adicionarPessoa(i, nome, idade, altura);
                        sucesso = true; // Avança para a próxima pessoa no 'for'

                    } catch (IllegalArgumentException error) {
                        // Captura as exceções lançadas internamente pelo GrupoPessoas
                        // durante a criação e validação do objeto Pessoas.
                        System.out.printf("[ERRO NO CADASTRO] %s Tente novamente.%n", error.getMessage());
                    }
                }
            }

            // FIM DA LEITURA -> O main agora apenas exibe os resultados calculados pela classe
            System.out.printf("%n================= RESULTADO DO GRUPO =================%n");
            System.out.printf("Média de altura das pessoas: %.2f metros%n", grupo.calcularMediaAlturas());
            System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", grupo.calcularPorcentagemMenores16());

            // Pede para o grupo a lista de nomes formatada
            String menores = grupo.obterNomesMenores16();
            if (!menores.isEmpty()) {
                System.out.println("Nomes das pessoas com menos de 16 anos:");
                System.out.print(menores);
            } else {
                System.out.println("Nenhuma pessoa com menos de 16 anos foi cadastrada.");
            }
        }
        sc.close();
    }
}