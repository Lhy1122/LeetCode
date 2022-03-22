import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min = 0;
        int max = 0;
        int sum = 0;
        int m = scan.nextInt();
        max = m;
        min = m;
        sum += m;
        while(scan.hasNext()){
          int i = scan.nextInt();
          sum += i;
          if(i < min)
            min = i;
          if(i > max)
            max = i;
        }

        double su = (double) sum;
        double nn = (double) n;
        su = su / nn;

        System.out.println(max);
        System.out.println(min);
        System.out.println(String.format("%.2f",su));

        scan.close();
    }
}