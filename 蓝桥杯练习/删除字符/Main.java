import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arr = scan.next();
        int t = scan.nextInt();
        scan.close();

        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < arr.length(); i++){
            list.add(arr.charAt(i));
        }

        for(int i = 1; i <= t; i++){
            if(list.get(0) > list.get(1)){
                list.remove(0);
            }
            else{
                list.remove(1);
            }
        }

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }
    }
}