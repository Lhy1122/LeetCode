import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String res = "";
    
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = n;
        scan.close();

        
        ArrayList<String> tiangan = new ArrayList<>(){
            {
            this.add("jia");
            this.add("yi");
            this.add("bing");
            this.add("ding");
            this.add("wu");
            this.add("ji");
            this.add("geng");
            this.add("xin");
            this.add("ren");
            this.add("gui");
            }
        };
        

        ArrayList<String> dizhi = new ArrayList<>(){
            {
                this.add("zi");
                this.add("chou");
                this.add("yin");
                this.add("mao");
                this.add("chen");
                this.add("si");
                this.add("wu");
                this.add("wei");
                this.add("shen");
                this.add("you");
                this.add("xu");
                this.add("hai");
            }
        };

        res += tiangan.get((n + 6) % 10);
        res += dizhi.get((m + 8) % 12);

        System.out.println(res);
    }
}