import java.util.Scanner;

public class Main{

    static String[][] list = new String[200][200];

    //四个方向的边界
    static int uu = 0, dd = 0, ll = 0, rr = 0;

    static boolean isclose(int i, int j){
        if(list[i][j] == " ")
            return false;
        if(list[i][j] == "*")
            return true;
        if(list[i][j] == "1"){
            for(int i1 = ll; i1 < i; i1++)
                if(list[i1][j] == "*")
                    for(int i2 = i + 1; i2 <= rr; i2++)
                        if(list[i2][j] == "*")
                            for(int j1 = j + 1; j1 <= dd; j1++)
                                if(list[i][j1] == "*")
                                    for(int j2 = j - 1; j2 >= ll; j2--)
                                        if(list[i][j2] == "*")
                                            return true;
            
        }
        return false;
    }
    public static void main(String[] args){

        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++){
                list[i][j] = "1";
            }
        }

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        
        String str = sc.next();
        sc.close();
        

        
        

        int a = 99, b = 99, c = 0;
        list[a][b] = " ";

        while(c < str.length()){
            if(str.charAt(c) == 'U'){
                a--;
                list[a][b] = " ";
                c++;
                continue;
            }
            else if(str.charAt(c) == 'D'){
                a++;
                list[a][b] = " ";
                c++;
                continue;
            }
            else if(str.charAt(c) == 'L'){
                b--;
                list[a][b] = " ";
                c++;
                continue;
            }
            else if(str.charAt(c) == 'R'){
                b++;
                list[a][b] = " ";
                c++;
                continue;
            }
        }

        

        boolean p = false;

        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++)
                if(list[i][j] == " "){
                    list[i - 1][j] = "*";
                    p = true;
                }
            if(p == true){
                uu = i - 1;
                p = false;
                break;
            }   
        }

        for(int i = 199; i >= 0; i--){
            for(int j = 0; j < 200; j++){
                if(list[i][j] == " "){
                    list[i + 1][j] = "*";
                    p = true;
                }
            }
            if(p == true){
                dd = i + 1;
                p = false;
                break;
            }
        }

        for(int j = 0; j < 200; j++){
            for(int i = 0; i < 200; i++){
                if(list[i][j] == " "){
                    list[i][j - 1] = "*";
                    p = true;
                }
            }
            if(p == true){
                ll = j - 1;
                p = false;
                break;
            }
        }

        for(int j = 199; j >= 0; j--){
            for(int i = 0; i < 200; i++){
                if(list[i][j] == " "){
                    list[i][j + 1] = "*";
                    p = true;
                }
            }
            if(p == true){
                rr = j + 1;
                p = false;
                break;
            }
        }

        for(int x = uu; x <= dd; x++){
            for(int y = ll; y <= rr; y++){
                if(isclose(x, y) == true)
                    list[x][y] = "*";
                
            }
        }

        for(int i = uu; i <= dd; i++){
            for(int j = ll; j <= rr; j++){
                if(j == rr)
                    System.out.println(list[i][j]);
                else
                    System.out.print(list[i][j] + " ");
            }
        }
        
    }
}