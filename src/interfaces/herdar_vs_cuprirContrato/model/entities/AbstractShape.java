package interfaces.herdar_vs_cuprirContrato.model.entities;

/*
 * AbstractShape partially implements the Shape interface.
 * It provides the color attribute and its accessor methods,
 * while leaving the area() method to be implemented by
 * its concrete subclasses.
 *
 * For example, AbstractShape explicitly implements the
 * Shape interface, but it does not provide an implementation
 * for the area() method because it is an abstract class.
 *
 * Therefore, every concrete subclass of AbstractShape
 * must implement the area() method. Otherwise, it must
 * also be declared abstract.
 */
public abstract class AbstractShape implements Shape {
    /*
     * Although the AbstractShape class implements the Shape interface,
     * which defines the contract for the area() method, it does not
     * provide an implementation for it.
     *
     * By declaring AbstractShape as abstract, Java allows the class
     * to omit the implementation of the interface method, leaving
     * this responsibility to its concrete subclasses.
     */

    // Shape color
    private Color color;

    // Initializes the shape with a color
    public AbstractShape(Color color) {
        this.color = color;
    }

    // Returns the shape color
    public Color getColor() {
        return color;
    }

    // Updates the shape color
    public void setColor(Color color) {
        this.color = color;
    }
}