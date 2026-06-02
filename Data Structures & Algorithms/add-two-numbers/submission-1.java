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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode ptr1=l1, ptr2=l2, ptr3=new ListNode(0);
        ListNode dummy=ptr3;
        int carry=0;
        while(ptr1!=null && ptr2!=null)
        {
            int sum = ptr1.val + ptr2.val + carry;
            carry = (sum)/10;
            ListNode temp=new ListNode(sum%10);
            ptr3.next = temp;
            ptr3=temp;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        while(ptr1!=null)
        {
            int sum =ptr1.val+carry;
            ListNode temp=new ListNode(sum%10);
            ptr3.next = temp;
            ptr3=temp;
            carry=sum/10;
            ptr1=ptr1.next;
        }   
        while(ptr2!=null)
        {
            int sum =ptr2.val+carry;
            ListNode temp=new ListNode(sum%10);
            ptr3.next = temp;
            ptr3=temp;
            carry=sum/10;
            ptr2=ptr2.next;
        } 
        if(carry!=0)
        {
            ListNode temp = new ListNode(carry);
            ptr3.next = temp;
        }
        return dummy.next;
    }
}
