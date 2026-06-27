package Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities;

import Heranca_polimorfismo.classes_abstratas.exercicioFixac.Color;

/**
 * Representa uma forma geométrica genérica.
 * * POR QUE ESTA CLASSE É ABSTRATA?
 * Uma "Forma" (Shape) é um conceito abstrato demais no mundo real. Você não consegue
 * desenhar ou instanciar uma "forma" pura, você sempre desenha uma forma ESPECÍFICA
 * (um círculo, um retângulo, etc.).
 * * Portanto, definir esta classe como 'abstract' impede que ela seja instanciada
 * diretamente (ex: new Shape() gerará um erro de compilação).
 */
public abstract class Shape {
   private Color color;

   public Shape() {
   }

   public Shape(Color color) {
      this.color = color;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   /**
    * Calcula a área da forma geométrica.
    * * POR QUE ESTE MÉTODO É ABSTRATO? (Não possui implementação/corpo)
    * A classe 'Shape' NÃO possui dados suficientes para calcular uma área.
    * Cada forma geométrica possui uma fórmula matemática completamente diferente:
    * - Retângulo precisa de: largura * altura
    * - Círculo precisa de: PI * raio^2
    * - Triângulo precisa de: (base * altura) / 2
    * * Como a classe genérica 'Shape' não sabe qual fórmula aplicar, ela deixa o método
    * sem corpo (abstrato), servindo apenas como um COMPROMISSO/CONTRATO.
    * * OBRIGATORIEDADE: Qualquer classe filha concreta (como 'Rectangle' ou 'Circle')
    * será OBRIGADA a herdar este método e fornecer a sua implementação real (Override).
    */
   public abstract double area();
}