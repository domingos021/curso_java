package Sobrecarga;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        // CONSTRUTOR PADRÃO (Default): Inicializa o objeto com "folha em branco".
        // O Java apenas aloca o espaço na Heap e preenche as variáveis com os valores
        // padrão do sistema (null para objetos/String, 0.0 para double e 0 para int).
        // Aqui a responsabilidade de preencher os dados é 100% do Main.
        SobrecargaClass sobrecarga = new SobrecargaClass();
        System.out.println("Nome do produto sem dado: " + sobrecarga.name);

        // A leitura de dados só é relevante se o construtor escolhido
        // exigir aquele parâmetro como argumento para instanciar o objeto.
        System.out.println("Digite os dados do produto (Testando Sobrecarga): ");
        System.out.print("Nome do produto: ");
        String name = sc.nextLine(); // Variável temporária na Stack

        System.out.print("Preco do produto: ");
        double price = sc.nextDouble(); // Variável temporária na Stack

        System.out.print("Quantidade do produto: ");
        int quantity = sc.nextInt(); // Variável temporária na Stack

        // =========================================================================
        // LABORATÓRIO DE TESTES: ESCOLHENDO O CONSTRUTOR DA SOBRECARGA
        // =========================================================================
        /*
          Alterne os comentários abaixo para testar os dois comportamentos:

          OPÇÃO 1 (Com 2 argumt): O produto nasce sem estoque (zerado) na Heap.
          OPÇÃO 2 (Com 3 argum): O produto nasce com a quantidade inicial informada.

          O Java faz a resolução em tempo de compilação batendo o número de argumentos!
        */

        //COSTRUTORES PERSONALIZADOS
        // SobrecargaClass product = new SobrecargaClass(name, price); // OPÇÃO 1: Construtor com 2 argumt
        SobrecargaClass product = new SobrecargaClass(name, price, quantity); // OPÇÃO 2: Construtor com 3 argum


        // Exibe o estado inicial do objeto de acordo com o construtor escolhido acima
        System.out.println("\nDados do produto cadastrado: " + product);

        // --- SEU FLUXO DE VALIDAÇÃO DE ENTRADA (Continua idêntico e intacto!) ---
        // Se usar a OPÇÃO 1 (nasce com 0), vai entrar direto no 'else' pedindo para adicionar!
        if (product.quantity >= 100) {
            System.out.println("Estoque alto: " + product.quantity);
        } else {
            System.out.println();
            System.out.print("Digite o numero de produtos a ser adicionado ao estoque: ");
            int addQuantity = sc.nextInt();

            while (addQuantity <= 0) {
                System.out.println("Erro: Digite um numero acima de zero!");
                System.out.print("Digite o numero de produtos a ser adicionado ao estoque: ");
                addQuantity = sc.nextInt();
            }

            product.addProducts(addQuantity); // Soma os itens informados em cima do valor inicial da Heap
            System.out.println("Dados atualizados: " + product);
        }

        // --- SEU FLUXO DE VALIDAÇÃO DE SAÍDA (Continua idêntico e funcionando perfeitamente) ---
        if (product.quantity > 0) {
            System.out.println();
            System.out.print("Digite o numero de produtos a ser removido do estoque: ");
            int removeQuantity = sc.nextInt();

            while (removeQuantity <= 0 || removeQuantity > product.quantity) {
                if (removeQuantity <= 0) {
                    System.out.println("Erro: Digite um numero acima de zero!");
                } else {
                    System.out.println("Erro: Voce nao pode remover mais itens do que possui em estoque! (Disponivel: " + product.quantity + ")");
                }
                System.out.print("Digite o numero de produtos a ser removido do estoque: ");
                removeQuantity = sc.nextInt();
            }

            product.removeProducts(removeQuantity);
            System.out.println("Dados atualizados: " + product);

        } else {
            System.out.println("\nEstoque indisponivel para remocao (Zerado).");
        }

        sc.close(); // Fecha o Scanner para evitar vazamento de memória (Memory Leak)
    }
}