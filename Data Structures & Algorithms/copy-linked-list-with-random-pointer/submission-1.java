/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        if(head==null)
            return null;
        Node ptr=head;
        while(ptr!=null)
        {
            Node temp=new Node(ptr.val);
            temp.next=ptr.next;
            ptr.next=temp;
            ptr=temp.next;
        }
        ptr=head;
        while(ptr!=null && ptr.next!=null)
        {
            if(ptr.random==null)
                ptr.next.random=null;
            else
                ptr.next.random=ptr.random.next;
            ptr=ptr.next.next;
        }
        ptr=head;
        Node res=ptr.next;
        while(ptr!=null && ptr.next!=null)
        {
            Node temp=ptr.next;
            ptr.next=ptr.next.next;
            ptr=temp;
            temp=ptr.next;
            if(ptr.next!=null)
                ptr.next=ptr.next.next;
            else
                ptr.next=null;
            ptr=temp;
        }
        return res;
    }
}
