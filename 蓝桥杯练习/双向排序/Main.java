import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        m = 0;
        int[] list = new int[n];
        for(int i = 1; i <= n; i++)
          list[i - 1] = i;
        
        while(scan.hasNext()){
          
          if(scan.nextInt() == 0){
            int i = scan.nextInt();
            Arrays.sort(list, 0, i);
            int j = (i - 1) / 2;
            int c = 0;
            while(c <= j){
                int e = list[c];
                list[c] = list[i - c - 1];
                list[i - c - 1] = e;
                c++;
            }
          }

          else{
            int i = scan.nextInt();
            Arrays.sort(list, i - 1, n);
          }
          
        }
        scan.close();

        for(int z = 0; z < n; z++)
          System.out.print(list[z] + " ");
    }
}