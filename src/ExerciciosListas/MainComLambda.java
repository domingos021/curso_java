package ExerciciosListas;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainComLambda {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criando uma lista de objetos do tipo Funcionario
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

                // Validação para não repetir o ID usando a função auxiliar (que usa Lambda)
                contador = 0;
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

                // Adiciona o novo funcionário na lista
                list.add(new Funcionario(id, nome, salario));
            }

            // ==========================================
            // PARTE DO AUMENTO (MODELO: EXPRESSÃO LAMBDA)
            // ==========================================

            Funcionario func = null;
            int tentativas = 0;

            // O loop roda enquanto não achar o funcionário E não estourar o limite de 2 tentativas
            while (func == null && tentativas < 2) {

                System.out.print("\nDigite o ID do funcionário que receberá aumento: ");
                int idAumento = sc.nextInt();

                // SUBSTUIÇÃO DO FOR: A expressão Lambda faz a busca e retorna o objeto ou null
                func = list.stream()
                        // Passa por cada funcionário da lista (chamado aqui de 'aumento'),
                        // pega o seu ID e compara com o ID digitado pelo usuário.
                        .filter(aumento -> aumento.getId() == idAumento)
                        .findFirst() // Pega o primeiro funcionário que passou no teste do filtro
                        .orElse(null); // Se encontrou alguém, entrega o objeto; se a lista ficou vazia, devolve null.findFirst()

                // Se a Lambda retornou null, significa que o ID não existe na lista
                if (func == null) {
                    tentativas++;

                    if (tentativas < 2) {
                        System.out.println("Este ID não existe! Tente novamente. (Tentativa " + tentativas + "/2)");
                    }
                }
            }

            // Verificamos como o loop terminou
            if (func == null) {
                System.out.println("Limite de tentativas excedido! Operação abortada.");
            } else {
                System.out.print("Digite a porcentagem do aumento: ");
                double porcentagem = sc.nextDouble();

                // Aplica o aumento diretamente no objeto encontrado pela Lambda
                func.aumentarSalario(porcentagem);

                // MOSTRAR LISTAGEM ATUALIZADA
                System.out.println("\nLista de funcionários:");
                // Aqui também podemos usar Lambda para imprimir a lista de forma moderna!
                list.forEach(f -> System.out.println(f));
            }

            sc.close();
        }
    }

    // Função auxiliar para verificar se o ID já existe na lista (Usa Stream/Lambda)
    public static boolean hasId(List<Funcionario> list, int id) {
        Funcionario func = list.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        return func != null;
    }
}
