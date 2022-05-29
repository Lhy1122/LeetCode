import java.util.Scanner;

public class Main{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        
        int res = n;
        while(n > 2){
            int num = n / 3;
            res += num;
            n = n % 3 + num;
        }

        
        System.out.println(res);
    }
}