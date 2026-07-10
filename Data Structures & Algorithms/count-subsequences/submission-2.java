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
            Arrays.fill(dp[i],0);

        for(int i=0;i<s.length()+1;i++)
            dp[i][t.length()]=1;
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=t.length()-1;j>=0;j--)
            {
                if(s.charAt(i)==t.charAt(j))
                    dp[i][j]+=dp[i+1][j+1];
                dp[i][j]+=dp[i+1][j];
            }
        }
        return dp[0][0];
        //return helper(0,0,s,t,dp);
    }
}
