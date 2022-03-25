import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String arr = sc.next();
        sc.close();

        char[] list = arr.toCharArray();
        int n = list.length;

        ArrayList<Character> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(list[i]);
        }

        while(res.contains(',')){
            for(int i = 0; i < n; i++){
                if(res.get(i) == ','){
                    res.remove(i);
                    n--;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(res.get(i));
        }
	}
}