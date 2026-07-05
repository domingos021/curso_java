package interfaces.model.services;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Invoice;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    //Composição dizendo que RentalService usa o bjeto taxService
    private BrazilTaxService taxService; // usa o objeto como argumento


    public RentalService() {
    }

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BrazilTaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(BrazilTaxService taxService) {
        this.taxService = taxService;
    }

    /*
    Composição
    esse método usa o objeto carRental como parâmetro para calcular o valor do aluguel e o
     imposto, e depois cria uma fatura (Invoice)associada ao aluguel de carro.
     - pega o retorno da hora de retirada do veiculo do objeto carRente (getStar)
     - pega o retorno da hora de devolução do objeto carRenter(getFinish)

     calcula a duração do aluguem de xhrs para xhrs , quanto tempo durou o aluguel do veiculo
     1. se o aluguel for menor ou igual a 12 horas, cobra por hora
     2. se o aluguel for maior que 12 horas, cobra por dia
     3. calcula o imposto usando o serviço de imposto (taxService)
     4. cria uma nova fatura e associa ao aluguel de carro (carRental.setInvoice)
     */
    public void processInvoice(CarRental carRental) {
        //Calcula a duração do aluguel em horas
        double hours = java.time.Duration.between(carRental.getStart(), carRental.getFinish()).toHours();
        double basicPayment;

        //Se o aluguel for menor ou igual a 12 horas, cobra por hora
        if (hours <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            //Se o aluguel for maior que 12 horas, cobra por dia
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        }

        //Calcula o imposto usando o serviço de imposto
        double tax = taxService.taxService(basicPayment);

        //Cria uma nova fatura e associa ao aluguel de carro
      /*
        O método setInvoice() espera receber um objeto do tipo Invoice.

        Por isso, criamos uma nova fatura utilizando:

            new Invoice(basicPayment, tax)

        O objeto criado é passado como argumento para o método setInvoice(),
        fazendo com que o aluguel (CarRental) passe a possuir uma Invoice.

        Não passamos apenas os valores basicPayment e tax, pois CarRental não
        armazena esses dados separadamente. Ele armazena um objeto Invoice,
        que encapsula todas as informações da fatura.

        Esse é um exemplo de composição, pois CarRental TEM uma Invoice.
        */
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}


/*
    ===============================================================================
    ENTENDENDO O Math.ceil() (TETO MATEMÁTICO)
    ===============================================================================

    O método Math.ceil(double a) pertence à biblioteca nativa do Java e serve para
    arredondamento. A palavra "ceil" vem de "ceiling" (teto, em inglês).

    Regra do método:
    Ele arredonda qualquer valor com fração decimal para o PRÓXIMO número inteiro
    maior ou igual a ele, retornando um double.

    Exemplos práticos:
        Math.ceil(4.0)  -> Retorna 4.0
        Math.ceil(4.1)  -> Retorna 5.0 (subiu para o teto)
        Math.ceil(4.9)  -> Retorna 5.0 (subiu para o teto)
        Math.ceil(0.1)  -> Retorna 1.0 (subiu para o teto)

    -------------------------------------------------------------------------------
    APLICAÇÃO NO NOSSO NEGÓCIO (Aluguel de Carros):

    1. Caso por Hora: Math.ceil(hours)
       Se a duração do aluguel der 4.2 horas (4 horas e 12 minutos), o Math.ceil
       transforma isso em 5.0. O cliente pagará por 5 horas cheias.

    2. Caso por Dia: Math.ceil(hours / 24.0)
       Se o aluguel durar 26 horas, a divisão por 24.0 resulta em 1.0833... dias.
       O Math.ceil joga esse valor para 2.0. O cliente pagará por 2 dias cheias.

    Isso garante que qualquer fração de hora ou de dia seja cobrada como uma unidade
    inteira a mais, protegendo a margem de lucro da locadora de forma automatizada.
    ===============================================================================
*/