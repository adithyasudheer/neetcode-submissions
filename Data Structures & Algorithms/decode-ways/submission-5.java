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
            if(x<=26)
                take2=helper(s,idx+2,dp);
        }   
        return dp[idx]=take1+take2;
        
    }
    public int numDecodings(String s) {
        HashMap<Integer,Character>m=new HashMap<>();
        int []dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        for(int i=1;i<=26;i++)
        {
            m.put(i,(char)('A'+i-1));
        }
        // for(Map.Entry<Integer,Character>e:m.entrySet())
        //     System.out.println(e.getKey()+"->"+e.getValue());
        return helper(s,0,dp);
    }
}
