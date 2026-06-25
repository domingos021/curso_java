package Data_hora.codigo;

import java.time.*;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

public class Treinamento {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        System.out.println("======================= Lição -1ª:LocalDate && LocalDateTime =======================");
        System.out.println("======================= LocalDate (Ano,Mês,Dia) =======================");
        /*
        LocalDate
            ↓
            Data data e hora sem fuso horario

        parse() -> Converte uma String em um objeto de data ou hora.
         */
        LocalDate data = LocalDate.parse("2022-07-20"); //feito de forma manual
        System.out.println(data);

        /*
        Aula 2 — Data Atual do Computador
       Até agora você criou datas manualmente:
       LocalDate=>ano, mês, ano
        now() => pega a data atual do computador e cria um objeto de data com ela.
         */
        /*
        LocalDate hoje =LocalDate.now();
        1º- LocalDate => classe do pacote java.time que representa uma data sem hora.
        2º- hoje =>        variável do tipo LocalDate que armazena a data atual obtida pelo método now().
        3º- LocalDate.now() => método estático da classe LocalDate que retorna a data atual do sistema.
         */

        LocalDate hoje = LocalDate.now(); //execução automatica, java pega a data atual do sistema
        System.out.println("Data atual de Hoje: " + hoje);

        //EXERCICICIO
        LocalDate hoje2 = LocalDate.now();
        System.out.println(hoje.getYear()); // getYear() extrai somente o ano do objeto LocalDate
        System.out.println(hoje.getMonth());
        System.out.println(hoje.getMonthValue());
        System.out.println(hoje.getDayOfMonth());
        System.out.println(hoje.getDayOfWeek());
        System.out.println(hoje.getDayOfYear());

        System.out.println();
        System.out.println("======================= LocalDateTime =======================");
        /*
        LocalDateTime
            ↓
            Data + Hora =>sem fuso horario

         LocalDateTime => Ano, Mês, Dia, Hora, Minuto, Segundo
         O T é apenas um separador entre:
         2022-07-20T01:30:26
         2022-07-20 -> Data
            2022 = Ano
            07   = Mês
            20   = Dia
         */

        LocalDateTime agora = LocalDateTime.now(); //automatico java pega os dados atuais do sistema
        System.out.println(agora);

        System.out.println();
        System.out.println("===============Exercício===============");
        LocalDateTime horaDataAtual = LocalDateTime.now();
        System.out.println("Hora e data atual: " + horaDataAtual);

        System.out.println(horaDataAtual.getYear());
        System.out.println(horaDataAtual.getMonth());
        System.out.println(horaDataAtual.getHour());
        System.out.println(horaDataAtual.getMinute());
        System.out.println(horaDataAtual.getSecond());

        System.out.println("======================= LocalDateTime.parse() =======================");
        /*
        O T apenas separa:
        Aula 3 — LocalDateTime.parse()
        Código para criar um LocalDateTime a partir de uma String:
        LocalDateTime dataHora = LocalDateTime.parse("2022-07-20T01:30:26");
        2022-07-20T01:30:26
        2022-07-20 -> Data
            2022 = Ano
            07   = Mês
            20   = Dia
         */

        LocalDateTime dataHora = LocalDateTime.parse("2000-10-15T14:30:00");
        System.out.println(dataHora);

        System.out.println("======================= LocalDateTime.now() =======================");
        LocalDateTime dataHora2 = LocalDateTime.now();
        System.out.println(dataHora2); // CORRIGIDO: Imprime a variável correta dataHora2

        System.out.println("======================= Exercicicio aplicado =======================");

        LocalDateTime prova =
                LocalDateTime.parse("2035-11-25T21:45:10");

        System.out.println(prova.getYear());
        System.out.println(prova.getMonthValue());
        System.out.println(prova.getDayOfMonth());

        System.out.println(prova.getHour());
        System.out.println(prova.getMinute());
        System.out.println(prova.getSecond());

        System.out.println("============= Lição -2ª:Instant=======================");
        /*
        Instant
        ↓
        Data + Hora + UTC (Tempo Universal Coordenado)
        ====================================================================
        Instant (no mesmo instante ou mesmo tempo, horários e países diferentes,
         mas sendo observados no mesmo instante
        ===========================================================
        Agora imagine que existe um relógio único para o mundo inteiro:
        Relógio global (UTC - Tempo Universal Coordenado)
        Todos os países podem converter esse horário para seus fusos locais.
        Exemplo:
        UTC     16:24
        Brasil  13:24
        Japão   01:24 (dia seguinte)

        Mas todos estão olhando para o mesmo instante.
        ==================================================
        Z = Horário mundial
        UTC (Z) => Tempo Universal Coordenado
        (Z é a letra que representa o horário mundial, sem considerar o fuso horário de um país específico)
        T = Separador entre data e hora ✅
        UTC => Universal Time Coordinate
        ================================= Então o que é Instant?=================
        Instant instante = Instant.parse("2026-06-18T16:24:26Z");
        Significa: => ("18/06/2026 às 16:24:26 no horário UTC.")

        O Instant mantém o Z because ele representa um instante no horário UTC.
         */
        System.out.println("============= Exercício pequeno ===================");
        Instant evento = Instant.parse("2030-12-25T10:30:15Z");
        System.out.println(evento);

        System.out.println();
        System.out.println("============= Exercício pequeno instant ===================");
        /*
        Todos pegam o momento atual, mas retornam tipos diferentes.
        LocalDate.now();
        LocalDateTime.now();
        Instant.now();
         */
        Instant instantNow = Instant.now();
        System.out.println(instantNow.toString()); //converte o instant para string

        System.out.println();
        System.out.println("====Aula 4 — Converter Instant para LocalDateTime ===================");
        /*
        O próximo passo natural é aprender:
        Instant -> LocalDateTime
        ou seja, como pegar um horário UTC (Instant) e transformá-lo em horário do Brasil usando um ZoneId.

        Mas agora isso vai fazer muito mais sentido, porque você já entende o que é um Instant.
         Antes você estava tentando aprender tudo ao mesmo tempo. Agora a base está construída. 🚀
         */

        /*
        Analogia
       Imagine que você tem um relógio mundial:

        16:24 UTC

        Agora você pergunta:

        "Como esse horário fica no Brasil?"

        O Java precisa saber qual fuso horário usar.
        Por isso existe:
        ZoneId.of("America/Sao_Paulo")
         */
        System.out.println();
        System.out.println("===EXEMPLO==");

        //Horario mundial UTC a ser convertido
        Instant instante = Instant.parse("2026-06-18T16:24:26Z");

        LocalDateTime brasil =
                // Local e data no instante a partir de um local específico no mundo
                LocalDateTime.ofInstant(
                        instante,
                        // Zona do instante
                        ZoneId.of("America/Sao_Paulo")
                );

        System.out.println(brasil);
        /*
        Tenho um horário UTC

        16:24:26

        Quero enxergá-lo no fuso de São Paulo

        Resultado:

        13:24:26

        A fórmula que eu quero que você grave
        Instant + ZoneId = LocalDateTime

        ou

        Horário UTC + Fuso Horário = Horário Local
         */


        System.out.println();
        System.out.println("===EXERCICIO==");

        Instant instante01 = Instant.parse("2026-06-18T20:00:00Z"); //Horario UTC, BASE PARA CALCULO
        /*
        UTC = 20:00
        Brasília = UTC - 3
         */

        LocalDateTime brasil01 =
                LocalDateTime.ofInstant(
                        instante01,
                        ZoneId.of("America/Sao_Paulo")
                );

        System.out.println(brasil01); // CORRIGIDO: Imprime brasil01 em vez de brasil

        System.out.println();
        System.out.println("===EXERCICIO02=========================================");
        /*
        20:00 UTC
        +1h
        -----
        21:00
         */

        Instant instante02 = Instant.parse("2026-06-18T20:00:00Z");

        LocalDateTime portugal =
                LocalDateTime.ofInstant(
                        instante02,
                        ZoneId.of("Europe/Lisbon")
                );

        System.out.println(portugal);


        System.out.println();
        System.out.println("===DateTimeFormatter========================================");

        //3. Formatando um LocalDate
        /*
        EXEMPLO
        DateTimeFormatter fmt =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Observe o padrão:

        dd      -> dia

        MM      -> mês

        yyyy    -> ano

        HH      -> hora

        mm      -> minuto

        ss      -> segundo

        dd/MM/yyyy

        dd-MM-yyyy

        dd/MM/yyyy HH:mm

        dd/MM/yyyy HH:mm:ss

        Fluxo mental profissional

        Quando você vê:

        LocalDate.parse(texto, fmt);

        pense:

        String
         ↓
        DateTimeFormatter
         ↓
        LocalDate
         */
        //Objeto a ser formatado => Criamos a data
        LocalDate date = LocalDate.parse("2030-12-25");

        //1ª- Criamos uma máscara (dia/mês/ano)
        DateTimeFormatter fmt =
                //formatação
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Passo 3
        //Aplicamos a máscara (data.format(fmt);)
        System.out.println(date.format(fmt));


        System.out.println();
        System.out.println("=====    4. Formatando LocalDateTime========================================");
  /*
        dd/MM/yyyy HH:mm:ss

        Fluxo mental profissional

        Quando você vê:

        LocalDate.parse(texto, fmt);

        pense:

        String
         ↓
        DateTimeFormatter
         ↓
        LocalDate
   */

        LocalDateTime date01 = LocalDateTime.parse("2030-12-25T14:30:10");

        DateTimeFormatter fmt02 =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy HH:mm:ss"
                );

        System.out.println(date01.format(fmt02));

        //======================================================
        System.out.println();
        System.out.println("Exercicio 02====");

        DateTimeFormatter fmt03 =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy"
                );

        LocalDate date02 =
                LocalDate.parse(
                        "10/08/2040",
                        fmt03
                );

        System.out.println(date02);


        System.out.println("====Aula 5 — Duration ===================");
        /*
        Enquanto Period trabalha com:

        anos
        meses
        dias

        Duration trabalha com:

        horas
        minutos
        segundos
        milissegundos
         */

        // Define a data e hora de início (01 de Janeiro de 2030 às 10:00:00)
        LocalDateTime inicio = LocalDateTime.parse("2030-01-01T10:00:00");

        // Define a data e hora de fim (01 de Janeiro de 2030 às 12:30:00)
        LocalDateTime fim = LocalDateTime.parse("2030-01-01T12:30:00");

        // Calcula o intervalo de tempo (duração) entre o início e o fim
        Duration duracao = Duration.between(inicio, fim);

        // Exibe apenas as horas inteiras da duração (vai ignorar os 30 minutos e imprimir: 2)
        System.out.println("Horas inteiras: " + duracao.toHours());

        // Opcional: Se quiser ver o total em minutos (vai imprimir: 150)
        // System.out.println("Total em minutos: " + duracao.toMinutes());

        /*
        Quantas horas existem entre essas datas?
        Quantos minutos?
        Quantos segundos?
        */

        System.out.println("=============== Aula 5.1 — Duration.toHours()=================");

        /*
        O método toHours() da classe Duration é usado para obter a duração total em horas, arredondando para baixo.
         Ele retorna o número inteiro de horas completas contidas na duração,
         ignorando quaisquer minutos ou segundos restantes.

         sintaxe:
         duracao.toHours();

         Somente pega horas completas
         2h30min  → 2
        5h59min  → 5
        0h45min  → 0
        10h00min → 10

         */

        //EXEMPLO 01
        LocalDateTime inicio01 =
                LocalDateTime.parse("2030-01-01T10:00:00"); //começa 10 horas
        LocalDateTime fim01 =
                LocalDateTime.parse("2030-01-01T12:30:00"); //termina 12 horas
        Duration duracao01 =
                Duration.between(inicio01, fim01); //das 10 horas as 12 horas tem 2 horas completas, os 30 minutos não contam

        System.out.println(duracao.toHours()); //duração de horas completas de uma para outra


        System.out.println("=============== Aula 5.2 — Duration.toMinutes()=================");
       /*
       Retorna a quantidade total de minutos contidos em uma Duration
       (convertendo as horas, se houver, para minutos).

       Sintaxe:
       duration.toMinutes();
        */

        //Exemplo 01
        LocalDateTime start =
                LocalDateTime.parse("2030-05-10T10:00:00");

        LocalDateTime end =
                LocalDateTime.parse("2030-05-10T10:45:00");

        Duration duration =
                Duration.between(start, end);

        System.out.println(duration.toMinutes()); //10:00 ==> 10:45 tem 45 minutos, então o resultado é 45

        //Exemplo 02

        LocalDateTime start01 =
                LocalDateTime.parse("2030-01-01T08:45:00");

        LocalDateTime end01 =
                LocalDateTime.parse("2030-01-01T11:15:00");

        Duration duration01 =
                Duration.between(start01, end01);

        System.out.println(duration01.toMinutes());

        System.out.println("=============== Aula 5.3 — Duration.toDays()=================");
        /*
        Retorna a quantidade total de dias completos contidos em uma Duration.

        Sintaxe
        duracao.toDays();

        📌 Regra para gravar: Assim como o toHours(), o toDays() olha apenas
         para blocos de 24 horas completas. Se a duração tiver 23 horas e 59 minutos,
          ainda é 0 dia.
         */
        //Exercício Mental 1
        //Sem executar:
        LocalDateTime start02 =
                LocalDateTime.parse("2030-01-01T08:00:00");

        LocalDateTime end02 =
                LocalDateTime.parse("2030-01-03T12:00:00");

        Duration duration02 =
                Duration.between(start02, end02);

        System.out.println(duration02.toDays()); //2 dias

        //exemplo
        LocalDateTime start03 =
                LocalDateTime.parse("2030-01-01T15:00:00");

        LocalDateTime end03 =
                LocalDateTime.parse("2030-01-02T11:00:00");

        Duration duration03 =
                Duration.between(start03, end03);

        System.out.println(duration03.toDays()); //0 dias

        System.out.println("=============== Aula 5.4 — Duration.getSeconds()=================");
        /*
        Retorna a quantidade total de segundos contidos em uma Duration.

        Sintaxe
        duracao.getSeconds();

        📌 Regra para gravar: Fique atento ao nome, ele começa com "get" (getSeconds)
         e não com "to". Ele converte todo o tempo da duração (horas e minutos)
         para o total absoluto de segundos.
         */
        //Exercício Mental 1
        //Sem executar:
        LocalDateTime start04 =
                LocalDateTime.parse("2030-01-01T10:00:00");

        LocalDateTime end04 =
                LocalDateTime.parse("2030-01-01T10:02:30");

        Duration duration04 =
                Duration.between(start04, end04);

        System.out.println(duration04.getSeconds()); // 150 segundos

        //Exemplo
        LocalDateTime start05 =
                LocalDateTime.parse("2030-01-01T14:00:00");

        LocalDateTime end05 =
                LocalDateTime.parse("2030-01-01T14:01:05");

        Duration duration05 =
                Duration.between(start05, end05);

        System.out.println(duration05.getSeconds());
           /*
        Vamos ao cálculo passo a passo:
        1º Passo: Achar a duração total
        De 10:00:00 até 10:02:30 se passaram 2 minutos e 30 segundos
        2º Passo: Converter tudo para segundos
        1 minuto = 60 segundos
        2 minutos = 120 segundos (2 x 60)120 se
        120 segundos + 30 segundos restantes = 150 segundos
         */
        System.out.println("==O Conceito: Somar e Subtrair Tempo (plus / minus)===");

        /*
        No dia a dia profissional, usamos muito isso para calcular vencimento de faturas,
         expiração de tokens ou prazos de entrega. As classes LocalDate e
          LocalDateTime possuem métodos prontos para somar ou subtrair dias,
           semanas, meses e horas.
         */

        /*
        Sintaxe

        data.plusDays(quantidade);
       data.minusHours(quantidade);
         */
        //Exercício Mental 1

        LocalDate today = LocalDate.parse("2026-06-19"); //database de inicio do calculo
        LocalDate vencimento = today.plusDays(7); //dias a ser acrescentado

        System.out.println(vencimento); //  de 19/06/2026 a 26/06/2026 tem 7 dias, então o resultado é 26/06/2026

        System.out.println("=============== Aula 6.2 — Comparar Datas (isBefore / isAfter) ================");
        /*
        Em sistemas reais, usamos isso para regras de negócio fundamentais, como checar
        se o cartão de crédito do cliente está vencido ou se um link de redefinição
        de senha ainda é válido.

        Sintaxe:
        data1.isBefore(data2); // Retorna true se data1 for ANTES de data2
        data1.isAfter(data2);  // Retorna true se data1 for DEPOIS de data2
         */

        // Exercício Mental 2
        // Sem executar:
        boolean expirou = isExpirou(); //tru

        System.out.println(expirou); // O dia 28 é DEPOIS do dia 25? Sim, então o resultado é true
        //==========================================================================================
        boolean valido = isValid();
        System.out.println(valido); //true

        System.out.println("=============== Aula 6.3 — Diferença com Period (Anos, Meses, Dias) ================");
        /*
        Usamos Period quando a regra de negócio exige saber o tempo exato decorrido
        em uma escala de calendário (Anos, Meses e Dias), como no cálculo de idade.

        Sintaxe:
        Period periodo = Period.between(dataInicio, dataFim);
        periodo.getYears();
        periodo.getMonths();
        periodo.getDays();
         */

        // Exercício Mental 3
        // Sem executar:
        LocalDate nascimento = LocalDate.parse("2000-05-15");
        LocalDate diaAtual   = LocalDate.parse("2026-06-19");

        Period idade = Period.between(nascimento, diaAtual);

        System.out.println(idade.getYears() + " anos");
    }

    // METODO QUE verifica se o cartão expirou
// comparando a data de uso com a data limite de vencimento
    private static boolean isExpirou() {
        String limitDate = "2026-06-26"; //true=> bloqueado, false => valido
        LocalDate dataAcesso = LocalDate.now(); //data atual do sistema, ou seja, dia 28/06/2026
        LocalDate dataLimite = LocalDate.parse(limitDate); //parse=> retorna texto

    /*
     O cartão tinha validade até 25/06/2026.

     O usuário tentou usar no dia 28/06/2026,
     ou seja, depois da data limite → expirado.
    */

        boolean expirou = dataAcesso.isAfter(dataLimite);

        return expirou;
    }

    // verifica se o dia da compra e depois do vencimento
    private static boolean isValid() {
        String data = "2026-06-21"; //false=> bloqueado, true => valido

        LocalDate vencimentoCartao = LocalDate.parse(data);
        LocalDate diaDaCompra = LocalDate.now();

        // FORMA 1 (mais direta)
        // válido apenas se a compra for ANTES do vencimento
        // boolean valido = diaDaCompra.isBefore(vencimentoCartao);

        // FORMA 2 (mais completa / realista)
        // válido se NÃO estiver depois do vencimento (inclui o dia do vencimento)
        boolean valido = !diaDaCompra.isAfter(vencimentoCartao);

        return valido;
    }


}
