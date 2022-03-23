public class Main {
    public static void main(String[] args) {
      //每一斜边长度增加1，即第一斜边长度为1，第二斜边长度为2，第三斜边长度为3
      //第n行第n列的元素在第2n-1条斜边上，故第20行20列的元素在第39条斜边上
        int n = 39;
        int res = 0;
        //第39条斜边及其之前38条斜边的元素总和
        for(int i = 1; i <= n; i++){
          res += i;
        }
        //第39斜边边角距离其中点19
        res = res - 19;
        System.out.println(res);

    }
}