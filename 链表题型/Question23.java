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
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        ListNode res = new ListNode();
        ListNode res1 = new ListNode();
        
        if(len == 0){
            
            return null;
        }
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            ListNode start = lists[i];
            if(start == null)
                continue;
            list.add(start.val);
            while(start.next != null){
                start = start.next;
                list.add(start.val);
            }

        }
        Collections.sort(list);
        if(list.size() > 0)
            res.val = list.get(list.size() - 1);
        else
            return null;
        for(int i = list.size() - 2; i >= 0; i--){
            res1 = new ListNode();
            res1.val = list.get(i);
            res1.next = res;
            res = res1;
        }

        return res;
    }
}