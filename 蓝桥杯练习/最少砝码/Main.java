import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        int i = 1;
        int res = 1;
        while(i < n){
            i = i * 3 + 1;
            res++;
        }
        
        System.out.println(res);
        
    }
}