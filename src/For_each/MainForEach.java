package For_each;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainForEach {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        /*
        USANDO O FOR
        for(int i = 0; i < vect.lengh; i++){
        System.out.println(vect[i])
        }
         */
       String[] vect = new String[] {
               "Domingos","Maria","Miguel"
       };
       /*
            (String obj : vect)
            como lemos
            para cada objeto obj contida no vetor Vect faça

            String: => tipo dos elementos de cada posição
            obj => apelido para cada elemeto
            vect=> coleção
        */


       for (String obj : vect) {
           System.out.println(obj);
       }


    }
}


    /*
    ===============================================================================
    GUIA COMPLETO DAS ESTRUTURAS DE REPETIÇÃO EM JAVA
    ===============================================================================

    O QUE É UMA ESTRUTURA DE REPETIÇÃO?
    -------------------------------------------------------------------------------
    Uma estrutura de repetição (laço ou loop) é um mecanismo que permite executar
    um bloco de código várias vezes sem precisar escrever o mesmo código repetidamente.

    Imagine que você precisa mostrar a mensagem "Olá" 100 vezes.

    Sem repetição:

    System.out.println("Olá");
    System.out.println("Olá");
    System.out.println("Olá");
    ...
    (100 linhas)

    Com repetição:

    for (int i = 0; i < 100; i++) {
        System.out.println("Olá");
    }

    Resultado:
    - Menos código.
    - Mais organização.
    - Mais facilidade de manutenção.

    ===============================================================================
    1) FOR TRADICIONAL
    ===============================================================================

    PROPÓSITO:
    -------------------------------------------------------------------------------
    Utilizado quando sabemos ou conseguimos controlar quantas vezes o laço será
    executado.

    É a estrutura mais utilizada em:
    - Vetores
    - Matrizes
    - Algoritmos
    - Processamento de dados
    - Ordenação
    - Relatórios

    ESTRUTURA:
    -------------------------------------------------------------------------------

    for (inicialização; condição; incremento) {
        // código
    }

    EXEMPLO:

    for (int i = 0; i < 5; i++) {
        System.out.println(i);
    }

    ANÁLISE DETALHADA:
    -------------------------------------------------------------------------------

    int i = 0
    ↓
    i < 5 ? (SIM)
    ↓
    Executa o bloco
    ↓
    i++
    ↓
    i < 5 ? (SIM)
    ↓
    Executa novamente
    ↓
    Repete até a condição ser falsa

    SAÍDA:

    0
    1
    2
    3
    4

    EXEMPLO REAL - MOSTRAR POSIÇÕES DE UM VETOR:
    -------------------------------------------------------------------------------

    String[] nomes = {"Ana", "Carlos", "Maria"};

    for (int i = 0; i < nomes.length; i++) {
        System.out.println("Posição " + i + ": " + nomes[i]);
    }

    SAÍDA:

    Posição 0: Ana
    Posição 1: Carlos
    Posição 2: Maria

    EXEMPLO REAL - SOMAR ELEMENTOS:
    -------------------------------------------------------------------------------

    double[] notas = {7.5, 8.0, 9.0};

    double soma = 0;

    for (int i = 0; i < notas.length; i++) {
        soma += notas[i];
    }

    System.out.println(soma);

    RESULTADO:

    24.5

    EXEMPLO REAL - ENCONTRAR O MAIOR VALOR:
    -------------------------------------------------------------------------------

    double[] numeros = {10, 25, 8, 40, 15};

    double maior = numeros[0];

    for (int i = 1; i < numeros.length; i++) {

        if (numeros[i] > maior) {
            maior = numeros[i];
        }
    }

    System.out.println(maior);

    RESULTADO:

    40

    VANTAGENS:
    -------------------------------------------------------------------------------
    ✓ Controle total.
    ✓ Possui índice.
    ✓ Permite modificar elementos.
    ✓ Essencial para algoritmos.

    DESVANTAGENS:
    -------------------------------------------------------------------------------
    ✗ Mais verboso.
    ✗ Mais sujeito a erros de índice.

    ===============================================================================
    2) FOR-EACH
    ===============================================================================

    PROPÓSITO:
    -------------------------------------------------------------------------------
    Percorrer todos os elementos de um vetor ou coleção de forma simples.

    Foi criado para tornar o código mais limpo e legível.

    ESTRUTURA:
    -------------------------------------------------------------------------------

    for (Tipo variavel : colecao) {
        // código
    }

    EXEMPLO:

    String[] nomes = {"Ana", "Carlos", "Maria"};

    for (String nome : nomes) {
        System.out.println(nome);
    }

    COMO LER:
    -------------------------------------------------------------------------------

    "Para cada nome dentro do vetor nomes"

    O Java faz algo semelhante a:

    for (int i = 0; i < nomes.length; i++) {
        String nome = nomes[i];
        System.out.println(nome);
    }

    SAÍDA:

    Ana
    Carlos
    Maria

    EXEMPLO REAL - LISTA DE PRODUTOS:
    -------------------------------------------------------------------------------

    String[] produtos = {
        "Notebook",
        "Mouse",
        "Teclado"
    };

    for (String produto : produtos) {
        System.out.println(produto);
    }

    RESULTADO:

    Notebook
    Mouse
    Teclado

    EXEMPLO REAL - SOMAR ELEMENTOS:
    -------------------------------------------------------------------------------

    double[] notas = {7.5, 8.0, 9.0};

    double soma = 0;

    for (double nota : notas) {
        soma += nota;
    }

    System.out.println(soma);

    RESULTADO:

    24.5

    VANTAGENS:
    -------------------------------------------------------------------------------
    ✓ Código mais limpo.
    ✓ Mais fácil de ler.
    ✓ Menos erros.

    LIMITAÇÕES:
    -------------------------------------------------------------------------------
    ✗ Não possui índice.
    ✗ Não é ideal para alterar elementos.
    ✗ Não permite saber facilmente a posição atual.

    QUANDO UTILIZAR:
    -------------------------------------------------------------------------------
    ✓ Exibir dados.
    ✓ Ler informações.
    ✓ Percorrer listas.
    ✓ Relatórios.

    ===============================================================================
    3) WHILE
    ===============================================================================

    PROPÓSITO:
    -------------------------------------------------------------------------------
    Executar enquanto uma condição for verdadeira.

    Utilizado quando não sabemos exatamente quantas vezes a repetição ocorrerá.

    ESTRUTURA:
    -------------------------------------------------------------------------------

    while (condicao) {
        // código
    }

    EXEMPLO:

    int contador = 1;

    while (contador <= 5) {
        System.out.println(contador);
        contador++;
    }

    SAÍDA:

    1
    2
    3
    4
    5

    EXEMPLO REAL - LOGIN:
    -------------------------------------------------------------------------------

    String senha = "";

    while (!senha.equals("1234")) {

        System.out.print("Digite a senha: ");
        senha = sc.nextLine();

    }

    System.out.println("Acesso liberado!");

    O sistema continua pedindo a senha até o usuário acertar.

    EXEMPLO REAL - VALIDAÇÃO:
    -------------------------------------------------------------------------------

    int idade = -1;

    while (idade < 0) {

        System.out.print("Digite uma idade válida: ");
        idade = sc.nextInt();

    }

    VANTAGENS:
    -------------------------------------------------------------------------------
    ✓ Ideal para validações.
    ✓ Ideal para entrada de dados.
    ✓ Excelente para menus.

    DESVANTAGENS:
    -------------------------------------------------------------------------------
    ✗ Pode gerar loop infinito se mal utilizado.

    EXEMPLO DE LOOP INFINITO:
    -------------------------------------------------------------------------------

    while (true) {
        System.out.println("Nunca para");
    }

    ===============================================================================
    4) DO-WHILE
    ===============================================================================

    PROPÓSITO:
    -------------------------------------------------------------------------------
    Executar pelo menos uma vez antes de verificar a condição.

    ESTRUTURA:
    -------------------------------------------------------------------------------

    do {

        // código

    } while (condicao);

    EXEMPLO:

    int numero = 1;

    do {

        System.out.println(numero);
        numero++;

    } while (numero <= 5);

    SAÍDA:

    1
    2
    3
    4
    5

    DIFERENÇA ENTRE WHILE E DO-WHILE:
    -------------------------------------------------------------------------------

    WHILE:

    while (condicao) {
    }

    Primeiro verifica.

    DO-WHILE:

    do {
    } while (condicao);

    Primeiro executa.

    EXEMPLO REAL - MENU DE BANCO:
    -------------------------------------------------------------------------------

    int opcao;

    do {

        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("0 - Sair");

        opcao = sc.nextInt();

    } while (opcao != 0);

    O menu aparece pelo menos uma vez.

    ===============================================================================
    QUAL É MAIS UTILIZADO NO MERCADO?
    ===============================================================================

    FOR
    -------------------------------------------------------------------------------
    Muito utilizado em:
    - Algoritmos
    - Vetores
    - Matrizes
    - Processamento de dados

    FOR-EACH
    -------------------------------------------------------------------------------
    Muito utilizado em:
    - APIs
    - Spring Boot
    - Sistemas corporativos
    - Listas e coleções

    WHILE
    -------------------------------------------------------------------------------
    Muito utilizado em:
    - Login
    - Validações
    - Menus
    - Processos contínuos

    DO-WHILE
    -------------------------------------------------------------------------------
    Menos comum que os demais,
    mas ainda aparece em menus e sistemas interativos.

    ===============================================================================
    REGRA DE OURO
    ===============================================================================

    Preciso da posição?
    → FOR

    Só quero percorrer elementos?
    → FOR-EACH

    Não sei quantas vezes vai repetir?
    → WHILE

    Precisa executar pelo menos uma vez?
    → DO-WHILE

    ===============================================================================
    */