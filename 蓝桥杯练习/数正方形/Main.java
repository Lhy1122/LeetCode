import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        long sum = 0;
        int x = (int)Math.pow(10, 9) + 7;

        for(int i = 1; i <= n; i++){
            sum += (long) i * (long) (n-i)* (long) (n-i);
            sum %= x;
        }

        System.out.println(sum);
        
    }
}