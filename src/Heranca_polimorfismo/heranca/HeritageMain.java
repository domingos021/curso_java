package Heranca_polimorfismo.heranca;

import Heranca_polimorfismo.heranca.entities.Account;
import Heranca_polimorfismo.heranca.entities.BusinessAccount;
import Heranca_polimorfismo.heranca.entities.SavingsAccount;

import java.util.Locale;
import java.util.Scanner;

/**
 * CONCEITO CENTRAL: HERANÇA
 * Permite o reuso de atributos e métodos (dados e comportamentos)
 * através de uma relação de "É UM" (Ex: BusinessAccount É UMA Account).
 * * Account (Superclasse / Mãe)
 * ▲
 * ┌─────────────┴─────────────┐
 * │                           │
 * BusinessAccount (Subclasse)  SavingsAccount (Subclasse)
 */
public class HeritageMain {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------------------------
        // 1. INSTANCIAÇÃO NORMAL (Sem Upcasting)
        // -------------------------------------------------------------------------
        Account account = new Account(1001, "Domingos", 00.00);

        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 00.00, 500.00);
        /*
          TEORIA: Objeto e Variável não são a mesma coisa!

          bacc                          new BusinessAccount(...)
            │                                       │
            │                                       └── Objeto real criado na memória Heap
            └── Variável (Referência na Stack)

          Como a variável 'bacc' é do tipo BusinessAccount, ela enxerga tudo:
          bacc.deposit(100.0); -> Método herdado de Account
          bacc.loan(200.0);    -> Método próprio de BusinessAccount
         */

        // -------------------------------------------------------------------------
        // 2. EXEMPLOS DE UPCASTING
        // O processo de atribuir um objeto da classe filha para uma referência da classe mãe.
        // Regra: Upcasting NÃO muda o objeto na memória, muda apenas a "lente" de acesso.
        // -------------------------------------------------------------------------

        // Exemplo A: Atribuindo uma variável existente
        Account acc1 = bacc;
        /*
          RESOLUÇÃO DO EXERCÍCIO / CHECKLIST DE COMPORTAMENTO:

          - Account: Superclasse/mãe. Planta modelo da qual outras classes se apoiam.
          - BusinessAccount: Subclasse/filha. Classe do objeto real em memória.
          - bacc: Variável do tipo BusinessAccount que referencia o objeto real.
          - acc1: Variável do tipo Account que referencia o MESMO objeto real (Upcasting).

          1. acc1 aponta para um objeto BusinessAccount?
             ✅ SIM. O objeto na memória nasceu como BusinessAccount e continua sendo um.
          2. acc1.deposit(100.0) funciona?
             ✅ SIM. Porque deposit() existe na classe Account (o tipo da variável).
          3. acc1.loan(100.0) funciona?
             ❌ NÃO. O compilador barra porque loan() não existe in Account. O compilador
                sempre checa o tipo declarado da variável, não o objeto real.
          4. bacc e acc1 são referências diferentes para o mesmo objeto?
             ✅ SIM. Ambas apontam exatamente para o mesmo endereço de memória.
         */

        // Exemplo B: Instanciação direta com Upcasting (BusinessAccount para Account)
        Account acc2 = new BusinessAccount(1003, "Bob", 00.00, 200.00);

        // 1. Instanciação do objeto real na memória Heap
        // A variável 'sacc' (tipo SavingsAccount) aponta para ele.
        SavingsAccount sacc = new SavingsAccount(1004, "Juan", 00.00, 500.00);

        // 2. O UPCASTING:
        // Pegamos a referência do objeto (que estava in 'sacc') e atribuímos
        // para a nova variável 'acc3' (que é do tipo Account).
        Account acc3 = sacc;

        /* O SEU RACIOCÍNIO COMENTADO:
          A nova referência 'acc3' muda a "lente" de acesso para o tipo Account,
          mas o objeto real na memória continua sendo, imutavelmente, um SavingsAccount.

          "Se eu fizer acc3.deposit(100.0);, o saldo do sacc muda?"

        Você já sabe a resposta: Sim, muda! Porque as duas variáveis estão apontando para o mesmo e único objeto no banco de dados da memória.
        */

        // CONCLUSÃO => O UPCASTING POSSIBILITA GERENCIAR VÁRIOS OBJETOS DE CLASSES DIFERENTES
        // USANDO O TIPO DE REFERÊNCIA DE UMA ÚNICA SUPERCLASSE.
        // EXEMPLO:
        Account acc4 = new BusinessAccount(1005, "Domingos Dinis", 10.00, 600.00);
        Account acc5 = new SavingsAccount(1006, "Maria", 10.00, 700.00);

        //A MESMA COISA (Instanciação direta)
        // Account acc3 = new SavingsAccount(1004, "Juan", 00.00, 500.0);

        /*
        Resumo das permissões de acesso no seu código:
        Se você usar sacc.updateBalance(); (método próprio de poupança) ➔ Funciona, porque a lente de sacc é da classe filha.

        Se você usar acc3.updateBalance(); ➔ Não funciona (Erro de compilação), porque a lente de acc3 é da classe mãe e não enxerga o que é específico da poupança.

        Ambas as formas estão corretas e são muito comuns no dia a dia da programação!
         NA MEMORIA
         Variáveis (Stack)                Objeto Real (Heap)

           sacc  ───────────────┐
                                ▼
           acc3  ───────────────►  [ SavingsAccount ]
                                    - number: 1004
                                    - holder: Juan
                                    - balance: 0.0
                                    - interestRate: 500.0
         */
        /*
        Account acc3 = new SavingsAccount(1004, "Juan", 00.00, 500.0);
        acc3 => variável da Superclass Account
        ou seja : atribuimos o objeto savingsAccount para uma variável(acc3) do tipo Account (upcasting)
         */
        /*
          TABELA DE COMPARAÇÃO DE ACESSO (UPCASTING):

          | Variável | Tipo Declarado    | Objeto Real em Memória | Pode usar .loan()? |
          | -------- | ----------------- | ---------------------- | ------------------ |
          | `bacc`   | `BusinessAccount` | `BusinessAccount`      | Sim                |
          | `acc1`   | `Account`         | `BusinessAccount`      | Não                |
          | `acc2`   | `Account`         | `BusinessAccount`      | Não                |
          | `acc3`   | `Account`         | `SavingsAccount`       | Não                |
         */

        // -------------------------------------------------------------------------
        // 3. AGORA O DOWNCASTING
        // O processo de converter uma referência do tipo classe mãe de volta para o tipo classe filha.
        // -------------------------------------------------------------------------
        /*
          IDEIA CENTRAL DO DOWNCASTING =>
          Como vimos no Upcasting com a variável 'acc2', a lente da classe mãe nos impede de acessar
          métodos específicos da subclasse (como o .loan()).

          O Downcasting serve para recuperar o acesso. Nós mudamos a lente da variável de volta para a classe filha.
          A operação NÃO é automática. Exige a sintaxe de casting manual: (ClasseFilha)
         */

        // Exemplo A: Convertendo a referência com sucesso
        // acc2 é do tipo Account, mas sabemos que aponta para um objeto real BusinessAccount.
        BusinessAccount acc6 = (BusinessAccount) acc2;
        acc6.loan(100.0); // ✅ AGORA FUNCIONA! Recuperamos o acesso ao método específico.

        /*
         NA MEMÓRIA (DOWNCASTING):
         Variáveis (Stack)                     Objeto Real (Heap)

           acc2 (Account) ───────────────┐
                                         ▼
           acc6 (BusinessAccount) ──────► [ BusinessAccount ]
                                           - loanLimit: 200.0
                                           - loan() ✅ Acessível por acc6
         */

        // -------------------------------------------------------------------------
        // 4. O PERIGO DO DOWNCASTING (ClassCastException)
        // -------------------------------------------------------------------------
        /*
          O compilador confia no seu casting manual, mas se você errar a real identidade
          do objeto que está na memória Heap, o sistema quebra enquanto roda!

          Vejamos a variável 'acc3': o objeto real dela é uma 'SavingsAccount'.
          Se tentarmos forçar esse objeto a caber em uma referência 'BusinessAccount':

          BusinessAccount acc7 = (BusinessAccount) acc3; // ❌ COMPILA, MAS DA ERRO AO EXECUTAR!

          Erro gerado: "ClassCastException" (Poupança não pode ser convertida para conta empresarial).
         */

        // -------------------------------------------------------------------------
        // 5. PROTEÇÃO SEGURA: O operador 'instanceof'
        // Antes de arriscar um Downcasting, checamos o tipo do Objeto Real na memória.
        // -------------------------------------------------------------------------

        // Teste 1: O objeto real por trás de 'acc3' é uma instância de BusinessAccount?
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc7 = (BusinessAccount) acc3;
            acc7.loan(200.0);
            System.out.println("Downcasting para BusinessAccount concluído.");
        }

        // Teste 2: O objeto real por trás de 'acc3' é uma instância de SavingsAccount?
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc8 = (SavingsAccount) acc3; // ✅ SEGURO. O 'instanceof' garantiu o tipo.
            acc8.updateBalance();
            System.out.println("Downcasting para SavingsAccount concluído com sucesso!");
        }

        /*
          TABELA COMPARATIVA FINAL:

          | Operação     | Sentido da Conversão | Tipo de Execução | Risco de Quebra | Como Proteger?  |
          | ------------ | -------------------- | ---------------- | --------------- | --------------- |
          | **Upcasting** | Filha ➔ Mãe          | Automática       | Nenhum          | Não necessita   |

          */
        // -------------------------------------------------------------------------
        // 3. PRATICANDO DOWNCASTING (ENTENDENDO AS LENTES)
        // -------------------------------------------------------------------------

        // 1ª ETAPA: Criação do Objeto e Aplicação do Upcasting (Lente Restrita)
        BusinessAccount originalnoncasting = new BusinessAccount(2002, "Aline Joel", 1500.00, 350.00); // Sem casting
        Account bistestingobj = originalnoncasting; // Agora sim o Upcasting acontece!

            /*
              - Quem é a lente aqui? A variável 'bistestingobj', declarada como Account.
              - O que acontece: bistestingobj aponta para o mesmo objeto, mas sua lente é do tipo Account.
              - Regra de acesso: Apenas 'originalnoncasting' pode acessar o método loan(). A variável
                'bistestingobj' NÃO pode (Dá Erro de Compilação), pois representa a lente restrita de fato.
             */

        // 2ª ETAPA: Trocando de Lente (Downcasting)
        // Aqui temos as duas formas corretas que você descobriu para liberar o acesso:

        // Forma A: O Atalho Temporário (Inline Casting / Downcasting "On-the-fly")
        ((BusinessAccount) bistestingobj).loan(100.0); // ✅ Executa perfeitamente!
            /*
              Troca a lente para BusinessAccount temporariamente APENAS para executar esta linha,
              sem precisar criar uma nova variável na memória Stack.
             */

        // Forma B: A Variável Fixa (Referência Permanente)
        BusinessAccount bacctesting = (BusinessAccount) bistestingobj;
        bacctesting.loan(100.0); // ✅ Executa perfeitamente!
            /*
              - Quem é a nova lente aqui? A variável 'bacctesting', que é do tipo BusinessAccount.
              - Como a troca foi feita? O comando (BusinessAccount) bistestingobj tirou os óculos de Account
                e fabricou uma nova lente estável, guardada em 'bacctesting'.
              - Conclusão: Por meio dela, podemos enxergar e acessar o método loan() livremente.

              ⚠️ IMPORTANTE: A variável 'bistestingobj' continua restrita lá atrás. Quem ganhou
              o superpoder definitivo de enxergar tudo foi a nova variável 'bacctesting'.

              NA MEMÓRIA (JOGO DE LENTES):
              Variáveis (Stack)                     Objeto Real (Heap)

                👓 bistestingobj (Account) ───────┐
                                                   ▼
                🔎 bacctesting (BusinessAccount) ─► [ BusinessAccount ] (O objeto real NUNCA muda)
                                                     - loanLimit: 350.00
                                                     - loan() ✅ Acessível pelas lentes convertidas
            */


        //como evitar o erro
        // TREINAMENTO 2
        SavingsAccount varsacc = new SavingsAccount(1009, "Maria Jose", 200.00, 900.00); // Sem upcasting
        Account acc10 = varsacc; // Com upcasting
        //downCasting
        //BusinessAccount baccdct = (BusinessAccount) acc10; // da erro em tempode execução porque acc10 e do tipo savingsaccount e não busnesacount

        // DOWNCASTING PROTEGIDO
        // Perguntamos ao Java: "O objeto real por trás de acc10 é uma Conta Empresa?"
        if (acc10 instanceof BusinessAccount) {
            BusinessAccount baccdct = (BusinessAccount) acc10;
            baccdct.loan(100.0);
            System.out.println("Empréstimo realizado com sucesso!");
        }
        // "Se não for, ele é uma Conta Poupança?"
        else if (acc10 instanceof SavingsAccount) {
            SavingsAccount saccdct = (SavingsAccount) acc10; // ✅ Downcasting correto e seguro!
            saccdct.updateBalance(); // Acessando o método específico de poupança
            System.out.println("Saldo da poupança updated com sucesso!");
        }


        // PRATICANDO SOBRESCRIÇÃO E POLIMORFISMO (VERSÃO PROFISSIONAL COM RETORNO BOOLEAN)

        System.out.println("================ Conta padrão Account ========================");
// Operando a conta padrão sem sobreposição
// Tipo da variável: Account | Tipo do objeto: Account
        Account acctext = new Account(111, "Domingos Jovete", 200.00);

// Executa o saque utilizando o retorno boolean da classe mãe (cobra taxa de 5.0)
// Como tem 200.00, tentar sacar 200.00 vai precisar de 205.00 pelo saldo+taxa. Vai dar falso!
        if (acctext.withdraw(200.00)) {
            System.out.println("Sucesso! Saque de R$ 200.00 realizado na Conta Padrão.");
        } else {
            System.out.println(">>> OPERAÇÃO NEGADA: Saldo insuficiente na Conta Padrão (R$ 5.00 de taxa)! <<<");
        }
        System.out.println("Saldo atual: " + acctext.getBalance()); // Deve continuar 200.00 porque o saque falhou

// Depósito na conta padrão
        acctext.deposit(150.00);
        System.out.println("Depósito realizado com sucesso.");
        System.out.println("Saldo atual final: " + acctext.getBalance()); // 200.00 + 150.00 = 350.00


        System.out.println("\n============= Conta poupança savingsAccount =============");
        // APLICAÇÃO DE POLIMORFISMO:
        // Declaramos a variável com o tipo genérico da classe mãe (Account),
        // mas instanciamos o objeto real como a classe filha (SavingsAccount).
        Account accsbc = new SavingsAccount(112, "Dinis", 200.00, 0.01);
        double saque = 200.00;
        System.out.println("Saldo atual: " + accsbc.getBalance());

        // APLICAÇÃO DE SOBRESCRIÇÃO EM TEMPO DE EXECUÇÃO:
        // Mesmo que a variável 'accsbc' seja do tipo Account, o Java identifica que o objeto real
        // na memória é uma SavingsAccount. O método withdraw() da filha avalia o boolean:
        // não cobra taxa, mas barra se o saldo ficar negativo. Como 200.00 < 250.00, vai dar falso!
        /*
        // Se o saque der certo, o método retorna true. O Java enxerga isso:
        if (true) {
            // ... roda o bloco de sucesso
        }

        // Se o saque falhar, o método retorna false. O Java enxerga isso:
        if (false) {
            // ... vai direto para o else
        }
         */

        if (accsbc.withdraw(saque)) { // 1º Executa o método (withdraw), altera o saldo se houver espaço. 2º Se o retorno for true, entra aqui.
            System.out.println("Sucesso! Saque de R$ " + saque + " realizado na Poupança.");
        } else { // Se o retorno for false, entra aqui.
            System.out.println("Aviso no Main: O saque de R$ " + saque + " NÃO pôde ser realizado.");
        }
        // Mostra o saldo depois do saque (Como foi negado, deve continuar 200.00)
        System.out.println("Saldo atual: " + accsbc.getBalance());

        // Depósito na conta poupança
        accsbc.deposit(150.00);
        System.out.println("Depósito realizado com sucesso.");

        // Mostra o saldo final após o depósito (200.00 originais + 150.00 = 350.00)
        System.out.println("Saldo atual final: " + accsbc.getBalance());

        System.out.println();
        System.out.println("==================================Polimorfismo==================");
        //=============================================================================
        // POLIMORFISMO: ORGANIZAÇÃO TEÓRICA E EXPERIMENTAL
        //==============================================================================
        /*
        POLIMORFISMO

        Polimorfismo significa: "muitas formas".

        Na programação orientada a objetos, ele acontece quando uma referência
        de uma classe mais genérica consegue apontar para objetos de classes
        mais específicas.

        Exemplo:
        Uma variável do tipo Account pode guardar um objeto Account,
        mas também pode guardar um objeto BusinessAccount ou SavingsAccount,
        porque essas classes herdam de Account.

        Account acc1 = new Account(...);
        Account acc2 = new BusinessAccount(...);
        Account acc3 = new SavingsAccount(...);

        Mesmo todas sendo vistas como Account, cada objeto pode se comportar
        de uma forma diferente quando um método é chamado.

        Isso é útil porque podemos trabalhar com vários tipos de contas usando
        uma única variável mais genérica: Account.

        OUTRA DEFINIÇÃO DE POLIMORFISMO
        ==================================================================
        2- POLIMORFISMO

        Acontece quando uma variável de um tipo mais genérico,
        como Account, pode apontar para objetos de tipos mais específicos,
        como SavingsAccount ou BusinessAccount.

        Exemplo:
        Account acc = new SavingsAccount(...);

        A variável é do tipo Account, mas o objeto real é do tipo SavingsAccount.
        Isso é possível porque SavingsAccount herda de Account:
        SavingsAccount "é uma" Account.
        ===================================================================

        Pilares de POO
        - ENCAPSULAMENTO
        - HERANÇA
        - POLIMORFISMO
        - ABSTRAÇÃO
        */

        // EXPERIMENTO PRÁTICO DE POLIMORFISMO
        /*
        Variáveis X e Y do tipo Account.

        X => aponta para um objeto do tipo Account.

        Y => embora seja uma variável do tipo Account, ela referencia
        (guarda o endereço de memória de) um objeto do tipo SavingsAccount.

        Isso é polimorfismo, pois uma referência da classe mãe (Account)
        pode apontar para objetos de suas subclasses, como SavingsAccount.

        Account é a classe mais genérica.
        SavingsAccount é uma classe mais específica, pois herda de Account.
        */

        // Instanciação Padrão
        Account X = new Account(1001, "Alex", 1000.0);

        /*
         Upcasting:
         Instanciamos a classe SavingsAccount passando o valor de saldo inicial (200.00):
         SavingsAccount a = new SavingsAccount(1002, "Joel", 200.00, 0.01);

         E a atribuímos para a variável da superclasse Account:
         Account Y = a;
         */
        SavingsAccount a = new SavingsAccount(1002, "Joel", 200.00, 0.01);
        Account Y = a; // Realizando Upcasting

        /*
        EXECUÇÃO COM X (Lente Account -> Objeto Account):
        Como Account possui withdraw(), X chama o método padrão.
        Se houver saldo suficiente considerando a taxa (50.00 + 5.00), realiza a operação.
        O método executa a lógica da própria Account com desconto da taxa padrão.
        */
        if (X.withdraw(50.00)) {
            System.out.println("Sucesso! Saque de R$ 50.00 realizado em X (Conta Padrão).");
        } else {
            System.out.println("Saque recusado em X (Saldo insuficiente).");
        }

        /*
        EXECUÇÃO COM Y (POLIMORFISMO: Lente Account -> Objeto SavingsAccount):
        Y também consegue chamar withdraw(), porque esse método existe no contrato de Account.
        Porém, em tempo de execução, o Java identifica que o objeto real na memória Heap é SavingsAccount.
        Como SavingsAccount sobrescreveu o método, o Java roda obrigatoriamente a regra da filha:
        avalia o saldo sem cobrar a taxa de R$ 5.00 e protege contra saldos negativos.
        */
        if (Y.withdraw(200.00)) {
            System.out.println("Sucesso! Saque de R$ 200.00 realizado em Y (Poupança).");
        } else {
            System.out.println("Saque recusado em Y (Saldo insuficiente).");
        }

        // POLIMORFISMO CONCLUSÃO
        /*
        É quando uma variável de um tipo mais genérico passa a referenciar
        um objeto de um tipo mais específico.

        Exemplo:
        Account acc = new SavingsAccount(...);

        A variável é do tipo Account, mas o objeto real é SavingsAccount.
        Isso permite trabalhar com objetos diferentes usando uma referência mais genérica.

        Quando um método é sobrescrito na subclasse, ao chamá-lo pela variável
        genérica, o Java executa o comportamento dinâmico do objeto real.
        */

        // Impressão dos resultados do experimento para validação no console
        System.out.println(" Classe account (X): " + X.getBalance());        // Esperado: 1000.0 - 55.0 = 945.0
        System.out.println(" Classe SavingsAccount (Y): " + Y.getBalance()); // Esperado: 200.0 - 200.0 = 0.0

        sc.close();
    }
}

/*
  =============================================================================
  EXEMPLO COMPLEMENTAR DE MODELAGEM (DIAGRAMA DE CLASSES UML)
  =============================================================================

            +------------------------------------------+
            |                  Client                  |  <--- Classe Mãe (Superclasse)
            +------------------------------------------+  |   Guarda o que é comum.
            | - name: String                           |
            | - email: String                          |
            +------------------------------------------+
            | + updateEmail(newEmail: String): void    |
            +------------------------------------------+
                                 ▲
                                 |  [Seta de Herança: aponta para a Mãe]
                   ┌─────────────┴─────────────┐
                   │                           │
     +---------------------------+   +---------------------------+
     |      PhysicalPerson       |   |        LegalPerson        |  <--- Classes Filhas (Subclasses)
     +---------------------------+   +---------------------------+  |   Herdam a mãe e adicionam
     | - cpf: String             |   | - cnpj: String            |  |   o que é específico.
     +---------------------------+   +---------------------------+
     | + validateCpf(): boolean  |   | + validateCnpj(): boolean |
     +---------------------------+   +---------------------------+
*/