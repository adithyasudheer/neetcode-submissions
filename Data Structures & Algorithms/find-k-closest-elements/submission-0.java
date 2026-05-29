class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<k;i++)
        {
            int t=Math.abs(arr[i]-x);
            pq.offer(new int[]{t,arr[i]});
        }    
        for(int i=k;i<arr.length;i++)
        {
            int t=Math.abs(arr[i]-x);
            if(t<pq.peek()[0] || (t==pq.peek()[0] && arr[i]<pq.peek()[1]))
            {
                pq.poll();
                pq.offer(new int[]{t,arr[i]});
            }            
        }
        List<Integer>res=new ArrayList<>();
        while(!pq.isEmpty())
        {
            res.add(pq.peek()[1]);
            pq.poll();
        }
        Collections.sort(res);
        return res;
    }
}