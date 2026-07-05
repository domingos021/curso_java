package interfaces;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Vehicle;
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
            O construtor de CarRental espera um objeto Vehicle.

            Por isso, não podemos passar apenas uma String (carModel),
            pois o relacionamento entre CarRental e Vehicle é de composição.

            Então criamos o objeto diretamente na chamada:

                new Vehicle(carModel)

            E o objeto resultante é passado como argumento do construtor.

            Isso significa que o CarRental "possui" um Vehicle completo,
            não apenas o nome do modelo.
            */
            CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));


        } catch (Leitor.LeituraInvalidaException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}