package generics.hascode_equals;

import generics.hascode_equals.entities.Client_HashCode;

public class ConceitoProgram {

    public static void main(String[] args) {
        /*
         * =========================================================================
         * equals() e hashCode()
         * =========================================================================
         *
         * Toda classe em Java herda esses dois métodos da classe Object.
         *
         * Eles são utilizados para comparar objetos e para permitir que
         * coleções baseadas em hash (HashSet, HashMap, Hashtable, etc.)
         * funcionem corretamente.
         *
         * =========================================================================
         * equals()
         * =========================================================================
         *
         * O método equals() verifica a igualdade lógica entre dois objetos.
         *
         * Exemplo:
         *
         *     String a = "Maria";
         *     String b = "Maria";
         *
         *     a.equals(b); // true
         *
         * Já o operador == compara as referências (endereços de memória),
         * e não o conteúdo dos objetos.
         *
         * Exemplo:
         *
         *     Person p1 = new Person("João");
         *     Person p2 = new Person("João");
         *
         *     p1 == p2          // false
         *     p1.equals(p2)     // depende da implementação
         *
         * =========================================================================
         * hashCode()
         * =========================================================================
         *
         * O método hashCode() retorna um número inteiro (hash)
         * que representa o objeto.
         *
         * Esse valor é utilizado para localizar rapidamente objetos
         * em estruturas baseadas em tabelas hash.
         *
         * Quanto menor o número de colisões (objetos diferentes
         * com o mesmo hash), melhor será o desempenho da coleção.
         *
         * =========================================================================
         * RELAÇÃO ENTRE equals() E hashCode()
         * =========================================================================
         *
         * Existe um contrato importante:
         *
         * Se:
         *
         *      obj1.equals(obj2) == true
         *
         * obrigatoriamente:
         *
         *      obj1.hashCode() == obj2.hashCode()
         *
         * O contrário NÃO é obrigatório.
         *
         * Dois objetos podem possuir o mesmo hashCode()
         * e ainda assim serem diferentes.
         *
         * Isso é chamado de colisão de hash.
         *
         * =========================================================================
         * RESUMO
         * =========================================================================
         *
         * ==          -> compara referências
         *
         * equals()    -> compara o conteúdo lógico dos objetos
         *
         * hashCode()  -> gera um código inteiro utilizado para
         *                acelerar pesquisas em coleções Hash.
         *
         * Sempre que sobrescrevemos equals(),
         * devemos sobrescrever hashCode().
         *
         * =========================================================================
         */

        // =====================================================================
        // equals()
        // =====================================================================
        //
        // equals() compara o conteúdo lógico dos objetos.
        // O retorno sempre será:
        //      true  -> conteúdos iguais
        //      false -> conteúdos diferentes
        //
        String a = "Maria";
        String b = "Maria Jose";

      // Retorna false, pois os conteúdos são diferentes.
        System.out.println("equals: " + a.equals(b));


        // =====================================================================
        // hashCode()
        // =====================================================================
        //
        // hashCode() retorna um número inteiro que representa o objeto.
        //
        // Objetos iguais possuem obrigatoriamente o mesmo hashCode().
        // Objetos diferentes normalmente possuem hashCodes diferentes,
        // embora possam ocorrer colisões.
        //

        System.out.println("Hash de a: " + a.hashCode());
        System.out.println("Hash de b: " + b.hashCode());

        // Compara os dois códigos hash.
        System.out.println("Hash iguais? " + (a.hashCode() == b.hashCode()));


        System.out.println("Usando a class client =====================");

        Client_HashCode ch1 = new Client_HashCode("Alex", "domingos@yahoo.com");
        Client_HashCode ch2 = new Client_HashCode("Alex", "maria@gmail.com");

        System.out.println(ch1.hashCode());
        System.out.println(ch2.hashCode());

        System.out.println(ch2.equals(ch1));
        System.out.println(ch1 == ch2 ); // (==) compara as referencias de memoria na memória heap quanto a sua posição



    }

}
