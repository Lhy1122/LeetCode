import java.util.Scanner;

public class Main {

    static int[] a=new int[3];
    static int res=0;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        for(int i=0;i<3;i++) {
            a[i]=sc.nextInt();
            sum=sum+a[i];
        }
        dfs(sum, 0, -1);
        System.out.println(res);
        sc.close();
    }

    static void dfs(int sum,int x,int last) {
        if(sum==0) {
            res++;
            return;
        }
        for(int i=0;i<3;i++) {
            if(i==last) 
                continue;
            
            for(int j=x+1;j<=a[i];j++) {
                a[i]-=j;
                if(sum>=j) 
                    dfs(sum-j, j, i);
                a[i]+=j;
            }
        }
    }
}