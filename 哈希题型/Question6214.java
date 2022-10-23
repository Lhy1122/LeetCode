class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] arr1 = new int[1440];
        int num1 = Integer.parseInt(event1[0].substring(0, 2));
        int num2 = Integer.parseInt(event1[0].substring(3, 5));
        int num3 = Integer.parseInt(event1[1].substring(0, 2));
        int num4 = Integer.parseInt(event1[1].substring(3, 5));

        int startIndex = num1 * 60 + num2;
        int endIndex = num3 * 60 + num4;

        if(startIndex > endIndex){
            for(int i = startIndex; i < 1440; i++){
                arr1[i] = 1;
            }
            for(int i = 0; i <= endIndex; i++){
                arr1[i] = 1;
            }
        }
        else{
            for(int i = startIndex; i <= endIndex; i++){
                arr1[i] = 1;
            }
        }

        num1 = Integer.parseInt(event2[0].substring(0, 2));
        num2 = Integer.parseInt(event2[0].substring(3, 5));
        num3 = Integer.parseInt(event2[1].substring(0, 2));
        num4 = Integer.parseInt(event2[1].substring(3, 5));

        startIndex = num1 * 60 + num2;
        endIndex = num3 * 60 + num4;

        if(startIndex > endIndex){
            for(int i = startIndex; i < 1440; i++){
                if(arr1[i] == 1)
                    return true;
            }
            for(int i = 0; i <= endIndex; i++){
                if(arr1[i] == 1)
                    return true;
            }
        }
        else{
            for(int i = startIndex; i <= endIndex; i++){
                if(arr1[i] == 1)
                    return true;
            }
        }

        return false;

    }
}