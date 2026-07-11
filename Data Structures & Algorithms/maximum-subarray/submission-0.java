class Solution {
    public int maxSubArray(int[] nums) {
        int currsum=nums[0],maxsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currsum=Math.max(currsum,0)+nums[i];
            maxsum=Math.max(maxsum,currsum);
        }
        return maxsum;
    }
}
