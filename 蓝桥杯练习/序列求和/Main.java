public class Main {
    public static void main(String[] args) {
        int res = 0;
        
        for(int i = 1; i <= 17; i++){

          for(int j = 1; j < 100000000; j++){
            int n = 0;
            for(int m = 1; m <= j; m++){
              if(j % m == 0){
                n++;
              }
            }

            if(n == i){
              res += j;
              break;
            }
            
          }

        }

        System.out.println(res);
    }
}