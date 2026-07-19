package generics.set.exercfixacao.model.entities;

/*
 * Representa um aluno do portal.
 *
 * Herda de Person os dados básicos:
 * code, name e email.
 *
 * O equals() e hashCode() também são herdados,
 * utilizando o code como identificador único.
 */
public class Student extends Person {

    public Student(Integer code, String name, String email) {
        super(code, name, email);
    }

    /*
     * Representação textual do aluno.
     * Facilita a visualização dos dados quando
     * o objeto for exibido no console.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student [");
        sb.append("Código: ").append(getCode());
        sb.append(", Nome: ").append(getName());
        sb.append(", Email: ").append(getEmail());
        sb.append("]");

        return sb.toString();
    }
}