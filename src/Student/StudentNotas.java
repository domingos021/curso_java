package Student;

public class StudentNotas {
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;



    // Construtor padrão
    public StudentNotas() {
    }

    // Retorno do nome
    public String getNome() {
        return nome;
    }

    // Validação do nome
    public void setNome(String nomePdrao) {
        if (nomePdrao != null && !nomePdrao.trim().isEmpty()) {
            this.nome = nomePdrao;
        }
    }

    // Getters das notas
    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    // CORRIGIDO: Agora testa as variáveis certas que vêm por parâmetro e aceita >= 0
    public void setNotas(double nota1Pdrao, double nota2Pdrao, double nota3Pdrao) {
        if (
                nota1Pdrao >= 0 && nota1Pdrao <= 10 &&
                nota2Pdrao >= 0 && nota2Pdrao <= 10 &&
                nota3Pdrao >= 0 && nota3Pdrao <= 10) {

            this.nota1 = nota1Pdrao;
            this.nota2 = nota2Pdrao;
            this.nota3 = nota3Pdrao;
        }
    }

    // ============================ NOVOS MÉTODOS ÚTEIS =========================

    /**
     * Calcula a nota final somando os três trimestres (Acumulado de 0 a 30 pontos)
     */
    public double notaFinal() {
        // Apenas soma. Sem dividir por 3 e sem tentar atribuir a uma variável "media" que não foi declarada.
        return  nota1 + nota2 + nota3;
    }

    /**
     * Retorna quantos pontos faltam para o aluno alcançar a nota mínima de recuperação (15.0 pontos na soma)
     */
    public double pontosFaltantes() {
        // Se a soma das notas for maior ou igual a 15, ele não está reprovado (está em recuperação ou aprovado)
        if (notaFinal() >= 15.0) {
            return 0.0;
        } else {
            // Se tirou menos que 15, faltam X pontos para ele chegar no 15 (limite da recuperação)
            return 15.0 - notaFinal();
        }
    }


    @Override
    public String toString() {
        double totalPontos = notaFinal();
        String situacao;
        String detalhesFaltantes = "";

        // Aplica as regras de negócio de forma isolada e segura usando o operador && (E)
        if (totalPontos >= 21.0 && totalPontos <= 30.0) {
            situacao = "APROVADO";
            // Não precisa de detalhesFaltantes pois ele já passou!

        } else if (totalPontos >= 15.0 && totalPontos < 21.0) {
            situacao = "RECUPERAÇÃO";
            // Se ele está em recuperação (ex: tem 16.0), faltam pontos para chegar no 21.0 (Aprovação)
            double faltamParaAprovacao = 21.0 - totalPontos;
            detalhesFaltantes = String.format("\nFALTARAM: %.2f PONTOS PARA A APROVAÇÃO DIRETA", faltamParaAprovacao);

        } else {
            situacao = "REPROVADO";
            // Se está abaixo de 15.0, faltam pontos para chegar no mínimo da recuperação (15.0)
            detalhesFaltantes = String.format("\nFALTARAM: %.2f PONTOS PARA A RECUPERAÇÃO", pontosFaltantes());
        }

       double media = totalPontos/3;
        // Monta a String final bem organizada que será impressa na tela
        return "============ RESULTADO FINAL ============\n" +
                "ALUNO: " + nome.toUpperCase() + "\n" +
                String.format("NOTA FINAL: %.2f DE 30.0\n", totalPontos) +
                String.format("MEDIA FINAL:%.1f / 3 =  %.1f\n",totalPontos, media) +
                "SITUAÇÃO: " + situacao +
                detalhesFaltantes +
                "\n=========================================";
    }
}