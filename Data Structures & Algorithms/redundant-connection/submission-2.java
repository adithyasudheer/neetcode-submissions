class DSU
{
    int []parent;
    DSU(int n)
    {
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
    }
    int findParent(int x)
    {
        if(parent[x]==x)
            return x;
        return parent[x]=findParent(parent[x]);
    }
    boolean union(int x, int y)
    {
        int parx=findParent(x);
        int pary=findParent(y);
        if(parx!=pary)
        {
            parent[Math.min(parx,pary)]=Math.max(parx,pary);
            return true;
        }
        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        DSU dsuobj=new DSU(edges.length+1);
        int []res=new int[2];
        for(int i=0;i<edges.length;i++)
        {
            if(!dsuobj.union(edges[i][0],edges[i][1]))
            {
                res[0]=edges[i][0];
                res[1]=edges[i][1];
            }
        }
        return res;
    }
}
