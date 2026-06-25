package Data_hora.conceito;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

    /*
    ===============================================================================
                        GUIA COMPLETO DE DATAS E HORAS EM JAVA
    ===============================================================================

    A API java.time foi introduzida no Java 8 para substituir:

    - Date
    - Calendar
    - SimpleDateFormat

    Principais vantagens:

    ✓ Mais moderna
    ✓ Mais segura
    ✓ Imutável
    ✓ Mais fácil de utilizar
    ✓ Melhor suporte para fusos horários

    ===============================================================================
    QUANDO USAR CADA CLASSE?
    ===============================================================================

    1) LocalDate

    Use quando precisar apenas da DATA.

    Exemplos:

    - Data de nascimento
    - Data de vencimento
    - Data de matrícula
    - Data de emissão

    Exemplo:

    20/07/2022


    2) LocalTime

    Use quando precisar apenas do HORÁRIO.

    Exemplos:

    - Horário de funcionamento
    - Horário de aula
    - Horário de atendimento

    Exemplo:

    14:30:25


    3) LocalDateTime

    Use quando precisar de DATA + HORA.

    Exemplos:

    - Data de criação de um registro
    - Data de uma reunião
    - Agendamento de consulta

    Exemplo:

    20/07/2022 14:30:25

    IMPORTANTE:

    NÃO possui fuso horário.


    4) Instant

    Use quando precisar de um momento EXATO no mundo.

    Exemplos:

    - Logs
    - APIs
    - Sistemas distribuídos
    - Auditorias

    Exemplo:

    2022-07-20T17:30:25Z

    Possui UTC.


    5) ZonedDateTime

    Use quando precisar de:

    Data + Hora + Fuso Horário

    Exemplo:

    São Paulo
    Lisboa
    Tóquio

    Todos podem ter horários diferentes para o mesmo instante.

    ===============================================================================
    */


public class DataApp {

    public static void main(String[] args) {

        /*
        =======================================================================
        1) OBTENDO DATA ATUAL
        =======================================================================
        */

        LocalDate dataAtual = LocalDate.now();

        System.out.println("\n===== LOCALDATE =====");
        System.out.println(dataAtual);


        /*
        =======================================================================
        2) OBTENDO HORA ATUAL
        =======================================================================
        */

        LocalTime horaAtual = LocalTime.now();

        System.out.println("\n===== LOCALTIME =====");
        System.out.println(horaAtual);


        /*
        =======================================================================
        3) OBTENDO DATA E HORA
        =======================================================================
        */

        LocalDateTime dataHoraAtual = LocalDateTime.now();

        System.out.println("\n===== LOCALDATETIME =====");
        System.out.println(dataHoraAtual);


        /*
        =======================================================================
        4) OBTENDO MOMENTO GLOBAL UTC
        =======================================================================
        */

        Instant instanteAtual = Instant.now();

        System.out.println("\n===== INSTANT =====");
        System.out.println(instanteAtual);


        /*
        =======================================================================
        5) CONVERTENDO STRING PARA DATA
        =======================================================================

        O parse() converte texto em objeto.
        */

        LocalDate data =
                LocalDate.parse("2022-07-20");

        LocalDateTime dataHora =
                LocalDateTime.parse("2022-07-20T14:30:25");

        Instant instante =
                Instant.parse("2022-07-20T14:30:25Z");

        System.out.println("\n===== PARSE =====");
        System.out.println(data);
        System.out.println(dataHora);
        System.out.println(instante);


        /*
        =======================================================================
        6) FORMATANDO DATAS
        =======================================================================

        ISO:
        2022-07-20

        Brasileiro:
        20/07/2022
        */

        DateTimeFormatter fmt1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter fmt2 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("\n===== FORMAT =====");
        System.out.println(data.format(fmt1));
        System.out.println(dataHora.format(fmt2));


        /*
        =======================================================================
        7) LENDO DATA BRASILEIRA
        =======================================================================
        */

        LocalDate dataBr =
                LocalDate.parse(
                        "20/07/2022",
                        fmt1
                );

        System.out.println("\n===== DATA BR =====");
        System.out.println(dataBr);


        /*
        =======================================================================
        8) EXTRAINDO INFORMAÇÕES
        =======================================================================
        */

        System.out.println("\n===== GETTERS =====");

        System.out.println("Ano: " + data.getYear());

        System.out.println("Mes: " + data.getMonth());

        System.out.println("Numero do mes: "
                + data.getMonthValue());

        System.out.println("Dia: "
                + data.getDayOfMonth());

        System.out.println("Dia da semana: "
                + data.getDayOfWeek());


        /*
        =======================================================================
        9) ADICIONANDO TEMPO
        =======================================================================
        */

        System.out.println("\n===== PLUS =====");

        System.out.println(
                data.plusDays(10)
        );

        System.out.println(
                data.plusMonths(2)
        );

        System.out.println(
                data.plusYears(1)
        );


        /*
        =======================================================================
        10) SUBTRAINDO TEMPO
        =======================================================================
        */

        System.out.println("\n===== MINUS =====");

        System.out.println(
                data.minusDays(5)
        );

        System.out.println(
                data.minusMonths(1)
        );

        System.out.println(
                data.minusYears(2)
        );


        /*
        =======================================================================
        11) CALCULANDO DIFERENÇA ENTRE DATAS
        =======================================================================

        Period é usado para datas.
        */

        LocalDate inicio =
                LocalDate.parse("2020-01-01");

        LocalDate fim =
                LocalDate.parse("2025-06-18");

        Period periodo =
                Period.between(inicio, fim);

        System.out.println("\n===== PERIOD =====");

        System.out.println(
                periodo.getYears() + " anos"
        );

        System.out.println(
                periodo.getMonths() + " meses"
        );

        System.out.println(
                periodo.getDays() + " dias"
        );


        /*
        =======================================================================
        12) CALCULANDO DIFERENÇA ENTRE HORÁRIOS
        =======================================================================

        Duration é usada para horas.
        */

        LocalDateTime inicioHora =
                LocalDateTime.now();

        LocalDateTime fimHora =
                inicioHora.plusHours(5);

        Duration duracao =
                Duration.between(
                        inicioHora,
                        fimHora
                );

        System.out.println("\n===== DURATION =====");

        System.out.println(
                duracao.toHours()
        );

        System.out.println(
                duracao.toMinutes()
        );


        /*
        =======================================================================
        13) FUSOS HORÁRIOS
        =======================================================================
        */

        ZoneId brasil =
                ZoneId.of("America/Sao_Paulo");

        ZoneId lisboa =
                ZoneId.of("Europe/Lisbon");

        ZoneId toquio =
                ZoneId.of("Asia/Tokyo");

        System.out.println("\n===== ZONEID =====");

        System.out.println(brasil);
        System.out.println(lisboa);
        System.out.println(toquio);


        /*
        =======================================================================
        14) ZONEDDATETIME
        =======================================================================

        Data + Hora + Fuso
        */

        ZonedDateTime sp =
                ZonedDateTime.now(brasil);

        ZonedDateTime pt =
                ZonedDateTime.now(lisboa);

        ZonedDateTime jp =
                ZonedDateTime.now(toquio);

        System.out.println("\n===== ZONEDDATETIME =====");

        System.out.println(sp);
        System.out.println(pt);
        System.out.println(jp);


        /*
        =======================================================================
        15) CONVERSÕES
        =======================================================================
        */

        LocalDateTime convertido =
                LocalDateTime.ofInstant(
                        Instant.now(),
                        ZoneId.systemDefault()
                );

        System.out.println("\n===== CONVERSÃO =====");
        System.out.println(convertido);


        /*
        =======================================================================
        16) COMPARAÇÕES
        =======================================================================
        */

        LocalDate data1 =
                LocalDate.parse("2022-01-01");

        LocalDate data2 =
                LocalDate.parse("2025-01-01");

        System.out.println("\n===== COMPARAÇÕES =====");

        System.out.println(
                data1.isBefore(data2)
        );

        System.out.println(
                data2.isAfter(data1)
        );

        System.out.println(
                data1.isEqual(data2)
        );


        /*
        =======================================================================
        17) CHRONOUNIT
        =======================================================================

        Calcula diferença diretamente.
        */

        long dias =
                ChronoUnit.DAYS.between(
                        data1,
                        data2
                );

        System.out.println("\n===== CHRONOUNIT =====");

        System.out.println(
                "Dias: " + dias
        );
    }
}