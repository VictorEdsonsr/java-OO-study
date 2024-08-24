package listExercise;

import listExercise.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        String name;
        int id;
        double salary;
        double increase;
        int idIncrease;

        System.out.print("How many employees will be registered: ");
        int employeeNumbers = sc.nextInt();

        for(int i = 0; i < employeeNumbers; i++){
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Salary: ");
            salary = sc.nextDouble();

            employees.add(new Employee(id,name,salary));
        }

        System.out.print("Enter employee id that will have salary increase: ");
        idIncrease = sc.nextInt();

        System.out.print("Enter the percentage: ");
        increase = sc.nextDouble();

        employees.stream().filter(x -> x.getId().equals(idIncrease)).findFirst().ifPresent(increaseEmployee -> increaseEmployee.increaseSalary(increase));

        for(Employee employee : employees){
            System.out.println(employee.getId() + ", " + employee.getName() + ", " + String.format("%.2f", employee.getSalary()) );
        }

        sc.close();
    }
}

