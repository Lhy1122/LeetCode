public class Main {
    public static void main(String[] args) {
        int a1 = 1;
        int a2 = 1;
        int a3 = 1;
        
        for(int i = 4; i < 20190325; i++){
          int n = (a1 + a2 + a3) % 10000;
          a1 = a2;
          a2 = a3;
          a3 = n;
        }

        System.out.println(a3);
    }
}