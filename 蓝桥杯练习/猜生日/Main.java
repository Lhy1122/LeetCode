public class Main{
    public static void main(String[] args){
        
        loop:for(int i = 1950; i < 1990; i ++){
            int j = 6;
                for(int k = 1; k < 31; k++){
                    int n = i * 10000 + j * 100 + k;
                    if(n % 2012 == 0 && n % 12 == 0){
                        System.out.println(n);
                        break loop;
                    }
                }
            
        }
    }
}