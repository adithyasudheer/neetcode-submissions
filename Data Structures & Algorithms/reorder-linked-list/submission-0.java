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
    public ListNode reverse(ListNode head)
    {
        ListNode dummy=head;
        ListNode prev=null,curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) 
    {
        if(head==null || head.next==null)
            return;
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }  
        slow.next=reverse(slow.next);
        ListNode p1=head,p2=slow.next;
        slow.next=null;
        while(p2!=null)
        {
            ListNode t=p1.next;
            p1.next=p2;
            p1=t;
            t=p2.next;
            p2.next=p1;
            p2=t;
        }
        if(p1.next!=null)
            p1.next.next=null;
    }
}
