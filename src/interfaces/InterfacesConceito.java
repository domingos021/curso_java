package interfaces;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Vehicle;
import interfaces.model.services.BrazilTaxService;
import interfaces.model.services.RentalService;
import interfaces.utils.Leitor;

import java.time.LocalDate; // Mantido caso precise usar no futuro
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

/*
 INTERFACE

 É um tipo que define um conjunto de operações (métodos) que uma classe
 deve implementar.

 Uma interface funciona como um contrato: qualquer classe que a implemente
 deve fornecer uma implementação para os métodos declarados na interface.

 As interfaces são utilizadas para definir comportamentos comuns entre
 diferentes classes, independentemente da hierarquia de herança.

 Isso torna o código mais flexível, reutilizável e desacoplado, pois o
 programa pode trabalhar com a interface em vez de depender de uma classe
 específica.
 */
public class InterfacesConceito {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Entre com os dados do aluguel ");

            //LEITURA DE TECLADO ATRAVES DE METODOS GENERICOS(CLASSE LEITOR)
            String  carModel = Leitor.lerTexto(sc, "Modelo do carro:");
            LocalDateTime start = Leitor.lerDataHora(sc, "Data da retirada do Carro (ex: 25/12/2026 14:30): ");
            LocalDateTime finish = Leitor.lerDataHora(sc, "Data da devolução do Carro (ex: 25/12/2026 14:30): ");

            //"A data de devolução é anterior à data de retirada?"
            while (finish.isBefore(start)) {
                System.out.println("Data de devolução não pode ser anterior a data de retirada.");
                finish = Leitor.lerDataHora(sc, "Data da devolução do Carro (ex: 25/12/2026 14:30):");
            }

              /*
                ===============================================================================
                CRIAÇÃO DO OBJETO CarRental
                ===============================================================================

                CarRental é a classe principal do aluguel.

                Ela possui como atributos:

                    - start  (data/hora da retirada)
                    - finish (data/hora da devolução)

                Além disso, CarRental possui um objeto Vehicle através de COMPOSIÇÃO.

                    CarRental
                        |
                        +----> Vehicle
                                    |
                                    +----> model

                O construtor de CarRental não recebe uma String representando o modelo do carro.

                Ele espera receber um objeto Vehicle.

                Por isso criamos o objeto Vehicle na própria chamada do construtor:

                    new Vehicle(carModel)

                O valor de carModel é enviado para o construtor de Vehicle, que o armazena
                em seu atributo model.

                Em seguida, o objeto Vehicle completo é enviado como argumento para o
                construtor de CarRental.

                Dessa forma:

                    carModel (String)
                            │
                            ▼
                    new Vehicle(carModel)
                            │
                            ▼
                    objeto Vehicle
                            │
                            ▼
                    new CarRental(start, finish, vehicle)

                Isso é um exemplo de COMPOSIÇÃO, pois CarRental TEM um Vehicle.
                ===============================================================================
                */

            CarRental carRental = new CarRental(start,finish,new Vehicle(carModel));

            double pricePerHour = Leitor.lerNumeroDouble(sc, "Preço por hora: ");
            double pricePerDay = Leitor.lerNumeroDouble(sc, "Preço por dia: ");

            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

            /*
            o metodo processInvoice na classe rentalService, recebe
             o carRental com a hora de retirada e devolução para calculo
             este metodo espera um objeto completo com os daddos passados via parametro nele
             */
            rentalService.processInvoice(carRental);

            System.out.printf(
                    "FATURA:%nPagamento básico: %.2f%nImposto: %.2f%nPagamento total: %.2f%n",
                    carRental.getInvoice().getBasicPayment(),
                    carRental.getInvoice().getTax(),
                    carRental.getInvoice().getTotalPayment()
                    // carRental esta associado ao invoice
                    //acessamos o invoice atravez do carRental

                    /*
                    carRental (Objeto Principal)
                       │
                       └───> getInvoice() (Retorna o objeto Invoice)
                                  │
                                  ├───> getBasicPayment()
                                  ├───> getTax()
                                  └───> getTotalPayment()
                     */
            );

        } catch (Leitor.LeituraInvalidaException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}