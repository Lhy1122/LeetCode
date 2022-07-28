class Solution {
    public void reverseString(char[] s) {
        int size = s.length;
        char k;

        if(size % 2 == 0){
            int s1 = size / 2;
            int f = 0;
            while(s1 > 0){
                k = s[f];
                s[f] = s[size - 1];
                s[size - 1] = k;

                f++;
                size--;
                s1--;
            }
        }
        else{
            int s2 = size / 2;
            int f = 0;
            while(s2 > 0){
                k = s[f];
                s[f] = s[size - 1];
                s[size - 1] = k;

                f++;
                size--;
                s2--;
            }
        }

        return;
    }
}