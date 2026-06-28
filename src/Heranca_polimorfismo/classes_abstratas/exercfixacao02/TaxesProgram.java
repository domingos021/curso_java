package Heranca_polimorfismo.classes_abstratas.exercfixacao02;

import Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities.CompanyTaxes;
import Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities.IndividualTaxPay;
import Heranca_polimorfismo.classes_abstratas.exercfixacao02.entities.TaxPayes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TaxesProgram {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Lista genérica da superclasse abstrata para aplicar Polimorfismo
        List<TaxPayes> taxesList = new ArrayList<>();

        System.out.print("Numero de contribuintes para calculo de impostos ");
        int n = sc.nextInt();

        // Loop de cadastro: inicia em 0 e vai até n-1 para controlar os índices corretamente
        for (int i = 0; i < n; i++) {
            // Exibe 'i + 1' apenas para fins estéticos na tela do usuário (1º, 2º...)
            System.out.printf("Dados do %dº contribuinte: %n", i + 1);
            System.out.print("Selecione o tipo de contribuinte (CNPJ / CPF): ");
            String tipoContribuinte = sc.next();

            // Validação de entrada: concede até 3 tentativas no total (entrada inicial + 2 no while)
            int contador = 0;
            while (!tipoContribuinte.equalsIgnoreCase("CNPJ") && !tipoContribuinte.equalsIgnoreCase("CPF") && contador < 2) {
                contador++;
                System.out.println("Opção inválida! Digite exatamente CPF ou CNPJ.");
                System.out.print("Selecione o tipo de contribuinte (CNPJ / CPF): ");
                tipoContribuinte = sc.next();
            }

            // Se após as tentativas a entrada continuar incorreta, interrompe o programa por segurança
            if (!tipoContribuinte.equalsIgnoreCase("CNPJ") && !tipoContribuinte.equalsIgnoreCase("CPF")) {
                System.out.println("SISTEMA ENCERRADO POR TENTATIVAS ERRADAS");
                sc.close();
                return; // Encerra o método main imediatamente
            } else {
                // Consome a quebra de linha (\n) deixada pendente pelo sc.next() no buffer do teclado
                sc.nextLine();

                // Fluxo para Pessoa Física
                if (tipoContribuinte.equalsIgnoreCase("CPF")) {
                    System.out.print("Nome da pessoa: ");
                    String name = sc.nextLine(); // Captura o nome completo com espaços

                    System.out.print("Faturamento anual: ");
                    double anualIncome = sc.nextDouble();

                    System.out.print("Gastos com saude: ");
                    double HealthExpenditures = sc.nextDouble();

                    // Polimorfismo: Instancia subclasse IndividualTaxPay dentro da lista de TaxPayes
                    taxesList.add(new IndividualTaxPay(name, anualIncome, HealthExpenditures));

                    // Fluxo para Pessoa Jurídica
                } else if (tipoContribuinte.equalsIgnoreCase("CNPJ")) {
                    System.out.print("Nome da empresa: ");
                    String name = sc.nextLine(); // Captura a razão social completa com espaços

                    System.out.print("Fraturamento anual: ");
                    double anualIncome = sc.nextDouble();

                    System.out.print("Numero de funcionários: ");
                    int numberOfEmployees = sc.nextInt();

                    // Polimorfismo: Instancia subclasse CompanyTaxes dentro da lista de TaxPayes
                    taxesList.add(new CompanyTaxes(name, anualIncome, numberOfEmployees));
                }
            }
        } // Fim do loop de cadastro

        // IMPRESSÃO DOS RELATÓRIOS (Executada uma única vez fora do loop principal)
        System.out.println("\nResumo de pagamento de impostos:");
        for (TaxPayes taxPay : taxesList) {
            System.out.printf("Nome: %s%n" +
                            "Fraturamento anual: $ %.2f%n" +
                            "Imposto a pagar: $ %.2f%n%n",
                    taxPay.getName(),
                    taxPay.getAnualIncome(),
                    taxPay.tax()); // Executa a implementação polimórfica do método tax() correspondente
        }

        // Cálculo acumulativo do total geral arrecadado
        double totalTaxes = 0.0;
        for (TaxPayes totalTax : taxesList) {
            totalTaxes += totalTax.tax();
        }

        System.out.println("----------------------------------------");
        System.out.printf("Total de impostos arrecadados: $ %.2f%n", totalTaxes);

        sc.close();
    }
}