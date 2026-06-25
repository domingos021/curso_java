package utilitarios;

public class Esfera {

    // Constante global (já era estática)
    public static final double PI = 3.14159;

    // Não temos variáveis privadas aqui e nem construtor!

    // Método estático para calcular a circunferência
    public static double calcularCircunferencia(double raio) {
        return 2.0 * PI * raio;
    }

    // Método estático para calcular o volume
    public static double calcularVolume(double raio) {
        return 4.0 * PI * raio * raio * raio / 3.0;
    }

    // Como não há toString() para classes estáticas, criamos um método utilitário de impressão
    public static String gerarRelatorio(double raio) {
        double circ = calcularCircunferencia(raio);
        double vol = calcularVolume(raio);

        return "============ RESULTADO DA ESFERA (ESTÁTICO) ============\n" +
                String.format("RAIO INFORMADO: %.2f%n", raio) +
                String.format("CIRCUNFERÊNCIA: %.2f%n", circ) +
                String.format("VOLUME: %.2f%n", vol) +
                String.format("VALOR DE PI: %.5f%n", PI) +
                "========================================================";
    }
}