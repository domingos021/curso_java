package generics.set.exercfixacao.model.services;

import generics.set.exercfixacao.model.entities.Course;
import generics.set.exercfixacao.model.entities.Enrollment;
import generics.set.exercfixacao.model.entities.Student;

import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * CLASSE ENROLLMENTSERVICE
 * ============================================================
 *
 * Representa a camada de serviço responsável por gerenciar
 * as matrículas dos alunos.
 *
 * Diferentemente das entidades (Student, Course e Enrollment),
 * esta classe concentra a lógica de negócio relacionada às
 * matrículas.
 *
 * Sua principal responsabilidade é controlar o processo de
 * matricular alunos em cursos, mantendo a consistência das
 * informações do sistema.
 *
 * ============================================================
 * RESPONSABILIDADES DA CLASSE
 * ============================================================
 *
 * ✔ Realizar matrículas.
 * ✔ Armazenar todas as matrículas realizadas.
 * ✔ Impedir matrículas duplicadas.
 * ✔ Manter sincronizadas as entidades Course e Enrollment.
 * ✔ Fornecer consultas sobre as matrículas.
 *
 * Em projetos reais, essa classe poderia também:
 *
 * • cancelar matrículas;
 * • pesquisar alunos matriculados;
 * • verificar vagas disponíveis;
 * • validar pré-requisitos;
 * • emitir certificados.
 */
public class EnrollmentService {

    /*
     * Conjunto contendo todas as matrículas realizadas.
     *
     * Foi escolhido um HashSet porque:
     *
     * • não permite matrículas duplicadas;
     * • possui inserção muito rápida (O(1));
     * • possui busca muito rápida (O(1)).
     *
     * A verificação de duplicidade ocorre através
     * dos métodos equals() e hashCode()
     * implementados na classe Enrollment.
     */
    private final Set<Enrollment> enrollments = new HashSet<>();

    /*
     * ============================================================
     * enroll()
     * ============================================================
     *
     * Realiza a matrícula de um aluno em um curso.
     *
     * O processo acontece em duas etapas:
     *
     * 1) Cria um novo objeto Enrollment, representando
     *    oficialmente a matrícula.
     *
     * 2) Adiciona essa matrícula ao conjunto de matrículas.
     *
     * Como utilizamos um HashSet, caso essa matrícula
     * já exista, ela será ignorada automaticamente.
     *
     * Depois disso, o aluno também é adicionado ao
     * conjunto de alunos do curso.
     *
     * Dessa forma, mantemos o relacionamento entre
     * Course e Enrollment sempre consistente.
     *
     * Relação mantida:
     *
     * EnrollmentService
     *        │
     *        ▼
     *   Enrollment
     *        │
     *        ▼
     *     Course
     *        │
     *        ▼
     *     Students
     */
    public void enroll(Student student, Course course) {

        // Cria uma nova matrícula.
        Enrollment enrollment = new Enrollment(student, course);

        // Adiciona a matrícula ao conjunto.
        // Caso já exista, o HashSet não permitirá duplicação.
        enrollments.add(enrollment);

        /*
         * Mantém a consistência do sistema.
         *
         * Além da matrícula existir na coleção de
         * Enrollment, o curso também precisa conhecer
         * seus alunos matriculados.
         *
         * Assim, Course e Enrollment permanecem
         * sincronizados.
         */
        course.addStudent(student);
    }

    /*
     * ============================================================
     * getEnrollments()
     * ============================================================
     *
     * Retorna todas as matrículas cadastradas.
     *
     * Observe que não retornamos o HashSet original.
     *
     * Utilizamos Set.copyOf() para devolver uma cópia
     * imutável da coleção.
     *
     * Isso impede que outras classes façam alterações
     * diretamente nas matrículas, preservando o
     * encapsulamento da classe.
     *
     * Exemplo de operação proibida:
     *
     * service.getEnrollments().add(...);
     */
    public Set<Enrollment> getEnrollments() {
        return Set.copyOf(enrollments);
    }

    /*
     * ============================================================
     * totalEnrollments()
     * ============================================================
     *
     * Retorna a quantidade total de matrículas
     * existentes no sistema.
     *
     * O método size() possui complexidade O(1),
     * pois o HashSet mantém internamente a quantidade
     * de elementos armazenados.
     *
     * Exemplo:
     *
     * 3 cursos
     * 15 alunos
     * 27 matrículas
     *
     * Resultado:
     *
     * totalEnrollments() → 27
     */
    public int totalEnrollments() {
        return enrollments.size();
    }

    /*
     * ============================================================
     * OBSERVAÇÃO
     * ============================================================
     *
     * Esta classe representa a camada Service da aplicação.
     *
     * Em uma arquitetura em camadas:
     *
     * Main
     *   │
     *   ▼
     * EnrollmentService
     *   │
     *   ▼
     * Enrollment
     *   │
     *   ├── Student
     *   └── Course
     *
     * Ou seja:
     *
     * • As entidades armazenam informações.
     * • O Service contém as regras de negócio.
     *
     * Essa separação torna o sistema mais organizado,
     * reutilizável e fácil de manter.
     */
}