package generics.set.exercfixacao.model.entities;

import java.time.LocalDateTime;
import java.util.Objects;

/*
 * ============================================================
 * CLASSE ENROLLMENT (MATRÍCULA)
 * ============================================================
 *
 * Representa a matrícula de um aluno em um curso.
 *
 * Esta classe estabelece o relacionamento entre
 * um Student e um Course, registrando também
 * o momento em que a matrícula foi realizada.
 *
 * Em um sistema real, uma matrícula é considerada
 * uma entidade própria, pois possui informações
 * além do aluno e do curso, como:
 *
 * • data da matrícula;
 * • situação (ativa, cancelada, concluída);
 * • nota final;
 * • frequência;
 * • data de conclusão;
 *
 * Neste exemplo, armazenamos apenas:
 *
 * • o aluno matriculado;
 * • o curso;
 * • a data e hora da matrícula.
 *
 * ============================================================
 * RESPONSABILIDADES DA CLASSE
 * ============================================================
 *
 * ✔ Representar uma matrícula.
 * ✔ Relacionar um aluno a um curso.
 * ✔ Registrar quando a matrícula aconteceu.
 * ✔ Impedir matrículas duplicadas quando utilizada
 *   dentro de um Set.
 */
public class Enrollment {

    /*
     * Aluno que realizou a matrícula.
     *
     * O atributo é final porque uma matrícula
     * sempre pertence ao mesmo aluno depois
     * de criada.
     */
    private final Student student;

    /*
     * Curso no qual o aluno foi matriculado.
     *
     * Também é final porque uma matrícula
     * não muda de curso após sua criação.
     */
    private final Course course;

    /*
     * Data e hora em que a matrícula foi criada.
     *
     * O valor é definido automaticamente
     * utilizando o horário atual do sistema.
     *
     * LocalDateTime representa uma data e hora
     * sem considerar fuso horário.
     */
    private final LocalDateTime enrollmentDate;

    /*
     * Cria uma nova matrícula.
     *
     * Ao criar uma matrícula é necessário informar:
     *
     * • o aluno;
     * • o curso.
     *
     * A data da matrícula é registrada automaticamente
     * utilizando LocalDateTime.now().
     */
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDateTime.now();
    }

    /*
     * Retorna o aluno matriculado.
     */
    public Student getStudent() {
        return student;
    }

    /*
     * Retorna o curso da matrícula.
     */
    public Course getCourse() {
        return course;
    }

    /*
     * Retorna a data e hora em que
     * a matrícula foi realizada.
     */
    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    /*
     * ============================================================
     * equals()
     * ============================================================
     *
     * Determina quando duas matrículas são consideradas iguais.
     *
     * Neste projeto, duas matrículas são iguais quando:
     *
     * • pertencem ao mesmo aluno;
     * • pertencem ao mesmo curso.
     *
     * A data da matrícula NÃO participa da comparação.
     *
     * Exemplo:
     *
     * João → Curso Java → 10:00
     * João → Curso Java → 15:00
     *
     * Mesmo com horários diferentes,
     * representam a mesma matrícula.
     *
     * Isso impede que o mesmo aluno seja
     * matriculado duas vezes no mesmo curso,
     * principalmente quando utilizamos HashSet.
     */
    @Override
    public boolean equals(Object obj) {

        // Verifica se ambos apontam para o mesmo objeto.
        if (this == obj) return true;

        // Verifica se o objeto é nulo ou pertence
        // a outra classe.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Converte o objeto para Enrollment.
        Enrollment other = (Enrollment) obj;

        // Compara aluno e curso.
        return Objects.equals(student, other.student)
                && Objects.equals(course, other.course);
    }

    /*
     * ============================================================
     * hashCode()
     * ============================================================
     *
     * Gera o código hash utilizado por estruturas
     * como:
     *
     * • HashSet
     * • HashMap
     * • Hashtable
     *
     * Como equals() utiliza student e course,
     * hashCode() também deve utilizar exatamente
     * esses mesmos atributos.
     *
     * Essa é uma regra fundamental do Java:
     *
     * Se dois objetos são iguais segundo equals(),
     * obrigatoriamente devem possuir o mesmo hashCode().
     */
    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

    /*
     * ============================================================
     * toString()
     * ============================================================
     *
     * Retorna uma representação textual da matrícula.
     *
     * Exibe:
     *
     * • nome do aluno;
     * • curso;
     * • data e hora da matrícula.
     *
     * Muito útil para:
     *
     * • depuração (debug);
     * • testes;
     * • impressão no console.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Enrollment [");
        sb.append("Student: ").append(student.getName());
        sb.append(", Course: ").append(course.getType());
        sb.append(", Enrollment Date: ").append(enrollmentDate);
        sb.append("]");

        return sb.toString();
    }
}