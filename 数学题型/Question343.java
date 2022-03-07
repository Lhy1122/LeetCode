class Solution {
    public int integerBreak(int n) {
        int a = 1;
        if(n == 2)
            return 1;

        if(n == 3)
            return 2;

        while(n > 4){
            n -= 3;
            a = a*3;
        }

        if(n == 2)
            a = a*2;
        
        if(n == 3)
            a = a*3;

        if(n == 4)
            a = a*4;

        return a;
    }
}