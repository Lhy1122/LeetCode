import java.util.ArrayList;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    public void dfs(int left, int right, String plu){
        if(left == 0 & right == 0){
            res.add(plu);
            return;
        }

        if(left > 0){
            dfs(left - 1, right, plu + "(");
        }

        if(right > left){
            dfs(left, right - 1, plu + ")");
        }
    }        
}