class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length == 1)
            return;
        
        int a = s.length - 1;
	
        for(int i = 0; i <= a; i++, a--){
            char temp = s[i];
            s[i] = s[a];
            s[a] = temp;
        }
    }
}