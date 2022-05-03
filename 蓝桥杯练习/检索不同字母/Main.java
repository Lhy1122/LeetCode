import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        sc.close();

        int[] aa = new int[26];
        int[] bb = new int[26];
        for(int i = 0; i < 26; i++){
            aa[i] = 0;
            bb[i] = 0;
        }

        for(int i = 0; i < first.length(); i++){
            int a1 = first.charAt(i) - 'a';
            aa[a1]++;
        }

        for(int i = 0; i < second.length(); i++){
            int b1 = second.charAt(i) - 'a';
            bb[b1]++;
        }

        boolean res = true;
        for(int i = 0; i < 26; i++){
            if(aa[i] != bb[i])
                res = false;
        }

        System.out.println(res);
    }
}