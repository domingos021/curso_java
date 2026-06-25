package EnumeracaoComposicao.composicao.ExercFixacao;

import EnumeracaoComposicao.composicao.ExercFixacao.Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList; // Importado para gerenciar a lista temporária de itens
import java.util.Date;
import java.util.List; // Importado para gerenciar a lista temporária de itens
import java.util.Locale;
import java.util.Scanner;

public class ProgramExercApp {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDateText = sc.nextLine();

        /*
           Converte o texto digitado, por exemplo "20/06/2026",
           em um objeto Date
        */
        Date birthDate = sdf.parse(birthDateText);

        //preenche o construtor
        // Cria o objeto do tipo Client com os dados fornecidos pelo usuário
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("How many items to this order? "); // Ajustado de println para print para ficar estético
        int orderQt = sc.nextInt();

        /* CONCEITUALMENTE CORRIGIDO:
           Em vez de instanciar o 'order' aqui (antes do usuário digitar os itens),
           criamos uma lista temporária para funcionar como o "Carrinho de Compras".
        */
        List<OrderItem> carrinhoComItemsTemporarios = new ArrayList<>();

        for (int i = 1; i <= orderQt; i++) {

            System.out.println("Enter #" + i + " item data:");

            System.out.print("Product name: ");
            sc.nextLine(); // limpar buffer
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Product quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            // CORREÇÃO: Passando também o objeto 'product' para o construtor do OrderItem
            // (Ajuste conforme a assinatura exata que você definiu na sua classe OrderItem)
            OrderItem item = new OrderItem(productQuantity, productPrice, product);// associando o produto

            // Adiciona o item gerado no nosso carrinho temporário (Lista)
            /*
            add/remove => faz parte da funções nativas de uma lista
            */
            carrinhoComItemsTemporarios.add(item);
        }

        //exibe o item
        /* DICA VISUAL: Para exibir no formato do toString() do OrderItem pulando linha,
           você pode trocar depois por um loop 'for (OrderItem item : carrinhoComItemsTemporarios)'
        */
        for (OrderItem orderItem : carrinhoComItemsTemporarios) {
            // CORREÇÃO: Imprime a variável 'orderItem' que representa o item atual do loop
            System.out.println(orderItem);
        }



        /*
           =========================================================================
           FECHAMENTO DO PEDIDO (O MOMENTO CORRETO):
           Agora que o usuário preencheu todo o carrinho e terminou as interações,
           instanciamos o pedido oficial. O 'LocalDateTime.now()' vai capturar o
           segundo exato do checkout.

           Envia para o construtor os seguintes Requeridos:
           - Momento do pedido (capturado com LocalDateTime.now())
           - Status do pedido (inicialmente PENDING_PAYMENT)
           - O cliente que realizou a compra (objeto 'client' criado no início)
           =========================================================================
        */
        Order_exerc order = new Order_exerc(LocalDateTime.now(), OrderStatus.PENDING_PAYMENT, client);

        /*
        percorre a lista temporária (carrinhoComItemsTemporarios) e adiciona cada item ao pedido oficial (order)
        // Transfere todos os itens coletados no loop para dentro do pedido definitivo
        */
        for (OrderItem item : carrinhoComItemsTemporarios) {
            //metodo dentro do order_exerc responsavel por adicionar cada item a lista definitiva
            order.addItem(item);
        }

        // Você pode adicionar aqui um System.out.println(order) no futuro para testar o sumário do pedido!
        System.out.println();
        System.out.println(order);

        sc.close();
    }
}