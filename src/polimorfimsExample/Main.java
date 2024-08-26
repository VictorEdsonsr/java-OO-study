package polimorfimsExample;

import polimorfimsExample.entities.Employees;
import polimorfimsExample.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers of employees: ");
        int numbersOfEmployees = sc.nextInt();

        List<Employees> employeesList = new ArrayList<>();

        for(int i = 1; i<=numbersOfEmployees;i++){
            System.out.print("Outsourced (y/n)?");
            char outsourced = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours:");
            Integer hours = sc.nextInt();

            System.out.print("Value per hour:");
            Double valuePerHour = sc.nextDouble();

            Double additionalCharge = null;

            if(outsourced == 'y' || outsourced == 'Y'){
                System.out.print("Additional charge: ");
                additionalCharge = sc.nextDouble();

                employeesList.add(new OutsourcedEmployee(name,hours,valuePerHour,additionalCharge));
            }else{
                employeesList.add(new Employees(name,hours,valuePerHour));
            }

        }

        System.out.println("PAYMENTS: ");
        for(Employees employee : employeesList){
            System.out.println(employee.getName() + " - " + "$" + String.format("%.2f",employee.payment()));
        }

        sc.close();
    }

}

