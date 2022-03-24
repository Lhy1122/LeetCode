import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        int n = 3;
        while (n < 5000){
          for(int i = 2; i < n; i++){
            if(i == n - 1){
              list.add(n);
              n++;
              break;
            }
            if(n % i == 0){
              n++;
              break;
            }
            if(n % i != 0)
              continue;
          }
          
        }
        int res = 0;
        for(int j = 11; j < 300; j++){
          for(int i = 1; i < 660; i++){
            int sum = list.get(i);
            for(int c = 1; c <= 10; c++){
              if(c == 10){
                res = j;
                break;
              }
              if(list.contains(sum + j) == true){
                sum += j;
              }
              else
                break;
            }
            if(res == 10)
              break;
          }
          if(res == 10)
            break;
        }
        System.out.println(res);
    }
}