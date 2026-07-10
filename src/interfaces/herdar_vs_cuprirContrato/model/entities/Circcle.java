package interfaces.herdar_vs_cuprirContrato.model.entities;

/*
 * AbstractShape provides the implementation of the Shape interface.
 * Therefore, subclasses can extend AbstractShape instead of implementing
 * the Shape interface directly.
 *
 * AbstractShape implements only the color-related members.
 * The area() method is still abstract, so every concrete subclass
 * must provide its own implementation. Otherwise, the subclass
 * must also be declared abstract.
 */
public class Circcle extends AbstractShape {
    private Double radius;

    public Circcle(Color color, Double radius) {
        // super class (shape) has enum Color,
        // so we need to pass it to the constructor of the super class
        super(color);
        this.radius = radius;
    }
    // comes from the contract of the interface Shape
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
