package Heranca_polimorfismo.heranca_multipla.devices.model;

/*
 * Defines the contract for scanning devices.
 *
 * Any class that implements this interface must provide an
 * implementation for the scan() method. By defining a contract
 * instead of a concrete implementation, this interface allows
 * different types of scanners to provide their own scanning
 * behavior while exposing a common API.
 */
public interface Scanner {

    /*
     * Scans a document and returns its digital representation.
     *
     * @return the scanned document as a String.
     */
    String scan();
}