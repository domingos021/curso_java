package exercicises;

// Importa a classe retangulo do pacote vizinho

import retangEntities.retangulo;

import java.util.Locale;
import java.util.Scanner;

public class exerciser01 {

    public static void main(String[] args) {
        // Configura o ponto flutuante para o padrão americano (ex: 3.5 em vez de 3,5)
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criação (instanciação) do objeto na memória usando o construtor padrão
        retangulo object = new retangulo();

        System.out.println("=== SISTEMA DE CÁLCULO GEOMÉTRICO ===");

        // 1. LEITURA DA ALTURA
        int tentativasAltura = 0;

        while (tentativasAltura < 2) {

            System.out.print("Digite a altura: ");
            object.setAltura(sc.nextDouble()); // Captura o valor digitado e envia para validação no ‘setter’

            // Se o valor armazenado da altura for maior que 0,
            // significa que o valor foi aceite pelo ‘setter’.
            // Nesse caso, interrompe o laço com break.
            // Caso contrário, o laço continua até atingir o limite de tentativas.
            //getAltura(9.00) tem o valor armazenado
            //getAltura() consulta qual é o valor que ficou armazenado após a validação.
            if (object.getAltura() > 0) {
                break;
            }

            tentativasAltura++;
        }

        int tentativasLargura = 0;

        while (tentativasLargura < 2) {

            System.out.print("Digite a largura: ");
            object.setLargura(sc.nextDouble());

            if (object.getLargura() > 0) {
                break;
            }

            tentativasLargura++;
        }

        if (object.getAltura() == 0) {
            System.out.println("[AVISO] Limite de tentativas atingido para a altura.");
        }

        if (object.getLargura() == 0) {
            System.out.println("[AVISO] Limite de tentativas atingido para a largura.");
        }


        System.out.println(); // Salta uma linha para organizar a saída no terminal

        // 3. EXIBIÇÃO DOS RESULTADOS
        // Ao mandar imprimir o "object" diretamente, o Java varre a classe 'retangulo'
        // atrás do método 'toString()' e imprime o texto formatado que criamos lá.
        System.out.println(object);

        // Fecha o Scanner para liberar os recursos do sistema operacional
        sc.close();
    }
}

/*
Usuário digita
      ↓
nextDouble captura
      ↓
setAltura recebe
      ↓
setAltura valida
      ↓
atributo altura é atualizado ou não
      ↓
getAltura consulta o valor armazenado
      ↓
if verifica esse valor
      ↓
break encerra o laço se estiver correto
 */