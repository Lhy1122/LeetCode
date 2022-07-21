class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int big = nums.length;
        int small = 0;
        int res = big / 2;

        while(nums[res] != target){
            if(big - small <= 1){
                res = small + 1;
                break;
            }
            if(nums[res] > target){
                big = res;
                res = (big + small) / 2;
            }
            else if(nums[res] < target){
                small = res;
                res = (big + small) / 2;
            }
        }
        if(res == 1 && nums[0] > target){
            res = 0;
        }
        return res;
    }
}