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
    ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode prev=null,curr=head,ptr=head.next;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=ptr;
            if(ptr!=null)
                ptr=ptr.next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode movingptr=dummy, prevtail=dummy;
        int kval=0;
        while(movingptr!=null)
        {
            if(kval<k)
            {
                while(movingptr.next!=null && kval<k)
                {
                    kval++;
                    movingptr=movingptr.next;
                }
                if(kval!=k)
                    break;
                ListNode newHead=movingptr;                
                ListNode newTail=prevtail.next;
                movingptr=movingptr.next;
                newHead.next=null;
                prevtail.next=reverse(prevtail.next);
                newTail.next=movingptr;
                prevtail=newTail;
                movingptr=prevtail;
            }
            kval=0;
        }
        return dummy.next;
    }
}
