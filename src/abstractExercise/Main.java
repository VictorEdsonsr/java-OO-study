package abstractExercise;

import abstractExercise.entities.Company;
import abstractExercise.entities.Individual;
import abstractExercise.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tax payers: ");
        int numberOftaxPayer = sc.nextInt();

        List<TaxPayer> taxPayerList = new ArrayList<>();

        for(int i = 1; i <= numberOftaxPayer; i++){
            System.out.println("Tax payer " + i + " data:");
            System.out.print("Individual or company (i/c): ");
            char option = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            switch (option){
                case 'i':
                case 'I':
                    System.out.print("Health expenditures: ");
                    Double healthExpenditures = sc.nextDouble();

                    taxPayerList.add(new Individual(name,anualIncome,healthExpenditures));
                    break;
                case 'c':
                case 'C':
                    System.out.print("Number of employees: ");
                    Integer numberOfEmployees = sc.nextInt();

                    taxPayerList.add(new Company(name,anualIncome,numberOfEmployees));
                    break;
                default:
                    break;
            }
        }


        System.out.println("TAX PAID:");
        for(TaxPayer taxPayer : taxPayerList){
            System.out.println(taxPayer.getName() + ": $" + String.format("%.2f",taxPayer.tax()));
        }

        Double totalTaxes = 0.0;
        System.out.print("TOTAL TAXES: ");
        for(TaxPayer taxPayer : taxPayerList){
            totalTaxes += taxPayer.tax();
        }
        System.out.println();
        System.out.print("$" + totalTaxes);

        sc.close();
    }

}

