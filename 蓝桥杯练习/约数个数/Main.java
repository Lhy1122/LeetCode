import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        sc.close();

        double res = 0;

        double max = 0;
        if(a > max)
            max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;

        for(double i = 1; i <= max; i++){
            if(a % i == 0 && b % i == 0){
                res++;
                continue;
            }
            if(a % i == 0 && c % i == 0){
                res++;
                continue;
            }
            if(b % i == 0 && c % i == 0){
                res++;
                continue;
            }
        }

        int ress = (int)res;

        System.out.println(ress);
	}
}