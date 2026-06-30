class Solution {
    public int countSubstrings(String s) 
    {
        if(s.length()==0)
            return 0;
        int ans=s.length();
        boolean [][]dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<s.length();j++)
            {
                if(i==j)
                    dp[i][j]=true;
                else
                    dp[i][j]=false;
            }
        }
        
        for(int len=1;len<s.length();len++)
        {
            for(int i=0;i+len<s.length();i++)
            {
                if(s.charAt(i)==s.charAt(i+len))
                {
                    if(len==1)
                    {
                        dp[i][i+len]=true;
                    }
                    else if(dp[i+1][i+len-1])
                    {
                        dp[i][i+len]=true;
                    }

                    if(dp[i][i+len])
                        ans++;
                }
            }
        }    
        return ans;
    }
}
