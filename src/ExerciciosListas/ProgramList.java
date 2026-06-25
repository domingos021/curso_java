package ExerciciosListas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramList {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criando uma lista de objetos do tipo Funcionario
        /*
         * ArrayList<> cria uma lista dinâmica que será armazenada na Heap.
         * A variável 'list' é uma referência para essa lista.
         * A lista foi declarada usando a interface List, o que permite trocar a implementação
         * futuramente (ArrayList, LinkedList, etc.) sem alterar o restante do código.
         * Essa lista armazenará objetos do tipo Funcionario.
         */
        List<Funcionario> list = new ArrayList<>();

        System.out.print("Quantos funcionários serão registrados? ");
        int N = sc.nextInt();

        int contador = 0;
        while ((N <= 0 || N > 100) && contador < 2) {
            System.out.print("Digite um numero entre 1 e 100: ");
            N = sc.nextInt();
            contador++;
        }

        if (N <= 0 || N > 100) {
            System.out.println("Programa encerrado por excesso de tentativas");
        } else {

            for (int i = 0; i < N; i++) {
                System.out.printf("Funcionário nº:%d:%n", i + 1);
                System.out.print("Id: ");
                int id = sc.nextInt();

                // Validação para não repetir o ID
                contador = 0; // Reinicia o contador para o funcionário atual
                while (hasId(list, id) && contador < 2) {
                    System.out.print("Esse ID já existe! Tente outro: ");
                    id = sc.nextInt();
                    contador++;
                }

                sc.nextLine(); // Limpar o buffer
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Salário: ");
                double salario = sc.nextDouble();

                // Cria um objeto Funcionario através do construtor e adiciona sua referência na lista
                list.add(new Funcionario(id, nome, salario));
            }

            // ==========================================
            // PARTE DO AUMENTO
            // ==========================================
            /*
             * A ESTRUTURA LAMBDA ABAIXO PODE SER USADA NO LUGAR DO FOR:
             * * Funcionario func = list.stream()
             * .filter(aumento -> aumento.getId() == idAumento)
             * .findFirst()
             * .orElse(null);
             */



            Funcionario func = null;
            int tentativas = 0;

            // O loop roda enquanto não achar o funcionário E não estourar o limite de 2 tentativas
            while (func == null && tentativas < 2) {

                System.out.print("\nDigite o ID do funcionário que receberá aumento: ");
                int idAumento = sc.nextInt(); // Declarado aqui dentro para receber o ID atualizado a cada tentativa

                // 1. O 'for' roda AQUI DENTRO para checar o ID que acabou de ser digitado
                for (Funcionario f : list) {
                    if (f.getId() == idAumento) {
                        func = f; // Se achar, 'func' ganha um objeto e sai do while na próxima checagem
                        break;
                    }
                }

                // 2. Se o 'for' acabou e 'func' continua null, significa que errou
                if (func == null) {
                    tentativas++; // Conta o erro

                    if (tentativas < 2) {
                        System.out.println("Este ID não existe! Tente novamente. (Tentativa " + tentativas + "/2)");
                    }
                }
            }

            // 3. Fora do while, verificamos como o loop terminou
            if (func == null) {
                System.out.println("Limite de tentativas excedido! Operação abortada.");
            } else {
                //se tudo der certo, se o id existir
                System.out.print("Digite a porcentagem do aumento: ");
                double porcentagem = sc.nextDouble();
                func.aumentarSalario(porcentagem); //acessa o metodo aumentarSalario dentro da class que a função de calcular a porcentagem



                // MOSTRAR LISTAGEM ATUALIZADA (SÓ MOSTRA SE O AUMENTO DEU CERTO)
                System.out.println("\nLista de funcionários:");
                for (Funcionario f : list) {
                    System.out.println(f);
                }
            }

            sc.close();
        }
    }

    // Função auxiliar para verificar se o ID já existe na lista
    public static boolean hasId(List<Funcionario> list, int id) {
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;
    }
} // <--- A CLASSE DO PROGRAMA FECHA AQUI COM SEGURANÇA!


// =========================================================================
// MEMORANDO DE ESTUDO VISUAL: BUSCANDO ELEMENTOS EM LISTA (STREAM & LAMBDA)
// =========================================================================
/*
 * O código abaixo faz exatamente o mesmo papel do loop 'for' que usamos no 'while':
 *
 * Funcionario func = list.stream()
 * .filter(aumento -> aumento.getId() == idAumento)
 * .findFirst()
 * .orElse(null);
 *
 * PASSO 1 - stream()
 * Transforma a lista em um Stream (fluxo de dados), permitindo operações encadeadas.
 * Lista:   [Maria, João, Ana]  ==>  Stream:  Maria ~~~~ João ~~~~ Ana
 *
 * PASSO 2 - filter()
 * Analisa cada objeto do fluxo. Mantém apenas os que atendem à regra da seta (->).
 * idAumento escolhido = 2
 * - Maria (id 1): 1 == 2 ? false ❌
 * - João  (id 2): 2 == 2 ? true  ✅
 * - Ana   (id 3): 3 == 2 ? false ❌
 * Resultado do filtro: [João]
 *
 * PASSO 3 - findFirst()
 * Retorna o primeiro elemento capturado dentro de um embrulho de proteção chamado Optional.
 * Resultado: Optional<Funcionario> (Contendo o João lá dentro)
 *
 * PASSO 4 - orElse(null)
 * Abre o embrulho do Optional. Se tiver alguém dentro, entrega o objeto. Se estiver vazio, retorna null.
 * - Se encontrou: Retorna a referência do funcionário João.
 * - Se não encontrou: Retorna null.
 *
 * MAPA MENTAL DO FLUXO SEU CÓDIGO:
 * Lista -> [Maria, João, Ana] -> stream() -> filter(id == idAumento) -> [João] -> findFirst() -> Optional(João) -> orElse(null) -> func
 *
 * -------------------------------------------------------------------------
 * EQUIVALENTE EM LOOP FOR (A abordagem clássica que você escolheu usar no While):
 * -------------------------------------------------------------------------
 * Funcionario func = null;
 * for (Funcionario aumento : list) {
 * if (aumento.getId() == idAumento) {
 * func = aumento;
 * break;
 * }
 * }
 */