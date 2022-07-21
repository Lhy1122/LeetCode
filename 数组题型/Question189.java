class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] n1 = new int[size];

        for(int i = 0; i < size; i++){
            n1[i] = nums[i];
        }

        for(int i = 0; i < size; i++){
            nums[(i + k) % size] = n1[i];
        }

        
    }
}