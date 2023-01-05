import BoyerMoore.preprocessing.preprocessor;
import BoyerMoore.boyerMoore;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_______________________________________________");
        System.out.print("Enter the input the string : ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern to be searched for : ");
        String pattern = scanner.nextLine();
        System.out.println("_______________________________________________");
        preprocessor pp = new preprocessor(pattern);
        System.out.println("Bad Character Heuristic Table");
        System.out.println(pp.badCharacterHeuristic);
        List<Integer> answer = boyerMoore.solve(pattern,text,pp.badCharacterHeuristic);
        if(answer.size()==0){
            System.out.println("Pattern Not found");
            System.out.println("_______________________________________________");
            System.out.println("Brute force comparisons needed : "+boyerMoore.naiveSolve(pattern,text));
            return;
        }
        System.out.println("Pattern found in the following indexes : "+answer);
        System.out.println("_______________________________________________");
        System.out.println("Brute Force Method : ");
        System.out.println("Brute force comparisons needed : "+boyerMoore.naiveSolve(pattern,text));
    }
}