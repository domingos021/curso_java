package generics.set.exercfixacao.model.services;

import generics.set.exercfixacao.model.entities.Course;
import generics.set.exercfixacao.model.entities.Instructor;
import generics.set.exercfixacao.model.entities.Student;

import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * CLASSE REPORTSERVICE
 * ============================================================
 *
 * Responsável pela geração de relatórios e consultas
 * da aplicação.
 *
 * Diferentemente do EnrollmentService, esta classe
 * NÃO altera os dados do sistema.
 *
 * Sua única responsabilidade é consultar os objetos
 * existentes e apresentá-los de forma organizada.
 *
 * ============================================================
 * RESPONSABILIDADES
 * ============================================================
 *
 * ✔ Gerar relatório completo do instrutor.
 * ✔ Exibir cursos ministrados.
 * ✔ Exibir alunos matriculados.
 * ✔ Calcular o total de alunos únicos.
 *
 * Em aplicações reais essa classe poderia gerar:
 *
 * • Relatórios PDF
 * • Planilhas Excel
 * • Dashboards
 * • Estatísticas
 *
 * Essa separação segue o princípio da Responsabilidade
 * Única (SRP - Single Responsibility Principle).
 */
public class ReportService {

    /*
     * ============================================================
     * showInstructorReport()
     * ============================================================
     *
     * Gera um relatório completo do instrutor.
     *
     * O relatório apresenta:
     *
     * • Dados do instrutor.
     * • Todos os cursos ministrados.
     * • Os alunos matriculados em cada curso.
     * • O total de alunos únicos.
     *
     * O objetivo é centralizar toda a impressão do
     * sistema nesta classe, deixando as entidades
     * livres da responsabilidade de formatar relatórios.
     */
    public void showInstructorReport(Instructor instructor) {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 INSTRUCTOR REPORT");
        System.out.println("======================================================");

        System.out.printf("Code : %d%n", instructor.getCode());
        System.out.printf("Name : %s%n", instructor.getName());
        System.out.printf("Email: %s%n", instructor.getEmail());

        System.out.println();
        System.out.println("Courses:");

        for (Course course : instructor.getCourses()) {

            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("Course : " + course.getType());
            System.out.println("Instructor : " + instructor.getName());

            System.out.println();
            System.out.println("Students:");

            if (course.getStudents().isEmpty()) {

                System.out.println("   No students enrolled.");

            } else {

                for (Student student : course.getStudents()) {
                    System.out.println("   • " + student);
                }
            }
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("Total unique students: "
                + totalUniqueStudents(instructor));
        System.out.println("======================================================");
    }

    /*
     * ============================================================
     * totalUniqueStudents()
     * ============================================================
     *
     * Calcula quantos alunos diferentes um instrutor
     * possui considerando TODOS os seus cursos.
     *
     * Um mesmo aluno pode estar matriculado em vários
     * cursos. Entretanto, ele deve ser contado apenas
     * uma única vez.
     *
     * Para eliminar automaticamente as duplicidades,
     * utilizamos um HashSet.
     *
     * Fluxo:
     *
     * Instructor
     *      │
     *      ▼
     * Percorre todos os cursos
     *      │
     *      ▼
     * Adiciona todos os alunos em um HashSet
     *      │
     *      ▼
     * Alunos repetidos são ignorados
     *      │
     *      ▼
     * size()
     *
     * Complexidade aproximada: O(N)
     * onde N representa a quantidade total
     * de alunos percorridos.
     */
    public int totalUniqueStudents(Instructor instructor) {

        /*
         * Conjunto auxiliar responsável por armazenar
         * todos os alunos encontrados durante a
         * varredura dos cursos.
         */
        Set<Student> students = new HashSet<>();

        /*
         * Percorre todos os cursos do instrutor.
         */
        for (Course course : instructor.getCourses()) {

            /*
             * Adiciona todos os alunos do curso.
             *
             * Como HashSet não permite duplicatas,
             * um mesmo aluno será armazenado apenas
             * uma única vez.
             */
            students.addAll(course.getStudents());
        }

        return students.size();
    }
}