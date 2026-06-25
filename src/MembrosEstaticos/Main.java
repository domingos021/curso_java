package MembrosEstaticos;

import utilitarios.Esfera;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // 1. Captura o dado do usuário igualzinho
        System.out.print("Digite o raio: ");
        double raio = sc.nextDouble();

        System.out.println();

        // 2. MODELO ESTÁTICO: Não damos "new".
        // Chamamos direto a classe 'Esfera' e passamos o raio para o método que gera o texto
        String resultado = Esfera.gerarRelatorio(raio);
        System.out.println(resultado);

        sc.close();
    }
}

/*
[ OBJETO INSTANCIADO (new) ]               [ CLASSE ESTÁTICA (static) ]
Cada cliente cria o seu próprio carrinho       A regra do imposto é uma lei única

   +------------------------------------+          +------------------------------------+
           |         CarrinhoCompra             |          |          CalculadoraFiscal         |
        +------------------------------------+          +------------------------------------+
        | - cliente: "Domingos"              |          | + static calcularICMS(valor)       |
        | - totalProdutos: 150.00            |          +------------------------------------+
        +------------------------------------+                            ^
        |                                               |
        +--- (chama para aplicar a taxa) ---------------+

 */