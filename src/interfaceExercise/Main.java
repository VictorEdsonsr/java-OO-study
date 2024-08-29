package interfaceExercise;

import interfaceExercise.model.entities.Contract;
import interfaceExercise.model.entities.Installments;
import interfaceExercise.model.services.ContractService;
import interfaceExercise.model.services.PaypalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número: ");
        Integer number = sc.nextInt();

        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy):");
        String date = sc.nextLine();

        System.out.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number,date,totalValue);

        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, n);

        System.out.println("Parcelas:");
        for (Installments installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        System.out.println(contract.getDate());
        sc.close();
    }
}

