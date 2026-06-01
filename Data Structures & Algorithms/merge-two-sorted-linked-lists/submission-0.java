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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode fin=null, p3=null, p1=list1,p2=list2;
        while(p1!=null && p2!=null)
        {
            if(p1.val<p2.val)
            {
                if(fin==null)
                {
                    fin=p1;
                    p3=fin;
                }
                else
                {
                    p3.next=p1;
                    p3=p1;
                }
                p1=p1.next;
            }
            else
            {
                if(fin==null)
                {
                    fin=p2;
                    p3=fin;
                }
                else
                {
                    p3.next=p2;
                    p3=p2;
                }
                p2=p2.next;
            }
        }    
        if(p1!=null)
        {
            p3.next=p1;
        }
        if(p2!=null)
        {
            p3.next=p2;
        }
        return fin;
    }
}