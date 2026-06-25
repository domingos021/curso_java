package Gerador_constru_getters_setters;

import Encapsulamento.ProdutoEncapsulamento;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Digite o valor do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Digite o quantidade do produto: ");
        int quantidade = sc.nextInt();


        ProdutoEncapsulamento produto = new ProdutoEncapsulamento(nome, preco, quantidade);
        System.out.println(produto.getQuantidadeProduto());

        //NESSE CAS0 ESPECIFICO A VALIDAÇÃO PEGA OS ATRIBUTOS PREENCHIDO DIRETO DOS GETTER QUE TEM O VALOR DO
        //RETORO APOS A VALIDAÇÃO
        // --- SEU FLUXO DE VALIDAÇÃO DE ENTRADA (Continua idêntico e intacto!) ---
        // Se usar a OPÇÃO 1 (nasce com 0), vai entrar direto no 'else' pedindo para adicionar!

        if (produto.getQuantidadeProduto() >= 100) {
            System.out.println("Estoque alto: " + produto.getQuantidadeProduto());
        } else {
            System.out.println();

            System.out.print("Digite o numero de produtos a ser adicionado ao estoque: ");
            int addQuantity = sc.nextInt();

            while (addQuantity <= 0) {
                System.out.println("Erro: Digite um numero acima de zero!");
                System.out.print("Digite o numero de produtos a ser adicionado ao estoque: ");
                addQuantity = sc.nextInt();
            }

            produto.addProducts(addQuantity); // Soma os itens informados em cima do valor inicial da Heap
            System.out.println("Dados atualizados: " + produto);
        }

        // --- SEU FLUXO DE VALIDAÇÃO DE SAÍDA (Continua idêntico e funcionando perfeitamente) ---
        if (produto.getQuantidadeProduto() > 0) {
            System.out.println();
            System.out.print("Digite o numero de produtos a ser removido do estoque: ");
            int removeQuantity = sc.nextInt();

            while (removeQuantity <= 0 || removeQuantity > produto.getQuantidadeProduto()) {
                if (removeQuantity <= 0) {
                    System.out.println("Erro: Digite um numero acima de zero!");
                } else {
                    System.out.println("Erro: Voce nao pode remover mais itens do que possui em estoque! (Disponivel: " + produto.getQuantidadeProduto() + ")");
                }
                System.out.print("Digite o numero de produtos a ser removido do estoque: ");
                removeQuantity = sc.nextInt();
            }

            //acessa o metodo e passe o valor digitado para que o metodo faço os devidos calculos
            produto.removeProducts(removeQuantity);
            System.out.println("Dados atualizados: " + produto.getQuantidadeProduto());

        } else {
            System.out.println("\nEstoque indisponivel para remocao (Zerado).");
        }

        System.out.println(produto);

        sc.close(); // Fecha o Scanner para evitar vazamento de memória (Memory Leak)
    }


}

/*
 ==============================================================================
 CONCEITO: ENCAPSULAMENTO
 ==============================================================================

 O Encapsulamento é a técnica de design de software que esconde os detalhes
 internos de funcionamento de uma classe e protege seus dados (atributos).

 Pense nele como o painel de um carro: você tem acesso aos pedais e ao volante
 (interface pública), mas o motor e a parte elétrica ficam escondidos sob o
 capô (detalhes de implementação).

 Na prática, ele se baseia em dois pontos principais:

 1. Restrição de Acesso: Os atributos da classe são definidos como privados
    (private), impedindo que sejam modificados diretamente por outras classes.

 2. Interface Pública: O acesso e a modificação desses atributos são feitos
    exclusivamente através de métodos públicos, geralmente conhecidos como:
    - Getters (para ler o valor do atributo).
    - Setters (para modificar o valor do atributo, permitindo validações).

 VANTAGENS:
 - Segurança: Impede que o estado do objeto seja corrompido com valores inválidos.
 - Flexibilidade/Manutenibilidade: Você pode mudar a lógica interna da classe
   sem quebrar o restante do sistema que a utiliza.
 - Reutilização: O código se torna mais modular e fácil de testar.
 ==============================================================================
*/
