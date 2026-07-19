package generics.set.exercfixacao.app;

import generals_utils.utils.Leitor;
import generics.set.exercfixacao.model.CourseType;
import generics.set.exercfixacao.model.entities.Course;
import generics.set.exercfixacao.model.entities.Instructor;
import generics.set.exercfixacao.model.entities.Student;
import generics.set.exercfixacao.model.services.EnrollmentService;
import generics.set.exercfixacao.model.services.ReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {


            /*
             * Criando instrutor.
             */
            int instructorCode = Leitor.lerNumeroInteiro(
                    sc,
                    "Digite code do instructor: "
            );

            String instructorName = Leitor.lerTexto(
                    sc,
                    "Nome do instrutor: "
            );

            String instructorEmail = Leitor.lerTexto(
                    sc,
                    "Email do instrutor: "
            );

            // Manda para o constructor responsável
            Instructor prof = new Instructor(
                    instructorCode,
                    instructorName,
                    instructorEmail
            );


            /*
             * ============================================================
             * CRIAÇÃO DE UM CURSO
             * ============================================================
             *
             * Estamos criando um objeto da classe Course.
             *
             * O construtor de Course espera dois argumentos:
             *
             * 1) O tipo do curso (CourseType).
             * 2) O instrutor responsável pelo curso.
             *
             * Neste exemplo:
             *
             * • CourseType.PROGRAMMING é uma constante do enum
             *   CourseType, indicando que este curso pertence
             *   à área de Programação.
             *
             * • prof é um objeto da classe Instructor,
             *   representando o professor responsável pelo curso.
             *
             * O enum CourseType foi importado para esta classe:
             *
             *      import generics.set.exercfixacao.model.CourseType;
             *
             * Isso permite acessar suas constantes diretamente,
             * como PROGRAMMING, SALES e ENGINEERING.
             *
             * O fluxo completo da criação do objeto é:
             *
             * Program (Main)
             *        │
             *        │
             *        ▼
             * CourseType.PROGRAMMING
             *        │
             *        │ (o Program acessa a constante do enum)
             *        ▼
             * new Course(CourseType.PROGRAMMING, prof)
             *        │
             *        │ (os argumentos são enviados ao construtor)
             *        ▼
             * public Course(CourseType type, Instructor instructor)
             *        │
             *        ├── this.type = type;
             *        └── this.instructor = instructor;
             *        │
             *        ▼
             * Objeto Course criado
             *
             * Observe que a classe Course não procura nem consulta
             * o enum. Quem acessa a constante do enum é o Program.
             * O construtor apenas recebe esse valor através do
             * parâmetro 'type' e o armazena no atributo:
             *
             *      private final CourseType type;
             *
             * Após a criação, a variável 'programming' passa a
             * referenciar um objeto Course do tipo PROGRAMMING,
             * ministrado pelo instrutor 'prof'.
             */
            Course programming = new Course(
                    CourseType.PROGRAMMING, //enum
                    prof //objeto
            );

            Course sales = new Course(
                    CourseType.SALES,
                    prof
            );

            Course engineering = new Course(
                    CourseType.ENGINEERING_MACHINE,
                    prof
            );


            /*
             * ============================================================
             * REGISTRANDO OS CURSOS DO INSTRUTOR
             * ============================================================
             *
             * Após criar os objetos Course, precisamos associá-los
             * ao instrutor responsável.
             *
             * Para isso, chamamos o método addCourse() da classe
             * Instructor.
             *
             * Fluxo da execução:
             *
             * Program (Main)
             *        │
             *        ▼
             * prof.addCourse(programming);
             *        │
             *        ▼
             * addCourse(Course course)
             *        │
             *        │ (o objeto 'programming' é recebido
             *        │  pelo parâmetro 'course')
             *        ▼
             * courses.add(course);
             *        │
             *        ▼
             * HashSet<Course>
             *        │
             *        ▼
             * Curso armazenado na coleção do instrutor
             *
             * O mesmo processo acontece para os demais cursos.
             *
             * Como a coleção 'courses' é um Set (HashSet),
             * caso o mesmo curso seja adicionado novamente,
             * ele será automaticamente ignorado, evitando
             * duplicidades.
             *
             * Após essas chamadas, o objeto 'prof' passa a
             * conhecer todos os cursos pelos quais é responsável.
             */

            prof.addCourse(programming);
            prof.addCourse(sales);
            prof.addCourse(engineering);


            /*
             * ============================================================
             * LISTA DE CURSOS DISPONÍVEIS
             * ============================================================
             *
             * Criamos uma coleção responsável por armazenar todos os
             * cursos que poderão ser utilizados durante a execução
             * do programa.
             *
             * Foi utilizada uma List (ArrayList) porque:
             *
             * • mantém a ordem de inserção dos cursos;
             * • permite acessar um curso pelo índice (get());
             * • facilita percorrer todos os cursos utilizando
             *   um laço de repetição (for ou foreach).
             *
             * Fluxo da execução:
             *
             * Program (Main)
             *        │
             *        ▼
             * ArrayList<Course>
             *        │
             *        ├── programming
             *        ├── sales
             *        └── engineering
             *
             * Essa lista funciona como um catálogo de cursos
             * disponíveis para matrícula.
             *
             * Sempre que for necessário localizar um curso,
             * basta percorrer essa coleção.
             *
             * Neste exemplo utilizamos uma List porque sabemos
             * exatamente quais cursos queremos armazenar e a
             * ordem pode ser importante para apresentação.
             */
            List<Course> courses = new ArrayList<>();

            // Adiciona os cursos ao catálogo.
            courses.add(programming);
            courses.add(sales);
            courses.add(engineering);


            /*
             * Serviços responsáveis pelas regras do sistema.
             */
            EnrollmentService enrollmentService =
                    new EnrollmentService();

            ReportService reportService =
                    new ReportService();


            /*
             * Realizando matrículas dos alunos.
             *
             * O aluno escolhe dinamicamente
             * em qual curso deseja se matricular.
             */
            readEnrollments(
                    sc,
                    courses,
                    enrollmentService
            );


            /*
             * ============================================================
             * EXIBINDO O RELATÓRIO FINAL
             * ============================================================
             *
             * A classe ReportService é responsável por consultar
             * os dados do sistema e apresentá-los ao usuário.
             *
             * O método showInstructorReport() gera um relatório
             * completo contendo:
             *
             * • informações do instrutor;
             * • cursos ministrados;
             * • alunos matriculados em cada curso;
             * • total de alunos únicos.
             *
             * Dessa forma, o Program apenas solicita a geração
             * do relatório, enquanto toda a lógica de apresentação
             * permanece centralizada na classe ReportService.
             */
            reportService.showInstructorReport(prof);


        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }


    /*
     * Realiza a matrícula dos alunos escolhendo
     * dinamicamente um curso disponível.
     *
     * O método recebe uma lista de cursos,
     * pois o aluno pode escolher qualquer curso
     * oferecido pelo instrutor.
     */
    private static void readEnrollments(
            Scanner sc,
            List<Course> courses,
            EnrollmentService enrollmentService
    ) {


        int quantity = Leitor.lerNumeroInteiro(
                sc,
                "Quantidade de matrículas: "
        );


        for (int i = 0; i < quantity; i++) {


            System.out.println("\nCursos disponíveis:");
            //percorre a lista de cursos
            for (int j = 0; j < courses.size(); j++) {

                System.out.println(
                        (j + 1)
                                + " - "
                                + courses.get(j).getType() //pega o curso na posição do índice atual
                );
            }

            /*
             * ============================================================
             * ESCOLHENDO UM CURSO
             * ============================================================
             *
             * O usuário informa um número correspondente ao curso
             * desejado.
             *
             * Exemplo:
             *
             * 1 - Programming
             * 2 - Sales
             * 3 - Engineering
             *
             * O método lerNumeroInteiro() lê o valor digitado e
             * o armazena na variável 'option'.
             */
            int option = Leitor.lerNumeroInteiro(
                    sc,
                    "Escolha o curso: "
            );

            /*
             * ============================================================
             * LOCALIZANDO O CURSO ESCOLHIDO
             * ============================================================
             *
             * A List<Course> armazena seus elementos utilizando
             * índices, que sempre começam em ZERO.
             *
             * Índice      Curso
             * ------      ----------------
             *   0    ->   Programming
             *   1    ->   Sales
             *   2    ->   Engineering
             *
             * Entretanto, para o usuário é mais intuitivo começar
             * a numeração em 1.
             *
             * Menu exibido:
             *
             * 1 - Programming
             * 2 - Sales
             * 3 - Engineering
             *
             * Se o usuário digitar:
             *
             *      option = 1
             *
             * Precisamos acessar a posição 0 da lista.
             *
             * Por isso fazemos:
             *
             *      option - 1
             *
             * Fluxo:
             *
             * Usuário
             *    │
             *    ▼
             * Digita: 1
             *    │
             *    ▼
             * option = 1
             *    │
             *    ▼
             * option - 1
             *    │
             *    ▼
             * courses.get(0)
             *    │
             *    ▼
             * Objeto Programming
             *
             * O método get() retorna o objeto Course armazenado
             * naquela posição da lista.
             *
             * A variável 'course' passa então a referenciar
             * exatamente o curso escolhido pelo usuário.
             */
            Course course = courses.get(option - 1);


            /*
             * Dados do aluno.
             */
            int code = Leitor.lerNumeroInteiro(
                    sc,
                    "Código do aluno: "
            );


            String name = Leitor.lerTexto(
                    sc,
                    "Nome do aluno: "
            );


            String email = Leitor.lerTexto(
                    sc,
                    "Email do aluno: "
            );


            Student student = new Student(
                    code,
                    name,
                    email
            );


            /*
             * A matrícula é feita pelo serviço,
             * mantendo as regras centralizadas.
             */
            enrollmentService.enroll(
                    student,
                    course
            );
        }
    }
}



/*
 * List x Set
 *
 * List:
 * - Mantém a ordem de inserção dos elementos.
 * - Permite elementos duplicados.
 * - Permite acesso por índice (get, set, etc.).
 * - Ideal quando a ordem dos elementos é importante.
 *
 * Set:
 * - Não permite elementos duplicados.
 * - Não possui acesso por índice.
 * - A ordem depende da implementação (HashSet, LinkedHashSet ou TreeSet).
 * - Ideal quando precisamos garantir que cada elemento seja único.
 */