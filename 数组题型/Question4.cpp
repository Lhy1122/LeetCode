class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double res;
        int num = 0;
        int m = 0;
        int n = 0;
        
        int s1 = sizeof(nums1) / sizeof(nums1[0]);
        int s2 = sizeof(nums2) / sizeof(nums2[0]);

        int nums[s1 + s2];

        while(m + n < s1 + s2 - 1){
            if(nums1[m] > nums2[n]){
                nums[num] = nums2[n];
                n++;
                num++;
                if(n == s2){
                    while(m < s1){
                        nums[num] = nums1[m];
                        num++;
                        m++;
                    }
                }
            }
            else{
                nums[num] = nums1[m];
                m++;
                num++;
                if(m == s1){
                    while(n < s2){
                        nums[num] = nums2[n];
                        num++;
                        n++;
                    }
                }
            }
        }
        
        if((s1 + s2) % 2 == 0){
            int i = (s1 + s2) / 2;
            res = (nums[i - 1] + nums[i]) / 2.0;
        }
        else{
            int i = (s1 + s2) / 2;
            res = double(nums[i]);
        }

        return res;
    }
};