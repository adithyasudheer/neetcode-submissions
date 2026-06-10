class Solution {
    
    int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(char [][]grid,int i, int j)
    {
        grid[i][j]='0';
        for(int k=0;k<dir.length;k++)
        {
            int x=dir[k][0], y=dir[k][1];
            if(i+y>=0 && i+y<grid.length && j+x>=0 && j+x<grid[0].length && grid[i+y][j+x]=='1')
                dfs(grid,i+y,j+x);
        }
    }
    public int numIslands(char[][] grid) 
    {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }    
        return count;
    }
}
