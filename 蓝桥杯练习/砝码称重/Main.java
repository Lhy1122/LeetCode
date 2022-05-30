import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      HashSet<Integer> set = new HashSet<Integer>();

      int fama [] = new int [n];

      for(int i = 0; i < n; i++){
        
        fama[i] = sc.nextInt();

      }

      set.add(0);
      for(int i = 0; i<n; i++){

        List<Integer> list = new ArrayList<>(set);
        for(int k : list){

          set.add(fama[i] + k);
          set.add(Math.abs(fama[i] - k));

        }
      }
      set.remove((Object)0);

      System.out.println(set.size());

    }
}