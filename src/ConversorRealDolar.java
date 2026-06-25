import utilitarios.CurrencyConverter;
import utilitarios.Esfera;

import java.util.Locale;
import java.util.Scanner;

public class ConversorRealDolar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Cotação atual do dolar do $?: ");
        double cotacao = sc.nextDouble();

        System.out.print("quantos dólares vai comprar?: ");
        double quantidadeDolares = sc.nextDouble();

        // no metodo static não instanciamos, pegamos o resultado direto
        String resultado = CurrencyConverter.gerarRelatorio(quantidadeDolares, cotacao);

        System.out.println(resultado);
        sc.close();
    }
}
