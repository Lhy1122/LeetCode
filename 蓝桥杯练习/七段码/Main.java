public class Main {
    static boolean n[][]=new boolean[8][8];
    static int fa[]=new int[8];
    static boolean vik[] = new boolean[8];
    static int u=0;
 public static void main(String[] args) {

     n[1][2]=true;n[1][6]=true;
     n[2][1]=true;n[2][7]=true;n[2][3]=true;
     n[3][2]=true;n[3][7]=true;n[3][4]=true;
     n[4][3]=true;n[4][5]=true;
     n[5][4]=true;n[5][7]=true;n[5][6]=true;
     n[6][1]=true;n[6][5]=true;n[6][7]=true;
     n[7][2]=true;n[7][3]=true;n[7][6]=true;n[7][5]=true;
     count(1);
        System.out.println(u);
 }
 public static void count(int num) {
     if(num>7) {
         for(int i=1;i<8;i++) {
             fa[i]=i;
         }
         for(int i=1;i<8;i++) {
             for(int j=1;j<8;j++) {
                 if(n[i][j] && vik[i] && vik[j]) {
                     int x=found(i);
                     int y=found(j);
                     if(x!=y) {
                         fa[x]=y;
                     }
                 }
             }
         }
         int t=0;
         for(int i=1;i<8;i++) {
             if(fa[i]==i&&vik[i]) t++;
         }
         if(t==1) {u++;}
         return;
     }
     vik[num]=true;
     count(num+1);
     vik[num]=false;
     count(num+1);
 }
 public static int found(int i) {
     if(fa[i]==i) return i;
     fa[i]=found(fa[i]);
     return fa[i];
 }
}