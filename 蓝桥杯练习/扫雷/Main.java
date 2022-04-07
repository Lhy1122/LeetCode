import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] list = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                list[i][j] = scan.nextInt();
            }
        }

        scan.close();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
            int x = 0;
            if(list[i][j] == 1){
              x = 9;
            }
            else{
            if(i > 0 && j > 0 && list[i-1][j-1] == 1)
              x++;
            if(i > 0 && list[i-1][j] == 1)
              x++;
            if(j > 0 && list[i][j-1] == 1)
              x++;
            if(i > 0 && j < n - 1 && list[i-1][j+1] == 1)
              x++;
            if(i < m -1 && j > 0 && list[i+1][j-1] == 1)
              x++;
            if(j < n - 1 && list[i][j+1] == 1)
              x++;
            if(i < m - 1 && list[i+1][j] == 1)
              x++;
            if(i < m - 1 && j < n - 1 && list[i+1][j+1] == 1)
              x++;
            }

            arr.add(x);

          }
        }

        for(int i = 1; i <= m * n; i++){
            if(i % 4 == 0)
                System.out.println(arr.remove(0));
            else
                System.out.print(arr.remove(0) + " "); 
            
        }

    }
}