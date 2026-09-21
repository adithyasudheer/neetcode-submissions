class Solution {
    int findP(int x,int []par)
    {
        if(par[x]==x)
            return x;
        else
            return par[x]=findP(par[x],par);
    }
    public int minCostConnectPoints(int[][] points) 
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<points.length-1;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int []res=new int[3];
                res[0]=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                res[1]=i;
                res[2]=j;
                pq.add(res);
            }
        }    
        int anslen=0,ans=0;
        int []par=new int[points.length];
        for(int i=0;i<points.length;i++)
            par[i]=i;
        while(anslen<points.length-1)
        {
            int[]top=new int[3];
            top=pq.poll();
            int par1=findP(top[1],par);
            int par2=findP(top[2],par);
            if(par1==par2)
                continue;
            else
            {
                par[par1]=par2;
                ans+=top[0];
                anslen++;
            }
        }
        return ans;
    }
}
