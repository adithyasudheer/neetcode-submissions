class Solution 
{
    int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    int val;
    private void dfs(int [][]grid, int i,int j)
    {
        val++;
        grid[i][j]=0;
        for(int k=0;k<dir.length;k++)
        {
            int x=dir[k][0],y=dir[k][1];
            if(i+y>=0 && i+y<grid.length && j+x>=0 && j+x<grid[0].length && grid[i+y][j+x]==1)
            {
                dfs(grid,i+y,j+x);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) 
    {
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    val=0;
                    dfs(grid,i,j);
                    ans=Math.max(ans,val);
                }
            }
        }        
        return ans;
    }
}
