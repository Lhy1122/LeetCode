public class Main{
    public static void main(String[] args){
        double time = 1618708103.123;
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
        
            System.out.println("0" + a + ":0" + b + ":" + c);
        
        
    }
}