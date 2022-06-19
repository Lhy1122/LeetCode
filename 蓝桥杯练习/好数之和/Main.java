import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long m = sc.nextLong();
        long n = sc.nextLong();

        sc.close();

        long res = 0;

        if(m < 2022 && n > 2022)
            m = 2022;

        for(long i = m; i <= n; i += 1){
            String num = "" + i;

            for(int j = 0; j < num.length() - 3; j++){
                String arr = "";
                char a = num.charAt(j);
                char b = num.charAt(j + 1);
                char c = num.charAt(j + 2);
                char d = num.charAt(j + 3);
                String aa = "" + a;
                String bb = "" + b;
                String cc = "" + c;
                String dd = "" + d;
                arr = arr + aa + bb + cc + dd;
                if(arr.equals("2022")){
                    res += i;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}