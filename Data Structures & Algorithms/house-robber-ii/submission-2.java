class Solution {
    int helper(int []nums,int idx,int []dp)
    {
        if(idx<0)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int take=Integer.MIN_VALUE;
        int notake=Integer.MIN_VALUE;
        take=nums[idx];
        if(idx-2>=0)
            take+=helper(nums,idx-2,dp);
        if(idx-1>=0)
            notake=helper(nums,idx-1,dp);
        return dp[idx]=Math.max(take,notake);
    }
    public int rob(int[] nums) 
    {
        if(nums.length==1)
            return nums[0];
        int []nums1=new int[nums.length-1];
        int []dp1=new int[nums.length-1];
        Arrays.fill(dp1,-1);
        int []nums2=new int[nums.length-1];
        int []dp2=new int[nums.length-1];
        Arrays.fill(dp2,-1);
        for(int i=1;i<nums.length;i++)
            nums1[i-1]=nums[i];
        for(int i=0;i<nums.length-1;i++)
            nums2[i]=nums[i];
        return Math.max(helper(nums1,nums1.length-1,dp1),helper(nums2,nums2.length-1,dp2));    
    }
}
