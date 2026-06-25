package EnumeracaoComposicao.entities;

import java.util.Date;

public class Order {
    private Integer id;
    private Date moment; //instante do pedido

    //Atributo do tipo orderStatus que e uma class
    //não tem import porque est na mesma pasta entities
    private OrderStatus status;

    public Order() {
        //construtor vazio
    }
    public Order(Integer id, Date moment, OrderStatus status) {
        //construtor com orgumentos
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    //GETTERS
    public Integer getId() {
        return id;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id +
                ", moment=" + moment +
                ", status=" + status +
                ']';
    }
}