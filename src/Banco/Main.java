package Banco;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o numero da conta (6 digitos): ");
        String conta = sc.next();

        // --- VALIDAÇÃO DA CONTA ---
        int tentativaConta = 0;
        while (!conta.matches("\\d{6}") && tentativaConta < 2) {
            System.out.println("A conta deve conter exatamente 6 digitos.");
            System.out.println("Digite novamente o numero da conta:");
            conta = sc.next();
            tentativaConta++;
        }

        if (!conta.matches("\\d{6}")) {
            System.out.println("[ERRO] Conta inválida. Encerrando.");
            sc.close();
            return;
        }

        // =====================================================================
        // CORREÇÃO: Limpa o "\n" que ficou sobrando no buffer do Scanner
        // =====================================================================
        sc.nextLine();

        System.out.println("Nome completo do titular:");
        String nomeTitular = sc.nextLine();

        // --- VALIDAÇÃO DO NOME ---
        int tentativaNome = 0;
        while (nomeTitular.trim().isEmpty() && tentativaNome < 2) {
            System.out.println("[ALERTA] Nome não pode ser vazio!");
            System.out.println("Digite novamente:");
            nomeTitular = sc.nextLine();
            tentativaNome++;
        }

        if (nomeTitular.trim().isEmpty()) {
            System.out.println("[ERRO] Nome inválido. Encerrando.");
            sc.close();
            return;
        }

        // --- INSTANCIAÇÃO DO OBJETO (O Comandante enviando os dados validados) ---
        // Usando o Construtor 2 (Sem saldo inicial, nasce zerada)
        BancoClass obj = new BancoClass(conta, nomeTitular);

        System.out.println("\n--- DADOS DA CONTA CRIADA ---");
        System.out.println("Conta Bancaria: " + obj.getConta());
        System.out.println("Titular: " + obj.getNome());
        System.out.println("Saldo inicial: $ " + String.format("%.2f", obj.getSaldo()));

        int opcao = 0;
        while (opcao != 3) {

            // =====================================================================
            // FLUXO DE OPERAÇÕES BANCÁRIAS (Menu do Comandante)
            // =====================================================================
            System.out.println("\nEscolha a operação:");
            System.out.println("[1] Depositar");
            System.out.println("[2] Sacar");
            System.out.println("[3] Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            // --- CÓDIGO DO DEPÓSITO ---
            if (opcao == 1) {
                System.out.println();
                System.out.print("Quanto vai depositar: ");
                double addSaldo = sc.nextDouble();

                while (addSaldo <= 0) {
                    System.out.println("Erro: Digite um valor acima de zero!");
                    System.out.print("Digite o valor que deseja depositar: ");
                    addSaldo = sc.nextDouble();
                }

                obj.depositar(addSaldo); // Altera o estado na Heap
                System.out.println("Saldo atualizado: $ " + String.format("%.2f", obj.getSaldo()));
            }

            // --- CÓDIGO DO SAQUE ---
            else if (opcao == 2) {
                System.out.println();
                System.out.print("Quanto deseja sacar: ");
                double valorSaque = sc.nextDouble();

                // Mantém o while para garantir que o usuário não digite valor negativo ou zero
                while (valorSaque <= 0) {
                    System.out.println("Erro: Digite um valor acima de zero!");
                    System.out.print("Digite o valor que deseja sacar: ");
                    valorSaque = sc.nextDouble();
                }

                // REMOVEMOS O IF/ELSE! O Comandante confia na classe e manda sacar direto.
                // O Comandante manda sacar e já captura o "recibo" da taxa que a classe devolveu
                double taxaCobrada = obj.sacar(valorSaque); //manda e e devolvida de imediato apos metodo fazer o calculo

                System.out.println("Saque realizado com sucesso!");
                System.out.println("Taxa desta transação: $ " + String.format("%.2f", taxaCobrada));
                System.out.println("Saldo atualizado: $ " + String.format("%.2f", obj.getSaldo()));
            }

            // --- OPÇÃO DE SAÍDA CORRETA ---
            else if (opcao == 3) {
                System.out.println("\nEncerrando suas operações bancárias...");
            }

            // --- FILTRO DE SEGURANÇA CONTRA ERROS DO USUÁRIO ---
            else {
                System.out.println("[AVISO] Opção inválida! Escolha 1, 2 ou 3.");
            }


        }
        System.out.println(obj);
        System.out.println("Fim do sistema. Obrigado!");


        sc.close();
    }
}