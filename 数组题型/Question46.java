import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            list = new ArrayList<>();
            list.add(nums[i]);
            res.add(list);
        }

        int times = len - 1;
        return dfs(res, nums, len, times);

        
    }

    public List<List<Integer>> dfs(List<List<Integer>> list, int[] nums, int len, int times){
        if(times == 0)
            return list;
        List<List<Integer>> list1 = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++){
            List<Integer> list2 = new ArrayList<>();
            for(int j = 0; j < len; j++){
                if(!list.get(i).contains(nums[j])){
                    list2 = new ArrayList<>();
                    list2.addAll(list.get(i));
                    list2.add(nums[j]);
                    list1.add(list2);
                    
                }
            }
        }

        return dfs(list1, nums, len, times - 1);
        
        
    }
}