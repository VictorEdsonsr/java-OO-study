package mapExercise;

import mapExercise.entities.President;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<President, Integer> votationsList= new LinkedHashMap<>();

        String path = "/home/victorreis/study/Java-OO/src/presidents.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] votationArray = line.split(",");
                String name = votationArray[0];
                int numberVotations = Integer.parseInt(votationArray[1]);

                if(votationsList.containsKey(new President(name))){
                    int voteAcumulation = votationsList.get(new President(name));
                    votationsList.put(new President(name), numberVotations + voteAcumulation);
                }else {
                    votationsList.put(new President(name), numberVotations);
                }
            }

            for (President votes : votationsList.keySet()){
                System.out.println(votes.getName() + ": " + votationsList.get(votes));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}