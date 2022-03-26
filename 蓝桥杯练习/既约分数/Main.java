public class Main {

    public static boolean pan(int i , int j){
      int max = 0;
      int min = 0;
      if(i >= j){
        max = i;
        min = j;
      }
      else{
        max = j;
        min = i;
      }

      for(int a = 1; a <= min; a++){
        if(a == 1)
          continue;
        if(max % a == 0 && min % a == 0)
          return false;
      }

      return true;
    }

    public static void main(String[] args) {
        int res = 0;
        for(int i = 1; i <= 2020; i++){
          for(int j = 1; j <= 2020; j++){
            if(pan(i,j))
              res++;
          }
        }
        System.out.println(res);
    }
}