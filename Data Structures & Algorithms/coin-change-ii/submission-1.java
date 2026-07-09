class Solution {
    int helper(int amount, int[]coins, int idx, int dp[][])
    {
        if(amount==0)
            return 1;
        if(idx>=coins.length)
            return 0;
        if(dp[idx][amount]!=-1)
            return dp[idx][amount];
        int take=0;
        if(amount>=coins[idx])
            take= helper(amount-coins[idx],coins,idx,dp);
        int notake=helper(amount,coins,idx+1,dp);
        return dp[idx][amount]=take+notake;
    }
    public int change(int amount, int[] coins) 
    {
        int [][]dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-1);
        return helper(amount,coins, 0,dp);    
    }
}
