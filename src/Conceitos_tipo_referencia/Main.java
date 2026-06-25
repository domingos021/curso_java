package Conceitos_tipo_referencia;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int idade;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Tipos_referencia obj = new Tipos_referencia();
        System.out.println("Valor inicial de nome: " + obj.nome); //valores padrão, null e 0
        System.out.println("Valor inicial de idade: " + obj.idade);

        System.out.println("Digite seu nome1 Guardado no objeto criado: ");
        obj.nome = sc.next(); // Ex: Maria

        System.out.println("Idade Guardado no objeto criado: ");
        obj.idade = sc.nextInt(); // Ex: Maria



         /*
         TIPO REFERÊNCIA (Objeto no Heap)
         1º - obj => guarda o endereço do objeto na Heap.
         2º - O Java pega esse endereço, vai até a Heap e acessa o objeto.
         3º - Se dirige ao atributo 'nome' e altera de null para "Maria".
         */

        String nome2 = obj.nome;
        System.out.println("Nome e Nome2 apontando para a mesma String:");

        System.out.printf(
                "Nome : %s%n" +
                        "Nome2: %s%n",
                obj.nome,
                nome2
        );
        /*
       obj ──► [ Objeto na Heap ]
               │
             nome ───┐
                     ▼
                 ┌─────────┐
                 │ "Maria" │ <── Duas referências apontando para cá!
                 └─────────┘
                     ▲
                     │
                   nome2

        */

        System.out.println("Digite sua idade Guardado na propria variavel: ");
        idade = sc.nextInt(); // Ex: 25

        System.out.println(idade);


        /*
                    TIPO REFERÊNCIA

            obj
             │
             ▼

            ┌─────────────────────┐
            │ nome  = "Maria"     │
            │ idade = 45          │
            └─────────────────────┘

                      ▲
                      │

            nome2 ────┘


            TIPO PRIMITIVO

            idade
            ┌─────┐
            │ 56  │
            └─────┘
         */
         /*
         =======================================================================
         TIPO PRIMITIVO REAL
         =======================================================================
         Aqui o Java faz exatamente o que você previu antes:
         1º - A variável 'idade' é criada diretamente na STACK.
         2º - Quando você digita 25, o número 25 é colocado DIRETO dentro dela.

         Não há 'new', não há busca na Heap, não há endereço intermediário.
         A variável 'idade' contém o valor 25 e ponto final.

         -----------------------------------------------------------------------
         TABELA DE TODOS OS TIPOS PRIMITIVOS EM JAVA (Guardam valor direto)
         -----------------------------------------------------------------------
         O Java possui exatamente 8 tipos primitivos, divididos em 4 categorias:

         1. INTEIROS (Números inteiros, sem casas decimais):
            - byte  (Ocupa 1 byte  | Guarda de -128 a 127)
            - short (Ocupa 2 bytes | Guarda de -32.768 a 32.767)
            - int   (Ocupa 4 bytes | Guarda de -2 bilhões a 2 bilhões) <- O MAIS USADO
            - long  (Ocupa 8 bytes | Guarda números gigantescos)

         2. PONTOS FLUTUANTES (Números com casas decimais):
            - float  (Ocupa 4 bytes | Precisão simples)
            - double (Ocupa 8 bytes | Precisão dupla) <- O MAIS USADO

         3. CARACTER (Guarda uma única letra ou símbolo):
            - char (Ocupa 2 bytes | Deve ser usado com aspas simples, ex: 'M', 'A')

         4. LÓGICO (Verdadeiro ou Falso):
            - boolean (Ocupa 1 bit | Guarda apenas: true ou false)

         -----------------------------------------------------------------------
         REGRA DA LETRA MINÚSCULA:
         Repare que todos os primitivos começam com letra minúscula (int, double).
         Eles guardam o dado direto na Stack. Se começar com letra maiúscula
         (String, Pessoa, Scanner), é uma Classe e guardará um endereço na Heap!
         =======================================================================
         */

        sc.close();
    }
}

    /*

    FATIADO DENTRO DA SUA MEMÓRIA RAM:
            ┌──────────────────────────────────────────┐
            │ STACK (Pilha de Variáveis Locais)        │
            │       │                                  │
            │       ▼ (Cresce para baixo)              │
            ├──────────────────────────────────────────┤
            │                                          │
            │      Espaço Livre de Manobra na RAM      │
            │                                          │
            ├──────────────────────────────────────────┤
            │       ▲ (Cresce para cima)               │
            │       │                                  │
            │ HEAP  (Espaço dos Objetos/new)           │
            └──────────────────────────────────────────┘



            VELOCIDADE DE ACESSO DO PROCESSADOR:
┌────────────────────────────────────────────────────────┐
│  1º lugar: Memória Cache (Guarda partes da STACK)     │ 🚀 Velocidade da Luz
├────────────────────────────────────────────────────────┤
│  2º lugar: Memória RAM de 8GB (A abriga STACK e HEAP)  │ 🏃 Muito Rápida
├────────────────────────────────────────────────────────┤
│  3º lugar: SSD (Guarda o arquivo .java salvo no disco) │ 🐌 Muito lento para o chip
└────────────────────────────────────────────────────────┘


     */