import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] list = new int[len];

        for(int i = 0; i < len; i++){
            if(arr[i] == '(')
                list[i] = 0;
            else
                list[i] = 1;
        }

        int num = 0;
        for(int i = 0; i < len; i++){
            if(list[i] == 0){
                stack.push(0);
                num = i;
                break;
            }
        }

        for(int i = num + 1; i < len; i++){
            if(list[i] == 0){
                stack.push(0);
            }
            else{
                if(stack.empty() || stack.peek() == 1){
                    stack.push(1);
                    continue;
                }
                else if(stack.peek() == 0){
                    stack.pop();
                    list[i] = 2;
                    for(int j = i - 1; j >= 0; j--){
                        if(list[j] == 0){
                            list[j] = 2;
                            break;
                        }
                    }
                }
            }
        }

        int res = 0;
        
        for(int i = 0; i < len - 1; ){
            if(list[i] == 2){
                int num1 = 0;
                while(i < len){
                    num1 += 2;
                    i++;
                    if(i < len && list[i] == 2){
                        continue;
                    }
                    else{
                        num1 /= 2;
                        if(num1 > res)
                            res = num1;
                        break;
                    }
                }
            }
            else{
                i++;
            }
        }

        return res;
    }
}