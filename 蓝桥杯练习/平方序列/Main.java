public class Main {
    public static void main(String[] args) {
        int m = 2019;
        int mm = 2019 * 2019;

        loop:for(int i = 1; i < 100000; i++){
            int a = m + i;

            for(int j = 1; j < 100000; j++){
                int b = a + j;

                int aa = (a * a) - mm;
                int bb = (b * b) - (a * a);
                
                if(aa == bb){
                    System.out.println(a + b);
                    break loop;
                }
            }
        }
    }
}