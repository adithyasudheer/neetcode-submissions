class Solution {
    public boolean colCheck(char[][] board)
    {
        int r=board.length, c=board[0].length;
        for(int i=0;i<c;i++)
        {
            Set<Character>s=new HashSet<>();
            for(int j=0;j<r;j++)
            {
                if(board[j][i]!='.')
                {
                    if(s.contains(board[j][i]))
                    {
                            return false;
                    }
                    else
                    {
                            s.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }
    public boolean rowCheck(char[][] board){
        int r=board.length, c=board[0].length;
        for(int i=0;i<r;i++)
        {
            Set<Character>s=new HashSet<>();
            for(int j=0;j<c;j++)
            {
                if(board[i][j]!='.')
                {
                    if(s.contains(board[i][j]))
                    {
                            return false;
                    }
                    else
                    {
                        s.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
    public boolean blockCheck(char[][] board)
    {
        int r=board.length, c=board[0].length;
        for(int k=0;k<r;k=k+3)
        {
            for(int l=0;l<c;l=l+3)
            {
                Set<Character>s=new HashSet<>();
                for(int i=k;i<k+3;i++)
                {
                    for(int j=l;j<l+3;j++)
                    {
                        if(board[i][j]!='.')
                        {
                            if(s.contains(board[i][j]))
                            {
                                    return false;
                            }
                            else
                            {
                                    s.add(board[i][j]);
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
    public boolean isValidSudoku(char[][] board) 
    {
        return colCheck(board)&&rowCheck(board)&&blockCheck(board);    
    }
}
