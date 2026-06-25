package EnumeracaoComposicao.composicao.ExercFixacao.Entities;

import java.text.SimpleDateFormat; // Importado para formatar a data de nascimento no toString
import java.util.Date;

public class Client {

    // Objeto estático para formatar a data de nascimento como DD/MM/YYYY
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;

    // Data de nascimento do cliente
    private Date birthDate;


    // Construtor padrão
    public Client() {
    }


    // Construtor com os dados do cliente
    public Client(String name, String email, Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // ADIÇÃO: Método toString para formatar a exibição do cliente no sumário do pedido
    // Exemplo: Alex Green (20/10/1980) - alex@gmail.com
    @Override
    public String toString() {
        return name + " (" + sdf.format(birthDate) + ") - " + email;
    }
}