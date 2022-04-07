import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        int res = 0;

        for(int i = 0; i < str.length() - 1; i++){
            for(int j = i + 1; j < str.length(); j++){
                char aa = str.charAt(i);
                char bb = str.charAt(j);
                String a = String.valueOf(aa);
                String b = String.valueOf(bb);
                if(a.hashCode() >= b.hashCode()){
                    res += a.hashCode() - b.hashCode();
                }
                else{
                    res += b.hashCode() - a.hashCode();
                }

            }
        }

        System.out.println(res);
    }
}