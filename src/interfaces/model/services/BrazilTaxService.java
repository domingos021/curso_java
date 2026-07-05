package interfaces.model.services;

//SERVIÇO PARA CALCULAR IMPOSTOS
public class BrazilTaxService {
    public double taxService(double amount) {
        if (amount <= 100.0) {
            return amount * 0.2; // 20% de imposto para valores até 100
        } else {
            return amount * 0.15; // 15% de imposto para valores acima de 100
        }
    }
}
