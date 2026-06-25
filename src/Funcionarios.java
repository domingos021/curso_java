import AppFuncuncionarios.FuncionarioInfo;

import java.util.Locale;
import java.util.Scanner;

public class Funcionarios {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        FuncionarioInfo func = new FuncionarioInfo();

        // VALIDAÇÃO DO NOME
        int tentativaNome = 0;
        while (tentativaNome < 2) {
            System.out.print("Digite o nome do funcionário: ");
            String nome = sc.nextLine();

            if (nome != null && !nome.trim().isEmpty()) {
                func.setNome(nome);// envia o nome ao metodo para validação
                break;

            }

            System.out.println("[ALERTA] Nome não pode ser vazio!");
            tentativaNome++;
        }

        // Se falhou as duas vezes, encerra o programa antes de pedir o salário
        if (func.getNome() == null) {
            System.out.println("[ERRO] Número de tentativas excedido para o NOME. Programa encerrado.");
            sc.close();
            return;
        }

        // VALIDAÇÃO DO SALÁRIO
        int tentativaSalario = 0;
        while (tentativaSalario < 2) {
            System.out.print("Digite o salário do funcionário: ");

            // Usar NextLine + Double.parseDouble evita quebras no buffer do Scanner
            try {
                double salarioBruto = Double.parseDouble(sc.nextLine());

                if (salarioBruto > 0) {
                    func.setSalarioBruto(salarioBruto);
                    break;
                }
                System.out.println("[ALERTA] Salário não pode ser zero ou negativo.");
            } catch (NumberFormatException e) {
                System.out.println("[ALERTA] Digite um número válido.");
            }

            tentativaSalario++;
        }

        // Se falhou as duas vezes no salário, encerra o programa
        if (func.getSalarioBruto() <= 0) {
            System.out.println("[ERRO] Número de tentativas excedido para o SALÁRIO. Programa encerrado.");
            sc.close();
            return;
        }

        // Exibe o resultado final formatado
        System.out.println("\n" + func);

        sc.close();
    }
}