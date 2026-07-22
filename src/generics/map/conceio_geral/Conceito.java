package generics.map.conceio_geral;

/*
 * ============================================================
 * MAP (Map<K, V>)
 * ============================================================
 *
 * *Principais implementações
 * *HashMap -> mais rapido o (operações O (1) em tabela hash) não ordenado
 * *treeMap -> mais lento (operações  O (log(n) em arvore rubro negra, ordenado pelo compareTo do objeto(ou comparador)
 * *LinkedHashMap -> velocidade intermediaria e elementos na ordem em que são adicionados
 * *
 * Map é uma estrutura de dados da Collections Framework
 * utilizada para armazenar informações no formato
 * CHAVE → VALOR (Key → Value).
 * *
 * *Metodos importantes
 * *-put(key, value), remove(key), contains(kesy) get(key)
 * *
 * *baseado em iquals e hashcode
 * *se equals e hashcode não existir, e usada a comparação de ponteiros
 * *
 * *clear()
 * *size()
 * *
 * *keySet -> retorna um set<k>
 *values() ->retorna um collevtiom<v>
 *
 * Diferentemente da List e do Set, um Map não armazena
 * apenas elementos.
 *
 * Uso comum (cooks, local storage, qualquer modelo chave valor
 * Cada informação armazenada possui obrigatoriamente:
 *
 * • uma chave (Key);
 * • um valor (Value).
 *
 * O objetivo principal do Map é permitir localizar
 * rapidamente um valor conhecendo sua chave.
 *
 * Podemos imaginar um Map como um dicionário:
 *
 * Palavra ---------> Significado
 *
 * Ou como uma agenda telefônica:
 *
 * Nome ------------> Telefone
 *
 * Ou ainda como um cadastro:
 *
 * Código ----------> Produto
 *
 * Em todos esses casos existe uma associação entre
 * uma chave única e um valor correspondente.
 */


import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Conceito {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Map<String,String> cookies = new TreeMap<>();
        cookies.put("username","Domingos"); //armazenando a chave o valor
        cookies.put("email","domingos@");
        cookies.put("Phone","984615325");


        //processando
        System.out.println("Size: "+cookies.size());
        System.out.println("Phone Number: "+cookies.get("Phone"));
        System.out.println("Contains 'email' key: " + cookies.containsKey("email"));//true
        cookies.remove("email");
        System.out.println("Contains 'email' key: " + cookies.containsKey("email")); //false
        cookies.put("Phone", "123456789");

        //para cada string key, no conjunto cookies.keyset

        System.out.println("All cookies ");
        for(String key : cookies.keySet()){
            System.out.println(key + " : " + cookies.get(key));
        }



    }
}
