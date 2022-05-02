/*
 * @Author: your name
 * @Date: 2022-04-28 14:49:32
 * @LastEditTime: 2022-04-29 19:40:24
 * @LastEditors: your name
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \undefinedd:\LeetCode\蓝桥杯练习\数字三角形\Main.java
 */
import java.util.Scanner;

public class Main{

    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
         }

    public static void main(String[] args){
        TreeSet<Integer> tree = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num  = 0;
        while(n > 0){
            num = num + n;
            n--;
        }


    }
}