package Gerador_constru_getters_setters;


public class Gerador {
    private final String nomeProduto;
    private final double precoProduto;
    private int quantidadeProduto;

    //construtor
    public Gerador(String nome, double preco, int quantidade) {
        this.nomeProduto = nome;
        this.precoProduto = preco;
        this.quantidadeProduto = quantidade;

    }

    //retono para uso publico acessado por outras classes
    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }


    // =========================================================================
    // MÉTODOS DE NEGÓCIO (Calculam e alteram os dados na Heap)
    // =========================================================================

    public double totalValueInStock() {
        return precoProduto * quantidadeProduto;
    }

    public void addProducts(int quantidade) {
        this.quantidadeProduto += quantidade; // Soma direto na variável da Heap
    }

    public void removeProducts(int quantidade) {
        this.quantidadeProduto -= quantidade; // Subtrai direto na variável da Heap
        /*

        [ Memória Stack: Método Main ]          [ Memória Heap: Objeto na Heap ]
     addQuantity = 5  -------------------------> quantidade = 5 (Parâmetro local)
                                                    |
                                                    v
                                      this.quantidadeProduto += quantidade;
                                                    ^
                                                    |
                                      (Atributo privado do Objeto)
         */
    }

    /*
       Para ficar bem visual, o fluxo que você descreveu funciona exatamente assim por baixo dos panos:

     [ Classe Main ]                               [ Objeto na Memória Heap ]
           |                                                   |
           | -- 1. Chama: produto.addProducts(addQuantity) --> |
           |                                                   | -- 2. Pega o valor atual do atributo (ex: 10)
           |                                                   | -- 3. Soma com o valor recebido (ex: +5)
           |                                                   | -- 4. Salva de volta no atributo usando 'this.quantidade = ...'
           |                                                   v
     */

    // =========================================================================
    // MÉTODO TOSTRING (Formatador visual para o System.out.println)
    // =========================================================================
    @Override
    public String toString() {
        return nomeProduto
                + ", $ "
                + String.format("%.2f", precoProduto)
                + ", "
                + quantidadeProduto
                + " unidades, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }
}

//GERAR CONTRUTORES, GETTER E SETTERS




/*
 * GERADOR DE CÓDIGO NO INTELLIJ IDEA
 *
 * Atalho:
 * Alt + Insert
 *
 * Para selecionar vários atributos:
 * Ctrl + clique nos atributos desejados
 * Mantendo Ctrl pressionado, selecione todos os campos necessários
 * e depois clique em OK.
 *
 * Opções disponíveis:
 * - Constructor
 * - Getter
 * - Setter
 * - Getter and Setter
 * - toString()
 * - equals() and hashCode()
 */