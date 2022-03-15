class Solution {
    public int uniquePaths(int m, int n) {
        int a = m + n - 2;
        int b = 0;
        if(m <= n)
            b = m - 1;
        if(n < m)
            b = n - 1;
        
        if(m == 1 || n == 1)
            return 1;

        
        long aa = (int)a;
        long bb = (int)b;
        long ress = 1;
        long ss = 1;

        for(long i = 1; i < bb + 1; i++)
            ss = ss * i;

        for(long i = aa; i > aa - bb; i--)
            ress *= i;

        long c = ress/ss;

        int cc = (int)c;

        return cc;

    }
}