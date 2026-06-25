package Boxing_Unboxing;

public class WrapperClasses {
    /*
    =========================================================
                    WRAPPER CLASSES
    =========================================================

    IMPORTANTE

    É muito comum utilizar Wrapper Classes em sistemas de
    informação porque elas são tipos de referência (objetos).

    Por serem objetos, elas:

    ✔ Podem receber null.
    ✔ Possuem métodos próprios.
    ✔ Podem ser utilizadas em Collections.
    ✔ Participam normalmente dos recursos da POO.
    ✔ Permitem Auto-Boxing e Auto-Unboxing.

    ---------------------------------------------------------
    EXEMPLOS
    ---------------------------------------------------------

    Tipo primitivo      Wrapper Class

    byte          ->    Byte
    short         ->    Short
    int           ->    Integer
    long          ->    Long
    float         ->    Float
    double        ->    Double
    char          ->    Character
    boolean       ->    Boolean

    ---------------------------------------------------------
    OBSERVAÇÃO
    ---------------------------------------------------------

    String NÃO é um tipo primitivo.

    String já é uma classe (objeto) da linguagem Java.

    Exemplo:

    String nome = "Diniz";

    Portanto, String não possui Wrapper Class equivalente,
    pois ela própria já é uma classe.

    =========================================================
    */

    // String já é uma classe (tipo de referência).
    public String nome;

    // Double é uma Wrapper Class do tipo primitivo double.
    // Como é private, só pode ser acessada diretamente
    // dentro desta classe.
    private Double salario;

    // Integer é uma Wrapper Class do tipo primitivo int.
    // Pode armazenar valores inteiros e também null.
    public Integer quantidade;

    /*
       Uma vantagem prática muito comum em sistemas:

        private int quantidade;

        Aqui a quantidade obrigatoriamente terá um valor (0 por padrão).

        Já:

        private Integer quantidade;

        Pode assumir:

        quantidade = 10;
        quantidade = 0;
        quantidade = null;

        Muitos bancos de dados usam NULL, por isso frameworks
        como Hibernate e Spring Boot utilizam bastante
        Wrapper Classes em entidades.
     */




}
