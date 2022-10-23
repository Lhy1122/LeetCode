import java.util.ArrayList;

class Solution {
    public String multiply(String num1, String num2) {
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < num1.length(); i++){
            list1.add(Integer.parseInt(String.valueOf(num1.charAt(i))));
        }

        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < num2.length(); i++){
            list2.add(Integer.parseInt(String.valueOf(num2.charAt(i))));
        }

        int[] res = new int[list1.size() + list2.size()];
        
        int que = 0;
        for(int i = list1.size() - 1; i >= 0; i--){
            int index = que;
            for(int j = list2.size() - 1; j >= 0; j--){
                int num = list1.get(i) * list2.get(j);
                int ben = num % 10;
                int jin = num / 10;

                res[index] += ben;
                if(res[index] > 9){
                    res[index + 1] += res[index] / 10;
                    res[index] -= 10 * (res[index] / 10);
                }
                index++;
                res[index] += jin;
            }
            que++;
        }

        String s = "";
        if(res[res.length - 1] != 0)
            s = s + (res[res.length - 1] + "");
        for(int i = res.length - 2; i >= 0; i--){
            s = s + (res[i] + "");
        }

        boolean w = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0')
                w = false;
        }
        if(w == true)
            return "0";

        return s;
    }
}