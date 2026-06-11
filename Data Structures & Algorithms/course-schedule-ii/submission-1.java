class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>>graph=new ArrayList<>();
        int[]indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
            indegree[i]=0;
        } 
        for(int[]pre:prerequisites)
        {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }   
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        List<Integer>res= new ArrayList<>();
        while(!q.isEmpty())
        {
            int t=q.poll();
            res.add(t);
            for(Integer neighbors:graph.get(t))
            {
                indegree[neighbors]--;
                if(indegree[neighbors]==0)
                    q.offer(neighbors);
            }
        }
        if(res.size()==0 || res.size()!=numCourses)
            return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
