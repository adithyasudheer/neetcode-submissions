class Solution {
    int helper(String s,int idx,int []dp)
    {
        if(idx>=s.length())
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int take1=helper(s,idx+1,dp);
        int take2=0;
        if(idx+1<s.length())
        {
            int x=Integer.parseInt(s.substring(idx,idx+2));
            System.out.println(x);
            if(x>=10 && x<=26)
                take2=helper(s,idx+2,dp);
        }   
        return dp[idx]=take1+take2;
        
    }
    public int numDecodings(String s) {
        int []dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        //return helper(s,0,dp);
        dp[s.length()]=1;
        for(int idx=s.length()-1;idx>=0;idx--)
        {
            if(s.charAt(idx)=='0')
            {
                dp[idx]=0;
                continue;
            }
            int take1=dp[idx+1];
            int take2=0;
            if(s.charAt(idx)!='0' && idx+1<s.length())
            {
                int x=Integer.parseInt(s.substring(idx,idx+2));
                System.out.println(x);
                if(x>=10 && x<=26)
                    take2=dp[idx+2];
            }   
            dp[idx]=take1+take2;
        }
        return dp[0];
    }
}
