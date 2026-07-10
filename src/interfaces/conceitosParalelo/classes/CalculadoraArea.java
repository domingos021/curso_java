package interfaces.conceitosParalelo.classes;

import interfaces.conceitosParalelo.model.FIiguraGeometrica;

public class CalculadoraArea {
    /*
    possibilidades
     Quadrado, Circulo
     Circulo, Quadrado
     Circulo, circulo
     */

    public double somarArea(FIiguraGeometrica Quadrado, FIiguraGeometrica circulo) {
        return Quadrado.calcularArea() + circulo.calcularArea();
    }
}
