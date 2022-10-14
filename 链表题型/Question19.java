/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null){
            return null;
        }
        
        int len = 1;
        ListNode Next = head;
        while(true){
            if(Next.next != null){
                len++;
                Next = Next.next;
            }
            else
                break;
        }

        int num = len - n;
        if(num == 0){
            return head.next;
        }
        Removed(head, num).next = removeD(head, num);
        
        return head;
    }

    public ListNode Removed(ListNode node, int num){
        if(num == 1){
            return node;
        }
        
        num--;
        return Removed(node.next, num);
    }

    public ListNode removeD(ListNode node, int num){
        if(num == 0){
            if(node.next == null)
                return null;
            return node.next;
        }
    
        num--;
        return removeD(node.next, num);
    }
}