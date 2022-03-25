import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(9);
        for(int i = 1; i < 2020; i++){
          int n = i;
          while(n > 0){
            if(list.contains(n % 10)){
              res += i;
              break;
            }
            n = n / 10;
          }
        }
        System.out.println(res);
    }
}