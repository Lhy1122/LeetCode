import java.util.Scanner;

public class Main {
    private static char[][] m;
    private static int[][] n;
    private static int ans;

    public static void main(String[] args) {
        String[] a = new String[10];
        m = new char[10][10];
        n = new int[10][10];
        a[0] = "UDDLUULRUL";
        a[1] = "UURLLLRRRU";
        a[2] = "RRUURLDLRD";
        a[3] = "RUDDDDUUUU";
        a[4] = "URUDLLRRUU";
        a[5] = "DURLRLDLRL";
        a[6] = "ULLURLLRDU";
        a[7] = "RDLULLRDDD";
        a[8] = "UUDDUDUDLL";
        a[9] = "ULRDLUURRR";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] = a[i].charAt(j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                f(i, j);
            }
        }
        System.out.println(ans);

    }

    private static void f(int i, int j) {
        if (i < 0 || i == 10 || j < 0 || j == 10) {
            ans++;
            return;
        }
        if (n[i][j] == 1)
            return;
        n[i][j] = 1;
        switch (m[i][j]) {
        case 'U':
            f(i - 1, j);
            break;
        case 'D':
            f(i + 1, j);
            break;
        case 'L':
            f(i, j - 1);
            break;
        case 'R':
            f(i, j + 1);
            break;
        default:
            break;
        }
        n[i][j] = 0;

    }
}