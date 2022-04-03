import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();

        int n = str.length();
        char[] aa = new char[n];
        for(int i = 0; i < n; i++){
            aa[i] = str.charAt(i);
        }

        int res = 0;

        for(int i = 1; i <= n; i++ ){

            for(int j = 1; j <= n + 1 - i; j++){

                ArrayList<Character> arr = new ArrayList<>();
                int t = i;
                int h = j - 1;

                while(t > 0){
                    
                    arr.add(aa[h]);
                    t--;
                    h++;
                }

                res += check(arr);

            }
        }

        System.out.println(res);


    }
    public static int check(ArrayList<Character> arr){
        int sum = 0;
        while(arr.size() > 0){
            char n = arr.get(0);
            arr.remove(0);
            if(arr.size() == 0){
                sum++;
                break;
            }
            if(arr.contains(n) == true){
                while(arr.contains(n))
                    arr.remove(arr.indexOf(n));
            }
            else{
                sum++;
            }
        }
        return sum;
    }
}