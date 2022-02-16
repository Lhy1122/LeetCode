import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < ops.length; i++){
            if("C".equals(ops[i])){
                res -= stack.pop();
            }    
            else if("D".equals(ops[i])){
                int n = 2 * stack.peek();
                stack.push(n);
                res += n;
            }
            else if("+".equals(ops[i])){
                int n = stack.pop();
                int a = stack.peek();
                stack.push(n);
                res += a + n;
                stack.push(a + n);
            }
            else{
                int a = Integer.parseInt(ops[i]);
                stack.push(a);
                res += a;
            }
        
        }

        return res;
        
    }   
    
}