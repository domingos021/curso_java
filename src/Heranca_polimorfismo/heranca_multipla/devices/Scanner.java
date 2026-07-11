package Heranca_polimorfismo.heranca_multipla.devices;

public class Scanner extends Device {
    public Scanner(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.printf("Scanner processing %s: ", doc);
    }

    public String scan(){
        return "Scanned content";
    }
}
