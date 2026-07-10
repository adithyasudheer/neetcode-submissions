class Solution {
    Boolean [][]dp;
    boolean helper(int i, int j, String s1, String s2, String s3,Boolean [][]dp)
    {
        int k=i+j;
        if(k==s3.length())
        {
            return (i==s1.length() && j==s2.length());
        }
        if(dp[i][j]!=null)
            return dp[i][j];
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
        {
            if(helper(i+1,j,s1,s2,s3,dp))
                return dp[i][j]=true;
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k))
        {
            if(helper(i,j+1,s1,s2,s3,dp))
                return dp[i][j]=true;
        }
        return dp[i][j]=false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        dp=new Boolean[s1.length()+1][s2.length()+1];
        // for(int i=0;i<s1.length()+1;i++)
        //     Arrays.fill(dp[i],false);
        return helper(0,0,s1,s2,s3,dp);    
    }
}
