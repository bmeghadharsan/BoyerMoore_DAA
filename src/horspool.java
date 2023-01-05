import Horspool.StringMatchHorspool;
import Horspool.preprocess;

import java.util.Scanner;

public class horspool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_______________________________________________");
        System.out.print("Enter the input the string : ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern to be searched for : ");
        String pattern = scanner.nextLine();
        System.out.println("_______________________________________________");
        preprocess pp = new preprocess(pattern);
        System.out.println("Bad Character Heuristic Table");
        System.out.println(pp.badMatchTable);
        System.out.println(StringMatchHorspool.patternMatch(text,pattern,pp.badMatchTable));
    }
}