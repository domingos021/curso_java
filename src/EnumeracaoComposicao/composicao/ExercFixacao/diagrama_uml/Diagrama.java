package EnumeracaoComposicao.composicao.ExercFixacao.diagrama_uml;

public class Diagrama {
                                /*
                            +-------------------------------------------------------+
                            |                       Program                         |
                            +-------------------------------------------------------+
                            | + main(args: String[])                                |
                            +-------------------------------------------------------+
                                                       |
                                                       v (Instancia e manipula)
                            +-------------------------------------------------------+
                            |                     Order_exerc                       |
                            +-------------------------------------------------------+
                            | - moment: Date                                        |
                            | - status: OrderStatus                                 |
                            | - client: Client                                      |
                            | - items: List<OrderItem>                              |
                            +-------------------------------------------------------+
                            | + addItem(item: OrderItem): void                      |
                            | + removeItem(item: OrderItem): void                   |
                            | + total(): Double                                     |
                            | + toString(): String                                  |
                            +-------------------------------------------------------+
                                   |                                         |
                                   | 1 (Tem um)                              | 1..* (Tem muitos)
                                   v                                         v
                            +-----------------------+               +-----------------------+
                            |        Client         |               |       OrderItem       |
                            +-----------------------+               +-----------------------+
                            | - name: String        |               | - quantity: Integer   |
                            | - email: String       |               | - price: Double       |
                            | - birthDate: Date     |               | - product: Product    |
                            +-----------------------+               +-----------------------+
                            | + toString(): String  |               | + subTotal(): Double  |
                            +-----------------------+               | + toString(): String  |
                                                                    +-----------------------+
                                                                                |
                                                                                | 1 (Associa-se a)
                                                                                v
                                                                    +-----------------------+
                                                                    |        Product        |
                                                                    +-----------------------+
                                                                    | - name: String        |
                                                                    | - price: Double       |
                                                                    +-----------------------+
                                                                    | + toString(): String  |
                                                                    +-----------------------+
                                 */
}
