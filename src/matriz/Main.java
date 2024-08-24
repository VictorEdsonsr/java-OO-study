package matriz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numbers of lines: ");
        int column = sc.nextInt();

        System.out.print("Numbers of columns: ");
        int line = sc.nextInt();

        int[][] numbers = new int[line][column];

        System.out.print("position of repeater number: ");
        int repeater = sc.nextInt();

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers[i].length; j++){
                numbers[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers[i].length; j++){
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers[i].length; j++){
                if(numbers[i][j] == repeater){
                    System.out.println("Position: " + i + "," + j);
                    if(j > 0){
                        System.out.println("Left: " + numbers[i][j - 1]);
                    }

                    if(i > 0){
                        System.out.println("Top: " + numbers[i - 1][j]);
                    }

                    if(j > numbers[i].length-1){
                        System.out.println("Right: " + numbers[i][j + 1]);
                    }

                    if(i > numbers.length-1){
                        System.out.println("Bottom: " + numbers[i + 1][j]);
                    }
                }
            }
        }

        sc.close();
    }
}

