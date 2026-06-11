class Solution {
    boolean []vis;
    private boolean istherecycle(List<List<Integer>>graph, int node, int parent)
    {
        if(vis[node]==true)
            return true;
        vis[node]=true;
        for(Integer neighbor:graph.get(node))
        {
            if(vis[neighbor]==false)
            {
                if(istherecycle(graph,neighbor,node))
                    return true;
            }
            else if(neighbor!=parent)
                return true;
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) 
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
        if(istherecycle(graph,0,-1)==false)
        {
            for(int i=0;i<n;i++)
                if(vis[i]==false)
                    return false;
        }
        else
            return false;
        return true;
    }
}
