import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(Yang(res,n));
    }

    public static int Yang(List<List<Integer>> res, int n){
        if(n<4)
            return 1;
        List<Integer> t = new ArrayList<>();
        t.add(1);
        res.add(new ArrayList<>(t));
        t.add(1);
        res.add(new ArrayList<>(t));
        int idx = 3;
        boolean flag=false;
        for (int i=2;i<10000;i++){
            List<Integer> r = new ArrayList<>();
            r.add(1);
            idx++;
            for (int j=0;j<i-1;j++){
                if(n==(res.get(i - 1).get(j)+ res.get(i-1).get(j+1))){
                        flag = true;
                        idx++;
                        break;
                }
                r.add(res.get(i - 1).get(j)+ res.get(i-1).get(j+1));
                idx++;
            }
            if (flag)
                break;
            r.add(1);
            idx++;
            res.add(new ArrayList<>(r));
        }
        return idx;

    }
}