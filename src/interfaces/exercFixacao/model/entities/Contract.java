package interfaces.exercFixacao.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//composição=> um contrato tem varias parcelas

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totaValue;

    //associação com as parcelas
    //criamos a lista das parcelas
    //um contrato tem varias parcelas por isso criamos uma lista de parcelas
    private List<Installments> installments = new ArrayList<>();
    //constructors

    public Contract() {
    }

    // Não recebemos as parcelas no construtor, pois elas serão geradas e adicionadas posteriormente.
    // Quando um contrato é criado, ainda não existem parcelas. Elas serão calculadas e adicionadas
    // ao contrato durante o processamento.
    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totaValue = totalValue;
    }



    //Class specific methods


    //get and setters


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotaValue() {
        return totaValue;
    }

    public void setTotaValue(Double totaValue) {
        this.totaValue = totaValue;
    }

    public List<Installments> getInstallments() {
        return installments;
    }


}
