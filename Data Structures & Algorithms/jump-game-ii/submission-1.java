class Solution {
    public int jump(int[] nums) 
    {
        int farthest=0, currend=0,jumps=0;
        for(int i=0;i<nums.length-1;i++)
        {
            farthest=Math.max(farthest,nums[i]+i);
            if(i==currend)
            {
                currend=farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
