import java.util.Scanner;

public class Main{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double l = sc.nextDouble();
        double time = l / 1000;
        double minute = 0;
        double hour = 0;
        while(time >= 3600){
            time = time - 3600;
            hour++;
        }

        while(time >= 60){
            time -= 60;
            minute++;
        }

        int a = (int) hour;
        a = a % 24;
        int b = (int) minute;
        int c = (int) time;
        
				if(a < 10)
            System.out.print("0" + a + ":");
				else
						System.out.print(a + ":");
			
				if(b < 10)
						System.out.print("0" + b + ":");
				else
						System.out.print(b + ":");
			
				if(c < 10)
						System.out.print("0" + c);
				else
						System.out.print(c);
        
        
    }
}