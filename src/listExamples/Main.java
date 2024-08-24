package listExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> pessoas = new ArrayList<>();

        pessoas.add("victor");
        pessoas.add("thalyta");
        pessoas.add("valentin");
        pessoas.add("vinicius");
        pessoas.add("thifanny");
        pessoas.add("tatiana");
        pessoas.add("joao");
        pessoas.add("jackson");

        for(String pessoa : pessoas){
            System.out.println(pessoa);
        }

        System.out.println("--------------------------------------------");

        pessoas.remove("victor");
        pessoas.remove(0);
        pessoas.removeIf(p -> p.charAt(0) == 'j');

        for(String pessoa : pessoas){
            System.out.println(pessoa);
        }

        System.out.println("--------------------------------------------");

        List<String> results = pessoas.stream().filter(p -> p.charAt(0) == 't').collect(Collectors.toList());

        for(String result : results){
            System.out.println(result);
        }


    }
}

