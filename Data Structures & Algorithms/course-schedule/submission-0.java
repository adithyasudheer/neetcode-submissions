class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        List<List<Integer>>graph=new ArrayList<>();
        int []indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
            indegree[i]=0;
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }   
        Queue<Integer>q=new LinkedList<>(); 
        boolean[]vis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                vis[i]=true;
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int sz=q.size();
            while(sz!=0)
            {
                int t=q.poll();
                for(int i=0;i<graph.get(t).size();i++)
                {
                    int node=graph.get(t).get(i);
                    if(vis[node]==false)
                    {
                        indegree[node]--;
                        if(indegree[node]==0)
                        {
                            vis[node]=true;
                            q.offer(node);
                        }

                    }
                    
                }
                sz--;
            }
        }
        for(int i=0;i<numCourses;i++)
        {
            if(vis[i]==false)
            {
                return false;
            }
        }
        return true;
    }
}
