package EnumeracaoComposicao;

import EnumeracaoComposicao.composicao.exercicio.entities.Department;
import EnumeracaoComposicao.composicao.exercicio.entities.HourContract;
import EnumeracaoComposicao.composicao.exercicio.entities.Worker;
import EnumeracaoComposicao.composicao.exercicio.entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class EnumApp {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //para ler a data no formato dia/mês/ano
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o departamento: ");
        String departmentName = sc.nextLine();

        System.out.println("Informe os dados do funcionário:");

        System.out.print("Nome: ");
        String workerName = sc.nextLine();

        System.out.print("Nível (JUNIOR, MID_LEVEL ou SENIOR): ");
        String workerLevelText = sc.nextLine();

        System.out.print("Salário base: ");
        double baseSalary = sc.nextDouble();

        /*
         Converte o texto digitado pelo usuário em um valor do enum.
         O .toUpperCase().trim() evita erros se o usuário digitar letras minúsculas ou espaços extras.
         Exemplo: "junior " → WorkerLevel.JUNIOR
        */
        WorkerLevel workerLevel = WorkerLevel.valueOf(workerLevelText.toUpperCase().trim());

        // Cria o objeto Worker associando-o ao nível e ao novo objeto Department (Composição)
        //Manda para o construtor
        Worker worker = new Worker(
                workerName,
                workerLevel,
                baseSalary,
                new Department(departmentName)
        );

        // For para ler a quantidade de contratos que o usuário deseja adicionar.
        System.out.print("Quantos contratos para este trabalhador? ");
        int N = sc.nextInt();

        /*
         Consome o Enter deixado pelo nextInt().

         Isso é necessário porque, logo abaixo, começaremos a usar nextLine()
         para ler a data digitada pelo usuário.
        */
        sc.nextLine();
        for (int i = 1; i <= N; i++) {

            System.out.println("Entre com os dados do contrato #" + i + ":");

            System.out.print("Digite a data neste formato (dd/MM/yyyy): ");
            String dateText = sc.nextLine();//digitado pelo usuário ex:"20/06/2026",

            /*
             Converte o texto digitado, por exemplo "20/06/2026",
             em um objeto Date.
            */
            Date contractDate = sdf.parse(dateText);

            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duração do contrato (horas): ");
            int hours = sc.nextInt();

           /*
             Cria um objeto do tipo HourContract usando os dados informados pelo usuário:
             data, valor por hora e quantidade de horas.
             cada argumento vai para o construtor
            */
            HourContract contract = new HourContract(
                    contractDate,
                    valuePerHour,
                    hours
            );

            //ASSOCIAR O CONTRATO AO FUNCIONÁRIO (COMPOSIÇÃO)
            worker.addContract(contract); //adiciona o contrato naa lista

            sc.nextLine(); //consome o Enter deixado pelo nextInt()


        }

        /*
        [ worker.getContracts() ] ──> Retorna a lista de contratos guardada na Entity Worker.
          │
          ▼
       [ Loop For-Each ]   ──> Pega um contrato por vez e joga na variável 'c'.
              │
              ▼
       [ System.out.println(c) ] ──> Executa o seu 'toString()' personalizado com a data formatada.
         */

        // EXIBIR CONTRATOS CADASTRADOS
        System.out.println();
        System.out.println("CONTRATOS CADASTRADOS:");

        for (HourContract c : worker.getContracts()) {
            System.out.println(c);
        }

        System.out.println();
        /*
        MES E ANO PARA CALCULAR O SALÁRIO
         Depois de cadastrar todos os contratos,
         pergunta uma única vez o mês e ano desejados.
        */
        System.out.print("Entre com o mês e ano para calcular o salário (MM/yyyy): ");
        //MêS
        String monthAndYear = sc.next();//08/2000

        /*
         A string monthAndYear está no formato "MM/yyyy".

         Exemplo: "06/2026"

         substring(0, 2) pega os dois primeiros caracteres da string,
         que representam o mês (MM).

         Resultado: "06"
         Integer.parseInt(monthAndYear.substring(0, 2)) converte essa substring "06" em um número inteiro 6, que representa o mês de junho.
        */
        int month = Integer.parseInt(monthAndYear.substring(0, 2));

        //ANO
        int year = Integer.parseInt(monthAndYear.substring(3));//pe a string da posição 3 em diante

        System.out.println();
        System.out.println("EXIBIÇÃO DO RESULTADO");
        System.out.println("Nome: " + worker.getName()); // nome do trabalhador

        /* Navegação por Composição de Objetos:
         1. Por meio da classe principal (View/App).
         2. chama o objeto worker (Worker).
         3. Através dele(worker),  acessássemos o objeto que está guardado dentro dele (getDepartment(), que é da classe Department).
         4. E só então  pegamos o nome dele (getName()).
        */
        System.out.println("Departamento: " + worker.getDepartment().getName());

        System.out.printf(
                "Ganhos para %s: %.2f%n",
                monthAndYear,
                worker.income(year, month));
        sc.close();
    }

    /*
    =====================================================================================
    ESTRUTURA DE DESIGN DE ARQUITETURA EM CAMADAS
    =====================================================================================

    VIEWS => Tela principal do sistema ou interface CLI, onde o usuário interage diretamente.

    CONTROLLER => Camada intermediária que processa os dados recebidos da View, valida as
                  requisições e direciona para as regras de negócio.

    SERVICES => Camada onde ficam as regras de negócio principais do sistema. Ela processa
                os dados e interage com os modelos e repositórios.

    REPOSITORIES => Camada responsável pelo acesso aos dados (banco de dados, arquivos, etc.).

    ENTITIES / MODEL => Classes que representam as entidades do mundo real (ex: Worker, Department)
                        e encapsulam seus atributos e comportamentos diretos.


    [VIEW] (Usuário preenche os dados e clica em enviar)
      │
      ▼
    [CONTROLLER] (Recebe os dados do formulário e valida o formato)
      │
      ▼
    [SERVICE] (Aplica as regras de negócio, calcula salários e bônus)
      │ 🧠 (Utiliza os dados e métodos das ENTITIES)
      ▼
    [REPOSITORY] (Salva o funcionário no banco de dados)
    =====================================================================================
    */
}