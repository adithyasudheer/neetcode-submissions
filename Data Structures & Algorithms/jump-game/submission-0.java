class Solution {
    public boolean canJump(int[] nums) 
    {
        int maxj=0;
        for(int i=0;i<nums.length;i++)
        {
            maxj=Math.max(maxj,i+nums[i]);
            if(maxj>=nums.length-1)
                return true;
            if(maxj<=i)
                return false;
            //maxj--;
        }
        return true;
    }
}
