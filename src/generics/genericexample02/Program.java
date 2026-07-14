package generics.genericexample02;

import generals_utils.utils.Leitor;
import generics.genericexample01.services.PrintService;
import generics.genericexample02.model.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        /*
         * Aplicando Generics:
         *
         * A classe PrintService foi criada utilizando um parâmetro
         * de tipo genérico (T):
         *
         *      PrintService<T>
         *
         * Ao instanciar a classe, definimos qual será o tipo concreto
         * que substituirá o T.
         *
         * Neste caso:
         *
         *      PrintService<Person>
         *
         * significa que:
         *
         * - T passa a representar Person.
         * - A lista interna da PrintService será uma List<Person>.
         * - O método addValue(T value) passa a receber
         *   addValue(Person value).
         * - O método first() passa a retornar um objeto Person.
         *
         * O main não precisa conhecer como a PrintService armazena
         * os dados internamente. Ele apenas utiliza os recursos públicos
         * fornecidos pela instância.
         *
         * A mesma classe PrintService poderia ser utilizada com outros
         * tipos, por exemplo:
         *
         *      PrintService<String>
         *      PrintService<Integer>
         *      PrintService<Product>
         *
         * sem alterar a implementação da classe.
         */
        PrintService<Person> ps = new PrintService<>();

        try (Scanner sc = new Scanner(System.in)) {

            int n = Leitor.lerNumeroInteiro(sc, "Quantas pessoas deseja cadastrar? ");

            for (int i = 0; i < n; i++) {

                System.out.printf("%n=== %dª Pessoa ===%n", i + 1);

                String name = Leitor.lerTexto(sc, "Nome: ");
                int age = Leitor.lerNumeroInteiro(sc, "Idade: ");
                double height = Leitor.lerNumeroDouble(sc, "Altura: ");
                String email = Leitor.lerTexto(sc, "Email: ");

                Person person = new Person(name, age, height, email);

                ps.addValue(person); // public void addValue(T value) -> public void addValue(Person value)
            }

            System.out.println("\n===== PESSOAS CADASTRADAS =====");
            ps.print();

            System.out.println("\n===== PRIMEIRA PESSOA =====");
            System.out.println(ps.first());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}