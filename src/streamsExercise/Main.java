package streamsExercise;

import streamsExercise.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        String path = "/home/victorreis/study/Java-OO/src/data.csv";

        System.out.print("Enter salary:");
        double salaryComparable = sc.nextDouble();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] employeeArray = line.split(",");

                String name = employeeArray[0];
                String email = employeeArray[1];
                Double salary = Double.parseDouble(employeeArray[2]);

                employeeList.add(new Employee(name,email,salary));
            }

            List<Employee> newList = employeeList.stream().filter(x -> x.getSalary() > salaryComparable).sorted((x,y) -> x.getEmail().toUpperCase().compareTo(y.getEmail().toUpperCase())).toList();
            double sumOfSalary = employeeList.stream().filter(x -> x.getName().charAt(0) == 'M').map(Employee::getSalary).reduce(0.0,(x, y) -> x + y );

            System.out.println("Email of people whose salary is more than 2000.00: ");
            for (Employee employee : newList){
                System.out.println(employee.getEmail());
            }
            System.out.print("Sum of salary of people whose name starts with 'M': ");
            System.out.printf("%.2f", sumOfSalary);

        }catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}
