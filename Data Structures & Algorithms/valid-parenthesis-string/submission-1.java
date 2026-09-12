class Solution {
    boolean memo(int i, int open, String s, Boolean [][]dp)
    {
        if(open<0)
            return false;
        if(i>=s.length())
            return open==0;
        if(dp[i][open]!=null)
            return dp[i][open];
        boolean result=false;
        if(s.charAt(i)=='(')
            result=memo(i+1,open+1,s,dp);
        else if(s.charAt(i)==')')
            result=memo(i+1,open-1,s,dp);
        else
        {
            result=memo(i+1,open+1,s,dp)|memo(i+1,open-1,s,dp)|memo(i+1,open,s,dp);
        }
        return dp[i][open]=result;
    }
    public boolean checkValidString(String s) 
    {
        Boolean [][]dp=new Boolean [s.length()+1][s.length()+1];    
        return memo(0,0,s,dp);
    }
}
