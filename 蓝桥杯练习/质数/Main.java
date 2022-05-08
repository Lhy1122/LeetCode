import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int i = 2;
        int loop = 1;
        while(loop < 2019) {
            i++;
            if(isZhishu(i)) {
                loop++;
            }
        }
        System.out.println(i);
        
        scan.close();
    }
    public static boolean isZhishu(int num) {
        boolean res = true;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
