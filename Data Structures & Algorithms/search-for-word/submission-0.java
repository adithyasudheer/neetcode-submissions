class Solution {
    private boolean check(char [][]board,StringBuilder sb, int sidx, int r, int c)
    {
        if(sidx==sb.length())
            return true;
        if(r<0||r>=board.length ||c<0 || c>=board[0].length)
            return false;
        if(sb.charAt(sidx)==board[r][c])
        {
            char temp= board[r][c];
            board[r][c]='*';
            if(check(board,sb,sidx+1,r-1,c) || check(board,sb,sidx+1,r+1,c) ||check(board,sb,sidx+1,r,c-1)||check(board,sb,sidx+1,r,c+1))
            {
                board[r][c]=temp;
                return true;
            }
            board[r][c]=temp;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) 
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(check(board,new StringBuilder(word),0,i,j))
                    return true;
            }
        }
        return false;  
    }
}
