package generics.genericexample01;

import generals_utils.utils.Leitor;
import generics.genericexample01.services.PrintService;

import java.util.Locale;
import java.util.Scanner;

public class GenProgramInteger {

    public static void main(String[] args) {
        /*
         * A classe PrintService foi declarada com um tipo genérico (T),
         * o que significa que ela pode trabalhar com diferentes tipos
         * de dados.
         *
         * O tipo real é definido no momento da instanciação.
         * Neste exemplo, T é substituído por Integer.
         *
         * Classe genérica:
         *     PrintService<T>
         *
         * Instanciação:
         *     PrintService<Integer> ps = new PrintService<>();
         *
         * A partir desse momento, todos os locais da classe onde existe T
         * passam a representar Integer.
         *
         * Exemplo:
         *     void addValue(T value)  ->  void addValue(Integer value)
         *     T first()               ->  Integer first()
         *
         * Dessa forma, continuamos utilizando todos os recursos da classe
         * (métodos, atributos e construtores), porém agora ela trabalha
         * exclusivamente com Integer, garantindo segurança de tipos
         * (Type Safety).
         *
         * Em resumo:
         *
         * - A classe é declarada como genérica utilizando um parâmetro de tipo (T).
         * - Quando a classe é utilizada, T é substituído por um tipo concreto.
         *
         * Funcionando de forma genérica:
         *     PrintService<T>
         *
         * Utilizando um tipo concreto:
         *     PrintService<Integer> ps = new PrintService<>();
         *
         * significado da sintaxe:
         *
         * - <T>         -> Declara que a classe é genérica.
         * - <Integer>   -> Define que, nesta utilização, T será Integer.
         * - <>          -> Diamond Operator.
         *                  O compilador infere automaticamente o tipo informado
         *                  à esquerda (Integer), evitando repetição.
         *
         * A partir desse momento:
         * - Todo T da classe passa a representar Integer.
         * - Os métodos passam a trabalhar apenas com Integer.
         * - O compilador impede a utilização de outros tipos, garantindo
         *   segurança de tipos (Type Safety).
         *
         * Essa definição vale apenas para esta instanciação.
         * Outras partes do programa podem utilizar a mesma classe
         * com tipos diferentes, por exemplo:
         *
         *     PrintService<String>
         *     PrintService<Double>
         *     PrintService<Product>
         *
         * Ou seja, uma única classe genérica pode gerar objetos que
         * trabalham com diferentes tipos, sem precisar duplicar código.

         */
        PrintService<Integer> ps = new PrintService<>();

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            int n = Leitor.lerNumeroInteiro(sc, "Quantos números: ");

            for (int i = 0; i < n; i++) {
                System.out.printf("%dª ", i + 1);

                int value = Leitor.lerNumeroInteiro(sc, "Valor: ");
                ps.addValue(value);
            }

            ps.print();
            System.out.println("Primeiro: " + ps.first());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}