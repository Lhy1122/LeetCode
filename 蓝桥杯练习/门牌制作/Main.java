public class Main {
    public static void main(String[] args) {
        int a = 0;
        for(int i = 1; i < 2021; i++){
          int n = i;
          while(n > 0){
            if(n % 10 == 2)
              a++;
            n = n / 10;
          }
        }
        System.out.println(a);
    }
}