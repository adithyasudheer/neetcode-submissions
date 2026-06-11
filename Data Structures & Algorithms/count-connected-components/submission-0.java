class Solution {
    boolean[]vis;
    private void bfs(List<List<Integer>>graph, int node)
    {
        Queue<Integer>q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty())
        {
            int t=q.poll();
            for(int x:graph.get(t))
            {
                if(vis[x]==false)
                {
                    vis[x]=true;
                    q.offer(x);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) 
    {
        List<List<Integer>>graph=new ArrayList<>();
        vis=new boolean[n];
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                count++;
                bfs(graph,i);
            }
        }
        return count;
    }
}
