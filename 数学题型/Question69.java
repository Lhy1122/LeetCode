class Solution {
    public int mySqrt(int x) {
        String str = String.valueOf(x);
        long value = Long.parseLong(str);
        long a = 1;
        long i = 0;
        while(a * a <= value ){
            a++;
            i++;
        }
        int res = (int)i;
        return res;
    }
}