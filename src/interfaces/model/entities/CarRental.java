package interfaces.model.entities;

import java.time.LocalDateTime;


public class CarRental {
    private LocalDateTime start;
    private LocalDateTime finish;
    private Vehicle vehicle; // CarRental se associa a classe vehicle
    private Invoice invoice; // CarRental se associa a classe Invoice
    // |VEHICLE| <------- |carRental| -------> |INVOICE|  => composição (tem um)
    // CarRental possui um Vehicle e uma Invoice, mas não é um Vehicle nem uma Invoice.

    //CONSTRUTORES
    public CarRental() {
    }

    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;

    }

    public CarRental(String model) {
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /*
        ===============================================================================
        COMPOSIÇÃO x HERANÇA
        ===============================================================================

        Neste caso utilizamos COMPOSIÇÃO e não HERANÇA, porque um aluguel (CarRental)
        não é um veículo.

        O aluguel apenas utiliza um veículo para existir e gera uma fatura ao final.

        Para representar isso, CarRental possui (tem um):

            CarRental
                |
                +----> Vehicle
                |
                +----> Invoice

        Ou seja:

            CarRental TEM um Vehicle.
            CarRental TEM uma Invoice.

        Esse relacionamento é chamado de COMPOSIÇÃO (ou associação), pois uma classe
        possui objetos de outras classes como parte da sua estrutura.

        -------------------------------------------------------------------------------

        Já a HERANÇA representa uma relação completamente diferente.

        Ela só deve ser utilizada quando a classe filha realmente for um tipo mais
        específico da classe pai.

        Em outras palavras, quando existir uma relação do tipo:

                            "É UM" (IS-A)

        Exemplo:

                Animal
                   ▲
                   │
              Cachorro

        Animal é a classe mais genérica (superclasse).

        Cachorro é uma especialização de Animal (subclasse).

        Todo cachorro é um animal.

        Por isso faz sentido escrever:

            class Cachorro extends Animal

        Nesse caso, Cachorro herda todas as características e comportamentos comuns de
        Animal e ainda pode adicionar características próprias, como:

            - raça
            - latir()

        -------------------------------------------------------------------------------

        Regra prática:

        Se a frase fizer sentido:

            "Minha classe É um(a) objeto da outra."

        → Utilize HERANÇA (extends).

        Se a frase fizer sentido:

            "Minha classe TEM um(a) objeto da outra."

        → Utilize COMPOSIÇÃO (atributos).

        Essa é uma das principais formas de identificar qual relacionamento utilizar
        durante a modelagem de um sistema orientado a objetos.
        ===============================================================================
        */



}

    /*
    ===============================================================================
                         HERANÇA x COMPOSIÇÃO (POO)
    ===============================================================================

    HERANÇA (extends)
    -----------------

    Definição:
    Herança é um mecanismo da Programação Orientada a Objetos que permite que uma
    classe herde( atributos) e( métodos )de outra classe.

    A classe que herda é chamada de SUBCLASSE (classe filha), enquanto a classe da
    qual ela herda é chamada de SUPERCLASSE (classe pai).

    A herança representa uma relação do tipo:

                                "É UM" (IS-A)

    Ou seja, a classe filha é uma especialização da classe pai.

    Exemplos:

        Cachorro É um Animal.
        Aluno É uma Pessoa.
        Gerente É um Funcionário.
        ContaPoupanca É uma Conta.

    Exemplo:

        class Animal { }

        class Cachorro extends Animal { }

    Nesse caso, todo Cachorro também é um Animal, portanto a herança faz sentido.

    Quando utilizar?

    Sempre que existir uma verdadeira relação de especialização.

    Pergunta que deve ser feita:

        "Minha classe É um(a) objeto da outra classe?"

    Se a resposta for SIM, utilize HERANÇA.

    ===============================================================================

    COMPOSIÇÃO
    ----------

    Definição:
    Composição é um relacionamento em que uma classe possui objetos de outras
    classes como atributos.

    Nesse caso, uma classe não herda outra. Ela apenas utiliza outras classes para
    representar partes do objeto ou suas responsabilidades.

    A composição representa uma relação do tipo:

                                "TEM UM" (HAS-A)

    Exemplos:

        Pessoa TEM um Endereço.
        Pedido TEM um Cliente.
        Computador TEM um Processador.
        CarRental TEM um Vehicle.
        CarRental TEM uma Invoice.

    Exemplo:

        class CarRental {

            private Vehicle vehicle;
            private Invoice invoice;

        }

    Observe que CarRental apenas possui um Vehicle e uma Invoice.

    Ela NÃO é um Vehicle.

    Ela NÃO é uma Invoice.

    Quando utilizar?

    Sempre que um objeto possuir outro objeto como parte de sua estrutura ou
    necessitar armazená-lo.

    Pergunta que deve ser feita:

        "Minha classe TEM um(a) objeto da outra classe?"

    Se a resposta for SIM, utilize COMPOSIÇÃO.

    ===============================================================================

    POR QUE NÃO USAR HERANÇA EM CarRental?

    Se fizéssemos:

        class CarRental extends Vehicle

    Estaríamos afirmando que:

        "Um aluguel É um veículo."

    Isso está errado.

    O aluguel apenas utiliza um veículo.

    Da mesma forma:

        class CarRental extends Invoice

    Significaria que:

        "Um aluguel É uma fatura."

    Também está errado.

    O aluguel apenas gera uma fatura.

    Por isso o correto é:

        class CarRental {

            private Vehicle vehicle;
            private Invoice invoice;

        }

    ===============================================================================

    DEPENDÊNCIA (USA UM)
    --------------------

    Existe ainda outro relacionamento muito comum chamado Dependência.

    Definição:
    Uma classe utiliza outra apenas para executar alguma tarefa, sem armazená-la
    como atributo.

    Representa uma relação do tipo:

                                "USA UM"

    Exemplo:

        class RentalService {

            public double processPayment(TaxService taxService) {
                ...
            }

        }

    Nesse exemplo, RentalService utiliza TaxService, mas não o mantém como parte do
    seu estado.

    ===============================================================================

    RESUMO

    HERANÇA
    --------
    Relação: "É UM" (IS-A)

    Pergunta:
    Minha classe É um(a) objeto da outra?

    Resposta:
    Sim -> Utilize extends.

    Exemplo:
    Cachorro -> Animal.

    ===============================================================================

    COMPOSIÇÃO
    ----------
    Relação: "TEM UM" (HAS-A)

    Pergunta:
    Minha classe TEM um(a) objeto da outra?

    Resposta:
    Sim -> Utilize atributos.

    Exemplo:
    CarRental -> Vehicle.

    ===============================================================================

    DEPENDÊNCIA
    -----------
    Relação: "USA UM"

    Pergunta:
    Minha classe apenas utiliza outra temporariamente?

    Resposta:
    Sim -> Utilize dependência (parâmetros, variáveis locais ou injeção de
    dependência).

    Exemplo:
    RentalService -> TaxService.

    ===============================================================================

    REGRA DE OURO

    Sempre faça estas perguntas:

    É um?
        -> HERANÇA (extends)

    Tem um?
        -> COMPOSIÇÃO (atributos)

    Usa um?
        -> DEPENDÊNCIA

    Em projetos profissionais, a composição costuma ser preferida quando não existe
    uma verdadeira relação de "É UM", pois gera um código mais flexível, organizado
    e de fácil manutenção.
    ===============================================================================

     */

    /*
    ===============================================================================
                               "É UM" (IS-A)
    ===============================================================================

    "É UM" (IS-A) é a relação que define quando devemos utilizar HERANÇA (extends).

    Ela indica que uma classe é uma versão mais especializada de outra classe.

    Em outras palavras:

        A classe filha É um tipo da classe pai.

    A classe filha herda os atributos e métodos da classe pai e também pode criar
    novos atributos e métodos específicos.

    Sempre faça esta pergunta antes de utilizar "extends":

            "Minha classe É um(a) objeto da outra classe?"

    Se a resposta for SIM, a herança faz sentido.

    -------------------------------------------------------------------------------

    Exemplos:

        Cachorro( É um) Animal.

            Animal
               ▲
               │
          Cachorro


    Todo cachorro é um animal.

    Logo:

        class Cachorro extends Animal { }

    Nesse caso:

    ANIMAL => termo abrangente cabe todas especies de animais.
    CACHORRO => termo específico, apenas uma especie de animal.
    ------
    É a classe mais GENÉRICA ou ABRANGENTE (superclasse).

    Ela representa o conceito mais abrangente, reunindo características e
    comportamentos comuns a todos os animais, como por exemplo:

        - nome
        - idade
        - comer()
        - dormir()

    Nela podem se encaixar diversas espécies, como:

        - Cachorro
        - Gato
        - Cavalo
        - Pássaro

    ------------------------------------------------------------

    Cachorro
    ---------
    É a classe mais ESPECÍFICA (subclasse).

    Ela representa apenas um ( tipo ) de Animal.

    Além de herdar tudo que Animal possui, ela pode adicionar características
    e comportamentos próprios, como por exemplo:

        - raça
        - latir()

    Por isso dizemos que:

        Cachorro É um Animal.

    Essa é uma relação do tipo "É UM" (IS-A), sendo um caso correto para o uso
    de herança (extends).


    -------------------------------------------------------------------------------

    Outro exemplo:

        Carro É um Veículo.

            Vehicle
               ▲
               │
              Car

    Todo carro é um veículo.

    Logo:

        class Car extends Vehicle { }

    -------------------------------------------------------------------------------

    Outro exemplo:

        ContaPoupanca É uma Conta.

            Conta
              ▲
              │
    ContaPoupanca

    Toda conta poupança continua sendo uma conta, apenas possui características
    e comportamentos específicos.

    -------------------------------------------------------------------------------

    Uma característica muito importante da relação "É UM" é que um objeto da classe
    filha também pode ser tratado como um objeto da classe pai.

    Exemplo:

        Animal animal = new Cachorro();

    Embora o objeto criado seja um Cachorro, ele também pode ser tratado como um
    Animal, pois todo Cachorro é um Animal.

    Esse conceito é a base do POLIMORFISMO.

    -------------------------------------------------------------------------------

    Quando NÃO utilizar herança?

    Se a frase "É UM" não fizer sentido.

    Exemplo:

        CarRental É um Vehicle?

    Resposta:
    Não.

    Um aluguel NÃO é um veículo.

    Ele apenas utiliza um veículo.

    Logo, o correto é utilizar COMPOSIÇÃO.

    -------------------------------------------------------------------------------

    Outro exemplo:

        Pedido É um Cliente?

    Não.

    Um pedido apenas( possui) um cliente.

    -------------------------------------------------------------------------------

    Regra prática:

    Se a frase abaixo fizer sentido:

        "Minha classe É um(a) objeto da outra."

    → Utilize HERANÇA (extends).

    Caso contrário, provavelmente você deverá utilizar COMPOSIÇÃO (TEM UM) ou
    DEPENDÊNCIA (USA UM).

    ===============================================================================
    */