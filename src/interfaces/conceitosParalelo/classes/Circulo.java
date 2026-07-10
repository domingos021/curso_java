package interfaces.conceitosParalelo.classes;

import interfaces.conceitosParalelo.model.FIiguraGeometrica;

public class Circulo implements FIiguraGeometrica {

    // 1. Atributos
    private int radius;

    // 2. Construtores
    public Circulo() {
    }

    public Circulo(int radius) {
        this.radius = radius;
    }

    @Override  //sobrescreve a interface
    public double calcularArea() {
        //double area = Math.PI * radius * radius;
        return Math.PI * Math.pow(radius, 2);
    }

    /*
        // 3. Métodos públicos (regras de negócio)
        public double calcularArea() {
            //double area = Math.PI * radius * radius;
            return Math.PI * Math.pow(radius, 2);
        }
   */


    // 4. Getters e Setters
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
