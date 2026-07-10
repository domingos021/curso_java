package interfaces.herdar_vs_cuprirContrato.model.entities;


public class Retangle extends AbstractShape {

    // 1. Attributes
    private double width;
    private double height;

    // 2. Constructors


    public Retangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // 4. Methods
    @Override
    public double area() {
        return width * height;
    }

    // 3. Getters and Setters


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
