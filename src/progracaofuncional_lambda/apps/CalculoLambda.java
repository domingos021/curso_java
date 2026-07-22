package progracaofuncional_lambda.apps;
/*
 * ============================================================
 * PARADIGMA FUNCIONAL DE PROGRAMAÇÃO
 * ============================================================
 *
 * O paradigma funcional de programação é um modelo de
 * programação baseado no conceito matemático de funções.
 *
 * Sua origem está relacionada ao Cálculo Lambda (λ-calculus),
 * criado pelo matemático Alonzo Church em 1930.
 *
 * O Cálculo Lambda é um sistema formal matemático usado
 * para estudar computação através da definição e aplicação
 * de funções.
 *
 * A ideia principal é tratar funções como valores de primeira
 * classe, ou seja:
 *
 * ✔ funções podem ser armazenadas em variáveis;
 *
 * ✔ funções podem ser passadas como argumentos para outras
 *   funções;
 *
 * ✔ funções podem retornar outras funções.
 *
 *
 * ============================================================
 * PRINCIPAIS CARACTERÍSTICAS DA PROGRAMAÇÃO FUNCIONAL
 * ============================================================
 *
 * 1) Funções puras:
 *
 * Uma função pura sempre produz o mesmo resultado para a
 * mesma entrada e não causa efeitos colaterais externos.
 *
 *
 * 2) Imutabilidade:
 *
 * Em vez de alterar dados existentes, normalmente criamos
 * novos valores a partir dos valores antigos.
 *
 *
 * 3) Composição de funções:
 *
 * Pequenas funções podem ser combinadas para formar
 * operações mais complexas.
 *
 *
 * ============================================================
 * RELAÇÃO COM EXPRESSÕES LAMBDA EM JAVA
 * ============================================================
 *
 * O Java não é uma linguagem puramente funcional.
 *
 * Java é principalmente uma linguagem orientada a objetos,
 * mas a partir do Java 8 passou a incorporar conceitos
 * funcionais.
 *
 * A principal ferramenta para isso são as Expressões Lambda.
 *
 *
 * Exemplo:
 *
 * Comparator<Product> comp =
 *      (p1, p2) -> p1.getName().compareTo(p2.getName());
 *
 *
 * A expressão Lambda representa uma função anônima que
 * implementa automaticamente uma Interface Funcional.
 *
 * Neste caso:
 *
 * Comparator
 *      |
 *      ▼
 * compare(p1, p2)
 *
 *
 * A Lambda fornece a implementação desse método sem a
 * necessidade de criar uma classe separada ou uma classe
 * anônima.
 */

public class CalculoLambda {

    public static void main(String[] args) {

    }
}