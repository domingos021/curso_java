package EnumeracaoComposicao.composicao.exercicio02.entities;

public class Coment {
    private String text ;

    public Coment() {
        //const vazio padrão
    }

    public Coment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
