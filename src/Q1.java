import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void function(List<Integer> number, int target, List<Integer> partial){
        int sum = 0,n;
        for(int i:partial){
            sum = sum + i;
        }
        if(sum==target) {
            System.out.println();
            System.out.println("⭐⭐⭐ Solution found: " + partial + " ⭐⭐⭐");
            System.out.println();
        }
        if(sum>=target)
            return;
        for(int i=0;i<number.size();i++){
            n = number.get(i);
            List<Integer> temp = new ArrayList<>(partial);
            temp.add(n);
            System.out.println("Checking the tree with root : "+temp);
            function(number.subList(i+1,number.size()),target,temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 9, 10, 1, 99, 3, 2, 4);
        List<Integer> partial = new ArrayList<>();
        function(input,0,partial);
    }
}
