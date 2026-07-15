package generics.tipos_curinga.delimitado.model.entities;

import generics.tipos_curinga.delimitado.Shape_curing;

public class Circle_coringa implements Shape_curing {
    private Double radius;

    public Circle_coringa(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(radius, 2);
        //ou Math.PI * radius * radius;
    }
}
