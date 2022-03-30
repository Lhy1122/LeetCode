import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[][] list = new int[35][35];
		
		int ceng = 0;
		
		
		for(int i = 0; i < n; i++){

            
            if(i > 0)
			    System.out.print((list[ceng][0] = 1) + " ");
			
			for(int j = 1; j < i; j++)
				System.out.print((list[ceng][j] = list[ceng - 1][j - 1] + list[ceng - 1][j]) + " ");
			
            
			System.out.println(list[ceng][i] = 1);
			ceng++;
			
		}
	}
}