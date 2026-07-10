package interfaces.conceitosParalelo;


import interfaces.conceitosParalelo.classes.CalculadoraArea;
import interfaces.conceitosParalelo.classes.Circulo;
import interfaces.conceitosParalelo.classes.Quadrado;

import java.util.Locale;
import java.util.Scanner;

public class AppConceitosParalelo {

    public static void main(String[] args) {
        Locale .setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Circulo circulo = new Circulo(10);
        Quadrado quadrado = new Quadrado(5);

        CalculadoraArea calculadora = new CalculadoraArea();
        double areaTotal = calculadora.somarArea(quadrado, circulo);
        System.out.printf("A área total é: %.2f%n", areaTotal);


        sc.close();
    }
}
