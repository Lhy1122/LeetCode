class Solution {
    public int removeDuplicates(int[] nums) {
        int deIndex = 1;
        int len = nums.length;
        

        if(len <= 1)
            return len;

        while(deIndex < len){
            if(nums[deIndex] == nums[deIndex - 1]){
                for(int i = deIndex; i < len - 1; i++){
                    nums[i] = nums[i + 1];
                }
                len--;
            }
            else
                deIndex++;
        }

        return len;
    }
}