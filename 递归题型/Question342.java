class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0 || n == 2 || n == 3)
            return false;

        if(n == 1)
            return true;

        while(n >= 4 && n % 4 == 0){
            n = n / 4;
            if(n == 1)
                return true;
        }

        return false;
    }
}