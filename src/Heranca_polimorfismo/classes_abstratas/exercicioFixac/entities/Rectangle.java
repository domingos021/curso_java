package Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities;

import Heranca_polimorfismo.classes_abstratas.exercicioFixac.Color;

/**
 * CLASSE FILHA CONCRETA
 * * Como 'Shape' é uma classe abstrata com um método abstrato (area()),
 * a classe 'Rectangle' é OBRIGADA a fornecer uma implementação real para esse método.
 * * Aqui, nós temos os dados específicos que a classe mãe não tinha: 'width' e 'height'.
 */
public class Rectangle extends Shape {

    private Double width;
    private Double height;

    // Construtor padrão
    public Rectangle() {
        super();
    }

    // Construtor com argumentos (repassando a cor para a classe mãe)
    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // --- GETTERS E SETTERS ---

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * SOBRESCRITA OBRIGATÓRIA DO MÉTODO ABSTRATO
     * * @Override indica ao compilador que estamos cumprindo o contrato da classe mãe.
     * * Agora o método NÃO É MAIS ABSTRATO, ele tem um corpo `{}` e a fórmula matemática
     * real para calcular a área de um retângulo.
     */
    @Override
    public double area() {
        return width * height;
    }
}