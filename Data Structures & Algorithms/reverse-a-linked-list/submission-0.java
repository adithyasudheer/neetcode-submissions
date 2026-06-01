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
    public ListNode reverseList(ListNode head) 
    {
        if(head== null || head.next==null)
            return head;
        ListNode one=null,two=head,three=head.next;
        while(three!=null)
        {
            two.next=one;
            one=two;
            two=three;
            three=three.next;
        }   
        if(two!=null)
            two.next=one;
        return two;
    }
}
