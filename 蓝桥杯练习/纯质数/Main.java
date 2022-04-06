public class Main{
    public static void main(String[] args){

        int res = 1;
        for(int a = 3; a <= 40; a++){
            if(isz(a) == true)
                res++;
        }
        System.out.println(res);
        
    }

    public static boolean isz(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        while(n > 0){
            if(n % 10 == 1 || n % 10 == 4 || n % 10 == 6 || n % 10 == 8 || n % 10 == 9 || n % 10 == 0)
                return false;
            n = n / 10;
        }

        return true;
    }
}