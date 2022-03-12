class Solution {

    public int get(int e){
        
        if(e == 3)
            return 3;

        if(e == 4)
            return 5;
        return get(e - 1) + get(e - 2);
    }


    public int climbStairs(int n) {
        if(n == 1)
            return n;

        if(n == 2)
            return n;

        return get(n);
    }
}