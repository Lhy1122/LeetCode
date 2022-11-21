class Solution {
    public String countAndSay(int n) {
        String str = "1";
        String res = "";

        while(n > 1){
            int num = 1;
            for(int i = 0; i < str.length(); i++){
                if(i == str.length() - 1){
                    res += num + "";
                    res += str.charAt(i);
                }
                else{
                    if(str.charAt(i) != str.charAt(i + 1)){
                        res += num + "";
                        res += str.charAt(i);
                        num = 1;
                    }
                    else{
                        num ++;
                    }
                }
            }
            
            str = res;
            res = "";
            
            n--;
        }

        return str;
    }
}