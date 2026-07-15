package generics.tipos_curinga.delimitado.model.entities;

import generics.tipos_curinga.delimitado.Shape_curing;

public class Rectangle_curinga implements Shape_curing {

    private Double width;
    private Double height;

    public Rectangle_curinga(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

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

    @Override
    public Double area() {
        return width * height;
    }
}
