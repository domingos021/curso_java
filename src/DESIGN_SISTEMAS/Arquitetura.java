package DESIGN_SISTEMAS;

public class Arquitetura {
    /*
================================================================================
                           GUIA ARQUITETURAL EM CAMADAS
================================================================================

[ FLUXOGRAMA GERAL DO SISTEMA ]

+------------------------------------------------------------------------+
|                                 VIEWS                                  |
|   (Interface com o usuário - Telas em React, HTML, Mobile, etc.)        |
+------------------------------------------------------------------------+
                                  │ ▲
             Envia JSON ou Form   │ │ Retorna HTML / JSON / Status
                                  ▼ │
+------------------------------------------------------------------------+
|                              CONTROLLERS                               |
|   (Porta de entrada - Valida formato dos dados e direciona o tráfego)   |
+------------------------------------------------------------------------+
                                  │ ▲
             Chama o Caso de Uso  │ │ Retorna Dados Processados
                                  ▼ │
+------------------------------------------------------------------------+
|                               SERVICES                                 |
|   (Coração do Sistema - Executa as Regras de Negócio e Orquestração)   |
+------------------------------------------------------------------------+
                                  │ ▲
             Aplica Lógica / Regras│ │ Retorna Objetos de Domínio
                                  ▼ │
+------------------------------------------------------------------------+
|                           ENTITIES / MODELS                            |
|   (Domínio - Classes que representam as regras e estruturas do objeto) |
+------------------------------------------------------------------------+
                                  │ ▲
             Solicita Persistência│ │ Retorna Dados Brutos do Banco
                                  ▼ │
+------------------------------------------------------------------------+
|                              REPOSITORIES                              |
|   (Acesso a Dados - Executa as Queries SQL, Comandos ORM ou Arquivos)  |
+------------------------------------------------------------------------+


================================================================================
                       DEFINIÇÕES E EXEMPLOS POR CAMADA
================================================================================

--------------------------------------------------------------------------------
1. VIEWS => Tela principal do sistema, onde o usuário interage.
--------------------------------------------------------------------------------
- CONCEITO: Camada de apresentação pura. Sua única função é renderizar as
  informações na tela para o usuário e capturar eventos (cliques, digitação).
  Não conhece regras de negócio e nem tabelas de banco de dados.
- EXEMPLO: Um botão "[Finalizar Compra]" em uma tela de checkout React que, ao
  ser clicado, dispara os dados brutos recolhidos do formulário:
  { "userId": 42, "items": [{ "productId": 101, "quantity": 2 }], "coupon": "VALE10" }

--------------------------------------------------------------------------------
2. CONTROLLER => Camada intermediária de entrada, gerencia as requisições.
--------------------------------------------------------------------------------
- CONCEITO: O "guarda de trânsito" da API. Recebe os dados brutos da VIEW, valida
  rapidamente se o formato está correto (ex: se os campos obrigatórios existem)
  e despacha a execução para o SERVICE correspondente. Define também o retorno
  HTTP (200 OK, 400 Bad Request, 201 Created).
  ⚠️ Regra de Ouro: NÃO deve conter regras de negócio (cálculos, validações de saldo).
- EXEMPLO:
  class OrderController {
      async createOrder(req, res) {
          if (!req.body.userId || !req.body.items) {
              return res.status(400).json({ error: "Dados obrigatórios ausentes!" });
          }
          const newOrder = await this.orderService.executeCheckout(req.body);
          return res.status(201).json(newOrder);
      }
  }

--------------------------------------------------------------------------------
3. SERVICES => Camada onde ficam as classes que implementam as regras de negócio.
--------------------------------------------------------------------------------
- CONCEITO: Onde o processo real da empresa acontece. O Service orquestra o fluxo:
  pede validações para os Repositories (ex: "tem estoque?"), aplica regras restritivas
  (ex: "usuário está bloqueado?"), manipula o estado das Entities e manda persistir.
- EXEMPLO:
  class OrderService {
      async executeCheckout(orderData) {
          const hasStock = await this.productRepository.checkStock(orderData.items);
          if (!hasStock) throw new Error("Estoque insuficiente!");

          const order = new Order(orderData.userId, orderData.items);
          if (orderData.coupon === "VALE10") {
              order.applyDiscount(10);
          }
          return await this.orderRepository.save(order);
      }
  }

--------------------------------------------------------------------------------
4. ENTITIES / MODELS => Camada que representa as entidades e dados do sistema.
--------------------------------------------------------------------------------
- CONCEITO: Classes que mapeiam os objetos do mundo real (ex: Order, Product) e suas
  estruturas de dados. Se for um modelo anêmico, possui apenas atributos. Se for rico,
  guarda regras intrínsecas da própria entidade (como autocalcular seu total).
  O MODELO é responsável por gerenciar o estado, a consistência dos dados estruturais
  e garantir que as regras fundamentais daquela entidade nunca sejam violadas.
- EXEMPLO:
  class Order {
      constructor(userId, items) {
          this.userId = userId;
          this.status = "PENDING";
          this.totalValue = this.calculateTotal(items);
      }
      applyDiscount(percentage) {
          this.totalValue -= (this.totalValue * (percentage / 100));
      }
  }

--------------------------------------------------------------------------------
5. REPOSITORIES => Camada responsável por acessar e persistir os dados.
--------------------------------------------------------------------------------
- CONCEITO: A ponte direta com o banco de dados (MySQL, PostgreSQL) ou arquivos.
  Isola completamente as instruções SQL ou métodos de ORM (Prisma, Sequelize, Hibernate)
  do restante do código. Apenas os Services chamam os Repositories.
- EXEMPLO:
  class OrderRepository {
      async save(order) {
          const sql = "INSERT INTO orders (user_id, total, status) VALUES (?, ?, ?)";
          const result = await db.execute(sql, [order.userId, order.totalValue, order.status]);
          order.id = result.insertId;
          return order;
      }
  }


================================================================================
                    FLUXO DE EXECUÇÃO PONTA A PONTA (EXEMPLO)
================================================================================

 [ VIEW ] (Usuário clica em "Comprar")
    │
    ▼ Envia JSON estruturado
 [ CONTROLLER ] (Valida se as propriedades do JSON existem)
    │
    ▼ Invoca o método: orderService.executeCheckout(dados)
 [ SERVICE ] (Orquestra as regras do negócio)
    │
    ├─► [ REPOSITORY (Product) ] ──► (Executa SELECT no MySQL para checar estoque)
    │                                         │
    ├◄──────────────── Retorna true/false ────┘
    │
    ├─► [ ENTITY (Order) ] ──► (Instancia o objeto e calcula taxas/descontos internos)
    │
    ▼ Invoca o método: orderRepository.save(order)
 [ REPOSITORY (Order) ] ──► (Executa o INSERT INTO no banco MySQL)

================================================================================
*/
}
