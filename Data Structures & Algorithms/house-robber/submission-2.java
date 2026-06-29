class Solution {
    int []dp;
    int helper(int []nums, int idx)
    {
        if(idx<0)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int take=Integer.MIN_VALUE;
        int notake=Integer.MIN_VALUE;
        
        take=nums[idx];
        if(idx-2>=0)
            take+=helper(nums,idx-2);
        if(idx-1>=0)
            notake=helper(nums,idx-1);
        return dp[idx]=Math.max(take,notake);
    }
    public int rob(int[] nums) 
    {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        // return helper(nums,nums.length-1); 
        int take=Integer.MIN_VALUE;
        int notake=Integer.MIN_VALUE;  
        for(int idx=0;idx<nums.length;idx++)
        {               
            take=nums[idx];
            if(idx-2>=0)
                take+=dp[idx-2];
            if(idx-1>=0)
                notake=dp[idx-1];
            dp[idx]=Math.max(take,notake);
        } 
        return dp[nums.length-1];
    }
}
