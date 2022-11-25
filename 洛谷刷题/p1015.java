import java.util.Scanner;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String m = sc.next();
        sc.close();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m.length(); i++){
            if(m.charAt(i) == 'A'){
                list.add(10);
            }
            else if(m.charAt(i) == 'B'){
                list.add(11);
            }
            else if(m.charAt(i) == 'C'){
                list.add(12);
            }
            else if(m.charAt(i) == 'D'){
                list.add(13);
            }
            else if(m.charAt(i) == 'E'){
                list.add(14);
            }
            else if(m.charAt(i) == 'F'){
                list.add(15);
            }
            else{
                list.add(m.charAt(i) - 48);
            }
        }

        int res = dfs(n, list, 0);
        if(res == -1){
            System.out.println("Impossible!");
        }
        else
            System.out.println("STEP=" + res);

        

    }

    public static int dfs(int n, ArrayList<Integer> list, int times){
        if(times > 30)
            return -1;

        boolean isture = true;
        for(int i = 0; i < list.size() / 2; i++){
            if(list.get(i) != list.get(list.size() -1 -i)){
                isture = false;
                break;
            }
        }
        if(isture == true)
            return times;

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++){
            list1.add(0);
        }

        
        for(int i = 0; i < list.size(); i++){
            int sum = list.get(i) + list.get(list.size() - 1 - i);
            list1.set(list1.size() -1 -i, list1.get(list1.size() -1 -i) + sum);
            if(list1.get(list1.size() -1 -i) >= n){
                list1.set(list1.size() -2 -i, 1);
                list1.set(list1.size() -1 -i, list1.get(list1.size() -1 -i) - n);
            }

        }

        if(list1.get(0) == 0)
            list1.remove(0);
        

        return dfs(n, list1, times + 1);
    }
}