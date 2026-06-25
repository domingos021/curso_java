package Array_vetores;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas vai inserir?: ");
        int N = sc.nextInt(); //ex:3
        sc.nextLine(); // <-- CORREÇÃO: Linha de código adicionada para limpar o buffer do nextInt()!

        // ATENÇÃO: Array de Objetos!
        // Na Heap, nasce um vetor preenchido com [null, null, ...]
        vetorClass[] vetor = new vetorClass[N];
        System.out.println(vetor.length); //mostra o array inteiro, ou seja, tamanho do array

        for (int i = 0; i < N; i++) {
            System.out.printf("%dª pessoa:%n", i + 1);

            System.out.print("Nome: ");
            // Agora lê direto, sem nenhuma linha de limpeza antes!
            String nome = sc.nextLine();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            // LIMPEZA IMEDIATA: Limpa o Enter do nextDouble() para a PRÓXIMA volta do laço
            sc.nextLine();

            // Criamos o objeto na Heap e guardamos a referência dele no índice do vetor
            vetor[i] = new vetorClass(nome,altura); // o construtor exige que os atributos no objeto na head ja nasça populado com dois argumentos
            /*
                O NASCIMENTO NA HEAP
              ┌───────────────────────┐
              │     Objeto [i]        │
              │  ┌─────────────────┐  │
              │  │ nome: "Ana"     │  │  <-- Já nasce preenchido!
              │  │ altura: 1.70    │  │
              │  └─────────────────┘  │
              └───────────────────────┘
             */

            System.out.println("Estado atual do vetor de Objetos:");
            System.out.println(Arrays.toString(vetor));
            System.out.println();
        }

        // Processamento: somar as alturas pegando de dentro de cada objeto
        double soma = 0.0;
        //percorre o array inteiro
        //(int i = 0; i < N; i++)
        for (int i = 0; i < vetor.length; i++) {
            // vector[i].getAltura() vai até o objeto na Heap e busca a altura dele e adiciona na variável soma
            //a cada volta até terminar o array
            soma += vetor[i].getAltura();

            System.out.println("Lendo dados de: " + vetor[i].getNome());
            System.out.printf("Soma acumulada das alturas: %.2f%n", soma);
            System.out.println();
        }

        //MAIS ALTO
        //se o tamanho do vetor for maior que 0
        if (vetor.length > 0) {

            // 1. Cria uma variável de referência do tipo vetorClass
            // 2. Obtém o objeto armazenado na posição 0 do vetor
            // 3. Faz a variável maisAlta apontar para esse objeto
            /*
            vetor[0] ──┐
                       │
                       ▼
                  Ana (1.65)
                       ▲
                       │
            maisAlta ──┘

            Você apenas pega uma cópia do endereço:

            vetor[0] ----┐
                         ├──> Casa da Ana
            maisAlta ----┘

           As duas variáveis apontam para a mesma casa (objeto).
            vetorClass → define o tipo da variável.
            maisAlta → nome da variável.
            = → atribui uma referência.
            vetor[0] → referência do objeto armazenado na posição 0.
             */
            vetorClass maisAlta = vetor[0];


            for (int i = 1; i < vetor.length; i++) {

                if (vetor[i].getAltura() > maisAlta.getAltura()) {

                    maisAlta = vetor[i];
                }
            }

            System.out.println("Pessoa mais alta:");
            System.out.println("Nome: " + maisAlta.getNome());
            System.out.printf("Altura: %.2f%n", maisAlta.getAltura());

            /*
                        STACK                                     HEAP
            ┌──────────────────┐              ┌─────────────────────────────────┐
            │                  │              │  vetor (Array)                  │
            │   vetor  ────────┼───────────── ┼> ┌───────────┬───────────┐       │
            │                  │              │  │  [0]     │    [1]    │       │
            │                  │              │  └────┬─────┴────┬──────┘       │
            │                  │              │       │          │              │
            │  maisAlta ───────┼──────────┐   │       ▼          ▼              │
            │                  │          │   │  ┌─────────┐┌─────────┐         │
            │ (A seta muda     │          └───┼─>│Objeto[0]││Objeto[1]│         │
            │  para o maior)   │              │  │Ana      ││Bob      │         │
            │                  │              │  │1.70     ││1.85     │         │
            └──────────────────┘              │  └─────────┘└────▲────┘         │
                                              │                  │              │
                                              └──────────────────┼──────────────┘
                                                                 │
                                              (Se Bob for maior, │
                                               maisAlta aponta   │
                                               para cá!) ────────┘
             */

        }

        System.out.println("===========================================");
        System.out.printf("Soma final das alturas: %.2f%n", soma);
        double mediaAltura = soma / N;
        System.out.printf("Média das alturas: %.2f%n", mediaAltura);

        sc.close();
    }
}

    /*
    ===============================================================================
    PARTE 1: ARRAYS DE TIPOS PRIMITIVOS (ARRAY SIMPLES)
    ===============================================================================
    Exemplo: double[] vect = new double[N];

    MEMÓRIA STACK (Estática)                 MEMÓRIA HEAP (Dinâmica)
    ┌─────────────────────────┐               ┌───────────────────────────────────┐
    │                         │               │                                   │
    │  int N = 5;             │               │   Objeto Array (double[])         │
    │  (Guarda o valor 5)     │               │   ┌──────┬──────┬──────┬──────┬──────┐│
    │                         │               │   │ 0.0  │ 0.0  │ 10.5 │ 0.0  │ 0.0  ││
    │  double[] vect ─────────┼───────────────┼─> └──────┴──────┴──────┴──────┴──────┘│
    │  (Guarda o ENDEREÇO)    │               │    [0]    [1]    [2]    [3]    [4] │
    │                         │               │                                   │
    └─────────────────────────┘               └───────────────────────────────────┘

    1. double[] -> Tipo da variável (Array de double). Arrays em Java são TIPOS REFERÊNCIA.
    2. vect -> Variável referência. Não guarda os números, guarda o endereço do array na Heap.
    3. new double[N] -> Cria o objeto Array na Heap. Todos os elementos nascem como 0.0.

    EXEMPLO DE ACESSO: vect[2] = 10.5;
    O Java lê o endereço em 'vect', vai à Heap, acha a posição 2 e muda direto para 10.5.
    Os valores primitivos ficam guardados DIRETAMENTE dentro das caixinhas do array.

    ===============================================================================
    PARTE 2: ARRAYS DE OBJETOS (TIPOS REFERÊNCIA)
    ===============================================================================
    Exemplo: vetorClass[] vect = new vetorClass[N];

    MEMÓRIA STACK (Estática)                 MEMÓRIA HEAP (Dinâmica)
    ┌─────────────────────────┐               ┌───────────────────────────────────┐
    │                         │               │ Objeto Array (vetorClass[])       │
    │  int N = 3;             │               │ ┌───────────┬───────────┬───────┐ │
    │                         │               │ │  Endereço │  Endereço │ null  │ │
    │  vetorClass[] vect ─────┼───────────────┼>└─────┬─────┴─────┬─────┴───────┘ │
    │  (Guarda o ENDEREÇO do  │               │      [0]         [1]       [2]    │
    │   Array)                │               │       │           │               │
    └─────────────────────────┘               │       ▼           ▼               │
                                              │  ┌───────────┐┌───────────┐       │
                                              │  │Objeto [0] ││Objeto [1] │       │
                                              │  │nome:"Ana" ││nome:"Bob" │       │
                                              │  │alt: 1.70  ││alt: 1.85  │       │
                                              │  └───────────┘└───────────┘       │
                                              └───────────────────────────────────┘

    1. vetorClass[] -> Tipo da variável (Array de Objetos da classe vetorClass).
    2. new vetorClass[N] -> Cria o objeto Array na Heap.
       ATENÇÃO: Todas as posições nascem valendo 'null' (não apontam para lugar nenhum).

    ===============================================================================
    DIFERENÇA CRUCIAL NA ATRIBUIÇÃO
    ===============================================================================

    Ao fazer: vect[0] = new vetorClass("Ana", 1.70);

    O Java faz um processo em duas etapas (Ponteiro apontando para Ponteiro):
    1º - Instancia o objeto "Ana" em um canto isolado da Heap.
    2º - Guarda o ENDEREÇO desse novo objeto dentro da posição [0] do Array.

    Ou seja, o array de objetos NÃO guarda os dados da pessoa dentro dele.
    Ele guarda uma lista de endereços (ponteiros) que levam até os objetos reais.

    ===============================================================================
    REGRA DE OURO ATUALIZADA
    ===============================================================================

    A) Tipo Primitivo Direto:
       double numero = 10.0; -> Caixinha na Stack guarda o valor 10.0 diretamente.

    B) Array Primitivo (Simples):
       double[] vect = new double[5]; -> Vetor na Heap guarda os VALORES (0.0) diretamente.

    C) Array de Objetos:
       vetorClass[] vect = new vetorClass[5]; -> Vetor na Heap guarda ENDEREÇOS (ou null).
       Os dados reais ficam nos objetos apontados por esses endereços.

    ===============================================================================
*/
/*
 double[] vect = new double[N];

MEMÓRIA STACK (Estática)                 MEMÓRIA HEAP (Dinâmica)
┌─────────────────────────┐               ┌───────────────────────────────────┐
│                         │               │                                   │
│  int N = 5;             │               │   Objeto Array (double[])         │
│  (Guarda o valor 5)     │               │   ┌──────┬──────┬──────┬──────┬──────┐│
│                         │               │   │ 0.0  │ 0.0  │ 10.5 │ 0.0  │ 0.0  ││
│  double[] vect ─────────┼───────────────┼─> └──────┴──────┴──────┴──────┴──────┘│
│  (Guarda o ENDEREÇO)    │               │    [0]    [1]    [2]    [3]    [4] │
│                         │               │                                   │
└─────────────────────────┘               └───────────────────────────────────┘
===============================================================================
double[] vect = new double[N];
===============================================================================

1. double[]
↓
Tipo da variável.

Neste caso não é um double comum.

É um ARRAY de double.

Arrays em Java são TIPOS REFERÊNCIA.

-------------------------------------------------------------------------------

2. vect
↓
Variável referência.

Não guarda os números.

Guarda apenas o endereço do array criado na Heap.

-------------------------------------------------------------------------------

3. new double[N]
↓
Cria um novo objeto Array na Heap.

O tamanho será N.

Todos os elementos nascem com valor padrão:

0.0

===============================================================================
EXEMPLO
===============================================================================

N = 5;

double[] vect = new double[5];

STACK

vect
 │
 ▼

HEAP

┌─────┬─────┬─────┬─────┬─────┐
│ 0.0 │ 0.0 │ 0.0 │ 0.0 │ 0.0 │
└─────┴─────┴─────┴─────┴─────┘

===============================================================================
IMPORTANTE
===============================================================================

Muita gente olha para:

double[] vect = new double[5];

e pensa:

"vect guarda os 5 números."

Mas isso NÃO acontece.

vect guarda apenas o endereço do array.

Os valores ficam dentro do objeto Array na Heap.

===============================================================================
ACESSANDO UMA POSIÇÃO
===============================================================================

vect[2] = 10.5;

O Java faz:

1º - Lê o endereço armazenado em vect.

2º - Vai até o array na Heap.

3º - Localiza a posição 2.

4º - Altera o valor para 10.5.

Resultado:

┌─────┬─────┬──────┬─────┬─────┐
│ 0.0 │ 0.0 │ 10.5 │ 0.0 │ 0.0 │
└─────┴─────┴──────┴─────┴─────┘

===============================================================================
ARRAY É OBJETO?
===============================================================================

SIM.

Arrays são objetos especiais da JVM.

Por isso:

✓ São tipos referência.

✓ Vivem na Heap.

✓ Podem receber null.

Exemplo:

double[] vect = null;

vect
 │
 ▼

null

Não existe array associado.

===============================================================================
REGRA DE OURO
===============================================================================

double numero = 10.0;

numero
┌──────┐
│ 10.0 │
└──────┘

Guarda o valor diretamente.

-------------------------------------------------------------------------------

double[] vect = new double[5];

vect
 │
 ▼

┌─────┬─────┬─────┬─────┬─────┐
│ 0.0 │ 0.0 │ 0.0 │ 0.0 │ 0.0 │
└─────┴─────┴─────┴─────┴─────┘

Guarda o endereço do array.

===============================================================================
*/



/*
MODELO PARA NEXlINE() EM STRING

1ª OPÇÃO PROFISSONAL
// CERTIFIQUE-SE de que tem um sc.nextLine(); logo após o sc.nextInt() lá em cima!

for (int i = 0; i < N; i++) {
    System.out.printf("%dª pessoa:%n", i + 1);

    System.out.print("Nome: ");
    // Agora lê direto, sem nenhuma linha de limpeza antes!
    String nome = sc.nextLine();

    System.out.print("Altura: ");
    double altura = sc.nextDouble();

    // LIMPEZA IMEDIATA: Limpa o Enter do nextDouble() para a PRÓXIMA volta do laço
    sc.nextLine();

    // Criamos o objeto na Heap e guardamos a referência dele no índice do vetor
    vect[i] = new vetorClass(nome, altura);

    System.out.println("Estado atual do vetor de Objetos:");
    System.out.println(Arrays.toString(vect));
    System.out.println();
}

USADO POR SENIORS, MAIS ELEGANTE E EFICIENTE

for (int i = 0; i < N; i++) {
    System.out.printf("%dª pessoa:%n", i + 1);

    System.out.print("Nome: ");
    String nome = sc.nextLine(); // Lê o nome normalmente

    System.out.print("Altura: ");
    // Pega a linha inteira como texto e converte para double usando Double.parseDouble()
    double altura = Double.parseDouble(sc.nextLine());

    vect[i] = new vetorClass(nome, altura);
}
 */
