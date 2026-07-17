package generics.set.set_iquals.entities;

import java.util.Objects;

public class Products_set {
    private String name;
    private Double price;

    public Products_set(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    // Compara os objetos pelo conteúdo (nome e preço),
// e não pela referência de memória.
    @Override
    public boolean equals(Object o) {

        // Verifica se o objeto recebido é null ou se pertence
        // a uma classe diferente de Products_set.
        if (o == null || getClass() != o.getClass()) return false;

        // Faz o casting do objeto recebido para Products_set,
        // permitindo acessar seus atributos.
        Products_set that = (Products_set) o;

        // Compara os atributos nome e preço.
        // Se ambos forem iguais, os objetos são considerados iguais.
        return Objects.equals(name, that.name)
                && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {

        // Gera um código hash baseado nos mesmos atributos
        // utilizados no equals().
        //
        // Regra importante:
        // Se dois objetos são iguais pelo equals(),
        // eles obrigatoriamente devem ter o mesmo hashCode().
        return Objects.hash(name, price);
    }
}
