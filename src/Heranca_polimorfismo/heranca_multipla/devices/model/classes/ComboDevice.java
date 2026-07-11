package Heranca_polimorfismo.heranca_multipla.devices.model.classes;
/*
 * Java does not support multiple inheritance of classes.
 * A class can extend only one superclass.
 *
 * The following declaration is invalid because Java does not allow
 * a class to extend more than one parent class:
 *
 *     public class ComboDevice extends Scanner extends Printer {
 *         public ComboDevice(String serialNumber) {
 *             super(serialNumber);
 *         }
 *     }
 *
 * This restriction avoids problems such as the "Diamond Problem",
 * where a class could inherit conflicting implementations of the
 * same method from multiple parent classes.
 *
 * To achieve multiple inheritance of behavior, Java uses interfaces.
 * A class may extend a single superclass while implementing one or
 * more interfaces, combining different capabilities in a safe and
 * flexible way.
 */


import Heranca_polimorfismo.heranca_multipla.devices.model.Printer;
import Heranca_polimorfismo.heranca_multipla.devices.model.Scanner;
import Heranca_polimorfismo.heranca_multipla.devices.model.device.Device;



public class ComboDevice extends Device implements Scanner, Printer {
    public ComboDevice(String serialNumber) {
        super(serialNumber);

    }

    @Override  //From Device
    public void processDoc(String doc) {
        System.out.println(" Combo Processing " + doc);
    }

    @Override // From interface Printer
    public void printDoc(String doc) {

        System.out.println(" Combo Printing " + doc);
    }

    @Override // From interface Scanner
    public String scan() {
        return " Combo Scanning result...";
    }
}


