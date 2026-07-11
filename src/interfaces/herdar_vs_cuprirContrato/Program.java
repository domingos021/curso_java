package interfaces.herdar_vs_cuprirContrato;

import interfaces.herdar_vs_cuprirContrato.model.entities.*;

public class Program {
    public static void main(String[] args) {

        /*
         * Polymorphism:
         * A reference of type AbstractShape can point to an object of any subclass of Shape.
         * Here, s1 points to a Circle object with a black color and a radius of 2.0,
         * while s2 points to a Rectangle object with a blue color, a width of 3.0,
         * and a height of 4.0.

         */
        AbstractShape s1 = new Circcle(Color.BLACK, 2.0);
        AbstractShape s2 = new Retangle(Color.BLUE, 3.0, 4.0);

        System.out.printf(
                " ========= Circle ============\n" +
                        "Circle Color: %s\n" +
                        "Circle Area: %.3f\n\n" +
                        "======== Rectangle ==========\n" +
                        "Rectangle Color: %s\n" +
                        "Rectangle Area: %.3f\n",

                /*
                 * Polymorphism:
                 * Both s1 and s2 are AbstractShape references.
                 * The getColor() method is inherited from AbstractShape,
                 * while the call to area() is resolved at runtime,
                 * invoking the implementation of each subclass.
                 */
                s1.getColor(),
                s1.area(),
                s2.getColor(),
                s2.area()
        );
    }
}


/*
*COMBINAÇÃO DE CLASSE ABSTRATA E INTERFACE
 *                     +------------------+
 *                     |      Shape       | <<interface>>
 *                     +------------------+
 *                     | + area(): double |
 *                     +------------------+
 *                              ▲
 *                              |
 *                     implements
 *                              |
 *                     +----------------------+
 *                     |    AbstractShape     | <<abstract>>
 *                     +----------------------+
 *                     | - color: Color       |
 *                     +----------------------+
 *                     | + getColor()         |
 *                     | + setColor()         |
 *                     +----------------------+
 *                              ▲
 *                extends       |       extends
 *                     +--------+--------+
 *                     |                 |
 *          +----------------+   +------------------+
 *          |     Circle     |   |    Rectangle     |
 *          +----------------+   +------------------+
 *          | - radius        |   | - width         |
 *          |                 |   | - height        |
 *          +----------------+   +------------------+
 *          | + area()        |   | + area()        |
 *          +----------------+   +------------------+
 *
 * AbstractShape partially implements the Shape interface.
 * It provides the common color attribute and its accessor methods,
 * while leaving the implementation of area() to its concrete subclasses.
 *
 * Therefore, every concrete subclass (Circle, Rectangle, etc.)
 * must implement area(). Otherwise, it must also be declared abstract.
 */