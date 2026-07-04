class Solution {
    boolean helper(String s,int idx, HashSet<String>m, Boolean[]dp)
    {
        if(idx>=s.length())
            return true;
        if(dp[idx]!=null)
            return dp[idx];
        boolean flag=false;
        for(int i=idx;i<s.length();i++)
        {
            if(m.contains(s.substring(idx,i+1)))
            {
                flag|=helper(s,i+1,m,dp);
                if(flag==true)
                    return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        HashSet<String>m=new HashSet<>();
        Boolean []dp=new Boolean[s.length()];
        for(String st:wordDict)
            m.add(st);
        return helper(s,0,m,dp);    
    }
}
