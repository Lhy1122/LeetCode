import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] a = new int[8][8];

        int head = 1;
        int tail = 49;

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (j <= 3) {
                    a[i][j] = head++;
                }else {
                    a[i][j] = tail--;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            Arrays.sort(a[i]);
        }

        int ans = a[4][4];

        System.out.println(ans);
    }
}