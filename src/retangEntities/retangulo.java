package retangEntities;

/**
 * Classe que representa a entidade geométrica de um Retângulo.
 * Aplica os conceitos de Encapsulamento (atributos privados, getters e setters).
 */
public class retangulo {

    // Atributos privados: não podem ser acessados ou modificados diretamente fora da classe.
    // Os valores são controlados pelos métodos da própria classe, como os setters,
    // que validam os dados antes de armazená-los nos atributos.
    private double largura;
    private double altura;

    // Construtor padrão (vazio) - Boa prática para arquitetura e frameworks
    public retangulo() {
    }

    // ==========================================
    // MÉTODOS GETTERS E SETTERS (Controle de Acesso)
    // ==========================================

    // 1º-Retorna o valor atual da largura para que outras partes do programa possam utilizá-lo.
    public double getLargura() {
        return largura; // armazenado na variável privada, acontece depois da validação do setaltura/largura
    }

    // Define a largura aplicando a REGRA DE PROTEÇÃO com variável diferenciada
    public void setLargura(double larguraAceita) {
        // 1. Testa o valor que acabou de chegar do usuário
        if (larguraAceita > 0) {
            // 2. Se for válido, o atributo da classe (this.largura) recebe esse valor
            this.largura = larguraAceita;
        } else {
            // 3. Se for inválido, mostra no alerta o valor rejeitado (larguraAceita)
            System.out.println("[ALERTA] Largura inválida (" + larguraAceita + "). Deve ser maior que zero! Mantido: " + this.largura);
        }
    }

    //2ºRetorna o valor atual da altura para que outras partes do programa possam utilizá-lo.
    public double getAltura() {
        return altura;
    }

    // Define a altura aplicando a REGRA DE PROTEÇÃO com variável diferenciada
    public void setAltura(double alturaAceita) {
        // 1. Testa o valor que acabou de chegar do usuário
        if (alturaAceita > 0) {
            // 2. Se for válido, o atributo da classe (this.altura) recebe esse valor
            this.altura = alturaAceita; //manda alturaAceita para o atributo privado altura
        } else {
            // 3. Se for inválido, mostra no alerta o valor rejeitado (alturaAceita)
            System.out.println("[ALERTA] Altura inválida (" + alturaAceita + "). Deve ser maior que zero! Mantido: " + this.altura);
        }
    }

    // ==========================================
    // MÉTODOS DE CÁLCULO (Comportamentos do Objeto)
    // ==========================================

    // Cálculo da Área: largura * altura
    public double area() {
        return largura * altura;
    }

    // Cálculo do Perímetro: soma de todos os 4 lados
    public double perimetro() {
        return 2 * (largura + altura);
    }

    // Cálculo da Diagonal: Teorema de Pitágoras (d² = l² + a²)
    public double diagonal() {
        return Math.sqrt((largura * largura) + (altura * altura));
    }

    // ==========================================
    // MÉTODO TOSTRING (Formatação de Saída)
    // ==========================================

    // Transforma os dados do objeto em um texto organizado e formatado
    @Override
    public String toString() {
        return "========================================\n"
                + "        RESULTADOS DO RETÂNGULO         \n"
                + "========================================\n"
                + "Altura Cadastrada  : " + String.format("%.2f", altura) + "\n"
                + "Largura Cadastrada : " + String.format("%.2f", largura) + "\n"
                + "----------------------------------------\n"
                + "ÁREA               : " + String.format("%.2f", area()) + "\n"
                + "PERÍMETRO          : " + String.format("%.2f", perimetro()) + "\n"
                + "DIAGONAL           : " + String.format("%.2f", diagonal()) + "\n"
                + "========================================";
    }
}


/*
    System.out.print("Digite a largura: ");
    object.setLargura(sc.nextDouble());

    Passo a passo:
    1. Usuário digita 5
         ↓
    2. sc.nextDouble() captura o 5
             ↓
    3. setLargura(5) recebe o 5
             ↓
    4. setLargura() valida e armazena o 5

    Depois, quando você faz:
    if (object.getLargura() > 0)

    acontece:

    1. getLargura() pega o valor armazenado
             ↓
    2. retorna 5
             ↓
    3. o if compara 5 > 0



    Scanner (nextDouble)
    ↓
    Captura o valor digitado

    SET
    ↓
    Recebe e armazena o valor

    GET
    ↓
    Devolve o valor armazenado

    IF
    ↓
    Analisa o valor retornado pelo GET
 */