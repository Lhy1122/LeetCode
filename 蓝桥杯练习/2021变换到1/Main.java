public class Main{
    public static void main(String[] args){
        int a = 2021;
        int res = 0;
        while(a > 1){
            if((a + 1) % 4 == 0){
                a++;
                a = a / 4;
                res += 3;
                continue;
            }

            if(a % 2 == 0){
                a = a / 2;
                res++;
                continue;
            }

            if(a % 2 != 0){
                if(a == 1)
                    break;
                a--;
                res++;
                continue;
            }
        }

        System.out.println(res);
        System.out.println(a);
    }
}