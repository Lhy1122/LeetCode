class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode tail = head;
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }

        while(tail != null){
            if(stack.pop() != tail.val)
                return false;
            tail = tail.next;
        }
        return true;
    }
}