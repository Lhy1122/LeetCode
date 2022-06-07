import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int t = sc.nextInt();

        int addMinute = t / 60;
        int second = t % 60;

        if (second + b > 60) {
            addMinute++;
        }
        
        System.out.println(a + addMinute);
        System.out.println((b + second) % 60);
        sc.close();
    }
}