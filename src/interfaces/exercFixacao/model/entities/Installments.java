package interfaces.exercFixacao.model.entities;
import interfaces.exercFixacao.model.utils.FormatadorData;

import java.time.LocalDate;

//parcelas
public class Installments {
    // 1. Atributos
    private LocalDate dueDate; // Data de vencimento
    private Double amount;     // Valor da parcela

    // 2. Construtores

    public Installments() {
    }

    public Installments(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    // 3. Métodos de negócio

    // 4. Getters e Setters
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {

        return String.format(
                "Parcela [Data: %s - Valor: %.2f]",
                dueDate != null ? FormatadorData.formatarData(dueDate) : "Sem data",
                amount
        );
    }

}
