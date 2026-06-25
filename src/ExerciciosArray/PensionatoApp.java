package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class PensionatoApp {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Instancia a classe de serviço que cuidará de toda a lógica do vetor
        PensionatoService pensionato = new PensionatoService();

        System.out.println("Quantos quartos vai alugar?: ");
        int N = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        for (int i = 1; i <= N; i++) {
            System.out.println();
            System.out.printf(" Aluguel nº #%dº: ", i);

            System.out.println("Nome do estudante: ");
            String name = sc.nextLine();

            System.out.println("Email do estudante: ");
            String email = sc.nextLine();

            System.out.print("Quarto nº?: ");
            int roomNumber = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            int contador = 0;
            // A validação visual continua no main, pois envolve interação por console
            while ((roomNumber <= 0 || roomNumber > 10) && contador < 2) {
                System.out.println("Digite de 1 a 10");
                System.out.print("Quarto nº?: ");
                roomNumber = sc.nextInt();
                sc.nextLine(); // Limpa o buffer
                contador++;
            }

            // O main envia os dados e o serviço decide como salvar
            boolean sucesso = pensionato.registrarAluguel(roomNumber, name, email);

            if (!sucesso) {
                System.out.println("Operação abortada, numero de quarto inexistente.");
            }
        }

        // Delega a exibição final para o serviço
        pensionato.exibirQuartosOcupados();

        sc.close();
    }
}



/*
1. O USUÁRIO digita os dados no console.
       │
       ▼
2. O MAIN (Porta de Entrada) lê as Strings e números.
       │
       ▼
3. O SERVIÇO (Regra de Negócio) recebe os textos do main, decide se há vaga,
   e se houver...
       │
       ▼
4. A CLASSE DE DADOS (RentClass) é instanciada. O construtor cria o objeto,
   os setters validam os campos e o objeto ganha vida na memória HEAP.
 */