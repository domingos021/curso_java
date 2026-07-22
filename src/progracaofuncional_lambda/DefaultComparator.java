package progracaofuncional_lambda;

/*
 * ============================================================
 * compareTo()
 * ============================================================
 *
 * Método definido pela interface Comparable.
 *
 * É aqui que definimos a ORDEM NATURAL da classe.
 *
 * Sempre que utilizarmos:
 *
 * Collections.sort(lista);
 *
 * este método será chamado automaticamente para
 * comparar dois objetos Product.
 *
 * Fluxo:
 *
 * Collections.sort(lista)
 *          │
 *          ▼
 * compareTo(produto1, produto2)
 *          │
 *          ▼
 * Retorna:
 *
 * < 0  → this vem antes de p
 * = 0  → objetos equivalentes
 * > 0  → p vem antes de this
 *
 * Neste exemplo estamos comparando apenas o nome
 * dos produtos.
 *
 * O método toUpperCase() transforma ambos os nomes
 * em letras maiúsculas antes da comparação.
 *
 * Assim:
 *
 * notebook
 * Notebook
 * NOTEBOOK
 *
 * serão considerados iguais para fins de ordenação,
 * tornando a comparação independente de letras
 * maiúsculas e minúsculas.
 * *
 * *Comparação por nomes, ignorando maiúsculos e minuscule
 */

import progracaofuncional_lambda.entities.Product;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

}
