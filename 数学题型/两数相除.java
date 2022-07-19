class Solution {
    public int divide(int dividend, int divisor) {
        int res = 0;

        if(dividend == 0)
            return res;

        if(dividend > 2147483647 && divisor > 0)
            return 2147483647;

        if(dividend > 2147483647 && divisor < 0)
            return -2147483648;

        if(dividend < -2147483648 && divisor > 0)
            return -2147483648;
        
        if(dividend < -2147483648 && divisor < 0)
            return 2147483647;
        
        if(dividend > 0 && divisor > 0){
            while(dividend >= 0){
                dividend -= divisor;
                res++;
            }
            res--;
        }

        else if(dividend > 0 && divisor < 0){
            while(dividend >= 0){
                dividend += divisor;
                res--;
            }
            res++;
        }

        else if(dividend < 0 && divisor > 0){
            while(dividend <= 0){
                dividend += divisor;
                res--;
            }
            res++;
        }

        else if(dividend < 0 && divisor < 0){
            while(dividend <= 0){
                dividend -= divisor;
                res++;
            }
            res--;
        }

        return res;
        
    }
}