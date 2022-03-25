import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //数组的长度为size
        int size = scan.nextInt();

        //新建一个动态数组list用于存储输入
        ArrayList<Integer> list = new ArrayList<>();

        //将N个整数添加进list中
        while(scan.hasNext())
          list.add(scan.nextInt());

        //新建另一个动态数组arr
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(list.get(0));

        //每当list中的第i个元素在arr中可找到，该元素+1，直到该元素在arr中不匹配
        for(int i = 1; i < size; i++){
          while(arr.contains(list.get(i))){
            list.set(i,list.get(i) + 1);
          }
          arr.add(list.get(i));
        }
        
        for(int i = 0; i < size; i++){
          
          System.out.print(arr.get(i) + " ");
        }

        scan.close();

    }
}