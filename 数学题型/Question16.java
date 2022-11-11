import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int start = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int min;
        if(start > target){
            min = start - target;
        }
        else
            min = target - start;
        int res = start;

        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int num = nums[i] + nums[j] + nums[k];
                    if(num < target){
                        if(target - num < min){
                            min = target - num;
                            res = target - min;
                        }
                    }
                    else{
                        if(num - target < min){
                            min = num - target;
                            res = target + min;
                        }
                        else
                            break;
                    }
                }
            }
        }

        return res;
    }
}