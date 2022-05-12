import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>(T);

        while(T > 0){
            int n = sc.nextInt();
            res.add(homo(n));
            T--;
        }
        sc.close();

        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    public static int homo(int num){

        if(num == 1)
            return 1;
        if(num == 2)
            return 2;
        if(num == 3)
            return 3;
        if(num == 4)
            return 3;
        
        int res = 0;
        while(num > 4){
            if(pan(num) == true){
                res = num;
                break;
            }
            else
                num--;
        }

        return res;
        
    }

    public static boolean pan(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}