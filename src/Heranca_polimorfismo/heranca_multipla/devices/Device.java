package Heranca_polimorfismo.heranca_multipla.devices;

public abstract class Device {
    public String serialNumber;

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public abstract void processDoc(String doc);

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
