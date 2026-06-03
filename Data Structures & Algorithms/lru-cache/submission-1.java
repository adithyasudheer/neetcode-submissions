class Node{
    Node next, prev;
    int key,val;
    Node(int k, int v)
    {
        key=k;
        val=v;
    }
}
class LRUCache {
    Node head,tail;
    HashMap<Integer,Node>hm;
    int cap;
    public LRUCache(int capacity) {
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        hm=new HashMap<>();
        cap=capacity;
    }
    
    void delete(int key)
    {
        if(hm.containsKey(key))
        {
            Node t=hm.get(key);
            hm.remove(key);
            t.prev.next=t.next;
            t.next.prev=t.prev;
        }
    }

    void insert(int key,int value)
    {
        if(hm.size()<cap)
        {
            Node t=new Node(key,value);
            t.prev=head;
            t.next=head.next;
            head.next=t;
            t.next.prev=t;
            hm.put(key,t);
        }
        else
        {
            delete(tail.prev.key);
            insert(key,value);
        }
    }



    public int get(int key) 
    {
        if(hm.containsKey(key))
        {
            int res=hm.get(key).val;
            delete(key);
            insert(key,res);
            return res;
        }    
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
        {
            delete(hm.get(key).key);
        }
        insert(key,value);
    }
}
