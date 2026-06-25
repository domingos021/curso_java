package ExerciciosArray;

public class RentClass {

    private String name;
    private String email;

    public RentClass() {
        //construtor sem argumentos
    }

    public RentClass(String name, String email) {
        //Construtor com argumentos
        this.name = name;
        this.email = email;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    // Adicionado: Getter para o email
    public String getEmail() {
        return email;
    }

    // Adicionado: Setter para o email
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        // Ajustado de "PensonatoClass" para "RentClass"
        return "RentClass{" +
                "nome='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}