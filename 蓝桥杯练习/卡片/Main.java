public class Main {
    public static void main(String[] args) {
        int a = 2021;
        int b = 1;
        while(a > -1){
          int n = b;
          while(n > 0){
            if(n % 10 == 1){
              a--;
            }
            n = n / 10;
          }
          b++;

        }
        System.out.println(b - 2);
    }
}