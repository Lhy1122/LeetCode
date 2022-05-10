import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[][] f = new int[n][3];
        for (int i = 0; i < n; i++) {
            f[i][0] = scan.nextInt();
            f[i][1] = scan.nextInt();
            f[i][2] = scan.nextInt();
        }
        Arrays.sort(f, (a, b) -> a[0] + a[1] + a[2] - b[0] - b[1] - b[2]);
        long ans = 0;
        long curTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                curTime += f[i][j];
                if (j == 1) ans += curTime;
            }
        }
        System.out.println(ans);
        scan.close();
    }
}