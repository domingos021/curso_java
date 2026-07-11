package Heranca_polimorfismo.heranca_multipla.devices.model;

/*
 * Defines the contract for printing devices.
 *
 * Any class that implements this interface must provide an
 * implementation for the printDoc() method. By defining a
 * contract instead of a concrete implementation, this interface
 * allows different types of printers to provide their own
 * printing behavior while sharing the same API.
 */
public interface Printer {

    /*
     * Prints the specified document.
     *
     * @param doc the document to be printed.
     */
    void printDoc(String doc);

}