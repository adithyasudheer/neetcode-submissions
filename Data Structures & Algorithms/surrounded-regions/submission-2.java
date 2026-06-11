class Solution {
    int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) 
    {
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if((i==0||j==0||i==board.length-1||j==board[0].length-1)&&board[i][j]=='O')
                {
                        q.offer(new int[]{i,j});
                        board[i][j]='#';
                }
            }
        }    
        while(!q.isEmpty())
        {
            int[] t=q.poll();
            for(int[]x:dir)
            {
                int nr=t[0]+x[1];
                int nc=t[1]+x[0];
                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O')
                {
                    q.offer(new int[]{nr,nc});
                    board[nr][nc]='#';
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
}
