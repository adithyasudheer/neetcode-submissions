class Solution {
    int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        int count=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            count++;
            while(sz!=0)
            {
                int []cord=q.poll();
                //grid[cord[0]][cord[1]]=2;
                for(int i=0;i<dir.length;i++)
                {
                    int x=cord[1]+dir[i][0];
                    int y=cord[0]+dir[i][1];
                    if(x>=0 && x<grid[0].length && y>=0 && y<grid.length && grid[y][x]==1)
                    {
                        grid[y][x]=2;
                        q.add(new int[]{y,x});
                    }
                }
                sz--;
            }

        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return count-1;
    }
}
