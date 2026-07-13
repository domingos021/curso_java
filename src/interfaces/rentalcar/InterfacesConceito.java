package interfaces.rentalcar;

// IMPORTS DOS SEUS CONCEITOS (Subpastas)


// OUTROS IMPORTS


import generals_utils.utils.Leitor;
import interfaces.rentalcar.model.entities.CarRental;
import interfaces.rentalcar.model.entities.Vehicle;
import interfaces.rentalcar.model.services.BrazilTaxService;
import interfaces.rentalcar.model.services.RentalService;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

/*
 INTERFACE
 É um tipo que define um conjunto de operações (métodos) que uma classe deve implementar.
 ...
 */
public class InterfacesConceito {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Entre com os dados do aluguel ");

            // LEITURA DE TECLADO ATRAVÉS DE MÉTODOS GENÉRICOS (CLASSE LEITOR)
            String carModel = Leitor.lerTexto(sc, "Modelo do carro:");
            LocalDateTime start = Leitor.lerDataHora(sc, "Data da retirada do Carro (ex: 25/12/2026 14:30): ");
            LocalDateTime finish = Leitor.lerDataHora(sc, "Data da devolução do Carro (ex: 25/12/2026 14:30): ");

            //"A data de devolução é anterior à data de retirada?"
            while (finish.isBefore(start)) {
                System.out.println("Data de devolução não pode ser anterior a data de retirada.");
                finish = Leitor.lerDataHora(sc, "Data da devolução do Carro (ex: 25/12/2026 14:30):");
            }

            // ✨ CORRIGIDO: Adicionado o tipo 'CarRental' no início da declaração
            CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

            double pricePerHour = Leitor.lerNumeroDouble(sc, "Preço por hora: ");
            double pricePerDay = Leitor.lerNumeroDouble(sc, "Preço por dia: ");

            // ✨ CORRIGIDO: Removido o caminho de pacote incompleto/errado
            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

            /*
             O método processInvoice na classe rentalService recebe o carRental
             com a hora de retirada e devolução para cálculo.
             */
            rentalService.processInvoice(carRental);

            System.out.printf(
                    "FATURA:%nPagamento básico: %.2f%nImposto: %.2f%nPagamento total: %.2f%n",
                    carRental.getInvoice().getBasicPayment(),
                    carRental.getInvoice().getTax(),
                    carRental.getInvoice().getTotalPayment()
            );

        } catch (Leitor.LeituraInvalidaException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}