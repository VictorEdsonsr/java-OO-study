package streamsExample;

import streamsExample.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String path = "/home/victorreis/study/Java-OO/src/products.csv";
        List<Product> products = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] productsArray = line.split(",");

                String name = productsArray[0];
                Double price = Double.parseDouble(productsArray[1]);

                products.add(new Product(name, price));

            }
            Comparator<String> comparator = (x, y) -> x.toUpperCase().compareTo(y.toUpperCase());

            Double average = products.stream().map(x -> x.getPrice()).reduce(0.0,(x,y) -> (x + y))/products.size();
            List<String> names = products.stream().filter(x -> x.getPrice() < average).map(Product::getName).sorted(comparator.reversed()).toList();

            System.out.println("Average price: " + String.format("%.2f", average));
            names.forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

/*
*             String path = "/home/victorreis/study/Java-OO/src/products.csv";
            List<Product> products = new ArrayList<>();
            List<Double> prices = new ArrayList<>();

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
                String line;
                while((line = bufferedReader.readLine()) != null){
                    String[] productsArray = line.split(",");

                    String name = productsArray[0];
                    products.add(new Product(name));

                    Double price = Double.parseDouble(productsArray[1]);
                    prices.add(price);
                }
                Double average = prices.stream().reduce(0.0,(x,y) -> (x + y))/prices.size();

                System.out.println("Average price: " + String.format("%.2f", average));
                products.forEach(x -> System.out.println(x.getName()));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
*
* */