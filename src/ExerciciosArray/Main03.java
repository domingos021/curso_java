package ExerciciosArray;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main03 {

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

            sc.nextLine(); // Limpeza preventiva
            Pessoas[] obj = new Pessoas[qt]; //cria um novo objeto do tipo pessoa

            // SISTEMA
            /*
              obj.length
              tamanho total do array, ex: qt = 6,
              isso quer dizer que o array tem 5 posições
              nesse caso o laço roda ate que o (i) cujo valor inical e 0, gira ate que o valor
              de i seja menor que o tamanho do array que e 5 voltas + a volta inicial (0) = 6 voltas
              ex: 0,1,2,3,4,5
             */
            for (int i = 0; i < obj.length; i++) {
                boolean sucesso = false; // so passa para proxima pessoa se sucesso for verdadeiro

                    /*
                     try = "tente executar este código".

                     Se tudo der certo, o programa continua normalmente.

                     catch = "se ocorrer um erro no try, capture esse erro
                     e execute este bloco de código".

                     Assim, o programa não é interrompido abruptamente.
                     */

                // Esse loop repete a MESMA pessoa se o usuário digitar dados inválidos
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

                        // Tenta criar o objeto na Heap chamando o Construtor + Setters
                        obj[i] = new Pessoas(nome, idade, altura);
                        /*
                          COSTRUTOR
                          1ª- Obriga que o vetor ja nasce populado, determina quais os dados devem existir
                          2ª- pega esses dados via parametro ex:(nome, idade, altura) para dentro da class
                          3ª- la ele aciona o setter responsavel pela validação por segurança

                          SETTER
                          1ª- verifica se esse dado atende o padrão, se sim {envia o dado seguro para o atributo por meio do : this.atributo = dado validado
                          2ª- se não, rejeita esse dado e envia de volta o erro para o main, via

                            throw new IllegalArgumentException("O nome não pode ser vazio."); ===> MANDA O ERRO PARA O CATCH

                          CATCH
                          1ª - recebe esse erro via:
                            RECEBE O ERRO DO SETTER==>catch (IllegalArgumentException error)
                          2ª- Exibe o erro via {
                          System.out.printf("[ERRO NO CADASTRO] %s Tente novamente.%n", error.getMessage());
                          }

                          3ª- Sucesso false, volta para o loop no ponto que não foi acertado para correção
                          o Usuario digita os dados de novo


                                              [ TENTATIVA NO MAIN ]
                                     │
                                     ▼
                              ┌──────────────┐
                              │ CONSTRUTOR   │ ◄── 1ª Determina o que deve existir
                              └──────┬───────┘     2ª Pega os dados via parâmetro
                                     │
                                     ▼
                              ┌──────────────┐
                              │    SETTER    │ ◄── 3ª Aciona a validação por segurança
                              └──────┬───────┘
                                     │
                           ┌─────────┴─────────┐
                           ▼                   ▼
                     [ DADO SEGURO? ]    [ DADO INVÁLIDO? ]
                           │                   │
                      (this.atrib = dado)      ▼
                           │             ┌───────────┐
                           ▼             │   THROW   │ ◄── Rejeita e manda o erro pro catch
                     [ Salva na Heap ]   └─────┬─────┘
                                               │
                                               ▼
                                         ┌───────────┐
                                         │   CATCH   │ ◄── 1ª Recepe o erro via (IllegalArgumentException error)
                                         └─────┬─────┘     2ª Exibe o erro com error.getMessage()
                                               │
                                               ▼
                                         ┌───────────┐
                                         │   WHILE   │ ◄── 3ª Sucesso continua false, loop pede os dados
                                         └───────────┘      de novo para correção!


                         */

                        // Se chegou aqui sem dar erro, a criação foi um sucesso!
                        sucesso = true;

                    } catch (IllegalArgumentException error) {
                        // Se qualquer Setter rejeitar o dado, o Java cai direto aqui!
                        System.out.printf("[ERRO NO CADASTRO] %s Tente novamente.%n", error.getMessage());
                        // O 'sucesso' continua false, então o while vai rodar de novo para a mesma pessoa
                    }
                }

                System.out.println("Estado atual do vetor de Objetos:");
                System.out.println(Arrays.toString(obj));
            }

            // PROCESSAMENTO DOS DADOS (Cálculo da Média)
            double somaAlturas = 0.0;
            int contMenores16 = 0;
            String nomesMenores = ""; // Acumulador para guardar os nomes dos menores de 16

            for (int i = 0; i < obj.length; i++) {
                somaAlturas += obj[i].getAltura();

                // Validação de menores de 16 anos
                if (obj[i].getIdade() < 16) {
                    contMenores16++;
                    nomesMenores += "- " + obj[i].getNome() + "\n";
                }
            }

            double mediaAlturas = somaAlturas / obj.length;
            // Cálculo da porcentagem (com cast para double para evitar divisão inteira truncada)
            double porcentagemMenores16 = ((double) contMenores16 / obj.length) * 100.0;

            System.out.printf("%n================= RESULTADO DO GRUPO =================%n");
            System.out.printf("Média de altura das pessoas: %.2f metros%n", mediaAlturas);
            System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", porcentagemMenores16);

            // Condicional para exibir a lista de nomes apenas se houverem menores de 16 anos
            if (contMenores16 > 0) {
                System.out.println("Nomes das pessoas com menos de 16 anos:");
                System.out.print(nomesMenores);
            } else {
                System.out.println("Nenhuma pessoa com menos de 16 anos foi cadastrada.");
            }
        }
        sc.close();
    }
}