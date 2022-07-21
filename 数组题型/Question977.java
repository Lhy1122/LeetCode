import java.util.*;

class Solution {

    public int[] sortedSquares(int[] nums) {

        int num = nums.length;
        int[] n1 = new int[num];
        
        for(int i = 0; i < num; i++){
            n1[i] = nums[i] * nums[i];
        }

        Arrays.sort(n1);

        return n1;
    }
}