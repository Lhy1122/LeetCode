/*
 * @Author: your name
 * @Date: 2022-03-20 15:39:32
 * @LastEditTime: 2022-03-20 15:51:16
 * @LastEditors: your name
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \蓝桥杯练习\单词分析\Main.java
 */
public class Main{
	public static void main(String[] args){
		  char[] arr = {'l','a','n','q','i','a','o'};
      int n = arr.length;
      int res = 0;
      char ch = 'a';

      for(int i = 0; i < n; i++){

        char bb = arr[i];
        int m = 0;
        
        for(int j = i; j < n; j++){

          if(arr[j] == bb)
            m++;

          if(m > res){
            res = m;
            ch = bb;
          }
        }
        
      }

      System.out.println(ch);
      System.out.println(res);
		
	}
}