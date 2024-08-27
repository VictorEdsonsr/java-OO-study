package exceptionExample;

import exceptionExample.model.entities.Reservation;
import exceptionExample.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();

            sc.nextLine();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            String chekinString = sc.nextLine();
            LocalDate chekinDate = LocalDate.parse(chekinString, formatter);

            System.out.print("Check-in date (dd/MM/yyyy): ");
            String chekoutString = sc.nextLine();
            LocalDate chekoutDate = LocalDate.parse(chekoutString, formatter);

            Reservation reservation = new Reservation(roomNumber,chekinDate,chekoutDate);

            System.out.println();

            System.out.println(reservation.toString());

            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            String chekinUpdateString = sc.nextLine();
            LocalDate chekinUpdateDate = LocalDate.parse(chekinUpdateString, formatter);

            System.out.print("Check-in date (dd/MM/yyyy): ");
            String chekoutUpdateString = sc.nextLine();
            LocalDate chekoutUpdateDate = LocalDate.parse(chekoutUpdateString, formatter);

            reservation.updateDates(chekinUpdateDate,chekoutUpdateDate);

            System.out.println();

            System.out.println(reservation.toString());

        }catch (DomainException error){
            System.out.println("Error in reservation: " + error.getMessage());
        }

        sc.close();
    }

}

