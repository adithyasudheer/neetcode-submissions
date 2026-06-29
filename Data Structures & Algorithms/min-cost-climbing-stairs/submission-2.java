class Solution {
    int []dp;
    int helper(int idx, int []cost)
    {
        if(idx<=1)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        if(idx-1>=0)
            one = cost[idx-1] + helper(idx-1,cost);
        if(idx-2>=0)
            two = cost[idx-2]+ helper(idx-2,cost);
        return dp[idx]=Math.min(one,two);
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1)
            return 0;
        dp=new int [cost.length+1];
        Arrays.fill(dp,-1);
        // return helper(cost.length,cost);
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        dp[0]=dp[1]=0;
        for(int idx=2;idx<cost.length+1;idx++)
        {
            if(idx-1>=0)
                one = cost[idx-1] + helper(idx-1,cost);
            if(idx-2>=0)
                two = cost[idx-2]+ helper(idx-2,cost);
            dp[idx]=Math.min(one,two);
        }
        return dp[cost.length];
    }
}
