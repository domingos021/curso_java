package Heranca_polimorfismo.exercicio_polimorfismo;

import Heranca_polimorfismo.exercicio_polimorfismo.entities.Employee;
import Heranca_polimorfismo.exercicio_polimorfismo.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Leitura de N funcionarios e salvar em uma lista
        List<Employee> empList = new ArrayList<>();

        //println => queda de linha print = sem quebra de linha
        System.out.print("How many employees you want to save? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee nº: #" + i + " data");

            // Perguntar se o funcionario e tercerizado ou efetivo
            System.out.print("Is the employee outsourced? (y/n) ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter employee name: ");
            sc.nextLine(); // consome a quebra linha
            String name = sc.nextLine();

            System.out.print("Enter employee hours: ");
            int hours = sc.nextInt();

            System.out.print("Enter employee value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Employee is outsourced. ");

                // Como a resposta foi "y", precisamos ler o valor adicional
                System.out.print("Enter additional charge: ");
                double additionalCharge = sc.nextDouble();

                /* * 1ª OPÇÃO: Usando variável temporária/auxiliar
                 * Upcasting: OutsourcedEmployee é uma subclasse de Employee, então pode ser tratado como Employee.
                 * Polimorfismo: a variável empTemporary tem tipo Employee, mas aponta para um objeto OutsourcedEmployee.
                 *
                 * Employee empTemporary = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                 * empList.add(empTemporary);
                 */

                // 2ª OPÇÃO: Inserir o objeto direto na lista (Mais limpa)
                empList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));

            } else {
                System.out.println("Employee is not outsourced.");

                /* * 1ª OPÇÃO: Usando variável temporária/auxiliar
                 * Employee empFixed = new Employee(name, hours, valuePerHour);
                 * empList.add(empFixed);
                 */

                // 2ª OPÇÃO: Inserir o objeto direto na lista (Mais limpa)
                // ✅ CORREÇÃO: Aqui instanciamos a classe comum Employee!
                empList.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("================ PAYMENTS:=================");

        // Laço for-each para percorrer a lista de funcionários
        //para cada funcionário emp na lista Emp, imprime o nome e pagamento
        for (Employee emp : empList) {
            // O polimorfismo acontece bem aqui: emp.payment() vai chamar o método
            // correto dependendo do objeto real que está na memória!
            System.out.printf("Funcionário: %s - $ %.2f%n",
                    emp.getName(), emp.payment()
            );
        }

        sc.close();
    }
}