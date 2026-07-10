class Solution {
    int helper(int [] nums, int idx, int sum)
    {
        if(idx>=nums.length)
        {
            if(sum==0)
                return 1;
            return 0;
        }
        return helper(nums,idx+1,sum-nums[idx])+helper(nums,idx+1,sum+nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) 
    {
        return helper(nums,0,target);    
    }
}
