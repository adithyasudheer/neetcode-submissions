class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        boolean pac[][]=new boolean[heights.length][heights[0].length];
        boolean atl[][]=new boolean[heights.length][heights[0].length];
        Queue<int[]>pac_q=new LinkedList<>();
        Queue<int[]>atl_q=new LinkedList<>();
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(i==0||j==0)
                {
                    pac[i][j]=true;
                    pac_q.add(new int[]{i,j});
                }
                if(j==heights[0].length-1 || i==heights.length-1)
                {
                    atl[i][j]=true;
                    atl_q.add(new int[]{i,j});
                }
            }
        }
        int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pac_q.isEmpty())
        {
            int sz=pac_q.size();
            while(sz!=0)
            {
                int []cord=pac_q.poll();
                for(int i=0;i<dir.length;i++)
                {
                    int x=dir[i][0]+cord[1];
                    int y=dir[i][1]+cord[0];
                    if(x>=0 && x<heights[0].length && y>=0 && y<heights.length && heights[y][x]>=heights[cord[0]][cord[1]] && pac[y][x]!=true)
                    {
                        pac[y][x]=true;
                        pac_q.add(new int[]{y,x});
                    }
                }
                sz--;
            }            
        }
        while(!atl_q.isEmpty())
        {
            int sz=atl_q.size();
            while(sz!=0)
            {
                int []cord=atl_q.poll();
                for(int i=0;i<dir.length;i++)
                {
                    int x=dir[i][0]+cord[1];
                    int y=dir[i][1]+cord[0];
                    if(x>=0 && x<heights[0].length && y>=0 && y<heights.length && heights[y][x]>=heights[cord[0]][cord[1]] && atl[y][x]!=true)
                    {
                        atl[y][x]=true;
                        atl_q.add(new int[]{y,x});
                    }
                }
                sz--;
            }            
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(pac[i][j]==true && atl[i][j]==true)
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }
}
