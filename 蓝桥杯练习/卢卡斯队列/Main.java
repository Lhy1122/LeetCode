public class main{
public static void main(String[] args)
        {
            int a = 1;
            int b = 3;
            int c = 0;
            double result = 0.618034;
            for(int i = 3; i < 800; i++)
            {
                c = a + b;
                a = b;
                b = c;
                double n = (double)a/b;
                if(n >= 0.6180335 && n <= 0.618034)
                {
                    System.out.print(a + "/" + b);
                    break;
                }
            }

        }
}