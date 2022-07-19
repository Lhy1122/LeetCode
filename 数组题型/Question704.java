class Solution {
    public int search(int[] nums, int target) {

        int big = nums.length - 1;
        int num = big / 2;
        int small = 0;
        int zan = 0;

        while(num != -1 && nums[num] != target){

            if(nums[num] > target){

                big = num;
                num = (big + small - 1) / 2;
                

            }

            else{

                small = num;
                num = (small + big + 1) / 2;
                
            }

            if(big - small <= 1){
                zan++;
                if(zan > 3){
                    num = -1;
                    break;
                }
                
            }

        }

        return num;
    }

}