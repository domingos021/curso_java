package Heranca_polimorfismo.exercicio_polimorfismo.entities;
//subclasse
//Classe funcionário tercerizado
public class OutsourcedEployee extends Employee {
    private Double additionalCharge; //pagamento adicinal

    public OutsourcedEployee() {
        super();
        //C/padrão
    }

    public OutsourcedEployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour); //herda os atributos da Superclass
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment() {
        //recebe os esmo pagamento de um funcionario normal + adicional 110% horas
        //pagamento normal chama o metodo de calculo da superclasse
        return super.payment() + additionalCharge * 1.1;

    }
}
