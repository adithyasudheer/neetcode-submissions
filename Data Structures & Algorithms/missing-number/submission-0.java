class Solution {
    public int missingNumber(int[] nums) 
    {
        int i=0;
        while(i<nums.length)
        {
            int correctidx=nums[i];
            if(correctidx<nums.length && nums[i]!=nums[correctidx])
            {
                int t=nums[correctidx];
                nums[correctidx]=nums[i];
                nums[i]=t;
            }
            else
                i++;
        }    
        for(i=0;i<nums.length;i++)
        {
            if(i!=nums[i])
                return i;
        }
        return nums.length;
    }
}
