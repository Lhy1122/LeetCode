import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int arr[]=new int[100];
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<100;i++){
          arr[i]=scan.nextInt();
          int x=arr[i];
          int y=arr[i];
          while(x%5==0&&x!=0){
            cnt1++;
            x=x/5;
          }
          while(y%2==0&&y!=0){
            cnt2++;
            y=y/2;
          }
        }
        System.out.print(cnt1>cnt2?cnt2:cnt1);
        scan.close();
    }
}