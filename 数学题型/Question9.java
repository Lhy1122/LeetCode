class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x == 0)
            return true;

        int n = x;
        int m = x;

        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        while(x != 0){
            list.add(x % 10);
            x = x / 10;
        }

        int b = 1;
        while(n / 10 != 0){
            b = 10 * b;
            n = n / 10;
        }
        for(int i = b; i > 0; i = i / 10){
            res.add(m / i);
            m = m % i;
        }

        if(res.equals(list))
            return true;

        return false;

    }
}