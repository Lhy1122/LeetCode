class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int a = 0; a < nums.length - 1; a++){
            for(int b = a + 1; b < nums.length; b++){
                if(nums[a] + nums[b] == target){
                    
                    res[0] = a;
                    res[1] = b;
                    break;
                }
            }
        }
        return res;
    }
}