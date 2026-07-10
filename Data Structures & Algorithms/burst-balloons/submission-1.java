class Solution {
    int helper(int l, int r,int []n,int [][]dp)
    {
        if(l>r)
            return 0;
        if(dp[l][r]!=Integer.MIN_VALUE)
            return dp[l][r];
        int mx=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++)
        {
            int cost=n[l-1]*n[i]*n[r+1]+helper(l,i-1,n,dp)+helper(i+1,r,n,dp);
            mx=Math.max(mx,cost);
        }
        return dp[l][r]=mx;
    }
    public int maxCoins(int[] nums) {
        int []n=new int[nums.length+2];
        for(int i=0;i<n.length;i++)
        {
            if(i==0||i==n.length-1)
                n[i]=1;
            else
                n[i]=nums[i-1];
        }
        int [][]dp=new int[n.length][n.length];
        for(int i=0;i<n.length;i++)
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        return helper(1,nums.length,n,dp);
    }
}
