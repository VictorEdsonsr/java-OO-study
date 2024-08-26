package polimorfismoExercise;

import polimorfismoExercise.entities.ImportedProduct;
import polimorfismoExercise.entities.Product;
import polimorfismoExercise.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        List<Product> productsList = new ArrayList<>();

        for(int i = 1; i <= numberOfProducts; i++){
            System.out.print("Common, used or imported (c/u/i): ");
            char option = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();

            switch (option){
                case 'i':
                case'I':
                    System.out.print("Customs Fee: ");
                    Double customsFee = sc.nextDouble();
                    productsList.add(new ImportedProduct(name,price,customsFee));
                    break;
                case 'u':
                case'U':
                    sc.nextLine();
                    System.out.print("Manufacture Date (DD/MM/YYYY): ");
                    String manufactureDateString = sc.nextLine();
                    LocalDate manufactureDate = LocalDate.parse(manufactureDateString, formatter);
                    productsList.add(new UsedProduct(name,price,manufactureDate));
                    break;
                default:
                    productsList.add(new Product(name,price));
                    break;
            }
        }

        System.out.println("PRICE TAGS:");
        for(Product product: productsList){
            System.out.println(product.priceTag());
        }

        sc.close();
    }

}

