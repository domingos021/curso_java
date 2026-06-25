package EnumeracaoComposicao.composicao.ExercFixacao.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // CORREÇÃO: Trocado de SimpleDateFormat para DateTimeFormatter
import java.util.ArrayList;
import java.util.List;

/*
==================================================================================
 DOCUMENTAÇÃO DE ARQUITETURA E DEPENDÊNCIAS DO SISTEMA
==================================================================================

 1. MAPA DE DEPENDÊNCIAS E DIRECIONALIDADE:
    [Program] --------> [Order_exerc] -------> [Client]
                             |
                             v
                        [OrderItem] ---------> [Product]

 2. QUEM DEPENDE DE QUEM E POR QUÊ?

    * Order_exerc DEPENDE DE Client (Associação 1:1)
      - Por quê? Um pedido não existe no vazio; ele precisa ser associado ao cliente
        que realizou a compra para sabermos quem vai pagar e receber.

    * Order_exerc DEPENDE DE OrderItem (Composição 1:N)
      - Por quê? O pedido precisa gerenciar a lista de itens comprados para calcular
        o valor total. Se o pedido for deletado, a lista de itens some com ele.

    * OrderItem DEPENDE DE Product (Associação 1:1)
      - Por quê? O item do pedido é apenas o "registro de compra" (Quantidade X Preço).
        Ele precisa saber qual produto está sendo comprado para buscar o nome e
        exibir no sumário.

    * Product NÃO DEPENDE DE NINGUÉM (Totalmente Desacoplado)
      - Por quê? Um produto ("Teclado Mecânico") existe no catálogo da loja
        independentemente de alguém tê-lo comprado ou não. Ele não sabe e não precisa
        saber quais pedidos o contêm. Isso evita dependências cíclicas no código.

==================================================================================
*/

public class Order_exerc {

    // CORREÇÃO: Formatador adequado para tipos LocalDateTime
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;

    /*
    Guarda o status atual do pedido.
    Exemplo: PENDING_PAYMENT, PROCESSING, SHIPPED, etc.
    */
    private OrderStatus status;

    /*
    RELAÇÃO: Associação Unidirecional (Order_exerc -> Client)
    O Pedido conhece o Cliente para quem está sendo gerado, mas o objeto Client
    permanece isolado e não conhece os pedidos do sistema.
    */
    private Client client;

    /*
    RELAÇÃO: Composição de Objetos (Order_exerc -> OrderItem)
    Lista serve guardar os items. Um pedido pode possuir vários itens.
    A lista começa vazia e recebe itens pelo método addItem().
    O ciclo de vida de OrderItem está preso ao de Order_exerc.
    */
    private final List<OrderItem> items = new ArrayList<>();

    public Order_exerc() {
        //Constructor padrão
    }

    public Order_exerc(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    //METODOS
    //adiciona e remove da lista
    public void addItem(OrderItem item) {
        items.add(item);  //pega o intem enviado pelo main e aciciona a lista items
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    /*
    Soma o subtotal de cada item que está no pedido.

    FLUXO DE EXECUÇÃO EM CASCATA:
    O método total() do Pedido delega a responsabilidade do cálculo do subtotal
    para cada OrderItem (multiplicação de preço por quantidade). O Pedido apenas
    acumula esses retornos.
    */
    public Double total() {
        Double sum = 0.0;
        for (OrderItem item : items) {
        /*
          O item é calculado antes pelo método subTotal() do OrderItem,
          que retorna o valor do item (preço * quantidade).
          Só então é armazenado na variável sum, que no final é retornada
          como o total do pedido.
        */
            sum += item.subTotal();
        }
        return sum;
    }

    /*
    O toString() do Pedido monta o cabeçalho, mas para exibir o Cliente e os Itens,
    ele delega a formatação chamando implicitamente o toString() de 'client'
    e o toString() de cada 'item' presente na lista.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        // CORREÇÃO: Alterado de sdf.format() para dtf.format() para aceitar o LocalDateTime
        sb.append("Order moment: ").append(dtf.format(moment)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client).append("\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }
}