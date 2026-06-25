package app;

import entities.products;
import java.util.Locale;
import java.util.Scanner;

public class programEstoque {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*
        =========================================================================
        CONCEITO CHAVE: INVERSÃO DE RESPONSABILIDADE NA INICIALIZAÇÃO
        =========================================================================
        - ANTES (Sem construtor customizado):
          O 'main' mandava o Java criar o objeto totalmente vazio. Ele nascia com
          os valores padrão da classe (null, 0.0, 0) na memória Heap. O 'main'
          tinha que ir lá preencher gaveta por gaveta depois através do "product.name = ...".

        - AGORA (Com construtor customizado):
          Houve uma INVERSÃO! O Java agora EXIGE que o 'main' forneça os dados válidos
          no exato instante do nascimento do objeto. O 'main' dita as regras e passa
          o "combustível" necessário. Se o 'main' não fornecer os dados dentro do 'new',
          o objeto sequer é criado. Isso garante consistência total e impede objetos fantasmas.
        */

        /*
        ATENÇÃO AO FLUXO DE EXECUÇÃO:
        Não podemos mais fazer 'products product = new products();' aqui no início.
        Como o construtor foi personalizado, o Java bloqueia a criação vazia.
        Por isso, primeiro coletamos os dados em VARIÁVEIS LOCAIS TEMPORÁRIAS (na Stack).
        */
        System.out.println("Digite os dados do produto: ");
        System.out.print("Nome do produto: ");
        //name agora vale "TV"
        String name = sc.nextLine(); // Variável temporária na memória Stack

        System.out.print("Preco do produto: ");
        double price = sc.nextDouble(); // Variável temporária na memória Stack

        System.out.print("Quantidade inicial: ");
        int quantity = sc.nextInt(); // Variável temporária na memória Stack

        // =========================================================================
        // A INSTANCIAÇÃO COM O CONSTRUTOR PERSONALIZADO
        // =========================================================================
        /*
          Aqui nós passamos as variáveis locais temporárias como ARGUMENTOS para o 'new'.
          O Java pega esses valores da Stack e joga direto para dentro das "gavetas"
          (atributos de instância) do objeto lá na memória Heap de uma vez só!
          O objeto já nasce 100% preenchido, seguro, blindado e pronto para uso.
        */
        //Product product = new Product(name, price, quantity); // Envia o "TV" lá para a classe
        products product = new products(name, price, quantity);

        // O Java chama implicitamente o método toString() customizado da sua classe aqui
        System.out.println("\nDados do produto: " + product);

        // --- VALIDAÇÃO DE ENTRADA ---
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

            // O método addProducts altera o atributo diretamente na memória Heap usando o 'this'
            product.addProducts(addQuantity);
            System.out.println("Dados atualizados: " + product);
        }

        // --- VALIDAÇÃO DE SAÍDA ---
        if (product.quantity > 0) {
            System.out.println();
            System.out.print("Digite o numero de produtos a ser removido do estoque: ");
            int removeQuantity = sc.nextInt();

            // Enquanto o usuário tentar tirar menos ou igual a zero,
            // OU tentar tirar mais do que o estoque possui, o loop prende ele aqui!
            while (removeQuantity <= 0 || removeQuantity > product.quantity) {
                if (removeQuantity <= 0) {
                    System.out.println("Erro: Digite um numero acima de zero!");
                } else {
                    System.out.println("Erro: Voce nao pode remover mais itens do que possui em estoque! (Disponivel: " + product.quantity + ")");
                }
                System.out.print("Digite o numero de produtos a ser removido do estoque: ");
                removeQuantity = sc.nextInt();
            }

            // Só atualiza o objeto quando a quantidade for perfeitamente válida
            product.removeProducts(removeQuantity);
            System.out.println("Dados atualizados: " + product);

        } else {
            System.out.println("\nEstoque indisponivel para remocao (Zerado).");
        }

        sc.close(); // Fecha o Scanner para evitar vazamento de memória (Memory Leak)
    }
}