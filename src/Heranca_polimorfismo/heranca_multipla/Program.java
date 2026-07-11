package Heranca_polimorfismo.heranca_multipla;

import Heranca_polimorfismo.heranca_multipla.devices.Printer;
import Heranca_polimorfismo.heranca_multipla.devices.Scanner;

public class Program {
    public static void main(String[] args) {
        Printer pt = new Printer("1080");
        pt.processDoc("My letter");
        pt.print("My letter");

        Scanner sc = new Scanner("1800");
        sc.processDoc("My email");
        System.out.printf(" Scan result: %s%n ", sc.scan());
    }
}
