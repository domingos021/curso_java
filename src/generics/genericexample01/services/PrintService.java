package generics.genericexample01.services;


import java.util.ArrayList;
import java.util.List;

/*
 * T é um parâmetro de tipo genérico (Type).
 *
 * Embora possa ter qualquer nome, por convenção utiliza-se
 * letras como T (Type), E (Element), K (Key) e V (Value).
 *
 * O tipo real será definido quando a classe, interface
 * ou método for utilizado.
 *
 * Isso permite criar código reutilizável e seguro,
 * sem ficar preso a um tipo específico.
 *
 * Exemplo:
 *     PrintService<T>
 *
 * Ao utilizar a classe:
 *     PrintService<String>
 *     PrintService<Integer>
 *
 * Nesses casos, T será substituído por String e Integer,
 * respetivamente.
 * *
 * *Essa classe esta parametrizada com tipo (T)
 */
public class PrintService<T> {
    List<T> list = new ArrayList<>(); //generic list

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("list' is empty");
        }
        return list.get(0);
    }


    // Printing the list
    public void print() {
        System.out.print("[");

        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }

        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }

        System.out.println("]");
    }


}
