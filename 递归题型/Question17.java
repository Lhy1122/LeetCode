import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        int len = digits.length();

        if(len == 0)
            return list;

        if(len == 1){
            char ch = digits.charAt(0);
            int n = ch - 48;
            if(n == 7){
                for(int i = 0; i < 4; i++){
                    String str = "" + (char)((n - 2) * 3 + i + 'a');
                    list.add(str);
                }
            }
            else if(n == 8){
                for(int i = 0; i < 3; i++){
                    String str = "" + (char)((n - 2) * 3 + i + 1 + 'a');
                    list.add(str);
                }
            }
            else if(n == 9){
                for(int i = 0; i < 4; i++){
                    String str = "" + (char)((n - 2) * 3 + i + 1 + 'a');
                    list.add(str);
                }
            }
            else{
                for(int i = 0; i < 3; i++){
                    String str = "" + (char)((n - 2) * 3 + i + 'a');
                    list.add(str);
                }
            }
            return list;
        }

        list.add("");

        return Change(list, digits, 0, len);
    }

    public List<String> Change(List<String> list, String digits, int index, int len){
        if(index == len)
            return list;

        ArrayList<String> list1 = new ArrayList<>();

        char ch = digits.charAt(index);
        int n = ch - 48;

        if(n == 7){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < list.size(); j++){
                    String str = "" + (char)((n - 2) * 3 + i + 'a');
                    list1.add(list.get(j) + str);
                }
            }
        }
        else if(n == 8){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < list.size(); j++){
                    String str = "" + (char)((n - 2) * 3 + i + 1 + 'a');
                    list1.add(list.get(j) + str);
                }
            }
        }
        else if(n == 9){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < list.size(); j++){
                    String str = "" + (char)((n - 2) * 3 + i + 1 + 'a');
                    list1.add(list.get(j) + str);
                }
            }
        }
        else{
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < list.size(); j++){
                    String str = "" + (char)((n - 2) * 3 + i + 'a');
                    list1.add(list.get(j) + str);
                }
            }
        }

        return Change(list1, digits, index + 1, len);
    }
}