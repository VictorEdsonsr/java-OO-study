package setExercise;

import setExercise.entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> studentSet = new HashSet<>();
        int code = 0;

        System.out.print("How many students for course A? ");
        int courseA = sc.nextInt();
        for (int i = 0; i < courseA; i++) {
            code = sc.nextInt();
            studentSet.add(new Student(code));
        }

        System.out.print("How many students for course B? ");
        int courseB = sc.nextInt();
        for (int i = 0; i < courseB; i++) {
            code = sc.nextInt();
            studentSet.add(new Student(code));
        }

        System.out.print("How many students for course C? ");
        int courseC = sc.nextInt();
        for (int i = 0; i < courseC; i++) {
            sc.nextLine();
            code = sc.nextInt();
            studentSet.add(new Student(code));
        }

        System.out.println("Total Students " + studentSet.size());

        sc.close();
    }
}

/*
OTHER SOLUTION
* Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();

		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			a.add(number);
		}

		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			b.add(number);
		}

		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			c.add(number);
		}

		Set<Integer> total = new HashSet<>(a);
		total.addAll(b);
		total.addAll(c);

		System.out.println("Total students: " + total.size());
* */

