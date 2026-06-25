package EnumeracaoComposicao.composicao.exercicio.entities;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HourContract {
    // No topo da sua classe HourContract (junto com os atributos):
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date date;
    private double valuePerHour;
    private Integer hours;

    public HourContract() {
        //construtor vazio
    }

    //construtor com argumento
    public HourContract(Date date, double valuePerHour, Integer hour) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hour;
    }
   //GETTERS
    public Date getDate() {
        return date;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    //SETTER
    public void setDate(Date date) {
        this.date = date;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    //método para calcular o valor total do contrato
    public double totalValue() {
        //multiplica o valor por hora pela quantidade de horas
        double  total = valuePerHour * hours;;
        return  total;
    }

    // O seu método toString() reescrito:
    @Override
    public String toString() {
        return "Contrato de horas: [ " +
                "Data do Contrato: " + sdf.format(date) +
                ", VALOR HORA: " + String.format("%.2f", valuePerHour) +
                ", Horas Trabalhadas: " + hours +
                ", Total = " + String.format("%.2f", totalValue()) +
                " ]";
    }
}
