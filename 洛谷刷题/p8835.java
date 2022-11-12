import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ress = new int[t];
        
        for(int i = 0; i < t; i++){
            int res = 0;
            int small = sc.nextInt();
            int big = sc.nextInt();
            String sm = sc.next();
            String bi = sc.next();
            char ch = sm.charAt(0);
            loop:for(int j = 0; j <= big - small; j++){
                if(ch == bi.charAt(j) || ch == bi.charAt(j) + 32 || ch == bi.charAt(j) - 32){
                    int z = 1;
                    for(int k = j + z; k < j + small; k++){
                        if(sm.charAt(z) == bi.charAt(k) || sm.charAt(z) == bi.charAt(k) + 32 || sm.charAt(z) == bi.charAt(k) - 32){
                            z++;
                            continue;
                        }
                        else
                            continue loop;
                    }
                    res++;
                }
            }

            ress[i] = res;

        }
        
        sc.close();
        for(int i = 0; i < t; i++){
            System.out.println(ress[i]);
        }
        
    }
}