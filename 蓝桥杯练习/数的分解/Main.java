public class Main {
    public static void main(String[] args) {
        int res = 0;
        for(int i = 1; i < 674; i++){
          int n = i;
          boolean nn = true;
          while(n > 0){
            if(n % 10 == 2 || n % 10 == 4)
              nn = false;
            n = n / 10;
          }

          if(nn == false)
            continue;

          for(int j = i + 1; j < 1009; j++){

            int m = j;
            boolean mm = true;

            while(m > 0){
            if(m % 10 == 2 || m % 10 == 4)
              mm = false;
            m = m / 10;
            }

            if(mm == false)
              continue;

            for(int k = j + 1; k < 2000; k++){

              int l = k;
              boolean ll = true;

              while(l > 0){
              if(l % 10 == 2 || l % 10 == 4)
                ll = false;
              l = l / 10;
              }

              if(ll == false)
                continue;

              if((i + j + k) == 2019)
                res++;
            }
              
          }
        }
        System.out.println(res);
    }
}