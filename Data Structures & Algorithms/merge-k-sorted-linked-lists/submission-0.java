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
class Object{
    int val;
    ListNode node;
    Object(int v, ListNode n)
    {
        val=v;
        node=n;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<Object>pq=new PriorityQueue<>((a,b)->{return a.val-b.val;});
        for(int i=0;i<lists.length;i++)
        {
            Object t=new Object(lists[i].val,lists[i]);
            pq.offer(t);
        }
        ListNode dummy=new ListNode(0);
        ListNode ptr=dummy;
        while(!pq.isEmpty())
        {
            Object t=pq.peek();
            pq.poll();
            ListNode n=new ListNode(t.val);
            ptr.next=n;
            ptr=n;
            if(t.node.next!=null)
            {
                t.node=t.node.next;
                t.val=t.node.val;
                pq.offer(t);
            }
        }
        return dummy.next;
    }
}
