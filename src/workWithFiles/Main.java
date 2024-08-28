package workWithFiles;

import workWithFiles.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        String inputStr = "/home/victorreis/study/Java-OO/src/source.csv";
        File inputPath = new File(inputStr);

        String parentPath = inputPath.getParent();
        Boolean outputDir = new File(parentPath + "/output").mkdir();
        String outputFileStr = parentPath + "/output/summary.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))){
            String line;

            while((line  = bufferedReader.readLine())  != null){
                String[] productArray = line.split(",");

                String name = productArray[0];
                Double price = Double.parseDouble(productArray[1]);
                Integer quantity = Integer.parseInt(productArray[2]);

                productList.add(new Product(name,price,quantity));
            }

            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileStr))){
                for(Product product: productList){
                    bufferedWriter.write(product.getName() + ", " + product.total());
                    bufferedWriter.newLine();
                }
                System.out.println("CREATED");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}

