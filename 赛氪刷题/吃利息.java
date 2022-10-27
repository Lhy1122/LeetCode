import java.util.Scanner;

public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      	int k = sc.nextInt();
      	int n = sc.nextInt();
      	sc.close();
      	
      	int res = 0;
      	for(int i = 0; i < n; i++){
        	if(k >= 50){
            	res = k + (n - i) * 10;
              	break;
            }
          	else{
            	int num = k / 10;
              	k += (num + 5);
              	res = k;
            }
        }
      
      	System.out.println(res);
    }
}