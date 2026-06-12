class Solution {
    public void islandsAndTreasure(int[][] grid) 
    {
        int n=grid.length,m=grid[0].length;
        Queue<Integer[]>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                    q.offer(new Integer[]{i,j});
            }
        }    
        int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        int dis=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            while(sz!=0)
            {
                Integer[]t=q.poll();
                for(int []x:dir)
                {
                    int nr=x[1]+t[0];
                    int nc=x[0]+t[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==Integer.MAX_VALUE)
                    {
                        grid[nr][nc]=dis+1;
                        q.offer(new Integer[]{nr,nc});
                    }
                }
                sz--;
            }
            dis++;
        }
    }
}
