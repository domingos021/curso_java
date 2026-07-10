package interfaces.exercFixacao.app;

import interfaces.exercFixacao.model.entities.Contract;
import interfaces.exercFixacao.model.entities.Installments;
import interfaces.exercFixacao.model.sevices.ContractService;
import interfaces.exercFixacao.model.sevices.PaypalService;
import interfaces.utils.Leitor;


import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Entre com os dados do contrato:");
            int contractNumber = Leitor.lerNumeroInteiro(sc, "Número do contrato:");
            LocalDate contractDate = Leitor.lerData(sc, "Data do contrato (dd/MM/yyyy):");
            double totalValue = Leitor.lerNumeroDouble(sc, "Valor total do contrato):");

            Contract  obj = new Contract(contractNumber, contractDate, totalValue);
            //PARCELAS

            int numberOfInstallments = Leitor.lerNumeroInteiro(sc, "Entre com o número de parcelas:");

            // O objeto PaypalService implementa a interface OnlinePaimentService.
            //
            // Por isso, podemos passar um objeto PaypalService para o construtor
            // de ContractService, que espera um objeto do tipo OnlinePaimentService.
            //
            // Dessa forma, quando o ContractService chamar os métodos interest()
            // e paymentFee() através da interface, o Java executará as implementações
            // existentes na classe PaypalService.
            ContractService contractService = new ContractService(new PaypalService());
            contractService.processContract(obj, numberOfInstallments);

            /*
            System.out.println("Parcelas geradas:");
          // Para cada objeto 'parcela' dentro da lista de parcelas do contrato (obj)
            for(Installments parcela : obj.getInstallments()) {
                System.out.println(parcela); // Exibe os dados da parcela (chama o método toString da classe)
            }

             */

            System.out.println("Parcelas geradas:");

            // Mudamos para o for tradicional utilizando um contador (i) para descobrir o índice atual.
            // O loop vai de 0 até o tamanho total da lista de parcelas do contrato.
            for (int i = 0; i < obj.getInstallments().size(); i++) {

                // Buscamos a parcela correspondente à posição 'i' dentro da lista
                Installments parcela = obj.getInstallments().get(i);

                // (i + 1) transforma o índice que começa em 0 em contagem humana (1ª, 2ª, 3ª...)
                // %dª insere o número ordinal e %s chama o toString() da parcela automaticamente
                System.out.printf("%dª %s%n", (i + 1), parcela);
            }



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
