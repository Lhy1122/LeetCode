/*
 * @Author: your name
 * @Date: 2022-03-20 10:56:44
 * @LastEditTime: 2022-03-20 11:01:14
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \蓝桥杯练习\数列排序\Main.java
 */
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		Integer n = sc.nextInt();
		
		ArrayList<Integer> res = new ArrayList<>();
		
		while(sc.hasNext()){
			Integer i = sc.nextInt();
			res.add(i);
		}
		
		System.out.println(res);
		
	}
}