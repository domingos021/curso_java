package Heranca_polimorfismo.classes_abstratas.exercicioFixac.entities;

import Heranca_polimorfismo.classes_abstratas.exercicioFixac.Color;

public class Circle extends Shape {
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public  double area(){
        //calculo da area do circulo
        return Math.PI* radius * radius ;
    }

}
