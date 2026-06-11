class Solution {
    Set<Integer>col,diag,antidiag;
    void check(int row, List<List<String>>res, int n, char[][]board)
    {
        if(row==n)
        {
            List<String>curr=new ArrayList<>();
            for(int i=0;i<n;i++)
                curr.add(new String(board[i]));
            res.add(curr);
        }
        for(int c=0;c<n;c++)
        {
            if(!col.contains(c) && !diag.contains(c-row) && !antidiag.contains(c+row))
            {
                col.add(c);
                diag.add(c-row);
                antidiag.add(c+row);
                board[row][c]='Q';
                check(row+1,res,n,board);
                col.remove(c);
                diag.remove(c-row);
                antidiag.remove(c+row);
                board[row][c]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>>res=new ArrayList<>();
        col=new HashSet<>();
        diag=new HashSet<>();
        antidiag=new HashSet<>();
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        check(0,res,n,board);
        return res;
    }
}
