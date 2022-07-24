class Solution {
    public void moveZeroes(int[] nums) {
        int num = 0;
        int size = nums.length;
        int n = 1;
        
        if(size == 1)
            return;

        for(int i = 0; i < size; i++){
            if(nums[i] == 0)
                num++;
        }
        if(num == 0){
            return;
        }

        int m = 0;

        for(int i = 0; i < size; i++){
            if(nums[i] == 0){
                m = i;
                break;
            }
        }

        for(int i = m; i < size - num; i++){
            if(nums[i + n] != 0){
                nums[i] = nums[i + n];
            }
            else{
                for(int j = n; j <= num; j++){
                    
                    if(nums[i + n] == 0)
                        n++;
                    else{
                        nums[i] = nums[i + n];
                        break;
                    }
                }
            }
        }

        for(int i = 1; i <= num; i++){
            nums[size - i] = 0;
        }

    }

}