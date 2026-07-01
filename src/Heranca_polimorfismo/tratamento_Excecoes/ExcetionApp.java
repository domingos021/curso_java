package Heranca_polimorfismo.tratamento_Excecoes;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ExcetionApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        method1(sc); //exibe o método com as exceções;

        System.out.println("--- Fim do programa (executado com sucesso até o final) ---");
        sc.close();
    }

    public static void method1(Scanner sc) {
        System.out.println("***METHOD1 START***");
        method2(sc); //tem o programa
        System.out.println("***METHOD1 END***");
    }

    //pilha de chamadas de métodos
    public static void method2(Scanner sc) {
        System.out.println("***METHOD2 START***");
        try {
            System.out.println("Digite os elementos do vetor separados por espaço:");
            String[] vect = sc.nextLine().split(" ");

            System.out.println("Digite a posição que deseja acessar:");
            int position = sc.nextInt();

            System.out.println("Elemento na posição " + position + ": " + vect[position]);
            //e => apelido do erro
            //a exceção de acessar um array fora , que não existe
        } catch (ArrayIndexOutOfBoundsException e) {
            // Captura se a posição não existir (ex: vetor tem 3 elementos e pediu a posição 5)
            System.out.println("Erro: Posição inválida no vetor!");

            // OPCIONAL
            // Exibe no console o Stack Trace (rastreamento da pilha de execução).
            // Mostra o tipo da exceção, sua mensagem, o arquivo e a linha onde o erro
            // ocorreu, além da sequência de chamadas de métodos até a exceção.
            // É muito utilizado para localizar e depurar (debugar) erros durante o desenvolvimento.
            e.printStackTrace();
            sc.next();
            //Exceção de trocar um numero pela por letra n o input
        } catch (InputMismatchException e) {
            System.out.println("Input error");
            // Captura se o usuário digitar texto no lugar de número
            System.out.println("Erro: Você precisa digitar um número inteiro válido!");
        }
        System.out.println("***METHOD2 END ***");
    }
}

    /*
    BLOCO TRY
    .Comtém o código que representa a execução normal do trecho de código que
    pode acarretar eme uma exceção


    -BLOCO CATCH
    .Contém o código a ser executado caso uma exceção ocorra
    .Deve ser especificado o tipo de exceção a ser tratada(upcasting eé permitido)

       /*
    ===============================================================================
                             SINTAXE DO TRY-CATCH
    ===============================================================================

    try {

        // Código que pode lançar uma exceção.

    }
    catch (TipoDaExcecao e) {

        // Código executado caso essa exceção ocorra.

    }
    catch (OutroTipoDaExcecao e) {

        // Trata outro tipo de exceção.

    }

    ===============================================================================
    */