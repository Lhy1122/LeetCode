public class Main {
    public static void main(String[] args) {
        boolean rel = false;
        int x = 2019;
        int y = 4038;

        while(rel == false){
            if(x % 2019 != 0){
                continue;
            }

            int n = x;
            while(n > 0){
                if(n % 2 == 0){
                    x += y;
                    break;
                }
                else{
                    n = n / 10;
                    continue;
                }
            }

            if(n == 0){
                rel = true;
            }
        }

        System.out.println(x);
    }
}