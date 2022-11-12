import java.util.ArrayList;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0)
            return res;

        int plu = words[0].length();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            list.add(words[i]);
        }

        List<String> arr = new ArrayList<>();
        loop:for(int i = 0; i <= s.length() - words.length * plu; i ++){
            if(!list.contains(s.substring(i, i + plu)))
                continue;
            arr = new ArrayList<>();
            arr.addAll(list);
            int k = i;
            for(int j = 0; j < words.length; j++){
                String ss = s.substring(k, k + plu);
                if(arr.contains(ss)){
                    
                    arr.remove(ss);
                    k += plu;
                }
                else{
                    continue loop;
                }
            }
            res.add(i);
        }
        return res;
    }
}