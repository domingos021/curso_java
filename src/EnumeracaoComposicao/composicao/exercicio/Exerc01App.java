package EnumeracaoComposicao.composicao.exercicio;
/*
==========================================================================================
                 DIAGRAMA DE CLASSES UML - SISTEMA DE CONTRATOS DE TRABALHADOR
==========================================================================================

   +-------------------------------------------------------+
   |                       DEPARTAMENTO                    |
   +-------------------------------------------------------+
   | - name: String                                        |
   +-------------------------------------------------------+

                               1
                               ▲
                               │ (Possui)
                               │
                               1
   +-------------------------------------------------------+
   |                       TRABALHADOR                     |
   +-------------------------------------------------------+
   | - name: String                                        |
   | - level: WorkerLevel (Enum)                           |
   | - baseSalary: Double                                  |
   +-------------------------------------------------------+
   | + addContract(contract: HourContract): void           |
   | + removeContract(contract: HourContract): void        |
   | + income(year: int, month: int): Double               |
   +-------------------------------------------------------+
                               1
                               ♦
                              / \  (Tem Vários)
                             / 1..* \
                            ▼        ▼
   +-------------------------------------------------------+
   |                      HOUR_CONTRACT                    |
   +-------------------------------------------------------+
   | - date: Date                                          |
   | - valuePerHour: Double                                |
   | - hours: int                                          |
   +-------------------------------------------------------+
   | + totalValue(): Double                                |
   +-------------------------------------------------------+


==========================================================================================
                      DETALHAMENTO DAS RELAÇÕES E MÉTODOS
==========================================================================================

1. Trabalhador ──► Departamento (Associação Simples 1 para 1):
   - Cada trabalhador pertence exatamente a 1 departamento específico.

2. Trabalhador ♦──► HourContract (Composição 1 para Muitos [1..*]):
   - O símbolo (♦) indica que o Trabalhador "tem vários" contratos associados a ele.
   - Se o objeto Trabalhador for destruído, seus contratos associados deixam de existir.

3. Método income(year, month):
   - É a função central do exercício. Ela recebe o ano e o mês informados pelo usuário,
     percorre a lista de contratos filtrando apenas os que pertencem àquela data,
     soma o resultado de totalValue() de cada um e adiciona ao baseSalary do trabalhador.

==========================================================================================
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc01App {

     /*
    Ler os dados fe um trabalhador com  N  contratos(N fornecido pelo usuário).Depois,
     solicitar do usuário um mes e mostrar qual foi o salario do funcionário nesse mes,
      conforme exemplo.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}
