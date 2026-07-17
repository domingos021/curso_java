package generics.set.set_iquals;

import generics.genericosdelimitados.model.entities.Product;
import generics.set.set_iquals.entities.Products_set;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Cria um HashSet que armazenará objetos Products_set únicos.
        Set<Products_set> set = new HashSet<>();

        // Adiciona objetos Products_set ao conjunto.
        set.add(new Products_set("tv", 1200.00));
        set.add(new Products_set("tablet", 1500.00));
        set.add(new Products_set("notebook", 1550.00));

        // Cria um novo objeto para testar comparação com o Set.
        //new Products_set("notebook", 1550.00) true-> existe no conjunto set
        Products_set prod = new Products_set("notebook", 1550.00);

        // Verifica se o objeto existe dentro do conjunto.
        System.out.println(set.contains(prod));
    }
}
