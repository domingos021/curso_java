package ExerciciosArray;

public class GrupoPessoas {

    /*
    Pessoas       → segurança e integridade dos dados
    GrupoPessoas  → processamento e lógica do grupo
    Main          → leitura e exibição

    Main ──────────► GrupoPessoas
                      │
                      └──► Pessoas (detalhe interno, Main não vê)
     */

    /*
 ==================================================================================
 POR QUE ESSA ABORDAGEM COM O VETOR DENTRO DA CLASSE É FANTÁSTICA?
 ==================================================================================

 1. ORGANIZAÇÃO EXTREMA:
    - O seu 'MainPessoas' não precisa gerenciar um emaranhado de dados soltos.
    - Ele não cria variáveis temporárias de controle nem lida com o array puro na Main.
    - O Main agora só conhece e conversa com um único objeto: o 'grupo'.

 2. RESPONSABILIDADE CENTRALIZADA (ENCAPSULAMENTO):
    - Se você precisar saber a média de altura ou filtrar dados daquelas pessoas,
      você NÃO faz um 'for' no Main caçando e extraindo os dados de lá de dentro.
    - Você simplesmente delega e pergunta para o grupo: "Grupo, calcule a média para mim".
    - O objeto 'grupo' olha para dentro do seu próprio vetor (privado), processa a
      lógica internamente e devolve apenas o resultado pronto (o "O que", e não o "Como").

 3. ESCALABILIDADE:
    - Se amanhã o limite do sistema mudar de 10 para 100 ou 1000 pessoas, o
      comportamento do seu código continua exatamente o mesmo.
    - O vetor se adapta dinamicamente ao tamanho (qt) que o usuário digitou e que
      você passou com segurança através do Construtor.

 CONCLUSION:
    - Você uniu com maestria o conceito de Estrutura de Dados (Vetores/Arrays)
      com o conceito de Encapsulamento da Programação Orientada a Objetos (POO).
    - O Main organiza o fluxo de tela, e a Classe gerencia a inteligência dos dados.
 ==================================================================================
 */
    //criação do vetor que vai ser usada como molde quando a classe for instanciada no main
    /*
        [ GrupoPessoas (Objeto Gerenciador) ]
           │
           ▼
     ┌──────────┐
     │ pessoas  │ ──► [ Vetor na Memória Heap ]
     └──────────┘         │
                          ├── Pos 0: [ Objeto Pessoas (Nome: "João", Idade: 20, Altura: 1.75) ]
                          ├── Pos 1: [ Objeto Pessoas (Nome: "Maria", Idade: 15, Altura: 1.60) ]
                          └── Pos 2: [ Objeto Pessoas (Nome: "Carlos", Idade: 30, Altura: 1.82) ]
     */

    private final Pessoas[] pessoas;  //define o vetor pessas como sendo do tipo da classe Pessoas

    // CONSTRUTOR: Método que define a quantidade ou o tamanho do vetor na memória.
    // Ao fazer isso, o Java cria as "gavetas" do array, todas inicializadas como 'null'.
   /*
 ==================================================================================
 DIÁLOGO DOS BASTIDORES: A CRIAÇÃO DO VETOR
 ==================================================================================

     1ª- Construtor => Main, por favor, me passe o tamanho do vetor para que eu possa
                       definir e moldar o espaço aqui dentro: (GrupoPessoas(int quantidade))

     2ª- Main       => Espera aí, vou perguntar na tela. Oh usuário, quantas pessoas
                       serão digitadas?

     3ª- Usuário    => Quero 3 gavetinhas para guardar os dados de 3 pessoas distintas.

     4ª- Main       => Obrigado! Deixa eu validar se esse número está entre 1 e 10...
                       Tudo certo! Construtor, aqui está: "GrupoPessoas grupo = new GrupoPessoas(qt);".
                       Mandei a quantidade ('qt') segura para você via parâmetro.

     5ª- Construtor => Main, recebido com sucesso!

     6ª- Construtor => Oh atributo/molde 'pessoas', execute a linha: "this.pessoas = new Pessoas[quantidade];".
                       Vá na memória Heap e prepare 3 casinhas (atualmente valendo null)
                       para acomodar os futuros objetos do tipo 'Pessoas'.
     ==================================================================================
     */
    public GrupoPessoas(int quantidade) {
        this.pessoas = new Pessoas[quantidade];
    }

    // Método responsável por receber os dados brutos lidos pelo Main, gerenciar a criação
    // do objeto Pessoas e guardá-lo na respectiva gaveta do vetor.
    // Se algum dado for inválido, o throw sobe da validação de Pessoas e cai direto no catch do Main.
    /*
      1ª - Recebe os dados brutos via parâmetro (int indice, String nome, int idade, double altura) enviados pelo Main.

      2ª - Tenta instanciar a classe Pessoas. As validações internas entram em ação. Se o dado for seguro,
           o Java cria o objeto na memória Heap. O endereço desse objeto é guardado temporariamente na variável 'pessoa'.

      3ª - Finalmente, a linha 'this.pessoas[indice] = pessoa;' pega esse endereço de memória e o copia
           diretamente para dentro da gaveta do vetor. Agora, o vetor aponta para o objeto completo na Heap.
     */
    public void adicionarPessoa(int indice, String nome, int idade, double altura) {
        // A inteligência de criar e validar agora foi delegada para dentro da classe gerenciadora!
        Pessoas pessoa = new Pessoas(nome, idade, altura); // exigencia do construtor da casse pessoas
        this.pessoas[indice] = pessoa; // O vetor guarda a REFERÊNCIA (o endereço) do objeto
    }

    // GETTER DE CONTROLE: Responsável por retornar o tamanho total do vetor.
    // Permite que o Main descubra o limite de posições de forma segura, sem acessar o array direto.
    public int getTamanho() {
        return pessoas.length;
    }

    // O FOR INTELIGENTE DE PROCESSAMENTO MORA AQUI:
    public double calcularMediaAlturas() {
        double somaAlturas = 0.0;
        for (int i = 0; i < pessoas.length; i++) {
            somaAlturas += pessoas[i].getAltura();
        }
        return somaAlturas / pessoas.length;
    }

    // OUTRO FOR DE PROCESSAMENTO DELEGADO:
    public double calcularPorcentagemMenores16() {
        int contMenores16 = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16) {
                contMenores16++;
            }
        }
        return ((double) contMenores16 / pessoas.length) * 100.0;
    }

    // FOR RESPONSÁVEL POR FILTRAR E MONTAR A STRING DE MENORES:
    public String obterNomesMenores16() {
        String nomesMenores = "";
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16) {
                nomesMenores += "- " + pessoas[i].getNome() + "\n";
            }
        }
        return nomesMenores;
    }
}