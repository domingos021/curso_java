package jpa_hibernate.application;

import jpa_hibernate.dominio.Person;

public class Program {
    public static void main(String[] args) {
        Person p1 = new Person(1, "John Doe", "john.doe@example.com");
        Person p2 = new Person(2, "Jane Smith", "jane.smith@example.com");
        Person p3 = new Person(3, "Michael Johnson", "michael.johnson@example.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
