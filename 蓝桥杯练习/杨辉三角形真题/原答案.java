import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[][] list = new int[100][100];
		
		int ceng = 0;
		
        int index = 0;
		
		loop: for(int i = 0; i < 50; i++){

		    list[ceng][0] = 1;
            index++;
            if(list[ceng][0] == n){
                System.out.println(index);
                break loop;
            }
          

			for(int j = 1; j < i; j++){
				list[ceng][j] = list[ceng - 1][j - 1] + list[ceng - 1][j];
                index++;
                if(list[ceng][j] == n){
                    System.out.println(index);
                    break loop;
                }
            }

            if(i > 0){  
			    list[ceng][i] = 1;
                index++;
            }
            ceng++;
		}
	}
}