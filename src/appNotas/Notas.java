package appNotas;

import Student.StudentNotas;
import java.util.Locale;
import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        StudentNotas student = new StudentNotas();

        // 1. VALIDAÇÃO DO NOME
        int tentativaNome = 0;
        while (tentativaNome < 2) {
            System.out.print("Digite o nome do aluno: ");
            String nomeDigitado = sc.nextLine();

            if (nomeDigitado != null && !nomeDigitado.trim().isEmpty()) {
                student.setNome(nomeDigitado);
                break;
            }
            System.out.println("[ALERTA] Nome não pode ser vazio!");
            tentativaNome++;
        }

        if (student.getNome() == null) {
            System.out.println("[ERRO] Nome inválido. Encerrando.");
            sc.close();
            return;
        }

        System.out.printf("Aluno: %s\n", student.getNome());
        System.out.println("Digite as 3 notas trimestrais:");

        // ============ NOTA 01 ================
        System.out.println("============NOTA:01================");
        double nota1 = -1;
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Digite a nota 1: ");
            nota1 = sc.nextDouble();

            if (nota1 >= 0 && nota1 <= 10) break;

            System.out.println("[ALERTA] A nota deve estar entre 0 e 10.");
        }
        if (nota1 < 0 || nota1 > 10) {
            System.out.println("[ERRO] Tentativas excedidas.");
            sc.close(); return;
        }
        // AJUSTADO: Mostra a variável local 'nota1' que acabou de ser digitada
        System.out.printf("Nota 1 confirmada: %.1f\n", nota1);

        // ============ NOTA 02 ================
        System.out.println("============NOTA:02================");
        double nota2 = -1;
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Digite a nota 2: ");
            nota2 = sc.nextDouble();
            if (nota2 >= 0 && nota2 <= 10) break;
            System.out.println("[ALERTA] A nota deve estar entre 0 e 10.");
        }
        if (nota2 < 0 || nota2 > 10) {
            System.out.println("[ERRO] Tentativas excedidas.");
            sc.close(); return;
        }
        // AJUSTADO: Mostra a variável local 'nota2'
        System.out.printf("Nota 2 confirmed: %.1f\n", nota2);

        // ============ NOTA 03 ================
        System.out.println("============NOTA:03================");
        double nota3 = -1;
        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Digite a nota 3: ");
            nota3 = sc.nextDouble();
            if (nota3 >= 0 && nota3 <= 10) break;
            System.out.println("[ALERTA] A nota deve estar entre 0 e 10.");
        }
        if (nota3 < 0 || nota3 > 10) {
            System.out.println("[ERRO] Tentativas excedidas.");
            sc.close(); return;
        }
        // AJUSTADO: Mostra a variável local 'nota3'
        System.out.printf("Nota 3 confirmada: %.1f\n", nota3);

        System.out.println("============ fim das notas digitadas================");
        System.out.println();

        // Envia as notas para o objeto (Agora sim o objeto guarda os valores!)
        student.setNotas(nota1, nota2, nota3);

        // Se quiser testar se o objeto guardou certo no final, funcionaria assim:
        System.out.printf("Notas salvas no sistema: %.1f, %.1f, %.1f%n",
                student.getNota1(), student.getNota2(), student.getNota3()
        );


        System.out.println(student);
        sc.close();
    }
}


/*
[ CLASSE PRINCIPAL: NOTAS ]                    [ CLASSE ENTIDADE: STUDENTNOTAS ]
              |                                                 |
 1. sc.nextLine() -> (Lê o Nome)                                |
 2. student.setNome(nomeDigitado) -------------------------->  (Valida e salva no private nome)
              |                                                 |
 3. sc.nextDouble() -> (Lê as 3 notas)                           |
 4. student.setNotas(nota1, nota2, nota3) ------------------>  (Valida se >= 0 e <= 10 e salva)
              |                                                 |
 5. System.out.println(student)                                 |
              |                                                 |
              +--- (O Java ativa o toString automaticamente) -> |
                                                                |-- Chama notaFinal() (soma)
                                                                |-- Chama pontosFaltantes()
                                                                |-- Calcula a média
                                                                |
        <-- (Retorna o texto do Relatório formatado) -----------+
              |
 6. Exibe no Console e sc.close()
 */