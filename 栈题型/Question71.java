import java.util.Scanner;
import java.util.Stack;

public class Question71{
    public static void main(String[] args){

        Stack<Character> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        sc.close();
        int n = path.length();
        int v = 0;


        while(v < n){

            if(v == n - 1){
                if(path.charAt(v) == '/'){
                    break;
                }
            }
            
            if(path.charAt(v) == '/' && v < n - 1){
                stack.add('/');
                v++;
                while(path.charAt(v) == '/'){
                    v++;
                }
                if(path.charAt(v) == '.'){
                    v++;
                    if(path.charAt(v) == '.'){
                        stack.pop();
                        while(stack.peek() != '/')
                            stack.pop();
                        v++;
                        continue;
                    }

                    stack.pop();
                    while(stack.peek() != '/')
                        stack.pop();
                    
                }

                while(path.charAt(v) - 'a' >= 0 && path.charAt(v) - 'a' < 26){

                    stack.add(path.charAt(v));
                    v++;
                    
                }

            }
            
            
        }
        while(stack.peek() == '/')
            stack.pop();
        int mm = stack.size();
        int m = stack.size();
        char[] ch = new char[m];
        mm--;
        while(mm >= 0){
            ch[mm] = stack.pop();
            mm--;
        }
        for(int i = 0; i < m; i++){
            System.out.print(ch[i]);
        }
    }
}