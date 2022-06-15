import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int sum = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int k = i + j;
                String a = "" + i + j + k;
                char [] b = a.toCharArray();
                Arrays.sort(b);
                String s = String.valueOf(b);
                if (s.equals("123456789") && i + j == k) {
                    sum++;
                }
            }
        }
        
        System.out.println(sum);
    }
}