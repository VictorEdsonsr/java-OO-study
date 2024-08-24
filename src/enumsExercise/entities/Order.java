package enumsExercise.entities;

import enumsExercise.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment = LocalDateTime.now();
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    public Order() {
    }

    public Order( Client client, OrderStatus status) {
        this.client = client;
        this.status = status;
    }

    public String getMoment() {
        return moment.format(formatter);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public Double total(){
        Double total = 0.0;
        for(OrderItem itemPrice : orderItems){
            total += itemPrice.subTotal();
        }
        return total;
    }
}
