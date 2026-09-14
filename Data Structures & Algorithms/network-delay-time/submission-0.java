class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        Map<Integer,List<int[]>>graph=new HashMap<>();
        /*for(int i=0;i<times.length;i++)
        {
            if(graph.containsKey(times[i][0]))
                graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
            else
            {
                graph.put(times[i][0],new ArrayList<>());
                graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
            }
        } */
        for(int i=0;i<times.length;i++)
        {
            graph.computeIfAbsent(times[i][0],j->new ArrayList<>()).add(new int[]{times[i][1],times[i][2]});
        }   
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        minHeap.offer(new int[]{0,k});
        Set<Integer>s=new HashSet<>();
        int res=0;
        while(!minHeap.isEmpty())
        {
            int[]val=new int[2];
            val=minHeap.poll();
            if(s.contains(val[1]))
                continue;
            s.add(val[1]);
            res=val[0];
            List<int[]>nei=graph.get(val[1]);
            for(int i=0;nei!=null && i<nei.size();i++)
            {
                if(!s.contains(nei.get(i)[0]))
                    minHeap.offer(new int[]{val[0]+nei.get(i)[1],nei.get(i)[0]});
            }
        }
        if(s.size()!=n)
            return -1;
        return res;
    }
}
