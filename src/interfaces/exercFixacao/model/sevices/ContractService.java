package interfaces.exercFixacao.model.sevices;

import interfaces.exercFixacao.model.entities.Contract;
import interfaces.exercFixacao.model.entities.Installments;
import interfaces.utils.FormatadorData;

import java.time.LocalDate;

public class ContractService {
    /*
 Declara uma variável do tipo da interface OnlinePaimentService.

 A variável recebe uma referência para um objeto que implementa essa
 interface, como a classe PaypalService.

 O ContractService trabalha com a interface e não depende diretamente
 de uma implementação específica, permitindo trocar o serviço de pagamento
 sem alterar essa classe.

 O modificador final garante que, depois de receber uma implementação no
 construtor, essa referência não poderá ser alterada para outro objeto.

 Ou seja, o ContractService usará sempre o mesmo serviço de pagamento
 durante sua execução, apenas chamando seus métodos, como:
 - interest()
 - paymentFee()
*/
    private final OnlinePaimentService onlinePaimentService;

    /*
  Recebe um objeto que implementa a interface OnlinePaimentService
  (como a classe PaypalService) e o armazena no atributo da classe.

  Dessa forma, o ContractService pode utilizar os métodos interest()
  e paymentFee() sem depender diretamente de uma implementação específica,
  trabalhando apenas com a interface.
  */
    public ContractService(OnlinePaimentService onlinePaimentService) {
        this.onlinePaimentService = onlinePaimentService;
    }

    public void processContract(Contract contract, int months) {


        /*
           // Teste manual para adicionar parcelas ao contrato
            Processo para criar e adicionar uma parcela:

            1 - Acessa o contrato.
            2 - Obtém a lista de parcelas através do método getInstallments().
            3 - Utiliza o método add() para adicionar novos objetos Installments
                dentro da lista de parcelas do contrato.

        contract.getInstallments().add(new Installments(LocalDate.of(2018, 7, 25), 206.04));
        contract.getInstallments().add(new Installments(LocalDate.of(2018, 8, 25), 206.04));
         */

        //parcela basica
        /*
         valor total do contrato / quantidade de parcelas = valor da parcela basica
         600.00 / 3 = 200.00
         200.00 + 1% = 202.00
         202.00 + 2% = 206.04
         200.00 + 2% = 204.00
         200.00 + 1% = 202.00
         200.00 + 2% = 204.00
         200.00 + 1% = 202.00
         200.00 + 2% = 204.00
         */
        double basicQuota = contract.getTotaValue() / months; // exemp: 600/3 = 200

        // AJUSTE: i começa em 1 para calcular corretamente os meses (1, 2, 3...)
        for(int i = 1; i <= months; i++) {

            // AJUSTE: plusMonths(i) para avançar de mês em mês, e não de dia em dia
            LocalDate dueDate = contract.getDate().plusMonths(i);

           /*
             1ª - Criamos uma variável do tipo double para armazenar o valor dos juros.

             2ª - Chamamos, através da interface OnlinePaimentService, o método interest(),
                  passando como parâmetros:
                  - basicQuota: valor da parcela básica;
                  - i: quantidade de meses da parcela.

             Exemplo:
             Valor do contrato: 600,00
             Número de parcelas: 3

             basicQuota = 600 / 3 = 200,00

             O método interest(), implementado na classe PaypalService,
             calcula juros simples de 1% ao mês:

             interest = amount * 0.01 * months

             Então:

             i = 1
             interest = 200 * 0.01 * 1 = 2,00

             i = 2
             interest = 200 * 0.01 * 2 = 4,00

             i = 3
             interest = 200 * 0.01 * 3 = 6,00

             Observe que o método retorna apenas o valor dos juros.
             A soma da parcela básica com os juros é feita posteriormente:

             parcelaAtualizada = basicQuota + interest
            */
            double interest = onlinePaimentService.interest(basicQuota, i); //interest pega a parcela basica e calcula os juros

            /*
             1ª; - Criamos uma vari&aacute;vel do tipo double para armazenar o valor da taxa
                  de pagamento.

             2ª; - Chamamos, atrav&eacute;s da interface OnlinePaimentService, o m&eacute;todo
                  paymentFee(), passando como par&acirc;metro a parcela j&aacute; atualizada
                  com os juros (basicQuota + interest).

             Exemplo:
             basicQuota = 200,00
             interest = 2,00

             Valor atualizado da parcela:
             200,00 + 2,00 = 202,00

             O m&eacute;todo paymentFee(), implementado na classe PaypalService,
             calcula uma taxa de 2% sobre esse valor:

             fee = amount * 0.02

             Ent&atilde;o:

             fee = 202,00 * 0.02 = 4,04

             Observe que o m&eacute;todo retorna apenas o valor da taxa.
             A soma da parcela atualizada com a taxa &eacute; feita posteriormente:

             totalInstallment = basicQuota + interest + fee

             Conclusão
             a primeira volta
            basicQuota = 200,00
            interest = 2,00
            -------------------
            basicQuota + interest = 202,00

            fee = 4,04
            -------------------
            Valor final = 206,04
            */
            double fee = onlinePaimentService.paymentFee(basicQuota + interest); //206

            double quota = basicQuota + interest + fee;
            // quota =206.04

            /*
             1ª - Acessamos o contrato.

             2ª - Chamamos o método getInstallments(), que retorna a lista de parcelas
                  (List<Installments>) pertencente ao contrato.

             3ª - Utilizamos o método add() da lista para adicionar uma nova parcela ao contrato.

             4ª - Para isso, criamos um novo objeto do tipo Installments, passando como
                  parâmetros a data de vencimento (dueDate) e o valor da parcela (quota).

             Ao final, a nova parcela fica armazenada na lista de parcelas do contrato.
             */
            contract.getInstallments().add(new Installments(dueDate, quota));

        }
    }
}