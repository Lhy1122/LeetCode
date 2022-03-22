import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int c = 0;
        int a = 0;
        while(scan.hasNext()){
          int i = scan.nextInt();
          if(i >= 60)
            c++;
          if(i >= 85)
            a++;
        }

        double aa = a * 100;
        double cc = c * 100;

        System.out.println(Math.round(cc / all) + "%");
        System.out.println(Math.round(aa / all) + "%");
        scan.close();
    }
}