package progracaofuncional_lambda.interface_funcionais.apps;

import progracaofuncional_lambda.entities.Product;
import progracaofuncional_lambda.interface_funcionais.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * ============================================================
 * FUNÇÕES QUE RECEBEM OUTRAS FUNÇÕES COMO PARÂMETRO
 * ============================================================
 *
 * Na programação funcional, um método pode receber uma função
 * como argumento, da mesma forma que recebe um número, uma String
 * ou um objeto.
 *
 * No Java, isso é possível por meio das Interfaces Funcionais,
 * como:
 *
 * • Function<T, R>
 * • Consumer<T>
 * • Predicate<T>
 * • Supplier<T>
 * • Comparator<T>
 *
 * Essas interfaces representam funções e podem ser passadas
 * como parâmetro para outros métodos.
 *
 * Exemplo:
 *
 *      list.stream()
 *          .map(new ProductFunction())
 *          .collect(Collectors.toList());
 *
 * O método map() recebe uma Function<Product, String>.
 *
 * Ou seja:
 *
 * map( Function<T, R> )
 *
 * Neste caso:
 *
 * T = Product  -> tipo recebido
 * R = String   -> tipo retornado
 *
 * O método map() não sabe como transformar um Product.
 * Quem define essa transformação é a Function passada
 * como parâmetro.
 *
 * Esse conceito é conhecido como:
 *
 * → Funções de alta ordem (Higher-Order Functions)
 *
 * Uma função de alta ordem é aquela que:
 *
 * ✔ recebe outra função como parâmetro; ou
 * ✔ retorna uma função.
 *
 * Esse recurso torna o código mais flexível, reutilizável
 * e desacoplado.
 */
public class Func_Recb_Func_Param {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Locale.setDefault(Locale.US);

            ProductService ps = new ProductService();

            // ============================================================
            // ABORDAGEM 1: Lógica rígida (Hardcoded)
            // Usa o método filterSum() que possui o filtro com 'T' fixo internamente.
            // ============================================================
            List<Product> listAbordagem1 = new ArrayList<>();
            listAbordagem1.add(new Product("Teclado Mecânico", 350.00));
            listAbordagem1.add(new Product("Mouse Gamer", 180.00));
            listAbordagem1.add(new Product("TV Smart 50\"", 2800.00));
            listAbordagem1.add(new Product("Headset HyperX", 420.00));

            double soma1 = ps.filterSum(listAbordagem1);
            System.out.println("Abordagem 1 (Hardcoded - Apenas produtos que começam com 'T'):");
            System.out.println("Soma dos preços: R$ " + String.format("%.2f", soma1));
            System.out.println("--------------------------------------------------");


            // ============================================================
            // ABORDAGEM 2: Função de Alta Ordem (Imperativa com Predicate)
            // Usa o método filterSoma(), passando a regra via Expressão Lambda.
            // ============================================================
            List<Product> listAbordagem2 = new ArrayList<>();
            listAbordagem2.add(new Product("Tablet Samsung", 1500.00));
            listAbordagem2.add(new Product("Notebook Dell", 4500.00));
            listAbordagem2.add(new Product("Toalha de Mesa", 60.00));
            listAbordagem2.add(new Product("Carregador USB", 90.00));

            // Aqui passamos a função do filtro como argumento (filtra produtos que começam com 'T')
            double soma2 = ps.filterSoma(listAbordagem2, p -> p.getName().charAt(0) == 'N');
            System.out.println("Abordagem 2 (Parametrizada - Lambda que inicia com 'T'):");
            System.out.println("Soma dos preços: R$ " + String.format("%.2f", soma2));
            System.out.println("--------------------------------------------------");


            // ============================================================
            // ABORDAGEM 3: Funcional Moderna (Java Streams)
            // Usa o método filterSomaStream(), combinando Predicate + Streams.
            // Podemos alterar facilmente o critério no parâmetro.
            // ============================================================
            List<Product> listAbordagem3 = new ArrayList<>();
            listAbordagem3.add(new Product("Temonitor LG 24\"", 980.00));
            listAbordagem3.add(new Product("Cadeira Ergonômica", 1200.00));
            listAbordagem3.add(new Product("Teclado Sem Fio", 220.00));
            listAbordagem3.add(new Product("Webcam Full HD", 310.00));

            // Exemplo variando o filtro funcional (somando produtos com preço maior que R$ 300.00)
            double soma3 = ps.filterSomaStream(listAbordagem3, p -> p.getPrice() > 300.00);
            System.out.println("Abordagem 3 (Streams - Lambda para preço > R$ 300.00):");
            System.out.println("Soma dos preços: R$ " + String.format("%.2f", soma3));

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}