class Solution {
    int helper(int i, int j, String s, String t,int [][]dp)
    {
        if(j==t.length())
        {
            return 1;
        }
        if(i>=s.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=0;
        if(s.charAt(i)==t.charAt(j))
            ans+=helper(i+1,j+1,s,t,dp);
        ans+=helper(i+1,j,s,t,dp);
        return dp[i][j]=ans;
    }
    public int numDistinct(String s, String t) {
        int [][]dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++)
            Arrays.fill(dp[i],-1);
        return helper(0,0,s,t,dp);
    }
}
