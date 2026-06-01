class KthLargest {

    PriorityQueue<Integer>pq;
    int nk;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>(Collections.reverseOrder());
        nk=k;
        for(int i=0;i<nums.length;i++)
            pq.offer(nums[i]);
    }
    
    public int add(int val) 
    {
        pq.offer(val);
        List<Integer>ls=new ArrayList<>();
        
        for(int i=0;i<nk-1;i++)
        {
            ls.add(pq.peek());
            pq.poll();
        }    
        Integer res=pq.peek();
        for(int i=0;i<nk && i<ls.size();i++)
        {
            pq.offer(ls.get(i));
        }
        return res; 
    }
}
