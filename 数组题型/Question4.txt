import java.util.Stack;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        for(int i = nums2.length - 1; i >= 0; i--){
            stack.push(nums2[i]);
        }

        int a = nums1.length;
        int b = nums2.length;
        int c = a + b;

        int[] res = new int[c];
        int i = 0;
        int l = 0;
        while(i < a || stack.isEmpty() != true){
            if(stack.isEmpty() == true){
                res[l] = nums1[i];
                l++;
                i++;
            }
            else if(i == a){
                res[l] = stack.pop();
                l++;
            }
            else if(nums1[i] < stack.peek()){
                res[l] = nums1[i];
                l++;
                i++;
            }
            else{
                res[l] = stack.pop();
                l++;
            }
        }
        if(c % 2 != 0)
            return res[(c - 1) / 2];

        double e = res[c / 2];
        double f = res[c / 2 - 1];
        double g = (e + f) / 2;
        return g;
    }
}