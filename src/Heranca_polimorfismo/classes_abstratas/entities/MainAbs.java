package Heranca_polimorfismo.classes_abstratas.entities;


import Heranca_polimorfismo.heranca.entities.Account;
import Heranca_polimorfismo.heranca.entities.BusinessAccount;
import Heranca_polimorfismo.heranca.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainAbs {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        /*
       AccountAbs acc01 = new AccountAbs(1001, "Domingos", 1000.00 ); //asbtract impede que a classe account seja instanciado
       AccountAbs acc02 = new SavingsAccountAbs(1002, "Aline", 1000.00, 100.00);
       AccountAbs acc03 = new BusnessAccountAbs(1003,"Bom",2000.00, 500.00 );
       */

        List<AccountAbs> list = new ArrayList<>(); //=> lista do tipo Account generico

        //inserindo algumas contas na lista
        list.add(new SavingsAccountAbs(1005, "Mariana", 200.00, 10.00));
        list.add(new BusnessAccountAbs(1006, "Aline", 2000.00, 500.00));
        list.add(new SavingsAccountAbs(1007, "Maroom five", 2000.00, 5.50));
        list.add(new BusnessAccountAbs(1008, "Samia", 1500.00, 350.00));

        //Totalizar o saldo das contas acima
        double sum = 0.0;
        double deposit = 0.0;

        //=============================FOR EACH PURO SEM INDICE ===================================
        /*
        System.out.println("DADOS DAS CONTAS:");

            for (Account account : list) {
                ================================================================================
                  QUANDO O FOREACH SEM ÍNDICE É IDEAL:
                  - Para relatórios, logs ou listagens simples onde o número "1º, 2º" não faz diferença.
                  - Quando você quer apenas acumular valores (ex: somar o saldo de todas as contas).
                  - Quando você quer enviar uma notificação ou e-mail para cada cliente da lista.
                  - É o código mais seguro: não corre o risco de dar erro de "índice fora dos limites" (IndexOutOfBoundsException).
          ==================================================================================================================
                    System.out.printf("Conta nº: %d | Titular: %s | Saldo: %.2f%n",
                            account.getNumber(),
                            account.getHolder(),
                            account.getBalance()
                    );
                }

       */

        //==========================EXPLICAÇÃO FOR EACH=============================
        /*
            FOR EACH E SEU USO EM RELAÇÃO A O FOR TRADICIONAL
              System.out.println("CONTAS EXISTENTES");

            Usamos uma variável por fora para controlar a numeração visual no console
            int i = 1;

         for (Account account : list) {
         =================================================================================
          QUANDO USAR O FOREACH (ESTE MODELO):
          - Use quando você quer apenas ler/percorrer todos os elementos da lista do início ao fim.
          - A sintaxe é mais limpa e moderna ("para cada account dentro de list").
          - Como ele não possui um índice nativo, criamos a variável 'i' manualmente apenas
            para exibir "1ª conta, 2ª conta" na tela.
         ===================================================================================
            System.out.printf("%dª conta - ", i);
            System.out.printf("Conta nº: %d%n" +
                            "Titular: %s%n" +
                            "Saldo: %.2f%n%n",
                    account.getNumber(),
                    account.getHolder(),
                    account.getBalance()
            );

            i++; // Incrementa o contador manualmente para a próxima volta
        }
         =========================================================================================
            /*
              QUANDO USAR O FOR TRADICIONAL (for (int i = 0; i < list.size(); i++)):
              - Use quando a posição (o índice) do elemento importa para a lógica do negócio.
              - Exemplo 1: Se você precisar alterar um elemento diretamente em uma posição específica da lista (ex: list.set(i, novaConta)).
              - Exemplo 2: Se você precisar percorrer a lista de trás para frente, ou pulando de 2 em 2 elementos.
              - Exemplo 3: Se você precisar comparar o elemento atual com o próximo elemento da lista (ex: comparar list.get(i) com list.get(i+1)).

          */

       // ========================= explicação do uso do for tradicional =======================================
        System.out.println("CONTAS EXISTENTES");
        for (int i = 0; i < list.size(); i++) {
            /*
              QUANDO USAR O FOR TRADICIONAL (ESTE MODELO):
              - Use quando a posição (o índice 'i') é fundamental para a regra de negócio.
              - É ideal se você precisar modificar um item em uma posição específica (ex: list.set(i, novaConta)).
              - É necessário se você precisar pular elementos (ex: i += 2) ou andar de trás para frente (ex: i--).
              - É perfeito quando você precisa comparar o elemento atual com o próximo (ex: list.get(i) com list.get(i + 1)).
             */

            // No for tradicional, precisamos buscar o objeto na lista usando o índice 'i'
            AccountAbs account = list.get(i);

            // Usamos (i + 1) apenas na exibição porque a lista começa no índice 0,
            // mas para o usuário fica mais natural ver "1ª conta", "2ª conta", etc.
            System.out.printf("%dª conta - ", i + 1);
            System.out.printf("Conta nº: %d%n" +
                            "Titular: %s%n" +
                            "Saldo: %.2f%n%n",
                    account.getNumber(),
                    account.getHolder(),
                    account.getBalance()
            );
            System.out.println("===========================================");
        }

        System.out.println();

        /*
          DIFERENÇA VISUAL DE COMPREENSÃO:

          [for tradicional] -> Você segura o controle do mapa (índice i). Você sabe exatamente em qual
                                gaveta está mexendo e pode escolher ir direto para a última ou pular gavetas.

          [forEach]         -> O Java esconde o controle e te entrega diretamente o objeto de dentro da gaveta,
                                um por um, do primeiro ao último, sem você precisar saber o número da gaveta.
         */
        //percorre a lista account, para cada conta da lista pega o saldo e atribui na var sum
        for (AccountAbs account : list) {
            sum += account.getBalance();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("A soma do saldo de todas as contas e: " + sum);
        System.out.println("-------------------------------------------------");
        System.out.println();


        //imprimir todas os saldos antes do deposito
        System.out.println("====================================");
        System.out.println("Saldo atual antes do deposito: ");
        System.out.println("=====================================");

        for (AccountAbs account : list) {
            System.out.printf(
                    " saldo atual da conta nº %d%n " +
                            "Titular: %s%n " +
                            "saldo atual: %.2f "
                    , account.getNumber(),
                    account.getHolder(),
                    account.getBalance()
            );
            System.out.println();
            System.out.println("===========================================");
        }

        System.out.println();
        System.out.println("Saldo atual depois do deposito: ");
        //depositar o valor x em todas as contas
        for (AccountAbs account : list) {
            account.deposit(10.00);
        }

        //exibir
        for (AccountAbs account : list) {
            System.out.printf(
                    " Atualização do saldo atual da conta nº %d%n " +
                            "Titular: %s%n " +
                            "saldo atual: %.2f "
                    , account.getNumber(),
                    account.getHolder(),
                    account.getBalance()
            );
            System.out.println();
            System.out.println("=====================================");

        }
        sc.close();
    }
}

/*
Classe abstratas não podem ser instanciadas
na UML o nome de uma classe abstrata e escrito em italico
 */