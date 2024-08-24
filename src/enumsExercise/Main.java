package enumsExercise;

import enumsExercise.entities.Client;
import enumsExercise.entities.Order;
import enumsExercise.entities.OrderItem;
import enumsExercise.entities.Product;
import enumsExercise.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email: ");
        String clientEmail = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY):");
        String clientBirthDateString = sc.nextLine();
        LocalDate clientParsedBirthDate = LocalDate.parse(clientBirthDateString, formatter);

        Client client = new Client(clientName, clientEmail, clientParsedBirthDate);

        System.out.print("Enter order data:");
        String orderStatusString = sc.nextLine();

        System.out.print("How many items to this order? ");
        int numberItems = sc.nextInt();

        OrderStatus orderStatus = OrderStatus.valueOf(orderStatusString);

        Order order = new Order(client,orderStatus);
        for(int i = 1; i<=numberItems; i++){
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();


            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity,productPrice,new Product(productName,productPrice));
            order.addItem(orderItem);
        }


        System.out.println("ORDER SUMMARY");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().getName() + " " + "(" + order.getClient().getBirthDay() + ")" + " - " + order.getClient().getEmail());
        System.out.println("order items: ");

        for(OrderItem item : order.getOrderItems()){
            System.out.println(item.getProduct().getName() + ", " + item.getProduct().getPrice() + ", " + "Quantity: " + item.getQuantity() + ", " + "Subtotal: " + String.format("%.2f",item.subTotal()) );
        }

        System.out.println("Total price: " + order.total());
        sc.close();
    }

}

