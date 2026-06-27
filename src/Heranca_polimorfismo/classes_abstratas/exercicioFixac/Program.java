package Heranca_polimorfismo.classes_abstratas.exercicioFixac;

import Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities.Circle;
import Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities.Rectangle;
import Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities.Shape;
//import Heranca_polimorfismo.classes_abstratas.exercicioFixac.Color; // Certifique-se de importar o seu Enum Color

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // ====================================================================
        // 1. O BALDE GENÉRICO COM POLIMORFISMO
        // ====================================================================
        /*
         * POLIMORFISMO EM PRÁTICA:
         * Criamos uma lista do tipo 'Shape' (nossa superclasse genérica e abstrata).
         * * Como o Java aceita o polimorfismo, esta lista NÃO guarda objetos 'Shape' puros
         * (até porque a classe é abstrata e proíbe isso). Em vez disso, ela funciona como
         * um conjunto de referências/variáveis genéricas.
         * * Cada posição desta lista apontará para objetos de tipos diferentes na memória
         * (como Rectangle ou Circle), desde que eles herdem de Shape.
         */
        List<Shape> list = new ArrayList<>();

        System.out.print("Insira o valor das formas: ");
        int totalShapes = sc.nextInt();

        // Este laço apenas CRIA os objetos e guarda na lista
        for (int i = 1; i <= totalShapes; i++) {
            System.out.printf(" Dados da %dº forma: # %n", i);
            System.out.print("Retângulo ou Circulo? escolha uma da opções (r/c): ");
            char ch = sc.next().charAt(0);

            System.out.print("cor do retângulo ou circulo (BLACK/BLUE/RED): "); // ENUM
            Color color = Color.valueOf(sc.next().toUpperCase());

            if (ch == 'r') {
                System.out.print("largura: ");
                double width = sc.nextDouble();
                System.out.print("altura: ");
                double height = sc.nextDouble();

                // Instancia o retângulo e coloca direto na lista genérica
                list.add(new Rectangle(color, width, height));

            } else if (ch == 'c') {
                System.out.print("raio: ");
                double radius = sc.nextDouble();

                // Instancia o círculo e coloca na mesma lista genérica
                list.add(new Circle(color, radius));
            }
            System.out.println();
        }

        // ====================================================================
        // ONDE FOI FEITO: Nova seção de exibição (Depois que o primeiro for fechou)
        // ====================================================================
        System.out.println("FORMA DAS AREAS FORMATADAS:");

        // Criamos um novo laço exclusivo para percorrer a lista e exibir os dados
        for (Shape shape : list) {

            // O Java é inteligente! Em tempo de execução, ele olha para o objeto real:
            // - Se for Retângulo, ele usa a fórmula do retângulo.
            // - Se for Círculo, ele usa a fórmula do círculo.
            // Tudo isso chamando apenas o método abstrato genérico '.area()' !
            // Aqui aplicamos o 'instanceof' para descobrir quem é quem

            //QUEREMOS SABER SE VALOR E UM RETANGULO OU RAIO, PORISSO USAMOS O FORMATO PARA DISTINGUIR
            String formato = "";

            //se a forma for um retângulo
            if (shape instanceof Rectangle) {
                formato = "Retângulo";

                //se a forma for um raio
            } else if (shape instanceof Circle) {
                formato = "Círculo";
            }

            // Aqui imprimimos de forma limpa e identificada
            System.out.printf("%s (%s) - Área: %.2f%n",
                    formato,
                    shape.getColor(), // Vem por Herança
                    shape.area()      // Funciona por Polimorfismo
            );
        }

        sc.close();
    }
}