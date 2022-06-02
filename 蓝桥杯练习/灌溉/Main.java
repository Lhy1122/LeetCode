import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int t=sc.nextInt();
        int a[][]=new int[n+1][m+1];

        a[sc.nextInt()][sc.nextInt()] = 2;
        a[sc.nextInt()][sc.nextInt()] = 2;

        int k = sc.nextInt();
        int sum = t;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a[i][j] == 2 ) {
                    if(i - 1 >= 1 && a[i-1][j] == 0) {a[i-1][j] = 1; sum++;}
                    if(j - 1 >= 1 && a[i][j-1] == 0) {a[i][j-1] = 1; sum++;}
                    if(i + 1 <= n && a[i+1][j] == 0) {a[i+1][j] = 1; sum++;}
                    if(j + 1 <= m && a[i][j+1] == 0) {a[i][j+1] = 1; sum++;}
                }
            }
        }
        
        System.out.println(sum);
    }
}