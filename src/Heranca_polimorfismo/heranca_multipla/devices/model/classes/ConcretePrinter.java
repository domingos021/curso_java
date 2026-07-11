package Heranca_polimorfismo.heranca_multipla.devices.model.classes;
import Heranca_polimorfismo.heranca_multipla.devices.model.Printer;
import Heranca_polimorfismo.heranca_multipla.devices.model.device.Device;

/*
 * ConcretePrinter extends the Device superclass while implementing
 * the Printer interface.
 *
 * This is a valid design in Java because a class can inherit from
 * only one superclass while implementing one or more interfaces.
 *
 * The superclass (Device) provides the common state and behavior
 * shared by all devices, whereas the interface (Printer) defines
 * a contract that specifies the printing capabilities the class
 * must implement.
 */
public class ConcretePrinter extends Device implements Printer {

    /*
     * Creates a new printer with the specified serial number.
     * from superclass Device
     * @param serialNumber the unique identifier assigned to the device.
     */
    public ConcretePrinter(String serialNumber) {
        super(serialNumber); // Initializes the inherited serialNumber attribute defined in Device.
    }

    /*
     * Simulates the document processing step before printing.
     * from the superclass Device
     * @param doc the document to be processed.
     */
    @Override
    public void processDoc(String doc) {
        System.out.printf("Printer processing %s: ", doc);
    }

    /*
     * Prints the specified document.
     * from interface
     * @param doc the document to be printed.
     */
    @Override
    public void printDoc(String doc) {
        System.out.printf("Printing %s ", doc);
    }
}