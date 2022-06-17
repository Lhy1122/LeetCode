import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arr = scan.next();
        scan.close();

        int n = arr.length();
        int res1 = 0;
        int res2 = 0;

        for(int i = 0; i < n; i++){
          char nn = arr.charAt(i);

          if(nn == 'a' || nn == 'e' || nn == 'i' || nn == 'o' || nn == 'u'){
            res1++;
          }
          else{
            res2++;
          }
        }

        System.out.println(res1);
        System.out.println(res2);

    }
}