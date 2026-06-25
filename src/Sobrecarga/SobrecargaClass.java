package Sobrecarga;

public class SobrecargaClass {

    // 1. ATRIBUTOS DE INSTÂNCIA (Gavetas na memória Heap)
    public String name;
    public double price;
    public int quantity;

    //construtor padrão
    public SobrecargaClass() {

    }

    // =========================================================================
    // CONCEITO CHAVE: SOBRECARGA DE CONSTRUTORES (OVERLOAD)
    // =========================================================================
    /*
      Aqui está a Sobrecarga na prática! Temos dois construtores com o mesmo nome
      da classe, mas com listas de parâmetros diferentes. O Java decide qual usar
      com base nos argumentos que você enviar no 'new' lá no seu Main.
    */

    // CONSTRUTOR 01: Padrão completo (Recebe 3 parâmetros)
    // Usado quando o produto já entra no sistema com um estoque inicial.
    public SobrecargaClass(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // CONSTRUTOR 02: SOBRECARREGADO (Recebe apenas 2 parâmetros)
    // Usado quando o produto é novo e vai nascer com a quantidade zerada (0) na Heap.
    public SobrecargaClass(String name, double price) {
        this.name = name;
        this.price = price;
        // Opcional: this.quantity = 0;
        // (O Java já inicializa o 'int' como zero por padrão se não passarmos nada)
    }

    // =========================================================================
    // MÉTODOS DE NEGÓCIO (Calculam e alteram os dados na Heap)
    // =========================================================================

    public double totalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity; // Soma direto na variável da Heap
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity; // Subtrai direto na variável da Heap
    }

    // =========================================================================
    // MÉTODO TOSTRING (Formatador visual para o System.out.println)
    // =========================================================================
    @Override
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " unidades, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }
}
