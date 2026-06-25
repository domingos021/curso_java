package entities;

public class products {
    public String name;
    public double price;
    public int quantity;  //atributo da classe

    // =========================================================================
    // CONSTRUTOR PERSONALIZADO (CUSTOM CONSTRUCTOR)
    // =========================================================================
    /*
      Este construtor substitui o construtor padrão automático do Java.

      PRINCIPAIS FUNÇÕES E CARACTERÍSTICAS:
      1. REGRA DE NEGÓCIO (SEGURANÇA): Obriga que o objeto já nasça com dados
         válidos (nome, preço e quantidade) no exato momento da instanciação ('new').
         Isso evita que existam produtos "vazios" ou incompletos no sistema.

      2. PALAVRA-CHAVE 'this': Resolve o conflito de nomes (Sombreamento de Variáveis).
         - 'this.name' refere-se ao ATRIBUTO da classe (lá em cima).
         - 'name' (sem o this) refere-se ao PARÂMETRO recebido aqui no construtor.

      3. IMPACTO NO MAIN: Ao declarar este construtor, a sintaxe antiga
         'new products()' deixa de existir, forçando o programador a passar
         os argumentos: 'new products(name, price, quantity)'.
    */
    //public Product(String name, double price, int quantity) { Recebe o "TV" na caixinha 'name'
    public products(String name, double price, int quantity) {
        this.name = name; // Atributo real recebe o valor do parâmetro!
        this.price = price;
        this.quantity = quantity;
    }

    //FUNÇÃO CALCULO DO TOTAL VALOR EM ESTOQUE
    public double totalValueInStock() {
        return quantity * price;
    }

    // =========================================================================
    // MÉTODOS DE MANIPULAÇÃO DE ATRIBUTOS (MÉTODOS DE NEGÓCIO)
    // =========================================================================

    //ADD PRODUCT, Recebendo argumentos
    //this referencia o atributo da class, não o parametro dentro da função
    public void addProducts(int quantity) {
        // O 'this.quantity' localiza o atributo do objeto lá na memória Heap
        // e soma a ele o valor da variável 'quantity' que veio do main.
        // this.quantity = this.quantity + quantity;
        this.quantity += quantity;
    }

    //REMOVE PRODUCT
    public void removeProducts(int quantity) {
        // O 'this.quantity' garante que estamos alterando o estoque real do objeto,
        // subtraindo a quantidade informada na validação do main.
        // this.quantity = this.quantity - quantity;
        this.quantity -= quantity;
    }

    // =========================================================================
    // SOBRESCRITA DE MÉTODO (OVERRIDE)
    // =========================================================================
    /*
      O método toString() pertence originalmente à classe Object do Java.
      Ao reescrevê-lo aqui, nós ensinamos ao Java como converter o nosso objeto
      'product' em texto legível automaticamente sempre que ele for chamado em um
      System.out.println(product), sem precisar puxar atributo por atributo no main.
    */
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + String.format("%d", quantity)
                + " units, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }
}