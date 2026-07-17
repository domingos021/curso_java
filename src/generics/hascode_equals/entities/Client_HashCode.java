package generics.hascode_equals.entities;

import java.util.Objects;

public class Client_HashCode {

    private String name;
    private String email;

    public Client_HashCode(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {

        // Se as duas referências apontam para o mesmo objeto,
        // eles são obrigatoriamente iguais.
        if (this == obj) {
            return true;
        }

        // Retorna false caso o objeto seja nulo
        // ou pertença a uma classe diferente.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Converte o Object para Client_HashCode
        // para que seus atributos possam ser acessados.
        Client_HashCode other = (Client_HashCode) obj;

        // Compara 'name' e 'email' para determinar igualdade,
        // pois ambos juntos identificam unicamente o cliente.
        // Objects.equals() trata valores nulos com segurança.
        return Objects.equals(name, other.name) && Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {

        // Usa 'name' e 'email' para gerar o hash, respeitando o contrato:
        // objetos iguais pelo equals() devem ter o mesmo hashCode().
        // Objects.hash() aceita múltiplos atributos.
        return Objects.hash(name, email);
    }
}