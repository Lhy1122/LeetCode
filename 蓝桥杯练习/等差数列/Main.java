import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1 ; i < n ;i++){
            if (nums[i] - nums[i - 1] < min){
                min = nums[i] - nums[i - 1];
            }
        }
        if (min == 0){
          System.out.println(n);
          return;
        }
        int res = (nums[n - 1] - nums[0]) / min + 1;
        System.out.println(res);
        sc.close();
    }
}