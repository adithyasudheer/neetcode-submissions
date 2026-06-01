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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode ptr2=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode ptr1=dummy;
        while(ptr2!=null && n>0)
        {
            ptr2=ptr2.next;
            n--;
        }
        while(ptr2!=null)
        {
            ptr2=ptr2.next;
            ptr1=ptr1.next;
        }
        if(ptr1.next!=null)
            ptr1.next=ptr1.next.next;
        else
            return null;
        return dummy.next;
    }
}
