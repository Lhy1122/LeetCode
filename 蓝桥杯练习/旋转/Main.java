import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]arr = new int[m][n];
        int hang = 0;
        int lie = n - 1;
        while(lie >= 0) {
            arr[hang][lie] = sc.nextInt();
            if(hang == m - 1) {
                hang = 0 ;
                lie--;
            }
            else {
                hang++;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}