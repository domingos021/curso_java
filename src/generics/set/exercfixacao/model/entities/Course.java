package generics.set.exercfixacao.model.entities;

import generics.set.exercfixacao.model.CourseType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * CLASSE COURSE
 * ============================================================
 *
 * Representa um curso oferecido por um instrutor.
 *
 * Esta classe é responsável por armazenar todas as informações
 * relacionadas a um curso específico, como:
 *
 * • o tipo do curso;
 * • o instrutor responsável;
 * • os alunos matriculados.
 *
 * Além de armazenar essas informações, esta classe também
 * gerencia as matrículas dos alunos, permitindo adicioná-los
 * ou removê-los do curso.
 *
 * Os alunos são armazenados em um Set para garantir que
 * um mesmo aluno nunca seja matriculado duas vezes no
 * mesmo curso.
 *
 * ============================================================
 * RESPONSABILIDADES DA CLASSE
 * ============================================================
 *
 * ✔ Representar um curso.
 * ✔ Conhecer seu instrutor.
 * ✔ Manter os alunos matriculados.
 * ✔ Impedir matrículas duplicadas.
 * ✔ Controlar o acesso à coleção de alunos
 *   através do encapsulamento.
 */
public class Course {

    /*
     * Identifica qual é o tipo do curso.
     *
     * Exemplos:
     * • JAVA
     * • CSHARP
     * • PYTHON
     *
     * O atributo é final porque um curso não deve
     * mudar de tipo depois de criado.
     */
    private final CourseType type;

    /*
     * Instrutor responsável pelo curso.
     *
     * Todo curso possui exatamente um instrutor.
     *
     * A referência é final para garantir que o curso
     * permaneça sempre associado ao mesmo instrutor.
     */
    private final Instructor instructor;

    /*
     * Conjunto de alunos matriculados.
     *
     * Foi escolhido um HashSet porque:
     *
     * • Não permite elementos duplicados.
     * • Possui inserção e busca muito rápidas (O(1)).
     * • A ordem dos alunos não é importante.
     *
     * Caso seja necessário preservar a ordem de inserção,
     * um LinkedHashSet poderia ser utilizado.
     *
     * Para que a verificação de duplicidade funcione
     * corretamente, a classe Student deve implementar
     * equals() e hashCode().
     */
    private final Set<Student> students = new HashSet<>();

    /*
     * Cria um novo curso.
     *
     * Para criar um curso é necessário informar:
     *
     * • o tipo do curso;
     * • o instrutor responsável.
     *
     * A coleção de alunos é criada automaticamente
     * vazia quando o objeto é instanciado.
     */
    public Course(CourseType type, Instructor instructor) {
        this.type = type;
        this.instructor = instructor;
    }

    /*
     * Retorna o tipo do curso.
     */
    public CourseType getType() {
        return type;
    }

    /*
     * Retorna o instrutor responsável pelo curso.
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /*
     * Retorna todos os alunos matriculados.
     *
     * Observe que NÃO retornamos o HashSet original.
     *
     * Em vez disso, retornamos uma visão somente leitura
     * (unmodifiableSet).
     *
     * Isso impede que outras classes façam alterações
     * diretamente na coleção através de chamadas como:
     *
     * course.getStudents().add(student);
     * course.getStudents().remove(student);
     *
     * Toda modificação deve acontecer somente pelos
     * métodos addStudent() e removeStudent(),
     * preservando o encapsulamento da classe.
     */
    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    /*
     * Matricula um aluno no curso.
     *
     * O aluno recebido como parâmetro é inserido
     * no HashSet de alunos matriculados.
     *
     * Como o HashSet não aceita elementos repetidos,
     * caso o aluno já esteja matriculado,
     * nenhuma duplicata será adicionada.
     *
     * Essa verificação depende da implementação
     * correta dos métodos equals() e hashCode()
     * na classe Student.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /*
     * Remove um aluno do curso.
     *
     * Caso o aluno exista no conjunto,
     * ele será removido.
     *
     * Caso contrário,
     * simplesmente nada acontecerá,
     * pois o método remove() retorna false
     * quando o elemento não é encontrado.
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /*
     * Retorna uma representação textual do objeto.
     *
     * São exibidos:
     *
     * • tipo do curso;
     * • instrutor responsável;
     * • alunos matriculados.
     *
     * Este método é bastante útil para:
     *
     * • depuração (debug);
     * • impressão no console;
     * • testes da aplicação.
     */

    /*
     * ============================================================
     * toString()
     * ============================================================
     *
     * Retorna uma representação textual do objeto Course.
     *
     * Este método é utilizado para facilitar a visualização
     * do objeto durante impressões no console, testes e
     * depuração da aplicação.
     *
     * Observe que este método exibe apenas as informações
     * pertencentes ao próprio curso:
     *
     * • Tipo do curso.
     * • Nome do instrutor responsável.
     *
     * A lista de alunos matriculados NÃO é exibida aqui.
     *
     * A responsabilidade de percorrer os alunos e montar
     * um relatório completo pertence à classe ReportService,
     * que foi criada especificamente para apresentar as
     * informações do sistema de forma organizada.
     *
     * Essa abordagem segue o princípio da Responsabilidade
     * Única (Single Responsibility Principle - SRP),
     * evitando que uma entidade tenha a responsabilidade
     * de representar também os objetos relacionados.
     *
     * Antes da criação da ReportService, este método também
     * imprimia a coleção de alunos, o que produzia uma saída
     * muito extensa e dificultava a leitura das informações.
     * Agora, cada classe representa apenas seus próprios
     * atributos, enquanto a ReportService centraliza toda
     * a lógica de apresentação dos dados.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Course [");
        sb.append("Type: ").append(type);
        sb.append(", Instructor: ").append(instructor.getName());
        sb.append("]");

        return sb.toString();
    }
}