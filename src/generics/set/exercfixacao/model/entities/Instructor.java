package generics.set.exercfixacao.model.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Instructor extends Person {

    /*
     * Composição:
     * Um instrutor possui um conjunto de cursos que ministra.
     *
     * A classe Instructor utiliza a classe Course como atributo,
     * estabelecendo uma relação "tem um" (has-a).
     *
     * O Set é utilizado para impedir que o mesmo curso
     * seja adicionado mais de uma vez ao instrutor.
     */
    /*
     * Quando executamos: no main
     *
     * Instructor prof = new Instructor(
     *         1,
     *         "Alex",
     *         "alex@email.com"
     * );
     *
     * O Java executa, de forma simplificada, os seguintes passos:
     *
     * 1. Reserva memória para o novo objeto Instructor.
     * 2. Inicializa os atributos da classe, incluindo:
     *      private final Set<Course> courses = new HashSet<>();
     * 3. Executa o construtor, inicializando os atributos herdados
     *    da classe Person por meio da chamada super(...).
     */

    /*
     * O conjunto de cursos é criado automaticamente quando
     * o objeto Instructor é instanciado. Assim, o construtor
     * não precisa receber um Set<Course> como parâmetro.
     */
    private final Set<Course> courses = new HashSet<>();

    public Instructor(Integer code, String name, String email) {
        super(code, name, email);
    }


    /*
     * Adiciona um curso ao conjunto de cursos do instrutor.
     *
     * Fluxo da execução:
     *
     * 1) O método é chamado na classe Program:
     *
     *      prof.addCourse(programming);
     *      prof.addCourse(sales);
     *      prof.addCourse(engineering);
     *
     * 2) O objeto Course recebido como parâmetro é armazenado
     *    na variável local 'course'.
     *
     * 3) Em seguida, o método add() do HashSet é chamado para
     *    inserir o curso na coleção 'courses'.
     *
     * Como a coleção é um Set, caso o mesmo curso seja
     * adicionado novamente, ele será automaticamente
     * ignorado, evitando duplicidades.
     *
     * A responsabilidade deste método é apenas receber
     * o curso e delegar sua inserção ao conjunto de cursos
     * pertencente ao instrutor.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }


    /*
     * Remove um curso do conjunto de cursos do instrutor.
     *
     * Caso o curso não exista no Set,
     * nenhuma alteração será realizada.
     */
    public void removeCourse(Course course) {
        courses.remove(course);
    }


    /*
     * Retorna uma visão somente leitura dos cursos.
     * Evita alterações externas diretas na coleção interna.
     */
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Instructor [");
        sb.append("Código: ").append(getCode());
        sb.append(", Nome: ").append(getName());
        sb.append(", Email: ").append(getEmail());
        sb.append("]");

        return sb.toString();
    }
}