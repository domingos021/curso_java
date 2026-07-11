package Heranca_polimorfismo.heranca_multipla.devices.model.device;

/*
 * Represents the base class for all devices in the system.
 *
 * This abstract class provides the common state and behavior
 * shared by all devices, such as the serial number.
 *
 * It also declares the processDoc() method as abstract,
 * requiring each concrete subclass to define how a document
 * should be processed before performing its specific operation
 * (such as printing or scanning).
 */
public abstract class Device {

    /*
     * Unique identifier assigned to the device.
     */
    private String serialNumber;

    /*
     * Creates a device with the specified serial number.
     *
     * @param serialNumber the unique identifier assigned to the device.
     */
    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /*
     * Processes the specified document.
     *
     * Each concrete device must provide its own implementation
     * describing how the document is prepared before its main
     * operation is executed.
     *
     * @param doc the document to be processed.
     */
    public abstract void processDoc(String doc);

    /*
     * Returns the device's serial number.
     *
     * @return the serial number.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /*
     * Updates the device's serial number.
     *
     * @param serialNumber the new serial number.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}