import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int a = 3;
        int ceng = 2;
        long[] list = new long[1000000];

        list[0] = 1L;
        list[1] = 1L;
        list[2] = 1L;

        loop:while(a < 1000000){
            if(n == 1){
                System.out.println(1);
                break;
            }
            list[a] = 1L;
            if(a + ceng > 1000000)
                break;
            list[a + ceng] = 1L;
            for(int i = a + 1; i < a + ceng; i++){
                list[i] = list[i - ceng - 1] + list[i - ceng];
                if(list[i] == n){
                    System.out.println(i + 1);
                    break loop;
                }
            }
            ceng++;
            a = a + ceng;
        }

		
		
	}
}