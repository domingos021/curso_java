package AppFuncuncionarios;

public class FuncionarioInfo {

    private String nome;
    private double salarioBruto;

    // Construtor padrão
    public FuncionarioInfo() {
    }

    // ==========================================
    // MÉTODOS GETTERS E SETTERS
    // ==========================================

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeAceito) {
        if (nomeAceito != null && !nomeAceito.trim().isEmpty()) {
            this.nome = nomeAceito;
        }
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBrutoAceito) {
        if (salarioBrutoAceito > 0) {
            this.salarioBruto = salarioBrutoAceito;
        }
    }

    // ==========================================
    // REGRAS DE NEGÓCIO (CÁLCULOS)
    // ==========================================

    public double calcularAumentoSalario() {
        double percentual;

        if (salarioBruto <= 1500.0) {
            percentual = 10.1;
        } else if (salarioBruto <= 3000.0) {
            percentual = 8.0;
        } else if (salarioBruto <= 4000.0) {
            percentual = 6.6;
        } else if (salarioBruto <= 5000.0) {
            percentual = 3.2;
        } else {
            percentual = 1.5;
        }

        return salarioBruto * percentual / 100.0;
        /*
        ex: salario bruto 1000
        1000 * 10.1/100
        aumento 101
         */
    }

    public double salarioComAumento() {
        return salarioBruto + calcularAumentoSalario();
    }

    public double calcularImposto() {
        double salarioBase = salarioComAumento();
        double taxa;

        if (salarioBase <= 2000.0) {
            taxa = 0.0;
        } else if (salarioBase <= 3000.0) {
            taxa = 7.5;
        } else if (salarioBase <= 4000.0) {
            taxa = 15.0;
        } else if (salarioBase <= 5000.0) {
            taxa = 22.5;
        } else {
            taxa = 27.5;
        }

        return salarioBase * taxa / 100.0;
    }

    public double salarioLiquido() {
        return salarioComAumento() - calcularImposto();
    }

    // ==========================================
    // FORMATAÇÃO DE SAÍDA
    // ==========================================

    @Override
    public String toString() {
        return String.format(
                "========================================\n" +
                        "            RESUMO SALÁRIO              \n" +
                        "========================================\n" +
                        "%-18s: %s\n" +
                        "%-18s: R$ %.2f\n" +
                        "----------------------------------------\n" +
                        "%-18s: R$ %.2f\n" +
                        "%-18s: R$ %.2f\n" +
                        "%-18s: R$ %.2f\n" +
                        "----------------------------------------\n" +
                        "%-18s: R$ %.2f\n" +
                        "========================================",
                "NOME", nome,
                "SALÁRIO BRUTO", salarioBruto,
                "AUMENTO", calcularAumentoSalario(),
                "SALÁRIO COM AUM.", salarioComAumento(),
                "IMPOSTO (-)", calcularImposto(),
                "SALÁRIO LÍQUIDO", salarioLiquido()
        );
    }
}