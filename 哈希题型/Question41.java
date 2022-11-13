class Solution {
    public int firstMissingPositive(int[] nums) {

        boolean[] list = new boolean[500001];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 500001 && nums[i] > 0)
                list[nums[i]] = true;
        }

        int res = 0;

        for(int i = 1; i < 500001; i++){
            if(!list[i]){
                res = i;
                break;
            }
        }

        return res;
    }
}