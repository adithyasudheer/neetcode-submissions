class Solution {
    boolean checksum(int []nums, int idx, int sum,Boolean [][]dp)
    {
        if(idx>=nums.length||sum==0)
            return sum==0;
        if(dp[idx][sum]!=null)
            return dp[idx][sum];
        boolean take=false,notake=false;
        if(sum>=nums[idx])
            take=checksum(nums,idx+1,sum-nums[idx],dp);
        notake=checksum(nums,idx+1,sum,dp);
        return dp[idx][sum]=take|notake;
    }
    public boolean canPartition(int[] nums) 
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        Boolean [][]dp=new Boolean[nums.length][sum+1];    
        // for(int i=0;i<nums.length;i++)
        //     Arrays.fill(dp[i],false);
        if(sum%2==1)
            return false;
        return checksum(nums,0,sum/2,dp);
    }
}
