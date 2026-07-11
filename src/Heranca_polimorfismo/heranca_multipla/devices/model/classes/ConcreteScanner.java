package Heranca_polimorfismo.heranca_multipla.devices.model.classes;

import Heranca_polimorfismo.heranca_multipla.devices.model.Scanner;
import Heranca_polimorfismo.heranca_multipla.devices.model.device.Device;

/*
 * ConcreteScanner extends the Device superclass while implementing
 * the Scanner interface.
 *
 * This is a valid design in Java because a class can inherit from
 * only one superclass while implementing one or more interfaces.
 *
 * The superclass (Device) provides the common state and behavior
 * shared by all devices, whereas the interface (Scanner) defines
 * a contract that specifies the scanning capabilities the class
 * must implement.
 */
public class ConcreteScanner extends Device implements Scanner {

    /*
     * Creates a new scanner with the specified serial number.
     * from the superclass Device
     * @param serialNumber the unique identifier assigned to the device.
     */
    public ConcreteScanner(String serialNumber) {
        super(serialNumber); // Initializes the inherited serialNumber attribute defined in Device.
    }

    /*
     * Simulates the document processing step before scanning.
     * from the superclass Device
     * @param doc the document to be processed.
     */
    @Override
    public void processDoc(String doc) {
        System.out.printf("Scanner processing %s: ", doc);
    }

    /*
     * Scans a document and returns its digital representation.
     *from the interface Scan
     * @return the scanned document as a String.
     */
    @Override
    public String scan() {
        return "Scanned content";
    }
}