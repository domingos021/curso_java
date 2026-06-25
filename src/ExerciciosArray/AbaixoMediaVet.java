package ExerciciosArray;

public class AbaixoMediaVet {

    /**
     * Recebe um vetor, calcula a média, e retorna um NOVO vetor
     * contendo apenas os elementos que estão abaixo dessa média.
     */
    public double[] abaixoMedia(double[] vetor) {
        int vt = vetor.length; // vt obtem o tamanho do vetor
        //VT=> representa o tamanho real do vetor original da qual toda operação depende na hora do laço

        double soma = 0.0;
        for (int i = 0; i < vt; i++) {
            soma += vetor[i];
        }

        double media = soma / vt;

        // Exibe a média aqui com 3 casas decimais conforme o enunciado
        System.out.printf("%nMEDIA DO VETOR = %.3f%n", media);

        // 1. Conta quantos elementos estão abaixo da média para saber o tamanho do novo vetor
        int qtNumerosAbaixoMedia = 0;
        for (int i = 0; i < vt; i++) {
            if (vetor[i] < media) {
                qtNumerosAbaixoMedia++; //define o tamanho do novo vetor, para comportar somente os numeros abaixo da media
            }
        }

        // 2. Cria o vetor que vai guardar o resultado com o tamanho exato
        double[] resultado = new double[qtNumerosAbaixoMedia];

        // 3. Copia os elementos menores que a média para o vetor "resultado"
        int posicaoNovoVetor = 0; // Começa na primeira gaveta (índice 0) do vetor de resultados

        for (int i = 0; i < vt; i++) {

            // O 'if' testa o elemento do vetor original (na posição 'i')
            if (vetor[i] < media) {

                // Se for menor que a média, colocamos esse valor na gaveta atual do novo vetor
                resultado[posicaoNovoVetor] = vetor[i];

                // CRUCIAL: Pulamos para a PRÓXIMA gaveta do novo vetor (ex: de 0 vai para 1)
                // Isso garante que o novo vetor seja preenchido em sequência, sem pular nenhuma casinha.
                posicaoNovoVetor++;
            }

            // Nota: Se o 'if' for falso, o 'i' do vetor original avança,
            // mas a 'posicaoNovoVetor' continua parada esperando o próximo número válido!
        }

        // Retorna o vetor preenchido para o App
        return resultado;
    }
}