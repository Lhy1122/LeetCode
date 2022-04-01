import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        long n = 2021041820210418l;
        ArrayList<Long> list = new ArrayList<>();

        for(long L = 1; L <= Math.sqrt(n); L++){
          if(n % L == 0){
            list.add(L);
            long m = n / L;
            list.add(m);
          }
        }
        
        int res = 0;

        for(long a : list ){

          for(long b : list ){

            for(long c : list ){
              if(a * b * c == n)
                res++;
            }
          }
        }

        System.out.println(res);
    }
}