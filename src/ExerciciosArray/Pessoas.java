package ExerciciosArray;

public class Pessoas {
    private String nome;
    private int idade;
    private double altura;

    /*
     [ MAIN ]
       │
       │ 1. "Java, crie uma Pessoa com estes dados!"
       ▼
    [ CONSTRUTOR ] (O Meio de Campo)
       │
       ├─► 2. Aciona internamente ──► setNome(nome)
       ├─► 3. Aciona internamente ──► setIdade(idade)  ──► (Se der erro, aborta tudo!)
       └─► 4. Aciona internamente ──► setAltura(altura)
       │
       ▼
    [ Objeto salvo com sucesso na HEAP ]


            [ DIGITAÇÃO NO MAIN ] ──> (Usuário digita Idade: -5)
                │
                ▼
        [ DESVIO PARA O CONSTRUTOR ] ──> Pessoas(nome, -5, altura)
                │
                └─► [ DESVIO PARA O SETTER ] ──> setIdade(-5)
                            │
                    (Verificação: -5 <= 0 ?) ───> SIM! (Dado Inválido)
                            │
                            ▼
                [ DEVOLVE O ERRO VIA THROW ] ──> IllegalArgumentException
                            │
               ┌────────────┴────────────┐
               ▼                         ▼
        [ ABORTA O CONSTRUTOR ]    [ CAI DIRETO NO CATCH ] ──> e.getMessage()
        (O objeto NÃO nasce na Heap)     │
                                         ▼
                                   [ MAIN AVISA O USUÁRIO ] ──> "Tente novamente..."


     */

    // Construtor obriga a passar os dados no nascimento...
    public Pessoas(String nome, int idade, double altura) {
        setNome(nome);    // ...mas terceiriza a validação para os setters!
        setIdade(idade);
        setAltura(altura);
    }

    // GETTERS
    public String getNome() { return nome; }

    public int getIdade() { return idade; }
    public double getAltura() { return altura; }

    // SETTERS (Controle de Integridade)
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade não pode ser menor ou igual a 0.");
        }
        this.idade = idade;
    }

    public void setAltura(double altura) {
        if (altura <= 0.0) {
            throw new IllegalArgumentException("Altura não pode ser menor ou igual a 0.0.");
        }
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", altura=" + altura + "}";
    }
}