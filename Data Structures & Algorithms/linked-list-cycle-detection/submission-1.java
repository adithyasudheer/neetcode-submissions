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
    public boolean hasCycle(ListNode head) 
    {
        if(head==null || head.next==null)
            return false;
        ListNode slow=head.next;
        ListNode fast=slow.next;
        while(fast!=null)
        {
            if(slow==fast)
                return true;
            slow=slow.next;
            
            if(fast.next==null)
                break;
            fast=fast.next.next;
        }
        return false;

    }
}
