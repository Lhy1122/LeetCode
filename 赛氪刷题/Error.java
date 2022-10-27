import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		
      	Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
        int[] list = new int[n + 10];
        for(int i = 0; i < n; i++){
          list[i] = sc.nextInt();
      	}
    
        sc.close();
    
      	int min = list[0];
      	int max = list[0];
      	for(int i = 0; i < n; i++){
          	if(list[i] < min)
             	 min = list[i];
          
          	if(list[i] > max)
              	max = list[i];
      	}

      
      	int res = 0;
      
      	if(max <= 10000){
        	for(int i = 0; i < max; i++){
          
            	if(Pan(list, i, n)){
                	res = i;
                	break;
            	}

            }
        }

        else if(max > 10000){
            for(int i = 10000; i < 1000000000; i += 10000){
                if(Pan(list, i, n)){
                    res = i;
                    break;
                }
            }

            for(int i = res - 10000; i <= res; i++){
                if(Pan(list, i, n)){
                    res = i;
                    break;
                }
            }
        }


      	System.out.println(res);
    
    }
  
  	public static boolean Pan(int[] list, int eps, int n){
        int num = list[0];
        int bi = 1;
        if(num - eps > 0)
            bi = num - eps;
        
        
        for(int i = 1; i < n; i++){
            if(list[i] > num && list[i] - bi > eps){
                bi = list[i] - eps;
                num = list[i];
            }
            else if(list[i] > num && list[i] - bi <= eps){
                bi++;
                num = list[i];
            }
            else if(list[i] < num && bi - list[i] >= eps){
                return false;
            }
            else if(list[i] < num && (list[i] - bi <= eps + 1 || bi - list[i] >= eps)){
                bi++;
                num = list[i];
            }
        }

        return true;
    }
}