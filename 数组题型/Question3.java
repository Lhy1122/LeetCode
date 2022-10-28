import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        int res = 0;
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++){
            list.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++){
                if(list.contains(s.charAt(j))){
                    if(res < list.size())
                        res = list.size();

                    break;
                }
                else{
                    list.add(s.charAt(j));
                    if(j == s.length() - 1){
                        if(res < list.size())
                        res = list.size();
                    }
                }
            }
            list = new ArrayList<>();
        }

        return res;
    }
}