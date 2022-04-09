import java.util.*;

public class Main {
    static int N=(int)2e6;
    static long[] a=new long[N];
    static long f(long x) {
        long l=1;
        long r=(long)3e6;
        while(l<r) {
            long mid=(l+r+1)>>1;
            if((mid+1)*mid<x*2)l=mid;
            else r=mid-1;
        }
        return l;
    }
    static long sum(long x) {
        return x*(x+1)/2;
    }
    static long ans(long x) {
        if(x==0)return 0;
        if(x==1)return 1;
        long y=f(x);
        return a[(int)y]+sum(x-sum(y));
    }
    static void pre() {
        for(int i=1;i<N;i++) {
            a[i]=a[i-1]+sum(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        pre();
        while(t-->0) {
            long l=sc.nextLong();
            long r=sc.nextLong();
            System.out.println(ans(r)-ans(l-1));
        }

    }

}