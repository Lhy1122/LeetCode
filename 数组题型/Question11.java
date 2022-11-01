class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int num = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = n - 1; j >= i; j--){
                if(height[j] >= height[i]){
                    num = height[i] * (j - i);
                    if(num > max)
                        max = num;
                    for(int z = j + 1; z < n; z++){
                        num = height[z] * (z - i);
                        if(num > max){
                            max = num;
                        }
                    }
                    break;
                }
                    
                

            }
        }

        return max;
    }
}