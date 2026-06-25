package EnumeracaoComposicao.composicao.exercicio.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    /*
    --------------------------------------------------------------------------------
     1. Atributos Básicos
    --------------------------------------------------------------------------------
    - POR QUE ESTÁ CERTO: Identifica perfeitamente os dados primitivos/envelopados
      que definem o estado direto do objeto.
     */
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    /*
     --------------------------------------------------------------------------------
        2. Associações (Composição de Objetos)
     -------------------------------------------------------------------------------
    - POR QUE ESTÁ CERTO: Como o Trabalhador "tem um" Departamento, isso é uma
    associação por composição/agregação de objetos. É a tradução ideal da seta do diagrama.
    */
    private Department department;

    /*
     --------------------------------------------------------------------------------
     3. A Regra da Lista (Não incluir no construtor e nem criar Setter)
     --------------------------------------------------------------------------------
     1º- Instanciar a lista na declaração (`= new ArrayList<>()`) garante que a
       lista nunca seja nula (`NullPointerException`), nascendo pronta para uso.

     2º- NÃO incluir a lista no construtor e NÃO criar um setContracts impede que
       uma lista externa inteira seja injetada e substitua a coleção. A manipulação
       de contratos DEVE ser feita exclusivamente pelos métodos addContract e removeContract.
     */
    private final List<HourContract> contracts = new ArrayList<>();// A lista de contratos do trabalhador começa vazia.


    // Construtor Padrão
    public Worker() {
    }

    // Construtor com Argumentos (Sem a lista!)
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    // -----------------------------------------------------------------------------
    // GETTERS & SETTERS (Contratos NÃO possuem Setter)
    // -----------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    // Retorna a lista para leitura (Sem o método duplicado)
    public List<HourContract> getContracts() {
        return contracts;
    }

    // -----------------------------------------------------------------------------
    // MÉTODOS DE MANIPULAÇÃO DA COMPOSIÇÃO, ADICIONAR E REMOVER A LISTA QDE CONTRATOS
    // -----------------------------------------------------------------------------
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    //ganhos em um ano (sum=> soma)

    //percorrer a lista de contratos do funcionario (for each => apropriado para percorrer listas)
    //pegar os contratos desse  mês e do ano, se sim entra na soma
        /*
        LEITURA DO LAÇO
        para cada contrato(HourContract) c: na lista de contratos
        testamos se esse contrato c e desse ano e desse mês,
        se sim, soma o valor total do contrato c (c.totalValue()) na variável sum

        1º- o contrato de uma data, e apartir da data pegamos o mês
        2ª- totalValue() => devolve o valor total do contrato
         */
    public double income(int year, int month) {
        // O ganho começa com o salário fixo base
        double sum = baseSalary;

        // calendar é uma classe que permite manipular datas de
        // forma mais flexível do que a classe Date. Aqui, estamos criando uma instância de Calendar
        // para poder extrair o ano e o mês de cada contrato.
        // Instanciamos o Calendar para extrair dia/mês/ano de objetos Date
        Calendar cal = Calendar.getInstance();

        /*
         Percorre todos os contratos que pertencem ao trabalhador.
        */
        for (HourContract ct: contracts) {
           /*
            1ª - Pega a data do contrato (ct.getDate()) e coloca essa data
            dentro do objeto Calendar (cal).

            Ou seja: define a data do Calendar como sendo a mesma data
            armazenada no contrato.
            */
            // Define a data do Calendar com a data específica do contrato atual
            cal.setTime(ct.getDate());

            /*
            2ª - Agora que o Calendar está representando a data do contrato,
            pega o ano e o mês dessa data e armazena em variáveis separadas.
            */
            int contractYear = cal.get(Calendar.YEAR);
            int contractMonth = cal.get(Calendar.MONTH) + 1;
            // Calendar.MONTH começa em 0:
            // Janeiro = 0
            // Fevereiro = 1
            // ...
            // Dezembro = 11
            //
            // Por isso somamos + 1 para obter o mês real:
            // Janeiro = 1
            // Junho = 6
            // Dezembro = 12

            /*
            Se o ano do contrato for igual ao ano solicitado
             e o mês do contrato for igual ao mês solicitado, soma o valor total daquele contrato.
            */
            if ( contractYear == year && contractMonth == month) {

                sum += ct.totalValue();
            }
        }

        return sum;
    }

}