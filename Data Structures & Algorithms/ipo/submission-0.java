class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<profits.length;i++)
        {
            if(capital[i]<=w)
            {
                capital[i]=Integer.MAX_VALUE;
                pq.offer(profits[i]);
            }
        }
        int ans=w;
        while(k>0 && pq.isEmpty()==false)
        {
            int t=pq.poll();
            w+=t;
            for(int i=0;i<profits.length;i++)
            {
                if(capital[i]!=Integer.MAX_VALUE && capital[i]<=w)
                {
                    capital[i]=Integer.MAX_VALUE;
                    pq.offer(profits[i]);
                }
            }
            ans+=t;
            k--;
        }
        return ans;
    }
}