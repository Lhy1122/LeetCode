public class Main{
    public static void main(String args[]){
        long res = 0;
        for(int i = 1; i <= 2019; i++){
            int j = i;
            long num = (long)j;

            while(j > 0){
                
                if(j % 10 == 2 || j % 10 == 0 || j % 10 == 1 || j % 10 == 9){
                    res += num * num;
                    break;
                }

                j /= 10;
            }
        }

        System.out.println(res);
    }
}