package roomExercise;

import roomExercise.entities.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String name;
            String email;
            int numberOfRoom;

            System.out.print("How many rooms will be rented?");
            int numbersOfRents = sc.nextInt();
            sc.nextLine();

            Room[] rooms = new Room[9];

            for(int i = 0; i < numbersOfRents; i++){
                System.out.println("Rent #" + (i + 1) + ":");
                System.out.print("Name: ");
                name = sc.nextLine();

                System.out.print("Email: ");
                email = sc.nextLine();

                System.out.print("Room: ");
                numberOfRoom = sc.nextInt();

                sc.nextLine();

                rooms[numberOfRoom] = new Room(name,email,numberOfRoom);
            }

            for(int i = 0; i < rooms.length; i++){
                if(rooms[i] != null){
                    System.out.println(i + ": " + rooms[i].getName() + ", " + rooms[i].getEmail());
                }
            }
        sc.close();
    }
}

