package Heranca_polimorfismo.heranca_multipla;

import Heranca_polimorfismo.heranca_multipla.devices.model.classes.ComboDevice;
import Heranca_polimorfismo.heranca_multipla.devices.model.classes.ConcretePrinter;
import Heranca_polimorfismo.heranca_multipla.devices.model.classes.ConcreteScanner;

public class Program {
    public static void main(String[] args) {

        System.out.println("========== CONCRETE PRINTER ==========");
        ConcretePrinter pt = new ConcretePrinter("1080");
        pt.processDoc("My letter");
        pt.printDoc("My letter");

        System.out.println();

        System.out.println("========== CONCRETE SCANNER ==========");
        ConcreteScanner sc = new ConcreteScanner("1800");
        sc.processDoc("My email");
        System.out.printf("Scan result: %s%n", sc.scan());

        System.out.println();

        System.out.println("========== COMBO DEVICE ==========");
        ComboDevice cd = new ComboDevice("2000");
        cd.processDoc("My combo document");
        cd.printDoc("My combo document");
        System.out.printf("Scan result: %s%n", cd.scan());
    }
}
