class Solution {
    public boolean oneEditAway(String first, String second) {
        
        if(first == second)
            return true;
        char[] list1 = first.toCharArray();
        char[] list2 = second.toCharArray();

        if(first.length() - second.length() == 1){
            
            int index1 = -1;
            for(int i = 0; i < second.length(); i++){
                if(list1[i] != list2[i]){
                    index1 = i;
                    break;
                }
            }

            if(index1 == -1)
                return true;
            for(int i = index1; i < second.length(); i++){
                if(list1[i + 1] != list2[i]){
                    return false;
                }
            }

            return true;

        }

        else if(second.length() - first.length() == 1){
            int index1 = -1;
            for(int i = 0; i < first.length(); i++){
                if(list1[i] != list2[i]){
                    index1 = i;
                    break;
                }
            }

            if(index1 == -1)
                return true;
            for(int i = index1; i < first.length(); i++){
                if(list1[i] != list2[i + 1]){
                    return false;
                }
            }

            return true;
        }

        else if(second.length() == first.length()){
            
            int index1 = 0;
            for(int i = 0; i < second.length(); i++){
                if(list1[i] != list2[i]){
                    index1 = i;
                        break;
                }
            }

            if(index1 == second.length() - 1)
                return true;
            for(int i = index1 + 1; i < second.length(); i++){
                if(list1[i] != list2[i])
                    return false;
            }

            return true;
            
        }

        else
            return false;
    }
}