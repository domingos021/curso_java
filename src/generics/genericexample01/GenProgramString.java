package generics.genericexample01;

import generals_utils.utils.Leitor;
import generics.genericexample01.services.PrintService;

import java.util.Locale;
import java.util.Scanner;

public class GenProgramString {

    public static void main(String[] args) {
        /*
         * ========================= GENERICS =========================
         *
         * A classe PrintService foi declarada utilizando um parâmetro
         * de tipo genérico (T). Isso significa que ela não foi criada
         * para trabalhar com um tipo específico, mas sim com qualquer
         * tipo definido no momento de sua utilização.
         *
         * Declaração da classe:
         *
         *      PrintService<T>
         *
         * O parâmetro T (Type) é apenas um marcador (placeholder)
         * que representa um tipo desconhecido até que a classe seja
         * instanciada.
         *
         * ============================================================
         * DEFININDO O TIPO CONCRETO
         * ============================================================
         *
         * Ao criar um objeto da classe, informamos qual será o tipo
         * que substituirá T.
         *
         * Exemplo:
         *
         *      PrintService<String> ps = new PrintService<>();
         *
         * Nesse momento:
         *
         * - T passa a representar String.
         * - Todos os métodos e atributos que utilizam T passam a
         *   utilizar String.
         * - O compilador impede a utilização de outros tipos,
         *   garantindo segurança de tipos (Type Safety).
         *
         * Exemplo da substituição:
         *
         *      Antes (classe genérica)
         *
         *          void addValue(T value)
         *          T first()
         *
         *      Depois da instanciação
         *
         *          void addValue(String value)
         *          String first()
         *
         * ============================================================
         * SIGNIFICADO DA SINTAXE
         * ============================================================
         *
         * PrintService<T>
         *      -> Declara uma classe genérica.
         *
         * PrintService<String>
         *      -> Define que, nesta utilização, T será String.
         *
         * new PrintService<>()
         *      -> O operador Diamond (<>).
         *         Ele permite que o compilador descubra
         *         automaticamente o tipo informado à esquerda,
         *         evitando escrever:
         *
         *              new PrintService<String>()
         *
         * ============================================================
         * REUTILIZAÇÃO
         * ============================================================
         *
         * A mesma classe pode ser utilizada com diferentes tipos,
         * sem modificar sua implementação.
         *
         * Exemplos:
         *
         *      PrintService<String>
         *      PrintService<Integer>
         *      PrintService<Double>
         *      PrintService<Product>
         *
         * Ou seja, uma única implementação atende vários tipos
         * diferentes.
         *
         * ============================================================
         * IMPORTANTE
         * ============================================================
         *
         * O objeto criado NÃO é do tipo String.
         *
         * O objeto é do tipo:
         *
         *      PrintService<String>
         *
         * O tipo String apenas informa que todos os locais onde
         * existe T dentro da classe passarão a representar String.
         *
         * Da mesma forma:
         *
         *      PrintService<Integer>
         *
         * faz com que T passe a representar Integer.
         *
         * ============================================================
         * RESUMINDO
         * ============================================================
         *
         * ✔ A classe nasce genérica (T).
         * ✔ O tipo concreto é definido na instanciação.
         * ✔ T é substituído pelo tipo informado (String, Integer etc.).
         * ✔ O compilador garante que apenas esse tipo será utilizado.
         * ✔ A mesma classe pode ser reutilizada com inúmeros tipos,
         *   evitando duplicação de código e aumentando a reutilização.
         */
        PrintService<String> ps = new PrintService<>();
        //ps.addValue(00); => aqui da erro porque agora o valor esperado e uma ‘String’

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            int n = Leitor.lerNumeroInteiro(sc, "Quantidade: ");

            for (int i = 0; i < n; i++) {
                System.out.printf("%dª ", i + 1);

                String value = Leitor.lerTexto(sc, "Valor: ");
                ps.addValue(value);
            }

            ps.print();
            System.out.println("Primeiro: " + ps.first());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}