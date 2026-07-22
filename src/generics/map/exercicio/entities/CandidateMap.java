package generics.map.exercicio.entities;

import java.util.Objects;

/*
 * ============================================================
 * CLASSE CANDIDATEMAP
 * ============================================================
 *
 * Representa um candidato da eleição.
 *
 * Esta classe será utilizada como CHAVE (Key) de um
 * HashMap.
 *
 * O total de votos NÃO pertence ao candidato.
 * Os votos serão armazenados como VALOR (Value)
 * dentro do Map.
 *
 * Exemplo:
 *
 * CandidateMap -----------------> Integer
 *
 * Alex Blue --------------------> 76
 * Maria Green ------------------> 71
 * Bob Brown --------------------> 61
 *
 * Como esta classe será utilizada como chave de um
 * HashMap, é obrigatório implementar corretamente
 * os métodos equals() e hashCode().
 *
 * Dois candidatos são considerados iguais quando
 * possuem o mesmo nome.
 */
public class CandidateMap {

    /*
     * Nome do candidato.
     *
     * Este atributo identifica unicamente o candidato
     * dentro do Map.
     */
    private String name;

    /*
     * Construtor.
     *
     * Recebe apenas o nome do candidato.
     */
    public CandidateMap(String name) {
        this.name = name;
    }

    /*
     * Retorna o nome do candidato.
     */
    public String getName() {
        return name;
    }

    /*
     * Altera o nome do candidato.
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * ============================================================
     * equals()
     * ============================================================
     *
     * Dois objetos CandidateMap serão considerados iguais
     * quando possuírem o mesmo nome.
     *
     * Isso permite que o HashMap reconheça quando um
     * candidato já existe e apenas atualize seu total
     * de votos.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CandidateMap other = (CandidateMap) obj;

        return Objects.equals(name, other.name);
    }

    /*
     * ============================================================
     * hashCode()
     * ============================================================
     *
     * Gera o código hash baseado apenas no nome.
     *
     * Como equals() utiliza somente o atributo name,
     * hashCode() também deve utilizar apenas esse
     * atributo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*
     * ============================================================
     * toString()
     * ============================================================
     *
     * Retorna apenas o nome do candidato.
     */
    @Override
    public String toString() {
        return name;
    }
}