class Solution {

    public int[] dell(int[] nums, int e){

        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == e){
                for(int j = i; j < nums.length; j++){
                    if(j == nums.length - 1){
                        nums[j] = 0;
                        break;
                    }
                    nums[j] = nums[j + 1];
                }
                break;
            }
        }
        return nums;
    }

    public int removeElement(int[] nums, int val) {
        
        int ll = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val)
                ll++;
        }

        int size = nums.length - ll;

        while(ll != 0){
            nums = dell(nums, val);
            ll--;
        }

        return size;

    }
}