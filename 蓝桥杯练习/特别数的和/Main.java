import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        int res = 0;

        for(int i = 1; i <= n; i++){
          int m = i;
          while(m > 0){
            if(m % 10 == 1 || m % 10 == 2 || m % 10 == 9 || m % 10 == 0){
              res += i;
              break;
            }

            m /= 10;
          }
        }

        System.out.println(res);
    }
}