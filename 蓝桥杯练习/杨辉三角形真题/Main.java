import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
        
        long[] list1 = new long[100000];
        long[] list2 = new long[100000];

        int a = 3;
        int res = 7;
        list1[0] = 1L;
        list1[1] = 2L;
        list1[2] = 1L;
        list2[0] = 1L;
        loop:while(a < 100000){
            if(n == 1){
                System.out.println(1);
                break;
            }

            if(n == 2){
                System.out.println(5);
                break;
            }

            for(int i = 1; i < a; i++){
                list2[i] = list1[i - 1] + list1[i];
                res++;
                if(list2[i] == n){
                    System.out.println(res);
                    break loop;
                }
            }
            list2[a] = 1;
            a++;
            res += 2;

            for(int i = 1; i < a; i++){
                list1[i] = list2[i - 1] + list2[i];
                res++;
                if(list1[i] == n){
                    System.out.println(res);
                    break loop;
                }
            }
            list1[a] = 1;
            a++;
            res += 2;
        }

        
	}
}