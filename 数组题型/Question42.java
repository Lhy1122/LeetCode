class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int max = 0;
        int indexmax = 0;
        int res = 0;
        for(int i = 0; i < len; i++){
            if(height[i] > max){
                max = height[i];
                indexmax = i;
            }
        }

        int left = 0;
        int right = 0;
        
        for(int i = 0; i < indexmax; i++){
            if(height[i] > left){
                left = height[i];
            }

            res += left - height[i];
        }

        for(int i = len - 1; i > indexmax; i--){
            if(height[i] > right)
                right = height[i];

            res += right - height[i];
        }

        return res;
    }
}