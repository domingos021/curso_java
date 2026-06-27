package Heranca_polimorfismo.exercicFixacao;

import Heranca_polimorfismo.exercicFixacao.entities.ImportedProduct;
import Heranca_polimorfismo.exercicFixacao.entities.ProductSup;
import Heranca_polimorfismo.exercicFixacao.entities.UsedProduct;
/*
FORMATAR A DATA MANUALMENTE
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramProduct {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        /*
        POLIMORFISMO
        ✔ Isso aqui é o coração do polimorfismo:
        mesma lista (tipo genérico) => ProductSup (classe pai)
        objetos diferentes (comportamentos diferentes)

        MAS RECEBE OS SEGUINTES OBJETOS
        ImportedProduct => do tipo ImportedProduct (classe filha, objeto com um comportamento)
        UsedProduct => do tipo UsedProduct  (classe filha, objeto com outro comportamento)

         LISTA => GAVETAS
        productList (GAVETA DE PRODUCTSUP)
          ├── [0] -> Objeto ProductSup puro (Comum)
          ├── [1] -> Objeto ImportedProduct (Importado) -> Entra porque É UM produto
          └── [2] -> Objeto UsedProduct (Usado)         -> Entra porque É UM produto
         */
        List<ProductSup> productList = new ArrayList<>();

        /*
        DATA MANUAL
        // Formatador para entender o que o usuário vai digitar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         */

        System.out.print("Quantos produtos voce deseja registrar? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Produto #" + i + " dados:");
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Nome do produto: ");
            sc.nextLine(); // Consome a quebra de linha pendente
            String name = sc.nextLine();

            System.out.print("Preco do produto: ");
            double price = sc.nextDouble();

            if (ch == 'c') {
                productList.add(new ProductSup(name, price));

            } else if (ch == 'u') {
                // Pega a data atual do sistema automaticamente
                LocalDate date = LocalDate.now();
                System.out.println("Data de fabricação registrada automaticamente (Hoje).");
                System.out.println(date);
                /*
                DIGITANDO A DATA MANUALMENTE

                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                sc.nextLine(); // Consome a quebra de linha antes de ler o texto da data
                String dateStr = sc.nextLine();

                // Converte a String digitada em um objeto LocalDate
                LocalDate date = LocalDate.parse(dateStr, dtf);


                 */

                productList.add(new UsedProduct(name, price, date));

            } else if (ch == 'i') {
                System.out.print("Taxa de importação: ");
                double tax = sc.nextDouble();

                productList.add(new ImportedProduct(name, price, tax));
            }
        }

        // --- EXIBIÇÃO DAS ETIQUETAS (POLIMORFISMO) ---
        System.out.println();
        System.out.println("ETIQUETAS DE PREÇO:");

        //🔥 2. Loop polimórfico perfeito
        for (ProductSup prod : productList) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}
        /*
                                    ┌─────────────────┐
                                    │   ProductSup    │  ◄─── (Sua lista é desse tipo)
                                    └────────┬────────┘
                                             │
                            ┌────────────────┴────────────────┐
                            ▼                                 ▼
                ┌───────────────────┐               ┌───────────────────┐
                │   UsedProduct     │               │  ImportedProduct  │
                └───────────────────┘               └───────────────────┘
                (Usa LocalDate.now())

        */

        /*
        ===============================
        HERANÇA vs COMPOSIÇÃO (POO)
        ===============================

        🔷 1. HERANÇA (extends)
        -----------------------

        📌 CONCEITO:
        Herança é usada quando existe uma relação clara de "É UM".

        👉 Se A É UM tipo de B, então faz sentido usar herança.

        Exemplo:
        - ImportedProduct É UM ProductSup
        - UsedProduct É UM ProductSup

        📌 IDEIA:
        Você tem uma classe base com comportamento comum,
        e subclasses que apenas especializam esse comportamento.

        --------------------------------------------------

        📌 QUANDO USAR HERANÇA:

        ✔ Quando existe relação "É UM"
        ✔ Quando subclasses compartilham comportamento e atributos
        ✔ Quando você quer polimorfismo (tratamento genérico)
        ✔ Quando o comportamento base faz sentido sozinho

        --------------------------------------------------

        📌 EXEMPLO REAL:

        class ProductSup {
            String name;
            double price;

            public String priceTag() {
                return name + " - $" + price;
            }
        }

        class ImportedProduct extends ProductSup {
            double customsFee;

            @Override
            public String priceTag() {
                return super.priceTag() + " (Customs fee)";
            }
        }

        👉 Aqui:
        ImportedProduct É UM ProductSup ✔

        --------------------------------------------------

        📌 VANTAGENS:
        ✔ Reutilização de código
        ✔ Polimorfismo
        ✔ Código mais limpo em hierarquias simples

        --------------------------------------------------

        📌 PROBLEMAS DA HERANÇA (quando usar errado):
        ❌ Hierarquia rígida
        ❌ Classes ficam acopladas demais
        ❌ Mudança na base quebra várias classes
        ❌ Não é flexível para múltiplos comportamentos

        ==================================================

        🔷 2. COMPOSIÇÃO (HAS-A)
        ------------------------

        📌 CONCEITO:
        Composição é quando uma classe "TEM UM" outro objeto.

        👉 Em vez de herdar comportamento, você DELEGA.

        Exemplo:
        - Order TEM Product
        - Carro TEM Motor
        - Usuário TEM Endereço

        📌 IDEIA:
        Em vez de "ser algo", a classe "usa algo".

        --------------------------------------------------

        📌 QUANDO USAR COMPOSIÇÃO:

        ✔ Quando a relação é "TEM UM"
        ✔ Quando você quer mais flexibilidade
        ✔ Quando não existe hierarquia clara
        ✔ Quando comportamento pode mudar dinamicamente
        ✔ Quando herança ficaria forçada

        --------------------------------------------------

        📌 EXEMPLO REAL:

        class Product {
            String name;
            double price;
        }

        class Order {
            List<Product> products; // composição
        }

        👉 Order NÃO É Product
        👉 Order TEM Products

        --------------------------------------------------

        📌 VANTAGENS:
        ✔ Muito mais flexível
        ✔ Menos acoplamento
        ✔ Mais fácil de manter
        ✔ Evita hierarquias complexas

        --------------------------------------------------

        📌 DESVANTAGEM:
        ❌ Pode ter mais código (delegação manual)

        ==================================================

        🔷 3. REGRA DE OURO (MUITO IMPORTANTE)
        --------------------------------------

        👉 Se você estiver em dúvida:

        ✔ Prefira COMPOSIÇÃO

        Porque:
        - é mais flexível
        - quebra menos código
        - é padrão em sistemas reais

        ==================================================

        🔷 4. DIFERENÇA RESUMIDA
        ------------------------

        HERANÇA:
        👉 "É UM"
        👉 ProductSup <- ImportedProduct
        👉 foco em especialização

        COMPOSIÇÃO:
        👉 "TEM UM"
        👉 Order -> List<Product>
        👉 foco em reutilização flexível

        ==================================================

        🔷 5. SEU CASO (o que você está aprendendo)

        Seu modelo atual:

        ProductSup
         ├── ImportedProduct
         └── UsedProduct

        ✔ Isso é HERANÇA correta
        ✔ Bom para aprender POO
        ✔ Bom para polimorfismo

        MAS em sistemas reais:
        → muitas vezes isso viraria composição dependendo do contexto

        ==================================================
*/
