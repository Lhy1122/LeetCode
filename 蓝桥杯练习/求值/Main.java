public class Main {
    public static void main(String[] args) {
        int res = 0;

        for(int i = 10000; i < 100000; i++){
          int num = 0;
            for(int j = 1; j <= i; j++){
              if(i % j == 0){
                num++;
              }
            }
          if(num == 100){
            res = i;
            break;
          }
        }

        System.out.println(res);
    }
}