import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
    	
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		int q = sc.nextInt();

		double sq = Math.sqrt(n);

		int gen = (int)sq;

		ArrayList<Integer> res = new ArrayList<>();

		for(int i = 0; i < q; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();

			int num = r - l + 1;
			int start = l % gen;
			if(start == 0)
				start = gen;
			
			
			int sum1 = gen - start + 1;
			
			if(num < sum1){
				res.add(num);
				continue;
			}
			num -= sum1;
			if(sum1 == gen)
				sum1 = 1;

			int sum2 = num / gen;
			int sum3 = num % gen;
			res.add(sum1 + sum2 + sum3);

		}

		for(int i = 0; i < res.size(); i ++){
			System.out.println(res.get(i));
		}
		

    }

	
}