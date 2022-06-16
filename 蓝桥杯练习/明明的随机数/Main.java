import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m, sum = 0;
        int a[] = new int[1000];
        for(int i = 0; i < n; i++){
          m = in.nextInt();
          a[m] = 1;
        }
        for(int i = 0; i < 1000; i++){
          if(a[i] == 1){
              sum++;
          }
        }
        System.out.println(sum);
        for(int i = 0; i < 1000; i++){
            if(a[i] == 1){

              System.out.print(i + " ");

            }
          }
        in.close();
    }
}