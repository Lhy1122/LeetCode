class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        if(len == 0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int index = 0;
        for(int i = len - 1; i >= 0; i -= 100){
            if(nums[i] < target){
                index = i;
                break;
            }
        }

        for(int i = index; i < i + 100 && i < len; i++){
            if(nums[i] == target){
                res[0] = i;
                index = i;
                break;
            }
        }
        for(int i = index; i < i + 100 && i < len; i++){
            if(nums[i] == target && i == len -1){
                res[1] = i;
                break;
            }
            if(nums[i] > target){
                res[1] = i - 1;
                break;
            }
        }

        if(res[1] < res[0])
            res[1] = res[0];

        if(nums[res[0]] != target){
            res[0] = -1;
            res[1] = -1;
        }

        return res;
    }
}