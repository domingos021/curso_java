package Heranca_polimorfismo.heranca_multipla.devices;

public class Printer extends Device{
    public Printer(String serialNumber) {
        super(serialNumber); //get seriaNumber from argument and send to the superclass
    }

    @Override
    public void processDoc(String doc) {
        System.out.printf("Printer processing %s: ", doc);
    }

    public void print(String doc) {
        System.out.printf("Printing %s ", doc);
    }
}
