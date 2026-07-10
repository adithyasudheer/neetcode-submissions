class Solution {
    int helper(int [] prices,int idx, int canBuy,int [][]dp)
    {
        if(idx>=prices.length)
            return 0;
        if(dp[idx][canBuy]!=-1)
            return dp[idx][canBuy];
        int profit=0;
        if(canBuy==1)
        {
            profit=Math.max(-prices[idx]+helper(prices,idx+1,0,dp),helper(prices,idx+1,canBuy,dp));
        }
        else
        {
            profit=Math.max(prices[idx]+helper(prices,idx+2,1,dp),helper(prices,idx+1,canBuy,dp));
        }
        return dp[idx][canBuy]=profit;
    }
    public int maxProfit(int[] prices) 
    {
        int [][]dp=new int[prices.length+1][2];
        for(int i=0;i<prices.length+1;i++)
            Arrays.fill(dp[i],-1);
        return helper(prices, 0,1,dp);    
    }
}
