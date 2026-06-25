package Boxing_Unboxing;

import java.util.Locale;
import java.util.Scanner;

public class MainBoxingUmboxing {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // BOXING
        // Transforma um valor primitivo (int) em um objeto.
        // O Java cria um objeto Integer na Heap contendo o valor 20.

        int x = 20;

        Object obj = x;

        System.out.println(obj);


        // UNBOXING
        // Faz o processo inverso do Boxing.
        //
        // O valor armazenado dentro do objeto é copiado
        // para uma variável primitiva.
        //
        // Como "obj" é do tipo Object, precisamos informar
        // ao Java qual é o tipo real armazenado nele.
        // Para isso utilizamos o cast (int).

        // int y = obj; // ERRO: Object não pode ser convertido
        // automaticamente para int.

        // Fazemos o cast para dizer ao Java que dentro
        // desse Object existe um Integer.

        int y = (int) obj;

        System.out.println(y);


        // WRAPPER CLASSES
        // Para cada tipo primitivo existe uma classe Wrapper compatível.
        //
        // int     -> Integer
        // double  -> Double
        // char    -> Character
        // boolean -> Boolean
        //
        // Utilizando uma Wrapper Class, evitamos trabalhar diretamente
        // com Object e casts desnecessários.

        int b = 45;

        // BOXING (ou Auto-Boxing)
        // O valor primitivo int é convertido automaticamente
        // para um objeto Integer.
        Integer obj2 = b;

        System.out.println(obj2);

        // UNBOXING (ou Auto-Unboxing)
        // O valor armazenado dentro do Integer é convertido
        // automaticamente para um int.

        // O Java extrai automaticamente o valor int armazenado
        // dentro do objeto Integer para realizar a expressão matemática.
        //
        // É como se o Java fizesse:
        // obj2.intValue() * 6 / 5
        //
        // Após o cálculo, o resultado é armazenado em c.
        int c = obj2 * 6 / 5 ;

        System.out.println(c);


    }

}

/*
int x = 20; // Tipo primitivo (valor)

/*
BOXING

Pegamos o valor primitivo armazenado na variável x
e o transformamos em um objeto.

Object obj = x;

Object => classe base de todos os objetos em Java.

obj => variável de referência que aponta para um
objeto criado na memória Heap.

Durante o Boxing:

1. É criado um objeto do tipo Integer na Heap.
2. O valor 20 é copiado para dentro desse objeto.
3. obj passa a referenciar esse objeto.

Representação simplificada:

STACK
-----
x = 20

obj -----------+

HEAP           |
----           |
Integer(20) <--+

Observação:

Na verdade o objeto criado é um Integer
(wrapper class do tipo int), mas ele é armazenado
em uma variável do tipo Object porque Integer
herda de Object.
*/


/*
=========================================================
                    UNBOXING
=========================================================

UNBOXING é o processo inverso do Boxing.

No Boxing:
    int -> Integer/Object

No Unboxing:
    Integer/Object -> int

---------------------------------------------------------
EXEMPLO
---------------------------------------------------------

Object obj = 20; // Boxing automático

int x = (int) obj; // Unboxing

---------------------------------------------------------
O QUE ACONTECE?
---------------------------------------------------------

1. obj aponta para um objeto Integer na Heap.
2. O Java verifica se o objeto realmente contém
   um Integer.
3. O valor 20 é extraído do objeto.
4. O valor é copiado para a variável x na Stack.

---------------------------------------------------------
REPRESENTAÇÃO DA MEMÓRIA
---------------------------------------------------------

ANTES DO UNBOXING

STACK
-----

obj ----------------------+

HEAP                      |
----                      |
                           v
                      Integer
                      valor = 20


---------------------------------------------------------
APÓS O UNBOXING
---------------------------------------------------------

Object obj = 20;
int x = (int) obj;

STACK
-----

x = 20

obj ----------------------+

HEAP                      |
----                      |
                           v
                      Integer
                      valor = 20

---------------------------------------------------------
OBSERVAÇÃO IMPORTANTE
---------------------------------------------------------

O Unboxing NÃO remove o objeto da Heap.

Ele apenas:

1. Lê o valor armazenado dentro do objeto.
2. Copia esse valor para uma variável primitiva.

O objeto continua existindo enquanto houver
alguma referência apontando para ele.

---------------------------------------------------------
POR QUE O CAST É NECESSÁRIO?
---------------------------------------------------------

Object obj = 20;

int x = (int) obj;

O compilador enxerga "obj" como Object.

Por isso precisamos informar explicitamente:

"Ei Java, eu sei que dentro desse Object existe
um Integer."

---------------------------------------------------------
RESUMO
---------------------------------------------------------

BOXING

int x = 20;
Object obj = x;

STACK                  HEAP

x = 20

obj -----------------> Integer(20)

---------------------------------------------------------

UNBOXING

Object obj = 20;
int x = (int) obj;

STACK                  HEAP

x = 20

obj -----------------> Integer(20)

---------------------------------------------------------

BOXING
-------
Primitivo -> Objeto

int -> Integer/Object

UNBOXING
---------
Objeto -> Primitivo

Integer/Object -> int

=========================================================
*/


/*
Wrapper Classes

Para cada tipo primitivo existe uma classe Wrapper
compatível responsável por representar esse valor
como um objeto.

Primitivo      Wrapper

byte      ->   Byte
short     ->   Short
int       ->   Integer
long      ->   Long
float     ->   Float
double    ->   Double
char      ->   Character
boolean   ->   Boolean

Essas classes permitem:

✔ Tratar valores primitivos como objetos.
✔ Utilizar métodos úteis.
✔ Armazenar valores em Collections.
✔ Realizar Boxing e Unboxing.

Exemplo:

int idade = 20;          // Tipo primitivo

Integer idadeObj = idade; // Boxing

int idadeNova = idadeObj; // Unboxing
*/