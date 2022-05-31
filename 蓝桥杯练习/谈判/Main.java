import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer>a=new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int a1=sc.nextInt();
            a.add(a1);
        }
        sort(a);
        int sum;
        int count=0;
        for (int i = 0; i < n-1; i++){
            sum=a.get(0)+ a.get(1);
            a.remove(1);
            a.remove(0);
            a.add(sum);
            sort(a);
            count+=sum;
        }
        System.out.println(count);
    }
}